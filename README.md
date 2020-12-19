## Gold Market API

### Database Spec
- PostgreSQL
- Database Name: gold_market_db

### API Spec

#### Create Customer
- Request: POST
- Endpoint : `/api/customer`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body : 
```json
{
    "firstName": "String",
    "lastName": "String",
    "dateOfBirth": "Date",
    "address": "String",
    "status": "Number",
    "userName": "String",
    "password": "String",
    "email": "String"
}
```

Response:
```json
  {
      "status": {
          "code": "Number",
          "message": "String"
      },
      "data": {
          "id": "String",
          "firstName": "String",
          "lastName": "String",
          "dateOfBirth": "Date",
          "address": "String",
          "status": "Number",
          "userName": "String",
          "password": "String",
          "email": "String"
      }
  }
  ```

#### Get Customer
- Request: GET
- Endpoint : `/api/customer/{id}`
- Header :
    - Content-Type: application/json
    
Response:
```json
  {
      "status": {
          "code": "Number",
          "message": "String"
      },
      "data": {
          "id": "String",
          "firstName": "String",
          "lastName": "String",
          "dateOfBirth": "Date",
          "address": "String",
          "status": "Number",
          "userName": "String",
          "password": "String",
          "email": "String"
      }
  }
  ```

#### Update Customer
- Request: PUT
- Endpoint : `/api/customer/{id}`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :
```json
{
    "firstName": "String",
    "lastName": "String",
    "dateOfBirth": "Date",
    "address": "String",
    "status": "Number",
    "userName": "String",
    "password": "String",
    "email": "String"
}
```

Response:
```json
  {
    "status": {
        "code": "Number",
        "message": "String"
    },
    "data": {
        "id": "String",
        "firstName": "String",
        "lastName": "String",
        "dateOfBirth": "Date",
        "address": "String",
        "status": "Number",
        "userName": "String",
        "password": "String",
        "email": "String"
    }
}
  ```

#### List Customer
- Request: GET
- Endpoint : `/api/customer?page=page?rows=5`
- Header :
    - Content-Type: application/json
- Query Param :
    - Page : number
    - Rows : number
    
Response:
```json
  {
      "status": {
          "code": "Number",
          "message": "String"
      },
      "data": [
      {
          "id": "String",
          "firstName": "String",
          "lastName": "String",
          "dateOfBirth": "Date",
          "address": "String",
          "status": "Number",
          "userName": "String",
          "password": "String",
          "email": "String"
      }
    ],
    "page": {
        "page": "Number",
        "rows": "Number",
        "totalPages": "Number",
        "totalRows": "Number"
    }
  }
  ```

#### Delete Customer
- Request: DELETE
- Endpoint : `/api/customer/{id}`
