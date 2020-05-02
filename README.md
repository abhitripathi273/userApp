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
    "firstName": "Abhisehk",
    "lastName": "Tripathi",
    "email": "abc@gmail.com",
    "phoneNumber": "6767676767"
	}
4 - PUT /update_user
	Request Payload:
	{
    "userId": 38361,
    "firstName": "Abhisehk",
    "lastName": "Tripathi",
    "email": "abhishek123@gmail.com",
    "phoneNumber": "6767676767"
	}
5 - DELETE /user/{userId}