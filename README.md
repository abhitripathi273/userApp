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

JWT Token api 

1. Call Get /Authenticate
Request PayLoad
{
"username":"useramit",
"password":"password"
}

Response
{
   "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyYW1pdCIsImV4cCI6MTU4ODQ5MjczMSwiaWF0IjoxNTg4NDc0NzMxfQ.O98N1kTV0qhE_a3R8KCA55StX7GZGT-Ymyu6fu9Nor6QU7BxA78D0TUCfsXVViieh7L1MI9kUdIHjIaztikOXg"
}

2.This Token Can only be used in user/{userId} api .
with Header 
Authorization -- Bearer
eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyYW1pdCIsImV4cCI6MTU4ODQ5MjczMSwiaWF0IjoxNTg4NDc0NzMxfQ.O98N1kTV0qhE_a3R8KCA55StX7GZGT-Ymyu6fu9Nor6QU7BxA78D0TUCfsXVViieh7L1MI9kUdIHjIaztikOXg

Without Bearer(with space and next line) it will not work

3.
Example 
request GET 'http://localhost:8100/user/61354' 
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyYW1pdCIsImV4cCI6MTU4ODQ5MjczMSwiaWF0IjoxNTg4NDc0NzMxfQ.O98N1kTV0qhE_a3R8KCA55StX7GZGT-Ymyu6fu9Nor6QU7BxA78D0TUCfsXVViieh7L1MI9kUdIHjIaztikOXg'

Without token error
{
    "timestamp": "2020-05-03T04:27:19.827+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Unauthorized",
    "path": "/user/61354"
}
