package main.metrics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DurationTest {

    @Nested
    class ToString {

        @Test
        public void toString_shouldDisplayHoursAndMinutesAndSeconds_Correctly() {
            Duration duration = Duration.Seconds(3688.5);
            Assertions.assertEquals("1 hours, 1 minutes, 28.5 seconds", duration.toString());
        }

        @Test
        public void toString_shouldYearsAndWeeks_Correctly() {
            Duration duration = Duration.Weeks(580.523);
            Assertions.assertEquals("11 years, 6 weeks, 6 days, 15 hours, 51 minutes, 50.4 seconds", duration.toString());
        }
    }

}
