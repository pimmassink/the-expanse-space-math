package main.metrics;

import java.util.Objects;
import main.NumberUtils;

/**
 * A duration is a certain length of time, which we track in seconds; the value.
 * A double type can hold the total number of seconds until the end of time - no BigDecimal needed.
 */
public class Duration {


    private final double value;

    public Duration(double value) {
        this.value = value;
    }

    private static double SECONDS_IN_MINUTE = 60;
    private static double SECONDS_IN_HOUR = 3600;
    private static double SECONDS_IN_DAY = 86400;
    private static double SECONDS_IN_WEEK = 604800;
    private static double SECONDS_IN_YEAR = 31536000;

    public static Duration Seconds(double numberOfSeconds) {
        return new Duration(numberOfSeconds);
    }

    public static Duration Minutes(double numberOfMinutes) {
        return new Duration(numberOfMinutes * SECONDS_IN_MINUTE);
    }

    public static Duration Hours(double numberOfHours) {
        return new Duration(numberOfHours * SECONDS_IN_HOUR);
    }

    public static Duration Days(double numberOfDays) {
        return new Duration(numberOfDays * SECONDS_IN_DAY);
    }

    public static Duration Weeks(double numberOfWeeks) {
        return new Duration(numberOfWeeks * SECONDS_IN_WEEK);
    }

    public static Duration Years(double numberOfYears) {
        return new Duration(numberOfYears * SECONDS_IN_YEAR);
    }

    public double getSecondValue() {
        return this.value;
    }

    public double getMinuteValue() {
        return this.value / SECONDS_IN_MINUTE;
    }

    public double getHourValue() {
        return this.value / SECONDS_IN_MINUTE;
    }

    public double getDayValue() {
        return this.value / SECONDS_IN_DAY;
    }

    public double getWeekValue() {
        return this.value / SECONDS_IN_WEEK;
    }

    public double getYearValue() {
        return this.value / SECONDS_IN_YEAR;
    }

    // We write the duration as A weeks, B days, C hours, D minutes, E seconds
    @Override
    public String toString() {
        double remainder = value;

        int years = (int) (remainder / SECONDS_IN_YEAR);
        remainder = remainder % SECONDS_IN_YEAR;

        int weeks = (int) (remainder / SECONDS_IN_WEEK);
        remainder = remainder % SECONDS_IN_WEEK;

        int days = (int) (remainder / SECONDS_IN_DAY);
        remainder = remainder % SECONDS_IN_DAY;

        int hours = (int) (remainder / SECONDS_IN_HOUR);
        remainder = remainder % SECONDS_IN_HOUR;

        int minutes = (int) (remainder / SECONDS_IN_MINUTE);
        remainder = remainder % SECONDS_IN_MINUTE;

        double seconds = remainder;

        StringBuilder result = new StringBuilder();
        if (years > 0) {
            result.append(years).append(" years");
        }
        if (weeks > 0) {
            result.append(", ").append(weeks).append(" weeks");
        }
        if (days > 0) {
            result.append(", ").append(days).append(" days");
        }
        if (hours > 0) {
            result.append(", ").append(hours).append(" hours");
        }
        if (minutes > 0) {
            result.append(", ").append(minutes).append(" minutes");
        }
        if (seconds > 0) {
            result.append(", ").append(NumberUtils.round(seconds)).append(" seconds");
        }
        if (result.length() > 0 && result.charAt(0) == ',') {
            result.deleteCharAt(0);
            result.deleteCharAt(0);
        }

        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Duration duration = (Duration) o;
        return Double.compare(duration.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
