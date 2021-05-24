package main.metrics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DistanceTest {


    @Nested
    class ToString {
        @Test
        public void shouldDisplayMeterFractions() {
            Distance distance = Distance.Meters(10.15);
            Assertions.assertEquals("10.15 meters", distance.toString());
        }

        @Test
        public void shouldDisplayMeterFractions_andNoKmFractions() {
            Distance distance = Distance.Meters(1600.5);
            Assertions.assertEquals("1 kilometers, 600.5 meters", distance.toString());
        }

        @Test
        public void shouldDisplayMeterFractionsWhenKilometersAsInput() {
            Distance distance = Distance.Kilometers(1500.6005);
            Assertions.assertEquals("1500 kilometers, 600.5 meters", distance.toString());
        }

        @Test
        public void shouldCorrectlySeparateMetersAndKilometers() {
            Distance distance = Distance.Meters(5612);
            Assertions.assertEquals("5 kilometers, 612.0 meters", distance.toString());
        }

        @Test
        public void shouldDisplayAUWhenBelow150() {
            Distance distance = Distance.AU(149.12312);
            Assertions.assertEquals("149.12312 AU, or: 20 lightHours, 40 lightMinutes, 13 lightSeconds, 45046 kilometers, 986.584 meters", distance.toString());
        }

        @Test
        public void shouldNotDisplayAUWhenAbove150() {
            Distance distance = Distance.AU(150.1234);
            Assertions.assertEquals("20 lightHours, 48 lightMinutes, 32 lightSeconds, 88368 kilometers, 548.38 meters", distance.toString());
        }

        @Test
        public void shouldDescribeWhatAnAUIs() {
            Distance distance = Distance.AU(1);
            Assertions.assertEquals("1.0 AU, or: 8 lightMinutes, 19 lightSeconds, 1434 kilometers, 158.0 meters", distance.toString());
        }

    }

}
