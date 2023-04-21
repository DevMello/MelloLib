package tk.devmello.mellolib.math.misc;



import tk.devmello.mellolib.exceptions.InvalidToleranceException;
import tk.devmello.mellolib.math.geometry.Angle;
import tk.devmello.mellolib.util.misc.ValidationUtils;


public class Equals {

    public static boolean softWithoutValidation(
            double a,
            double b,
            double tolerance
    ) {
        return Math.abs(a - b) <= tolerance;
    }


    public static boolean soft(double a, double b, double tolerance) {
        ValidationUtils.validate(a);
        ValidationUtils.validate(b);
        ValidationUtils.validate(tolerance);

        if (tolerance < 0) {
            throw new InvalidToleranceException(
                    "Cannot have a tolerance value less than 0!"
            );
        }

        return softWithoutValidation(a, b, tolerance);
    }


    public static boolean soft(int a, int b, int tolerance) {
        ValidationUtils.validate(a);
        ValidationUtils.validate(b);
        ValidationUtils.validate(tolerance);

        if (tolerance < 0) {
            throw new InvalidToleranceException(
                    "Cannot have a tolerance value less than 0!"
            );
        }

        return Math.abs(a - b) <= tolerance;
    }


    public static boolean soft(float a, float b, float tolerance) {
        ValidationUtils.validate(a);
        ValidationUtils.validate(b);
        ValidationUtils.validate(tolerance);

        if (tolerance < 0) {
            throw new InvalidToleranceException(
                    "Cannot have a tolerance value less than 0!"
            );
        }

        return Math.abs(a - b) <= tolerance;
    }


    public static boolean soft(long a, long b, long tolerance) {
        ValidationUtils.validate(a);
        ValidationUtils.validate(b);
        ValidationUtils.validate(tolerance);

        if (tolerance < 0) {
            throw new InvalidToleranceException(
                    "Cannot have a tolerance value less than 0!"
            );
        }

        return Math.abs(a - b) <= tolerance;
    }


    public static boolean softWithoutValidation(
            Angle a,
            Angle b,
            Angle tolerance
    ) {
        double minimumDeltaDeg = Math.abs(Angle.angleDeltaDeg(a, b));
        double toleranceDeg = Math.abs(tolerance.deg());

        return minimumDeltaDeg <= toleranceDeg;
    }


    public static boolean soft(Angle a, Angle b, Angle tolerance) {
        ValidationUtils.validate(a, "a");
        ValidationUtils.validate(b, "b");
        ValidationUtils.validate(tolerance, "tolerance");

        return softWithoutValidation(a, b, tolerance);
    }
}
