package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.expert.Expert;
import com.endava.extensions.TestReporterExtension;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

//========================== Exercise 4 ============================
// 4. Research a way to skip the tests for the surefire plugin and then for the failsafe plugin
/**
 * - How to skip the tests for the surefire plugin:
 *   1. Set pom surefire plugin <skipTest> property to true
 *   2. Set pom failsafe plugin <skipTest> property to false
 *   3. Run command "mvn install -DskipITs" in terminal
 */

@SuppressWarnings("ALL")
@ExtendWith(TestReporterExtension.class)
public class CalculatorTest {

    private Basic basic;
    private Expert expert;

    public static final Logger LOGGER = LogManager.getLogger(CalculatorTest.class);

    @BeforeAll
    public static void setUpAllTests(){
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


    @Tags({@Tag("smoke"), @Tag("ui")})
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldAddNumbersGivenOperand0(int a, int b){
        //WHEN
        long result = basic.add(a, b);

        //THEN
        LOGGER.info(result);
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
        LOGGER.info(result);
    }

    @Tags({@Tag("smoke"), @Tag("api")})
    @Test
    public void shouldAddBigNumbers() {
        //WHEN
        int result = basic.add(Integer.MAX_VALUE, 1);

        //THEN
        LOGGER.info(result);
    }

    @Test
    public void shouldAddZeroOperand(){
        //WHEN
        int result = basic.add();
        //THEN
        LOGGER.info(result);
    }

    @Test
    public void shouldAddOneOperand(){
        //WHEN
        int result = basic.add(4);
        //THEN
        LOGGER.info(result);
    }

    @ParameterizedTest
    @CsvSource({"1,2,4", "2,4,5"})
    @CsvFileSource(resources = "/com.endava.calculator/numberSources.csv")
    public void shouldAddMoreOperands(Integer a1, Integer b2, Integer c3){
        //WHEN
        int result = basic.add(a1, b2, c3);
        //THEN
        LOGGER.info(result);
    }
}
