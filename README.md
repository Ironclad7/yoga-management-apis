# Yoga Management App

## Technologies used

- React for front end
- SpringBoot for back end
- MySQL for the database

## Assumptions made

- User can enroll only for the current month and the next 6 months only
- User can make payment for 1 month at a time and has to choose the batch for each month

## The flow of the application

- The home page of the application is displayed with a Navigation bar having options to SignUp, Home, About, Pay and LogOut

#### 1. SignUp

- The user should first click on SignUp and fill out their details which will be stored in the SQL database
  - username: must be 4 or more characters
  - age: must be between 18 and 65
  - mobile no: must be 10 digits
  - password: must be 8 or more characters

#### 2. LogIn

- After they have signed up successfully, they can click on Pay but will be redirected to LogIn as it's their first time
- After providing the username and password, they are validated in the database

#### 3. Form filling

- If valid, their username is stored in a cookie, and they will be redirected to the Form page where they must specify the batch they want to enroll and the month of payment
- If that user has not done the payment before, they have done the payment successfully

#### 4. Log Out

- When they click on Log Out, the cookie will be removed, and they have to Log In again for payment

## Structure of the database

### ER diagram of the project

![ER Diagram](https://github.com/Ironclad7/yoga-management-app/blob/master/Yoga%20Management%20ER%20Diagram.PNG?raw=true)

### Structure of profiles

![profiles structure](https://github.com/Ironclad7/yoga-management-app/blob/master/profiles%20desc.png?raw=true)

### Structure of payment

![payment structure](https://github.com/Ironclad7/yoga-management-app/blob/master/payment%20desc.png?raw=true)

## References:

Front end part of the project in react js is [here](https://github.com/Ironclad7/yoga-management-app)
