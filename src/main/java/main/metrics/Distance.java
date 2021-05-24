package main.metrics;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;
import main.NumberUtils;

public class Distance {

    // we measure distance in meters
    // this can be problematic because the observable universe is 4.40 * 10^26m :(
    // We must therefore use BigDecimal
    private final BigDecimal value;

    private static BigDecimal METERS_IN_LIGHT_SECONDS = new BigDecimal("299792458");
    private static BigDecimal METERS_IN_LIGHT_MINUTE = new BigDecimal("17987547480");
    private static BigDecimal METERS_IN_LIGHT_HOUR = new BigDecimal("1079252848800");
    private static BigDecimal METERS_IN_LIGHT_DAY = new BigDecimal("25902068371200");
    private static BigDecimal METERS_IN_LIGHT_WEEK = new BigDecimal("181314478598400");
    private static BigDecimal METERS_IN_LIGHT_YEAR = new BigDecimal("9460730472580800");
    private static BigDecimal METERS_IN_AU = new BigDecimal("149597870700");
    private static BigDecimal METERS_IN_KM = new BigDecimal("1000");

    private Distance(BigDecimal value) {
        this.value = value;
    }

    // FACTORY METHODS
    public static Distance Meters(BigDecimal numberOfMeters) {
        return new Distance(numberOfMeters);
    }

    public static Distance Meters(double meters) {
        return Meters(new BigDecimal(Double.toString(meters)));
    }

    public static Distance Kilometers(BigDecimal numberOfKm) {
        return new Distance(numberOfKm.multiply(METERS_IN_KM, MathContext.DECIMAL128));
    }

    public static Distance Kilometers(double numberOfKm) {
        return Kilometers(new BigDecimal(Double.toString(numberOfKm)));
    }

    public static Distance AU(BigDecimal numberOfAu) {
        return new Distance(numberOfAu.multiply(METERS_IN_AU, MathContext.DECIMAL128));
    }

    public static Distance AU(double numberOfAu) {
        return AU(new BigDecimal(Double.toString(numberOfAu)));
    }

    public static Distance LightMinutes(BigDecimal numberOfLightMinutes) {
        return new Distance(numberOfLightMinutes.multiply(METERS_IN_LIGHT_MINUTE, MathContext.DECIMAL128));
    }

    public static Distance LightMinutes(double numberOfLightMinutes) {
        return LightMinutes(new BigDecimal(Double.toString(numberOfLightMinutes)));
    }

    public static Distance LightHours(BigDecimal numberOfLightHours) {
        return new Distance(numberOfLightHours.multiply(METERS_IN_LIGHT_HOUR, MathContext.DECIMAL128));
    }

    public static Distance LightHours(double numberOfLightHours) {
        return LightHours(new BigDecimal(Double.toString(numberOfLightHours)));
    }

    public static Distance LightDays(BigDecimal numberOfLightDays) {
        return new Distance(numberOfLightDays.multiply(METERS_IN_LIGHT_DAY, MathContext.DECIMAL128));
    }

    public static Distance LightDays(double numberOfLightDays) {
        return LightDays(new BigDecimal(Double.toString(numberOfLightDays)));
    }

    public static Distance LightWeeks(BigDecimal numberOfLightWeeks) {
        return new Distance(numberOfLightWeeks.multiply(METERS_IN_LIGHT_WEEK, MathContext.DECIMAL128));
    }

    public static Distance LightWeeks(double numberOfLightWeeks) {
        return LightWeeks(new BigDecimal(Double.toString(numberOfLightWeeks)));
    }


    public static Distance LightYears(BigDecimal numberOfLightYears) {
        return new Distance(numberOfLightYears.multiply(METERS_IN_LIGHT_YEAR, MathContext.DECIMAL128));
    }

    public static Distance LightYears(double numberOfLightYears) {
        return LightYears(new BigDecimal(Double.toString(numberOfLightYears)));
    }

    // GETTERS
    public BigDecimal getMeterValue() {
        return value;
    }

    public BigDecimal getKilometerValue() {
        return value.divide(METERS_IN_KM, MathContext.DECIMAL128);
    }

    public BigDecimal getAUValue() {
        return value.divide(METERS_IN_AU, MathContext.DECIMAL128);
    }

    public BigDecimal getLightMinuteValue() {
        return value.divide(METERS_IN_LIGHT_MINUTE, MathContext.DECIMAL128);
    }

    @Override
    public String toString() {

        // IMPORTANT: 1 AU = 8.31 light minutes
        BigDecimal valueInDec = new BigDecimal(this.value.toString());
        double au = valueInDec.divide(METERS_IN_AU, MathContext.DECIMAL128).doubleValue();

        BigDecimal remainder = new BigDecimal(String.valueOf(value));
        long lightYears = (remainder.divide(METERS_IN_LIGHT_YEAR, MathContext.DECIMAL128)).longValue();
        remainder = remainder.remainder(METERS_IN_LIGHT_YEAR, MathContext.DECIMAL128);

        int lightWeeks = (remainder.divide(METERS_IN_LIGHT_WEEK, MathContext.DECIMAL128)).intValue();
        remainder = remainder.remainder(METERS_IN_LIGHT_WEEK, MathContext.DECIMAL128);

        int lightDays = (remainder.divide(METERS_IN_LIGHT_DAY, MathContext.DECIMAL128)).intValue();
        remainder = remainder.remainder(METERS_IN_LIGHT_DAY, MathContext.DECIMAL128);

        int lightHours = (remainder.divide(METERS_IN_LIGHT_HOUR, MathContext.DECIMAL128)).intValue();
        remainder = remainder.remainder(METERS_IN_LIGHT_HOUR, MathContext.DECIMAL128);

        int lightMinutes = (remainder.divide(METERS_IN_LIGHT_MINUTE, MathContext.DECIMAL128)).intValue();
        remainder = remainder.remainder(METERS_IN_LIGHT_MINUTE, MathContext.DECIMAL128);

        int lightSeconds = (remainder.divide(METERS_IN_LIGHT_SECONDS, MathContext.DECIMAL128)).intValue();
        remainder = remainder.remainder(METERS_IN_LIGHT_SECONDS, MathContext.DECIMAL128);

        int kilometers = (remainder.divide(METERS_IN_KM, MathContext.DECIMAL128)).intValue();
        remainder = remainder.remainder(METERS_IN_KM, MathContext.DECIMAL128);

        double meters = remainder.doubleValue();

        StringBuilder result = new StringBuilder();
        if (au < 150 && au > 0.05) {
            result.append(au).append(" AU, or: ");
        }
        //        if (lightYears > 0) {
        //            result.append(lightYears).append(" lightYears");
        //        }

        addToStringResult(lightYears, result, "lightYears");

        addToStringResult(lightWeeks, result, "lightWeeks");
        addToStringResult(lightDays, result, "lightDays");
        addToStringResult(lightHours, result, "lightHours");
        addToStringResult(lightMinutes, result, "lightMinutes");
        addToStringResult(lightSeconds, result, "lightSeconds");
        addToStringResult(kilometers, result, "kilometers");
        addToStringResult(meters, result, "meters");

        if (result.length() > 0 && result.charAt(0) == ',') {
            result.deleteCharAt(0);
            result.deleteCharAt(0);
        }

        return result.toString();
        // When do we display distances as light minutes, when as AU?

        // Het lijkt als

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Distance distance = (Distance) o;
        return value.equals(distance.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private BigDecimal helper(BigDecimal METERS_IN_DISTANCE, BigDecimal remainder, String unitName, StringBuilder strResult) {
        int unit = (remainder.divide(METERS_IN_DISTANCE)).intValue();
        remainder = remainder.remainder(METERS_IN_DISTANCE);
        addToStringResult(unit, strResult, unitName);
        return remainder;
    }

    private void addToStringResult(int unit, StringBuilder strResult, String unitName) {
        if (unit > 0) {
            if (strResult.length() > 0 && strResult.charAt(strResult.length() - 1) != ' ') {
                strResult.append(", ");
            }
            strResult.append(unit).append(" ").append(unitName);
        }
    }

    private void addToStringResult(long unit, StringBuilder strResult, String unitName) {
        if (unit > 0) {
            if (strResult.length() > 0 && strResult.charAt(strResult.length() - 1) != ' ') {
                strResult.append(", ");
            }
            strResult.append(unit).append(" ").append(unitName);
        }
    }

    private void addToStringResult(double unit, StringBuilder strResult, String unitName) {
        if (unit > 0) {
            if (strResult.length() > 0 && strResult.charAt(strResult.length() - 1) != ' ') {
                strResult.append(", ");
            }
            strResult.append(NumberUtils.round(unit)).append(" ").append(unitName);
        }
    }
}
