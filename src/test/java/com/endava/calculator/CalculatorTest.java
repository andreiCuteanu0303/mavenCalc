package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.expert.Expert;
import com.endava.extensions.TestReporterExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@ExtendWith(TestReporterExtension.class)
public class CalculatorTest {

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


    @Tags({@Tag("smoke"), @Tag("ui")})
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldAddNumbersGivenOperand0(int a, int b){
        //WHEN
        long result = basic.add(a, b);

        //THEN
        System.out.println(result);
    }

    public static List<Arguments> numberProvider(){
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2));
        argumentsList.add(Arguments.of(2, 0));

        return argumentsList;
    }

    @Tag("smoke")
    @Test
    public void shouldAddNegativeNumbers() {
        //WHEN
        long result = basic.add(-2, -4);

        //THEN
        System.out.println(result);
    }

    @Tags({@Tag("smoke"), @Tag("api")})
    @Test
    public void shouldAddBigNumbers() {
        //WHEN
        int result = basic.add(Integer.MAX_VALUE, 1);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddZeroOperand(){
        //WHEN
        int result = basic.add();
        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddOneOperand(){
        //WHEN
        int result = basic.add(4);
        //THEN
        System.out.println(result);
    }

    @ParameterizedTest
    @CsvSource({"1,2,4", "2,4,5"})
    @CsvFileSource(resources = "/com.endava.calculator/numberSources.csv")
    public void shouldAddMoreOperands(Integer a1, Integer b2, Integer c3){
        //WHEN
        int result = basic.add(a1, b2, c3);
        //THEN
        System.out.println(result);
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
