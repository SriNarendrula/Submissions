
// 0. Switch to (create) the database
use("gadgetStore");

// 1. Create the "products" collection with a JSON Schema validator
db.createCollection("products", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["name", "price", "inStock"],
      properties: {
        name: {
          bsonType: "string",
          description: "must be a string and is required"
        },
        price: {
          bsonType: ["int", "double"],
          description: "must be an integer or double and is required"
        },
        inStock: {
          bsonType: "bool",
          description: "must be a boolean and is required"
        },
        specs: {
          bsonType: "object",
          description: "optional nested specs document",
          properties: {
            brand: {
              bsonType: "string",
              description: "must be a string if provided"
            }
          }
        }
      }
    }
  },
  validationAction: "error" 
});

// 2. Insert at least three gadgets with insertMany()
db.products.insertMany([
  {
    name: "Wireless Mouse",
    price: 25.99,
    inStock: true,
    specs: { brand: "Logitech" }
  },
  {
    name: "Mechanical Keyboard",
    price: 89,
    inStock: true,
    specs: { brand: "Corsair" }
  },
  {
    name: "Gaming Monitor",
    price: 299.99,
    inStock: false,
    specs: { brand: "Samsung" }
  }
]);

// 3. Test the validator with a document that VIOLATES the rules
//    (missing "price" entirely) — this insert should FAIL

try {
  db.products.insertOne({
    name: "Broken Webcam",
    inStock: true
  });
} catch (e) {
  print("Validation correctly rejected the bad document:");
  print(e.message);
}

try {
  db.products.insertOne({
    name: "Bad Type Speaker",
    price: "not a number", 
    inStock: true
  });
} catch (e) {
  print("Validation correctly rejected the wrong-type document:");
  print(e.message);
}

// 4. Pick one product to update — Wireless Mouse

// 4a. Add a new top-level field "category" with $set
db.products.updateOne(
  { name: "Wireless Mouse" },
  { $set: { category: "Accessories" } }
);

// 4b. Increase its price by 15 using $inc
db.products.updateOne(
  { name: "Wireless Mouse" },
  { $inc: { price: 15 } }
);

// 4c. Add a "tags" array field, pushing "wireless" first...
db.products.updateOne(
  { name: "Wireless Mouse" },
  { $push: { tags: "wireless" } }
);

// ...then push "bestseller" as a second, separate update
db.products.updateOne(
  { name: "Wireless Mouse" },
  { $push: { tags: "bestseller" } }
);

// 4d. Changed our mind — remove "wireless" from tags with $pull
db.products.updateOne(
  { name: "Wireless Mouse" },
  { $pull: { tags: "wireless" } }
);

// Check the result
print("Wireless Mouse after updates:");
printjson(db.products.findOne({ name: "Wireless Mouse" }));

// 5. Queries

// 5a. Products priced >= a certain amount (e.g., $50)
print("Products priced >= $50:");
db.products.find({ price: { $gte: 50 } }).forEach(doc => printjson(doc));

// 5b. Products from a specific brand using dot notation
print("Products made by Logitech:");
db.products.find({ "specs.brand": "Logitech" }).forEach(doc => printjson(doc));

// 5c. Products whose category matches one in a list, using $in
print("Products in category Accessories or Monitors:");
db.products.find({ category: { $in: ["Accessories", "Monitors"] } })
  .forEach(doc => printjson(doc));

// 6. Create the "orders" collection
db.createCollection("orders");

// Grab the _id of the Wireless Mouse to link an order to it
const mouse = db.products.findOne({ name: "Wireless Mouse" });

db.orders.insertOne({
  productId: mouse._id,
  quantity: 2
});

// 7. Aggregation pipeline: join orders -> products,
//    output a clean "customer receipt"
const receipt = db.orders.aggregate([
  {
    $lookup: {
      from: "products",
      localField: "productId",
      foreignField: "_id",
      as: "product"
    }
  },
  {
    $unwind: "$product"
  },
  {
    $project: {
      _id: 0,
      productName: "$product.name",
      quantity: 1
    }
  }
]).toArray();

print("Customer receipt:");
printjson(receipt);