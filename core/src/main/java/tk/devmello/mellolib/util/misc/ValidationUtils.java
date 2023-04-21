package tk.devmello.mellolib.util.misc;


import tk.devmello.mellolib.exceptions.ValidationException;
import tk.devmello.mellolib.queuing.tasks.TaskQueue;
import tk.devmello.mellolib.util.java.StringUtils;


public class ValidationUtils {
    private static final String NO_NAME = "parameter name not specified";
    private static final String NO_MORE_INFO = "no more information specified";

    public static double validateNotNaN(
            double value,
            String parameterName,
            String customMessage
    ) {
        if (Double.isNaN(value)) {
            TaskQueue.logger.consoleLogError(StringUtils.format(
                    "Could not validate (value: <%s> parameterName: <%s> " +
                            "customMesssage: <%s>) because it was NaN!",
                    value,
                    parameterName,
                    customMessage
            ));

            throw new ValidationException(
                    StringUtils.format(
                            "Failed to validate double <%s> because " +
                                    "the value was not a number! Value: <%s> (%s)",
                            parameterName,
                            value,
                            customMessage
                    )
            );
        }

        return value;
    }

    public static double validateNotNaN(double value, String parameterName) {
        return validateNotNaN(value, parameterName, NO_MORE_INFO);
    }

    public static double validateNotInfinite(
            double value,
            String parameterName,
            String customMessage
    ) {
        if (Double.isInfinite(value)) {
            TaskQueue.logger.consoleLogError(
                    StringUtils.format(
                            "Failed to validate double <%s> because " +
                                    "the value was infinite! Value: <%s> (%s)",
                            parameterName,
                            value,
                            customMessage
                    )
            );

            throw new ValidationException(
                    StringUtils.format(
                            "Failed to validate double <%s> because " +
                                    "the value was infinite! Value: <%s> (%s)",
                            parameterName,
                            value,
                            customMessage
                    )
            );
        }

        return value;
    }

    public static double validateNotInfinite(
            double value,
            String parameterName
    ) {
        return validateNotInfinite(value, parameterName, NO_MORE_INFO);
    }

    /**
     * Validate a double value by ensuring it's not {@code NaN} or infinite.
     * If the number is {@code NaN} or infinite, this method will throw
     * an {@link ValidationException}.
     *
     * @param value         the value to validate.
     * @param parameterName the name of the parameter that's being validated.
     * @param canBeNaN      can the value be NaN?
     * @param canBeInfinite can the value be positive or negative infinity?
     * @param customMessage a custom message to display at the end of the
     *                      exception that's thrown if validation fails.
     * @return if the value is validated (meaning it's not {@code NaN} and
     * it's not infinite), return the value.
     */
    public static double validate(
            double value,
            String parameterName,
            boolean canBeNaN,
            boolean canBeInfinite,
            String customMessage
    ) {
        if (!canBeNaN) validateNotNaN(value, parameterName, customMessage);
        if (!canBeInfinite) validateNotInfinite(
                value,
                parameterName,
                customMessage
        );

        return value;
    }

    /**
     * Validate a double value by ensuring it's not {@code NaN} or infinite.
     * If the number is {@code NaN} or infinite, this method will throw
     * an {@link ValidationException}.
     *
     * @param value         the value to validate.
     * @param parameterName the name of the parameter that's being validated.
     * @param mode          the validation mode.
     * @param customMessage a custom message to display at the end of the
     *                      exception that's thrown if validation fails.
     * @return if the value is validated (meaning it's not {@code NaN} and
     * it's not infinite), return the value.
     */
    public static double validate(
            double value,
            String parameterName,
            DoubleValidationMode mode,
            String customMessage
    ) {
        return validate(
                value,
                parameterName,
                mode.canBeNaN,
                mode.canBeInfinite,
                customMessage
        );
    }

    /**
     * Validate a double value by ensuring it's not {@code NaN} or infinite.
     * If the number is {@code NaN} or infinite, this method will throw
     * an {@link ValidationException}.
     *
     * @param value         the value to validate.
     * @param parameterName the name of the parameter that's being validated.
     * @param customMessage a custom message to display at the end of the
     *                      exception that's thrown if validation fails.
     * @return if the value is validated (meaning it's not {@code NaN} and
     * it's not infinite), return the value.
     */
    public static double validate(
            double value,
            String parameterName,
            String customMessage
    ) {
        return validate(
                value,
                parameterName,
                DoubleValidationMode.NOT_NAN_OR_INFINITE,
                customMessage
        );
    }

    /**
     * Validate a double value by ensuring it's not {@code NaN} or infinite.
     * If the number is {@code NaN} or infinite, this method will throw
     * an {@link ValidationException}.
     *
     * @param value         the value to validate.
     * @param parameterName the name of the parameter that's being validated.
     * @return if the value is validated (meaning it's not {@code NaN} and
     * it's not infinite), return the value.
     */
    public static double validate(double value, String parameterName) {
        return validate(value, parameterName, NO_MORE_INFO);
    }

    /**
     * Validate a double value by ensuring it's not {@code NaN} or infinite.
     * If the number is {@code NaN} or infinite, this method will throw
     * a {@link ValidationException}.
     *
     * @param value         the value to validate.
     * @return if the value is validated (meaning it's not {@code NaN} and
     * it's not infinite), return the value.
     */
    public static double validate(double value) {
        return validate(value, NO_NAME);
    }

    /**
     * Validate a float value by ensuring it's not {@code NaN} or infinite.
     * If the number is {@code NaN} or infinite, this method will throw
     * an {@link ValidationException}.
     *
     * @param value         the value to validate.
     * @param parameterName the name of the parameter that's being validated.
     * @return if the value is validated (meaning it's not {@code NaN} and
     * it's not infinite), return the value.
     */
    public static float validate(float value, String parameterName) {
        validate((double) value, parameterName);
        return value;
    }

    /**
     * Validate a double value by ensuring it's not {@code NaN} or infinite.
     * If the number is {@code NaN} or infinite, this method will throw
     * an {@link ValidationException}.
     *
     * @param value         the value to validate.
     * @return if the value is validated (meaning it's not {@code NaN} and
     * it's not infinite), return the value.
     */
    public static float validate(float value) {
        return validate(value, NO_NAME);
    }

    public static <T> T validateNotNull(
            T t,
            String parameterName,
            String customMessage
    ) {
        if (t == null) {
            TaskQueue.logger.consoleLogError(
                    StringUtils.format(
                            "Failed to validate object <%s> because it was null! (%s)",
                            parameterName,
                            customMessage
                    )
            );

            throw new ValidationException(
                    StringUtils.format(
                            "Failed to validate object <%s> because it was null! (%s)",
                            parameterName,
                            customMessage
                    )
            );
        }

        return t;
    }

    public static <T> T validateNotNull(T t, String parameterName) {
        return validateNotNull(t, parameterName, NO_MORE_INFO);
    }

    public static <T> T validate(
            T t,
            String parameterName,
            String customMessageFormat,
            Object[] formatSources
    ) {
        if (
                formatSources == null ||
                        formatSources.length < 1 ||
                        formatSources[0] == null
        ) return validateNotNull(t, parameterName, customMessageFormat);

        String customMessage = StringUtils.format(
                customMessageFormat,
                formatSources
        );

        return validateNotNull(t, parameterName, customMessage);
    }

    public static <T> T validateAndFormat(
            T t,
            String parameterName,
            String customMessage,
            Object... formatSources
    ) {
        return validate(t, parameterName, customMessage, formatSources);
    }

    public static <T> T validate(
            T t,
            String parameterName,
            String customMessage
    ) {
        return validateAndFormat(t, parameterName, customMessage);
    }

    /**
     * Validate an object by checking to see if it's null.
     *
     * @param t             the object to validate.
     * @param parameterName the name of the object.
     * @param <T>           the type.
     * @return the object.
     */
    public static <T> T validate(T t, String parameterName) {
        return validate(t, parameterName, NO_MORE_INFO);
    }

    /**
     * Validate an object by checking to see if it's null.
     *
     * @param t             the object to validate.
     * @param <T> the type.
     * @return the object.
     */
    public static <T> T validate(T t) {
        return validate(t, NO_NAME);
    }

    public enum DoubleValidationMode {
        DO_NOT_VALIDATE(true, true),
        NOT_NAN(false, true),
        NOT_INFINITE(true, false),
        NOT_NAN_OR_INFINITE(false, false);

        final boolean canBeNaN;
        final boolean canBeInfinite;

        DoubleValidationMode(boolean canBeNaN, boolean canBeInfinite) {
            this.canBeNaN = canBeNaN;
            this.canBeInfinite = canBeInfinite;
        }
    }
}