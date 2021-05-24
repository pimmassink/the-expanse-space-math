package main.metrics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class SpeedTest {

    @Nested
    class ToString {

        @Test
        public void toString_shouldShowFractionsCorrectly_atLowSpeeds() {
            Speed s = Speed.Ms(1000.12323);
            Assertions.assertEquals("Your speed is: 1000.123m/s, or: 3600.444km/h", s.toString());
        }

        @Test
        public void toString_shouldShowFractionsCorrectly_atHighSpeeds() {
            Speed s = Speed.Ms(15998877.12323);
            Assertions.assertEquals("Your speed is: 15998.877km/s", s.toString());
        }
    }

}
