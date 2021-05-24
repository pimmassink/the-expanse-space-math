package main.metrics;

import java.util.Objects;
import main.NumberUtils;

/**
 * The value is in meters / second
 */
public class Speed {

    private final double value;
    private static double NUMBER_OF_MS_IN_KMS = 1000;
    private static double NUMBER_OF_MS_IN_KMH = 3.6;

    private Speed(double value) {
        this.value = value;
    }

    public static Speed Ms(double metersPerSecond) {
        return new Speed(metersPerSecond);
    }

    public static Speed Kms(double kmPerSecond) {
        return new Speed(kmPerSecond / NUMBER_OF_MS_IN_KMS);
    }

    public static Speed Kmh(double kmPerHour) {
        return new Speed(kmPerHour / NUMBER_OF_MS_IN_KMH);
    }

    public double getMsValue() {
        return this.value;
    }

    public double getKmsValue() {
        return this.value / NUMBER_OF_MS_IN_KMS;
    }

    public double getKmhValue() {
        return this.value * 3.6;
    }

    @Override
    public String toString() {
        if (this.value > 10000) {
            return "Your speed is: " + NumberUtils.round(getKmsValue()) + "km/s";
        }
        return "Your speed is: " + NumberUtils.round(getMsValue()) + "m/s, or: " + NumberUtils.round(getKmhValue()) + "km/h";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Speed speed = (Speed) o;
        return Double.compare(speed.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
