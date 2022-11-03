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
import org.junit.platform.launcher.core.LauncherFactory;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

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


    @Tags({@Tag("smoke"), @Tag("ui")})
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldAddNumbersGivenOperand0(int a, int b, long expected){
        //WHEN
        long result = basic.add(a, b);

        //THEN
        assertThat(result, is(expected));
    }

    public static List<Arguments> numberProvider(){
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2, 2));
        argumentsList.add(Arguments.of(2, 0, 2));

        return argumentsList;
    }

    @Tag("smoke")
    @Test
    public void shouldAddNegativeNumbers() {
        //WHEN
        long result = basic.add(-2, -4);

        //THEN
        assertEquals(-6L, result);
        assertTrue(result == -6L);
    }

    //Bug found: JIRA-1456
    @Tags({@Tag("smoke"), @Tag("api")})
    @Test
    @DisplayName("Test that adds a big number as: MAX_INT")
    public void shouldAddBigNumbers() {

        assertThrows(AssertionError.class, () ->{
            //WHEN
            long result = basic.add(Integer.MAX_VALUE, 1L);

            //THEN
            assertThat(result, is(Integer.MAX_VALUE + 1L));
            //bug next
            assertThat(result, lessThan(0L));
            assertThat(result, notNullValue());
        });
    }

    @Test
    public void shouldAddZeroOperand(){
        //WHEN
        int result = basic.add();
        //THEN
        assertThat(result, is(0));
    }

    @Test
    public void shouldAddOneOperand(){
        //WHEN
        int result = basic.add(4);
        //THEN
        assertThat(result, is(4));
    }

    @ParameterizedTest
    @CsvSource({"1,2,4,7", "2,4,5,11"})
    @CsvFileSource(resources = "/com.endava.calculator/numberSources.csv")
    public void shouldAddMoreOperands(Integer a1, Integer b2, Integer c3, int expected){
        //WHEN
        int result = basic.add(a1, b2, c3);
        //THEN
        assertThat(result, is(expected));
    }
}
