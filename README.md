# API Test Automation Framework

Automated REST API testing framework built with **Rest Assured, Java and TestNG**. Tests the
Fake Store e-commerce API covering full **CRUD operations** with request and response
validation. A companion Postman collection is included for exploratory testing.

![Java](https://img.shields.io/badge/Java-21-orange)
![Rest Assured](https://img.shields.io/badge/Rest%20Assured-5-green)
![TestNG](https://img.shields.io/badge/TestNG-7-red)
![Postman](https://img.shields.io/badge/Postman-Collection-orange)

## Overview

This framework automates API tests against [fakestoreapi.com](https://fakestoreapi.com), an
e-commerce practice API. Tests follow Rest Assured's readable **Given–When–Then** style and
validate status codes, response bodies, and individual fields. It pairs with the UI Selenium
projects to demonstrate testing an application at **both the API and UI layers**.

## Tech Stack

| Tool | Purpose |
|------|---------|
| Java 21 | Programming language |
| Rest Assured 5 | REST API automation |
| TestNG | Test execution & assertions |
| Hamcrest | Matchers (equalTo, notNullValue, etc.) |
| Maven | Build & dependency management |
| Postman | Exploratory API testing collection |

## What It Tests

| # | Test | Method | Validates |
|---|------|--------|-----------|
| 1 | Get all products | GET | 200, list not empty |
| 2 | Get single product | GET | 200, correct id, fields present |
| 3 | Get products by category | GET | 200, items match category |
| 4 | Get non-existent product | GET | graceful handling |
| 5 | Create a product | POST | new id returned |
| 6 | Update a product | PUT | updated values returned |
| 7 | Delete a product | DELETE | 200 status |
| 8 | Get all categories | GET | 200, categories present |
| 9 | User login | POST | token returned |

## Project Structure

```
restassured-api-framework/
├── pom.xml
├── .gitignore
├── README.md
├── postman/
│   └── FakeStore.postman_collection.json   # Postman collection
└── src/test/java/
    ├── base/
    │   └── BaseTest.java        # Common setup (base URI)
    └── tests/
        ├── GetProductsTest.java
        ├── CreateProductTest.java
        ├── UpdateProductTest.java
        └── DeleteProductTest.java
```

## Prerequisites

- Java (JDK 21) installed
- Maven installed
- Internet connection (tests call a public API)

## How to Run

```bash
mvn clean test
```

Individual tests can also be run from VS Code using the **Run Test** link above each `@Test`
method or the **Testing** panel.

## Key Concept — Given / When / Then

Rest Assured tests read like plain English:

```java
given()
    .baseUri("https://fakestoreapi.com")
.when()
    .get("/products/1")
.then()
    .statusCode(200)
    .body("title", notNullValue());
```

`given()` sets up the request, `when()` sends it, and `then()` validates the response.

## Author

**Padmavathy Arumugam** · [github.com/Padma6060](https://github.com/Padma6060)
