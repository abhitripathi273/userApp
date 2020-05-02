User Application

Port: 8100

Hystrix:  

Spring Boot User Demo Application for E-commerce Application.

User can able to;
  1- Get all the details of users
  2- Get details of specific user
  3- Create a user
  4- Update the details of specific user
  5- Delete the specific user

 API Endpoints:
 
 1 - GET /users
 2 - GET /user/{userId}
 3 - POST /user
   Request Payload:
   	{
	"userId":1,
	"firstName": "abc",
	"lastName" : "def",
	"email" : "abc@gmail.com",
	"phoneNumber": "1231231231",
	"shippingAddress":[
		{
			"pinCode": 123,
			"area" : "abc",
			"district": "Gurgaon",
			"state": "Haryana",
			"country": "India",
			"defaultAddress": true
		}
		]
	}
4 - PUT /update_user
	Request Payload:
	{
	"userId":1,
	"firstName": "def",
	"lastName" : "def",
	"email" : "abc@gmail.com",
	"phoneNumber": "9898989898",
	"shippingAddress":[
		{
			"pinCode": 1234,
			"area" : "def",
			"district": "Gurgaon",
			"state": "Haryana",
			"country": "India",
			"defaultAddress": true
		}
		]
	}
5 - DELETE /user/{userId}