# Service 1 : user

## How to use it ?

- mvn clean packahe
- java -jar target/service1.jar
- works on port 8082
- designed to be used with server pizza and service 2

## functionalities
- create an user (name and email)
- update the user
- delete the user
- see every user
- search user by its name or id

## Structure

- Maincotroller handling DTO files shared with Server Pizza
- User and UserRepository are used for the database
- data are computed in User service

