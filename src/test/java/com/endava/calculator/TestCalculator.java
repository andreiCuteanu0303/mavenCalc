package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;

public class TestCalculator {

    public static void main(String[] args) {

        BasicOperations basic = new Basic(3);
        ExpertOperations expert = new Expert(3);

        System.out.println("Add: " + (basic.add(2, 3.3, 4)));
        System.out.println("Subtract: " + (basic.subtract(2, -3)));
        System.out.println("Multiply: " + (basic.multiply(2,3)));
        System.out.println("Multiply: " + (basic.multiply(3.5, 2.3)));
        System.out.println("Divide: " + (basic.divide(10,3)));
        System.out.println("Divide: " + (basic.divide(5,0)));
        System.out.println("====================");
        System.out.println("Power: " + (expert.pow(2,0)));
        System.out.println("Root: " + (expert.root(10)));
        System.out.println("Factorial: " + (expert.fact(3)));

        System.out.println("Calculate: " + expert.calculate("2+(-3-5)/4.56"));

    }
}
