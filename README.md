# RESTful Vaildation

## Inroduction
This project present a Login Vaildation API with basic Spring boot framework included:

* RESRful API
* Exception Handler (Error Handling)
* Aspect (Log AOP)

Developed in MVC three-layer Pattern

---

## Swagger-UI 

http://localhost:8081/swagger-ui/index.html

---

## API

POST: http://localhost:8081/login/validation

**Request**

```json
{
    "email":"string",
    "password":"string"
}
```

## Login Vaildation & Circumstances

Login Vaildation with condidtions listed below:

1. Email & Password can not be blank or null
2. Length of password should between 6 and 12
3. Password can only be composed of uppercase or lowercase letters and numbers

### Circumstances & ErrorCode

ErrorCode could be used to i18n on frontend framework

| ErrorCode | Circumstances | ErrorLevel | ErrorMsg |
| :-----:| :----: | :----: | :----: |
| 00001 | INPUT_FORMAT_ERROR | LOW | @Valid message |
| 10000 | USER_NOT_FOUND | LOW | User Not Found |
| 10001 | EMAIL_PASSWORD_NOT_MATCH | LOW | Email and Password Not Match |

---

## Development Environment

* OpenJDK 17
* Maven 3.8.6
* H2 database for unit test

## Execute Project

**Step:**
1. Clone this project 

> https://github.com/Williamrightone/restful-vaildation.git

2. Configurations setting

```First time Setting:``` Right click on Project, select ```Run As``` => ```Run Configurations``` and set profile -> ```local```

After that, just Run As Spring Boot App

