package main;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {

    public static double round(double input) {
        return round(input, 3);
    }

    public static double round(double input, int scale) {
        return new BigDecimal(Double.toString(input)).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }

}
