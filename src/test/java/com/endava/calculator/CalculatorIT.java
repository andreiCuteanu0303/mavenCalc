package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.expert.Expert;
import com.endava.extensions.TestReporterExtension;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.launcher.core.LauncherFactory;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.assertThat;

//========================== Exercise 4 ============================
// 4. Research a way to skip the tests for the surefire plugin and then for the failsafe plugin
/**
 * - How to skip the tests for the failsafe plugin:
 *   1. Set pom surefire plugin <skipTest> property to false
 *   2. Set pom failsafe plugin <skipTest> property to true
 *   3. Run command "mvn install -DskipITs" in terminal
 */

@ExtendWith(TestReporterExtension.class)
public class CalculatorIT{
    private Basic basic;
    private Expert expert;

    public static final Logger LOGGER = LogManager.getLogger(CalculatorIT.class);

    @BeforeAll
    public static void setUpAllTests(){
//        LauncherFactory.create().registerTestExecutionListeners();
        LOGGER.info("Before All");
    }

    @AfterAll
    public static void tearDownAllTests(){
        LOGGER.info("After All");
    }

    @BeforeEach
    public void setUpEachTest() {
        basic = new Basic();
        expert = new Expert();
        LOGGER.info("Before Each");
    }

    @AfterEach
    public void tearDownEachTest() {
        LOGGER.info("After Each  \n");
    }



    //=========================== Homework =============================

    //========================== Exercise 1 ============================
    // 1. Create testcases for multiply, pow and factorial methods

    //========================== Exercise 2 ============================
    // 2. Make the same tests run only on the verify phase

    //=========================== Multiply =============================
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldMultiplyWith0(int a, int b, double expected){
        //WHEN
        double result = basic.multiply(a, b);
        //THEN
        assertThat(result, is(expected));
        assertThat(result, greaterThanOrEqualTo(expected));
    }

    public static List<Arguments> numberProvider(){
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2, 0));
        argumentsList.add(Arguments.of(2, 0, 0));

        return argumentsList;
    }

    @Test
    public void shouldMultiplyWithNegativeNumbers(){
        //WHEN
        double result = basic.multiply(-3, -23);
        //THEN
        assertThat(69).isOdd()
                .isEqualTo(69L)
                .isLessThan(100);
    }

    @Test
    public void shouldMultiplyNoOperands(){
        //WHEN
        double result = basic.multiply();
        //THEN
        assertThat(result, is(1.0));
        assertThat(1.0, greaterThan(0.0));
    }


    @Test
    public void shouldMultiplyOneOperand(){
        //WHEN
        double result = basic.multiply(3.0);
        //THEN
        assertThat(result, is(3.0));
        assertThat(3.0, greaterThanOrEqualTo(0.0));
    }

    //=========================== Power =============================

    @Test
    public void shouldPowWithGivenNumbers(){
        //WHEN
        double result = expert.pow(4, 3);
        //THEN
        assertThat(result).isFinite()
                .isNotNull()
                .isEqualTo(64)
                .isGreaterThan(0);
    }

    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldPowWith0(int a, int b, double expected){
        //WHEN
        double result = expert.pow(a, b);
        //THEN
        assertThat(result).isFinite()
                .isNotNull()
                .isGreaterThanOrEqualTo(expected);
    }

    @Test
    public void shouldPowWithNegativeNumbers(){
        //WHEN
        double result = expert.pow(-5, -3);
        //THEN
        assertThat(result).isNotNull()
                .isEqualTo(-0.008)
                .isLessThan(0.0)
                .isNegative();
    }

    //=========================== Factorial =============================

    @Test
    public void shouldFactForGivenOperand(){
        //WHEN
        long result = expert.fact(4);
        //THEN
        assertThat(result).isNotNull()
                .isEqualTo(24)
                .isGreaterThan(4);
    }

    @Test
    public void shouldFactForOperand0(){
        //WHEN
        long result = expert.fact(0);
        //THEN
        assertThat(result).isNotNull()
                .isEqualTo(1L)
                .isLessThan(100L);
    }


    @Test
    public void shouldFactForNegativeNumber(){
        //WHEN
        double result = expert.fact(-3);
        //THEN
        assertThat(result).isNotNull()
                .isEqualTo(1)
                .isGreaterThan(0);
    }
}
