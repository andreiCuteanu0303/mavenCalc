package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.expert.Expert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class CalculatorIT {
    private Basic basic;
    private Expert expert;

    @BeforeAll
    public static void setUpAllTests(){
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDownAllTests(){
        System.out.println("After All");
    }

    @BeforeEach
    public void setUpEachTest() {
        basic = new Basic();
        expert = new Expert();
        System.out.println("Before Each");
    }

    @AfterEach
    public void tearDownEachTest() {
        System.out.println("After Each  \n");
    }



    //=========================== Homework =============================

    //========================== Exercise 1 ============================
    // 1. Create testcases for multiply, pow and factorial methods

    //=========================== Multiply =============================
    @Tag("homework")
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldMultiplyWith0(int a, int b){
        //WHEN
        double result = basic.multiply(a, b);
        //THEN
        System.out.println(result);
    }

    public static List<Arguments> numberProvider(){
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2));
        argumentsList.add(Arguments.of(2, 0));

        return argumentsList;
    }

    @Tag("homework")
    @Test
    public void shouldMultiplyWithNegativeNumbers(){
        //WHEN
        double result = basic.multiply(-3, -23);
        //THEN
        System.out.println(result);
    }

    @Tag("homework")
    @Test
    public void shouldMultiplyNoOperands(){
        //WHEN
        double result = basic.multiply();
        //THEN
        System.out.println(result);
    }

    @Tag("homework")
    @Test
    public void shouldMultiplyOneOperand(){
        //WHEN
        double result = basic.multiply(3);
        //THEN
        System.out.println(result);
    }

    //=========================== Power =============================

    @Tag("homework")
    @Test
    public void shouldPowWithGivenNumbers(){
        //WHEN
        double result = expert.pow(4, 4);
        //THEN
        System.out.println(result);
    }

    @Tag("homework")
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldPowWith0(int a, int b){
        //WHEN
        double resultPow = expert.pow(a, b);
        //THEN
        System.out.println(resultPow);
    }

    @Tag("homework")
    @Test
    public void shouldPowWithNegativeNumbers(){
        //WHEN
        double result = expert.pow(-3, -23);
        //THEN
        System.out.println(result);
    }

    //=========================== Factorial =============================

    @Tag("homework")
    @Test
    public void shouldFactForGivenOperand(){
        //WHEN
        long result = expert.fact(8);
        //THEN
        System.out.println(result);
    }

    @Tag("homework")
    @Test
    public void shouldFactForOperand0(){
        //WHEN
        long result = expert.fact(0);
        //THEN
        System.out.println(result);
    }

    @Tag("homework")
    @Test
    public void shouldFactForNegativeNumber(){
        //WHEN
        double result = expert.fact(-4);
        //THEN
        System.out.println(result);
    }
}
