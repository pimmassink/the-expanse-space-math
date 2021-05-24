package main.metrics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class AccelerationTest {

    @Nested
    class ToString {

        @Test
        public void toString_when1G_shouldDisplayCorrectly() {
            Acceleration a = Acceleration.G(1);
            Assertions.assertEquals("Your acceleration is: 1.0G, or: 35.30394km/h/s or: 9.80665m/s/s", a.toString());
        }

        @Test
        public void toString_whenOneThirdG_shouldDisplayCorrectly() {
            Acceleration a = Acceleration.G(0.33);
            Assertions.assertEquals("Your acceleration is: 0.33G, or: 11.6503002km/h/s or: 3.2361945m/s/s", a.toString());
        }

        @Test
        public void toString_when100kmhs_shouldDisplayCorrectly() {
            Acceleration a = Acceleration.Kmhs(100);
            Assertions.assertEquals("Your acceleration is: 2.833G, or: 100.0km/h/s or: 27.77777777777778m/s/s", a.toString());
        }

    }

}
