# UI tests for https://stellarburgers.nomoreparties.site

 In this project I created UI tests for testing main user scenarios
 Although I used API tests to optimaze the user creation and removing

Project is developed with:

- Java
- Maven
- JUnit
- PageObject
- Selenium Webdriver
- RestAssured
- Allure
- Faker
- ✨Magic ✨


Project contains following classes:

| CLASS | README |
| ------ | ------ |
| API | api methods to create and delete user |
| main/MainPage | locators and methods of main page |
| main/RegisterPage | locators and methods of page with registration form |
| main/EnterPage | locators and methods of authorization page |
| main/ChangePassPage | locators and methods of page with password change form |
| test/RegisterTests | tests for new user registration |
| test/LoginTests | tests to login with different login buttons on the page |
| test/AccountTests | testing scenarios of authorized user in account |
| test/ConstructorTests | testing the ingredient menu is switched with user navigation |
| allure-results | testing results report with allure |
