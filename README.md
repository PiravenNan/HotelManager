# Hotel Manager Web App

## Description

The Hotel Manager App is a web application which allows hotel managers to manage bookings and users to book those rooms.

# Hotel Manager API

## Libraries Used

- Spring Boot
- Spring Data JPA
- Spring Web
- Postgresql

## Setup Instructions

1. Clone the repository:

```bash
git  clone 
```

2. Navigate to the project directory

```bash
cd HotelManager
```

3. Ensure you have Java, Maven and PostgreSQL installed and running. Create the database:

```bash
createdb hotelBooking
```

4. Build the project

```bash
mvn clean install
```

5. Start the application

```bash
mvn spring-boot:run
```

6. Access the application at [https://localhost:8080](https://localhost:8080)

## API Routes

### Managers

- **Add New Manager:**

  - Method: `Post`
  - URL: `/managers/addManager`
  - Request Body: 
    ```json
    {
      "username" : "String",
      "password" : "String",
      "name"     : "String"
    }
    ```

- **Add New Building:**

  - Method: `Post`
  - URL: `/managers/addNewBuilding/1`
  - Request Body: 
    ```json
    {
      "numberOfFloors"  : "int",
      "roomsPerFloor"   : "int",
      "capacityPerRoom" : "int",
      "dayRate"         : "int"
    }
    ```

### Users

- **Add New User:**

  - Method: `Post`
  - URL: `/users/addUser`
  - Request Body: 
    ```json
    {
      "username" : "String",
      "password" : "String",
      "name"     : "String"
    }
    ```

- **Book User to Room:**

  - Method: `POST`
  - URL: `/users/booking/{userId}/{roomId}`

- **Remove User from Room:**

  - Method: `DELETE`
  - URL: `/users/booking/{userId}/{roomId}`

- **Get User by ID:**

  - Method: `GET`
  - URL: `/users/user/{userId}`
