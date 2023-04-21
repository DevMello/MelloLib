package tk.devmello.mellolib.util.misc;

public class NotNull {

    private NotNull() {}

    public static boolean isAnythingNull(Object... objects) {
        for (Object obj : objects) {
            if (obj == null) {
                return true;
            }
        }

        return false;
    }

    public static boolean isNothingNull(Object... objects) {
        return !isAnythingNull(objects);
    }

    public static void throwExceptionIfNull(String message, Object... objects) {
        if (isAnythingNull(objects)) {
            throw new NullPointerException(message);
        }
    }
}