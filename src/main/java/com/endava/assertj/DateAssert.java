package com.endava.assertj;

import org.assertj.core.api.AbstractAssert;

import java.time.LocalDateTime;

public class DateAssert extends AbstractAssert<DateAssert, LocalDateTime> {
    public DateAssert( LocalDateTime localDateTime ) {
        super( localDateTime, DateAssert.class );
    }

    public static DateAssert assertThat(LocalDateTime actual ) {
        return new DateAssert( actual );
    }

    public DateAssert inLastFiveMinutes() {
        LocalDateTime fiveMinutesAgo = LocalDateTime.now().minusMinutes( 5 );
        if ( actual.isAfter( fiveMinutesAgo ) ) {
            failWithMessage( "Date is older than five minutes" );
        }
        return this;
    }
}
