# Writing the content of the README.md file to the filesystem
readme_content = """
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
```
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
```
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
```
{
    "amount": 500.00
}
```

## 4. Withdraw Money
Endpoint:
POST /api/bankchor/{id}/withdraw

Path Parameter:

id (Long): ID of the bank account.
```
{
    "amount": 200.00
}
```
