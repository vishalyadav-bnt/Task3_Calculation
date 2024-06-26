package com.example.calculation.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class CalculationService {
    private final ExecutorService executorService=Executors.newFixedThreadPool(8);
    private static final Logger log=LoggerFactory.getLogger(CalculationService.class);
    private final Scanner scanner = new Scanner(System.in);

    public void executeCalculations() {
        try{
        System.out.println("Enter a number: ");
        int number = scanner.nextInt(); 
        executorService.submit(() -> calculateSquare(number));
        executorService.submit(() -> calculateCube(number));
        executorService.submit(() -> checkEvenOdd(number));
        executorService.submit(() -> checkPrime(number));
        executorService.submit(() -> checkArmstrong(number));
        executorService.submit(() -> checkPalindrome(number));
        executorService.submit(() -> calculateFactorial(number));
        executorService.submit(() -> calculateReverse(number));       
        }
        catch(NumberFormatException e)
        {
            log.error("Error Occured", e.getMessage());
            e.printStackTrace();
        }
        finally{
            executorService.shutdown();
        }
    }

    private void calculateSquare(int number) {
        int result = number * number;
        log.info("Square of {} is {}", number, result);
        System.out.println("Square: " + result);
    }

    private void calculateCube(int number) {
        int result = number * number * number;
        log.info("Cube of {} is {}", number, result);
        System.out.println("Cube: " + result);
    }

    private void checkEvenOdd(int number) {
        String result = (number % 2 == 0) ? "Even" : "Odd";
        log.info("{} is {}", number, result);
        System.out.println("Even/Odd: " + result);
    }

    private void checkPrime(int number) {
        boolean isPrime = true;
        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        log.info("{} is {}prime", number, isPrime ? "" : "not ");
        System.out.println("Prime: " + (isPrime ? "Yes" : "No"));
    }

    private void checkArmstrong(int number) {
        int originalNumber = number;
        int digits = String.valueOf(number).length();
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }

        boolean isArmstrong = (sum == originalNumber);
        log.info("{} is {} Armstrong number", originalNumber, isArmstrong ? "an" : "not an");
        System.out.println("Armstrong: " + (isArmstrong ? "Yes" : "No"));
    }

    private void checkPalindrome(int number) {
        int reversedNumber = 0;
        int originalNumber = number;

        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }

        boolean isPalindrome = (originalNumber == reversedNumber);
        log.info("{} is {} palindrome", originalNumber, isPalindrome ? "a" : "not a");
        System.out.println("Palindrome: " + (isPalindrome ? "Yes" : "No"));
    }

    private void calculateFactorial(int number) {
        int factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        log.info("Factorial of {} is {}", number, factorial);
        System.out.println("Factorial: " + factorial);
    }

    private void calculateReverse(int number) {
        int reversedNumber = 0;
        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }
        log.info("Reverse of {} is {}", number, reversedNumber);
        System.out.println("Reverse: " + reversedNumber);
    }
}
