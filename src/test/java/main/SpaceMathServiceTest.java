package main;

import static main.metrics.Acceleration.Mss;

import main.metrics.Acceleration;
import main.metrics.Distance;
import main.metrics.Duration;
import main.metrics.Speed;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class SpaceMathServiceTest {

    SpaceMathService spaceMathService = new SpaceMathService();

    @Nested
    class DistanceTravelled {
        @Test
        void whenAccIs10Mss_For0Seconds_shouldReturnZero() {
            Distance actual = spaceMathService.distanceTravelled(Mss(10), Duration.Seconds(0));
            Assertions.assertEquals(Distance.Meters(0), actual);
        }

        @Test
        void whenAccIs10Mss_For1Seconds_shouldReturn5() {
            Distance actual = spaceMathService.distanceTravelled(Mss(10), Duration.Seconds(1));
            Assertions.assertEquals(Distance.Meters(5), actual);
        }

        @Test
        void whenAccIs10Mss_For2Seconds_shouldReturn20() {
            Distance actual = spaceMathService.distanceTravelled(Mss(10), Duration.Seconds(2));
            Assertions.assertEquals(Distance.Meters(20), actual);
        }

        @Test
        void whenAccIs10Mss_For3Seconds_shouldReturn45() {
            Distance actual = spaceMathService.distanceTravelled(Mss(10), Duration.Seconds(3));
            Assertions.assertEquals(Distance.Meters(45), actual);
        }

        @Test
        void whenAccIs10Mss_For4Seconds_shouldReturn80() {
            Distance actual = spaceMathService.distanceTravelled(Mss(10), Duration.Seconds(4));
            Assertions.assertEquals(Distance.Meters(80), actual);
        }

        @Test
        void whenAccIs10Mss_For5Seconds_shouldReturn125() {
            Distance actual = spaceMathService.distanceTravelled(Mss(10), Duration.Seconds(5));
            Assertions.assertEquals(Distance.Meters(125), actual);
        }

    }

    @Nested
    class CalculateTopSpeed {
        @Test
        void whenAccIs10Mss_After5Seconds_ShouldBe50Ms() {
            Speed actual = spaceMathService.calculateTopSpeed(Mss(10), Duration.Seconds(5));
            Assertions.assertEquals(Speed.Ms(50), actual);
        }
    }

    @Nested
    class CalculateTripDurationWithoutBreaking {
        @Test
        void whenAccIs10Mss_andDistance45_tripLasts3Seconds() {
            Duration actual = spaceMathService.calculateTripDurationWithoutBreaking(Acceleration.Mss(10), Distance.Meters(45));
            Assertions.assertEquals(Duration.Seconds(3), actual);
        }

        @Test
        void whenAccIs10Mss_andDistance80_tripLasts4Seconds() {
            Duration actual = spaceMathService.calculateTripDurationWithoutBreaking(Acceleration.Mss(10), Distance.Meters(80));
            Assertions.assertEquals(Duration.Seconds(4), actual);
        }

        @Test
        void whenAccIs10Mss_andDistance125_tripLasts5Seconds() {
            Duration actual = spaceMathService.calculateTripDurationWithoutBreaking(Acceleration.Mss(10), Distance.Meters(125));
            Assertions.assertEquals(Duration.Seconds(5), actual);
        }

        @Test
        void whenAccIs10Mss_andDistance100_ShouldDisplayFractionalSeconds() {
            Duration actual = spaceMathService.calculateTripDurationWithoutBreaking(Acceleration.Mss(10), Distance.Meters(100));
            Assertions.assertEquals(Duration.Seconds(4.47213595499958), actual);
        }

        @Test
        void whenAccIs10Mss_ATripOf1000m_lasts14Seconds() {
            Duration actual = spaceMathService.calculateTripDurationWithoutBreaking(Acceleration.Mss(10), Distance.Meters(1000));
            Assertions.assertEquals(Duration.Seconds(14.142135623730951), actual);
        }

        @Test
        void whenAccIs10Mss_ATripOf2000m_lasts20Seconds() {
            Duration actual = spaceMathService.calculateTripDurationWithoutBreaking(Acceleration.Mss(10), Distance.Meters(2000));
            Assertions.assertEquals(Duration.Seconds(20), actual);
        }

        @Test
        void whenAccIsOneThirdG_aTripToJupiterOf10AU_takes() {
            Duration actual = spaceMathService.calculateTripDurationWithoutBreaking(Acceleration.G(0.33), Distance.AU(10));
            Assertions.assertEquals("1 weeks, 4 days, 3 hours, 5 minutes, 24.592 seconds", actual.toString());
        }

        @Test
        void whenAccIs1G_aTripToJupiterOf10AU_takes() {
            Duration actual = spaceMathService.calculateTripDurationWithoutBreaking(Acceleration.G(1), Distance.AU(10));
            Assertions.assertEquals("6 days, 9 hours, 25 minutes, 53.825 seconds", actual.toString());
        }

        @Test
        void whenAccIsOneThirdG_aTripToPlutoOf40AU_takes() {
            Duration actual = spaceMathService.calculateTripDurationWithoutBreaking(Acceleration.G(0.33), Distance.AU(40));
            Assertions.assertEquals("3 weeks, 1 days, 6 hours, 10 minutes, 49.183 seconds", actual.toString());
        }

        @Test
        void whenAccIs1G_aTripToPlutoOf40AU_takes() {
            Duration actual = spaceMathService.calculateTripDurationWithoutBreaking(Acceleration.G(1), Distance.AU(40));
            Assertions.assertEquals("1 weeks, 5 days, 18 hours, 51 minutes, 47.651 seconds", actual.toString());
        }
    }

    @Nested
    class CalculateTripDuration {

        @Test
        void whenAccIs10Mss_ATripOf1000m_lasts20Seconds() {
            Duration actual = spaceMathService.calculateTripDuration(Acceleration.Mss(10), Distance.Meters(1000));
            Assertions.assertEquals(Duration.Seconds(20), actual);
        }

        @Test
        void whenAccIs10Mss_ATripOf2000m_lasts28Seconds() {
            Duration actual = spaceMathService.calculateTripDuration(Acceleration.Mss(10), Distance.Meters(2000));
            Assertions.assertEquals(Duration.Seconds(28.284271247461902), actual);
        }

        @Test
        void whenAccIsOneThirdG_aTripToJupiterOf10AU_takes() {
            Duration actual = spaceMathService.calculateTripDuration(Acceleration.G(0.33), Distance.AU(10));
            Assertions.assertEquals("2 weeks, 1 days, 17 hours, 43 minutes, 21.118 seconds", actual.toString());
        }

        @Test
        void whenAccIs1G_aTripToJupiterOf10AU_takes() {
            Duration actual = spaceMathService.calculateTripDuration(Acceleration.G(1), Distance.AU(10));
            Assertions.assertEquals("1 weeks, 2 days, 59 minutes, 6.271 seconds", actual.toString());
        }

        @Test
        void whenAccIsOneThirdG_aTripToPlutoOf40AU_takes() {
            Duration actual = spaceMathService.calculateTripDuration(Acceleration.G(0.33), Distance.AU(40));
            Assertions.assertEquals("4 weeks, 3 days, 11 hours, 26 minutes, 42.236 seconds", actual.toString());
        }

        @Test
        void whenAccIs1G_aTripToPlutoOf40AU_takes() {
            Duration actual = spaceMathService.calculateTripDuration(Acceleration.G(1), Distance.AU(40));
            Assertions.assertEquals("2 weeks, 4 days, 1 hours, 58 minutes, 12.542 seconds", actual.toString());
        }


    }

}
