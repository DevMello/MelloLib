package tk.devmello.mellolib.math.controllers;

import tk.devmello.mellolib.math.misc.MinMax;
import tk.devmello.mellolib.util.java.StringUtils;
import tk.devmello.mellolib.util.misc.ValidationUtils;

public abstract class AbstractController implements Controller{
    private double min = Double.NEGATIVE_INFINITY;

    /**
     * The controller's default maximum. Unless changed, this value is
     * equal to positive infinity, meaning there is no maximum.
     */
    private double max = Double.POSITIVE_INFINITY;

    /**
     * The controller's minimum magnitude.
     */
    private double minMagnitude = Double.NEGATIVE_INFINITY;

    /**
     * The controller's maximum magnitude.
     */
    private double maxMagnitude = Double.POSITIVE_INFINITY;

    /**
     * The controller's target value.
     */
    private double target = 0.0;

    /**
     * Get the controller's minimum.
     *
     * @return the controller's minimum.
     */
    @Override
    public double getMin() {
        return min;
    }

    /**
     * Set the controller's minimum.
     *
     * @param min the controller's minimum output value.
     */
    @Override
    public void setMin(double min) {
        ValidationUtils.validate(min, "min");

        this.min = min;
    }

    /**
     * Get the controller's maximum.
     *
     * @return the controller's maximum.
     */
    @Override
    public double getMax() {
        return max;
    }

    /**
     * Set the controller's maximum.
     *
     * @param max the controller's maximum output value.
     */
    @Override
    public void setMax(double max) {
        ValidationUtils.validate(max, "max");

        this.max = max;
    }

    @Override
    public double getMinMagnitude() {
        return minMagnitude;
    }

    @Override
    public void setMinMagnitude(double minMagnitude) {
        this.minMagnitude = minMagnitude;
    }

    @Override
    public double getMaxMagnitude() {
        return maxMagnitude;
    }

    @Override
    public void setMaxMagnitude(double maxMagnitude) {
        this.maxMagnitude = maxMagnitude;
    }

    /**
     * Reset the controller. By default, there's nothing to reset here. You
     * can (and should) override this method if there IS something to reset,
     * but otherwise, it doesn't do anything. A common example where you'd
     * need to reset the controller is a PID controller. Because the integral
     * and derivative components of the controller persist, they'll need to
     * be reset if the controller is to be properly recalibrated.
     */
    @Override
    public void reset() {}

    /**
     * Get the controller's target.
     *
     * @return the controller's target.
     */
    @Override
    public double getTarget() {
        return target;
    }

    /**
     * Set the controller's target.
     *
     * @param target the controller's target value.
     */
    @Override
    public void setTarget(double target) {
        ValidationUtils.validate(target, "target");

        this.target = target;
    }

    @Override
    public double calculate(double value) {
        return 0;
    }

    /**
     * A method that calls the {@link #setTarget(double)} method and then
     * returns the result of the {@link #calculate(double)} method. Because
     * the function of this method is fairly universal, it's implemented
     * here so there's no need to do it yourself.
     *
     * @param value  the input the controller should calculate for.
     * @param target the value the controller should attempt to reach.
     * @return the result of the {@link #calculate(double)} method after
     * setting the {@link #target} to equal the provided target.
     */
    @Override
    public double calculate(double value, double target) {
        setTarget(target);

        return calculate(value);
    }

    public double clip(double value) {
        return MinMax.clip(value, min, minMagnitude, max, maxMagnitude);
    }

    @Override
    public String toString() {
        return StringUtils.format(
                "Controller (target: <%s> min: <%s> max: <%s>)",
                getTarget(),
                getMin(),
                getMax()
        );
    }
}
