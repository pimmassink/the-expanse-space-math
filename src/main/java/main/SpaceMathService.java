package main;

import java.math.BigDecimal;
import java.math.MathContext;
import main.metrics.Acceleration;
import main.metrics.Distance;
import main.metrics.Duration;
import main.metrics.Speed;

public class SpaceMathService {

    /**
     * Rather remarkably, we can use a double for the calculations here, it works rather well!
     * It does not reach its maximum value.
     * It makes me think whether the entire program could have worked using doubles instead of big-whatever
     * Formula: Distance = 0.5 * Time ^ 2 * Acceleration
     * FIXME: This does not calculate the maximum speed. It does not set a maximum speed...
     */
    public Distance distanceTravelled(Acceleration acceleration, Duration duration) {
        double distanceInMeters = 0.5 * Math.pow(duration.getSecondValue(), 2) * acceleration.getMssValue();
        System.out.println("Distance in meters is: " + distanceInMeters);
        Distance result = Distance.Meters(distanceInMeters);
        return result;
    }

    public Speed calculateTopSpeed(Acceleration acceleration, Duration duration) {
        return Speed.Ms(acceleration.getMssValue() * duration.getSecondValue());
    }

    /**
     * This is for a missile of sorts that doesn't have to break to get to it's location
     * The formula is: Time(s) = Sqrt( Distance(m) / (0.5 * Acceleration(mss) )
     */
    public Duration calculateTripDurationWithoutBreaking(Acceleration acceleration, Distance distance) {
        double denom = 0.5 * acceleration.getMssValue();
        double durInS = Math.sqrt(distance.getMeterValue().doubleValue() / denom);
        return Duration.Seconds(durInS);
    }

    /**
     * This is for humans, who peak their velocity halfway through the trip, and then break
     */
    public Duration calculateTripDuration(Acceleration acceleration, Distance distance) {
        Distance halfWay = Distance.Meters(distance.getMeterValue().divide(new BigDecimal("2"), MathContext.DECIMAL128));
        Duration halfTripDuration = calculateTripDurationWithoutBreaking(acceleration, halfWay);
        Duration result = Duration.Seconds(halfTripDuration.getSecondValue() * 2);
        return result;
    }
}
