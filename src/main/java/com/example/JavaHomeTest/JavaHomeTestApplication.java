package com.example.JavaHomeTest;

import com.example.JavaHomeTest.impl.SimpleNumberAdder;
import com.example.JavaHomeTest.interfaces.NumberAdder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class JavaHomeTestApplication {

	public static void main(String[] args) {
		//For better looking at console
		System.out.println();

		SpringApplication.run(JavaHomeTestApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		NumberAdder numberAdder = new SimpleNumberAdder();

		while (true) {
			System.out.print("Enter the first number (or 'q' to quit): ");
			String input1 = scanner.nextLine();

			if ("q".equalsIgnoreCase(input1)) {
				break; // Exit the program if 'q' is entered
			}

            System.out.print("Enter the second number: ");
			String input2 = scanner.nextLine();

			//I assume the exercise is for non-negative numbers. Validation:
			if (!isValidNumber(input1) || !isValidNumber(input2)) {
				System.out.println("Invalid input. Input must be non-negative integers.");
			}else{
				String result = numberAdder.addNumbers(input1, input2);
				System.out.println("Result: " + result);
			}
		}

		scanner.close();
	}

	private static boolean isValidNumber(String str) {
		return str.matches("\\d+");
	}
}
