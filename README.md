# Bank API

A simple RESTful API for creating and managing bank accounts, with the ability to deposit and withdraw funds.

## Features

- **Create Account:** Create a new bank account.
- **Get Account:** Retrieve details of an existing account by its ID.
- **Deposit:** Deposit money into a specified account.
- **Withdraw:** Withdraw money from a specified account.

## API Endpoints

### 1. Create a Bank Account

**Endpoint:**  
`POST /api/bankchor`  

**Request Body:**
```json
{
    "name": "John Doe",
    "balance": 1000.00
}
```
```json
{
    "id": 1,
    "name": "John Doe",
    "balance": 1000.00
}
```
## 2. Get Account Details
Endpoint:
GET /api/bankchor/{id}

Path Parameter:

id (Long): ID of the bank account to retrieve.
```json
{
    "id": 1,
    "name": "John Doe",
    "balance": 1000.00
}
```
3. Deposit Money
Endpoint:
POST /api/bankchor/{id}/deposit

Path Parameter:

id (Long): ID of the bank account.
```json
{
    "amount": 500.00
}
```

## 4. Withdraw Money
Endpoint:
POST /api/bankchor/{id}/withdraw

Path Parameter:

id (Long): ID of the bank account.
```json
{
    "amount": 200.00
}
```
## Response:
### JSON
```json
{
    "id": 1,
    "name": "John Doe",
    "balance": 800.00
}
```

## Error Handling
- If an account is not found, the API will return a 404 error with a message "Account not found".

## Technology Stack
- Java
- Spring Boot
- MySQL (or any preferred database)
- Lombok (for reducing boilerplate code)
- Postman (for testing API endpoints)

## Setup Instructions

- Clone the repository.
- Set up your database in application.properties or application.yml.
- Build the project using Maven or Gradle.
- Run the application.

## Bash

```bash
mvn spring-boot:run
```

## Testing the API


- You can use Postman or curl to test the API endpoints. Make sure the application is running on localhost:8080.


# Design by Harsh SIngh✨
