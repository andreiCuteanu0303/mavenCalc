package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTestAssertJ {

    private Basic basic = new Basic();

    @Test
    public void shouldAddOneOperand(){
        //WHEN
        long result = basic.add(167L);

        //THEN
        assertThat(result).isBetween(100L, 200L)
                .isGreaterThan(150L)
                .isEqualTo(167L)
                .isNegative()
                .isNotNull();

    }
}
