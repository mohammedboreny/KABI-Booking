### Description:
- This is a web application which has a feature where the user can add prices
for their items dynamically.
- Admin users are going to be able to select a start date, an end date, and add the
price, and They can overlap their prices.


### Technologies and Data structure used:
- This application is build with **java framework (springboot)** as a microservice web application.
- The comminication protocol used by this application is **Rest Api**.
- Common design pattern used for this application is the **strategy pattern**.
- The data structure used by this application to keep track of the dates and their prices is **Hashmap**.

### Endpoints 
- The application is running on port 8080
- The post url is /api/admin/setPrices
- **The post method** accept a list of objects with attributes startDate, endDate and price
- example of the Post method body is
  [{
  "startDate": "2022-01-05",
  "endDate": "2022-01-15",
  "price": 5.0
},{
  "startDate": "2022-01-01",
  "endDate": "2022-01-11",
  "price": 3.0
},
{
  "startDate": "2022-01-03",
  "endDate": "2022-01-13",
  "price": 10.00
},
{
  "startDate": "2022-01-02",
  "endDate": "2022-01-11",
  "price": 4.0
}]


- **The Get method** accepts a list of objects with attributes  startDate, endDate.
- The Get url is /api/admin/getPriceSum
- example of the Get method body is
 [{
  "startDate": "2022-01-01",
  "endDate": "2022-01-02",
},{
  "startDate": "2022-01-03",
  "endDate": "2022-01-12"
},
{
  "startDate": "2022-01-13",
  "endDate": "2022-01-13"
}]

- **Note that the date format is YYYY-MM-DD**

### How to run this application:
- You should have Java 17 or higher installed in your machine.
- After installation of java JDK, from the root head to ./src/target directory , then run the command line tool (ensure that the cmd is watching the target directory), Then run the command **java -jar operation-node-0.0.1-SNAPSHOT.jar** , and the server will start.

![alt](./Screenshot%202024-05-08%20080426.png)