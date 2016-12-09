curl -i -X POST -H "Content-Type:application/json" -d '{  "country": "USA", "name": "Intel", "officialUrl": "intel.com" }' http://localhost:8080/vendors
curl -X PUT -H "Content-Type:application/json" -d '{ "country": "USA", "name": "AMD", "officialUrl": "amd.com" }' http://localhost:8080/vendors/1
curl -X PATCH -H "Content-Type:application/json" -d '{ "name": "Intel", "officialUrl": "intel.com" }' http://localhost:8080/vendors/1
curl -i -X POST -H "Content-Type:application/json" -d '{ "model": "Core i7", "line": "Intel iCore", "cores": 4, "cost": 200, "quantity": 10, "vendorId": 1 }' http://localhost:8080/products
curl -X PATCH -H "Content-Type:application/json" -d '{ "model": "Core i9", "cost": 3000 }' http://localhost:8080/products/1
curl -X PATCH -H "Content-Type:application/json" -d '{ "quantity": 0 }' http://localhost:8080/info/1
curl -i -X POST -H "Content-Type:application/json" -d '{ "model": "Core i7", "line": "Intel iCore", "cores": 4, "cost": 200, "quantity": 10, "vendorId": 1 }' http://localhost:8080/products
curl -X PATCH -H "Content-Type:application/json" -d '{ "cores": 64 }' http://localhost:8080/info/1
