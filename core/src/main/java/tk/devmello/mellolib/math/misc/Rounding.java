package tk.devmello.mellolib.math.misc;



import tk.devmello.mellolib.util.misc.ValidationUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rounding {
    /**
     * The default number of places to round to.
     */
    public static final int DEFAULT_PLACES = 3;


    public static int roundInt(double value) {
        return (int) Math.round(value);
    }


    @Deprecated
    public static double round(double value, int places) {
        ValidationUtils.validate(value, "value");

        if (places < 0) throw new IllegalArgumentException(
                "Places must be greater than 0"
        );

        BigDecimal decimal = new BigDecimal(Double.toString(value))
                .setScale(places, RoundingMode.HALF_UP);
        return decimal.doubleValue();
    }


    @Deprecated
    public static double round(double value) {
        return round(value, DEFAULT_PLACES);
    }


    public static double fastRound(double value, int places) {
        ValidationUtils.validate(value, "value");

        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }


    public static double fastRound(double value) {
        return fastRound(value, DEFAULT_PLACES);
    }
}
