package main.metrics;

import java.util.Objects;
import main.NumberUtils;

/**
 * Acceleration's base value is measured in Meters per second per second (Mss).
 * Ergo a value of 10 means that every second you speed up with 10m/s more. This is roughly 1G, or 36km/h. You would reach 100kmh in under 3 seconds. :)
 */
public class Acceleration {

    private final double value;
    private static double NUMBER_OF_MSS_IN_G = 9.80665;
    private static double NUMBER_OF_KMHS_IN_MSS = 3.6;

    private Acceleration(double value) {
        this.value = value;
    }

    // STATIC FACTORY METHODS:
    public static Acceleration Mss(double numberOfMss) {
        return new Acceleration(numberOfMss);
    }

    public static Acceleration Kmhs(double numberOfKmhs) {
        return Mss(numberOfKmhs / NUMBER_OF_KMHS_IN_MSS);
    }

    public static Acceleration G(double numberOfGs) {
        return Mss(numberOfGs * NUMBER_OF_MSS_IN_G);
    }

    // GETTERS
    public double getGValue() {
        return this.value / NUMBER_OF_MSS_IN_G;
    }

    public double getMssValue() {
        return this.value;
    }

    public double getKmhsValue() {
        return this.value * NUMBER_OF_KMHS_IN_MSS;
    }

    @Override
    public String toString() {
        return "Your acceleration is: " + NumberUtils.round(getGValue()) + "G, or: " + getKmhsValue() + "km/h/s" + " or: " + getMssValue() + "m/s/s";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Acceleration that = (Acceleration) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
