# Task3_Calculation
# CalculatorApplication
# Calculator App
This project demonstrates a simple REST API application built with Spring Boot for performing various calculations asynchronously using multithreading.

### Description
The Calculator App allows users to trigger multiple calculations simultaneously through a REST endpoint /calculate. Each calculation runs on a separate thread to demonstrate concurrent processing.

### Technologies Used
Java
Spring Boot
SLF4J for logging

### Prerequisites
JDK 8 or higher
Gradle
Setup
### Clone the repository:

### bash
git clone https://github.com/yourusername/CalculatorApp.git

cd CalculatorApp

Build the project:

### bash

mvc clean package
Run the application:

bash
java -jar target/CalculatorApp-1.0.jar

Alternatively, you can use gradle to run the application:

bash
mvc spring-boot:run

Access the application:

Open a web browser and go to http://localhost:8080/calculate to trigger the calculations.

API Endpoint
GET /calculate
Description: Initiates multiple calculations concurrently.
Response: "Calculations started ..."
### Logging

SLF4J (Simple Logging Facade for Java) with Logback is used for logging. Logs can be found in the console output or configured as needed.

### Multithreading

The application demonstrates multithreading by starting separate threads for the following calculations:

Calculate square

Calculate cube

Check even or odd

Check prime number

Check Armstrong number

Check palindrome

Calculate factorial
### Contributors
Vishal Yadav
