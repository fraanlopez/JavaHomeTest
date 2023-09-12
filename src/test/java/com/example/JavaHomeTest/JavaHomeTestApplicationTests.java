package com.example.JavaHomeTest;

import com.example.JavaHomeTest.impl.SimpleNumberAdder;
import com.example.JavaHomeTest.interfaces.NumberAdder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.Random;

@SpringBootTest
class JavaHomeTestApplicationTests {

	@Test
	public void testRandomCases() {
		NumberAdder numberAdder = new SimpleNumberAdder();

		Random random = new Random();

		//
		int cantTest = 300;

		for (int i = 0; i < cantTest; i++) {
			int num1Length = random.nextInt(10) + 1; // Random number length between 1 and 10
			int num2Length = random.nextInt(10) + 1; // Random number length between 1 and 10

			StringBuilder num1Builder = new StringBuilder(num1Length);
			StringBuilder num2Builder = new StringBuilder(num2Length);

			for (int j = 0; j < num1Length; j++) {
				num1Builder.append(random.nextInt(10)); // Random digit between 0 and 9
			}

			for (int j = 0; j < num2Length; j++) {
				num2Builder.append(random.nextInt(10)); // Random digit between 0 and 9
			}

			String num1 = num1Builder.toString();
			String num2 = num2Builder.toString();

			BigInteger expectedResult = new BigInteger(num1).add(new BigInteger(num2));
			String expectedStringResult = String.valueOf(expectedResult);

			String actualResult = numberAdder.addNumbers(num1, num2);

			Assertions.assertEquals(expectedStringResult, actualResult, "Test case #" + (i + 1) + " failed." + "Number was: " + num1 + " and " + num2);
			System.out.println(num1 + " + " + num2 + " = " + actualResult);
		}
	}

}
