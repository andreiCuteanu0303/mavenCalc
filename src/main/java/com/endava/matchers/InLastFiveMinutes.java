package com.endava.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.time.LocalDateTime;

public class InLastFiveMinutes extends TypeSafeMatcher<LocalDateTime> {
    @Override
    protected boolean matchesSafely( LocalDateTime actual ) {
        LocalDateTime fiveMinutesAgo = LocalDateTime.now().minusMinutes( 5 );;
        return actual.isAfter( fiveMinutesAgo );
    }

    @Override
    public void describeTo( Description description ) {
        description.appendText( "not in the last 5 minutes" );
    }

    public static Matcher<LocalDateTime> inLastFiveMinutes() {
        return new InLastFiveMinutes();
    }
}
