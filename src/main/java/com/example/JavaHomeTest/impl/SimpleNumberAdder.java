package com.example.JavaHomeTest.impl;


import com.example.JavaHomeTest.interfaces.NumberAdder;

public class SimpleNumberAdder implements NumberAdder {
    @Override
    public String addNumbers(String num1, String num2) {
        //First, I discard the 0's on the left
        num1 = num1.replaceFirst("^0+(?!$)", "");
        num2 = num2.replaceFirst("^0+(?!$)", "");

        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        //I go through each character from right to left to perform the sum
        // meanwhile I control the carry
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.insert(0, sum % 10);
            i--;
            j--;
        }

        return result.toString();
    }
}
