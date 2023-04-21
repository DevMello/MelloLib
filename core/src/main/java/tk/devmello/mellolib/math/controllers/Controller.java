package tk.devmello.mellolib.math.controllers;

public interface Controller {
    /**
     * The controller's minimum output value.
     *
     * @return the controller's minimum output value.
     */
    double getMin();

    /**
     * Set the controller's minimum output value.
     *
     * @param min the controller's minimum output value. Any output below this
     *            value will automatically be set to this value.
     */
    void setMin(double min);

    /**
     * The controller's maximum output value.
     *
     * @return the controller's maximum output value.
     */
    double getMax();

    /**
     * Set the controller's maximum output value.
     *
     * @param max the controller's maximum output value. Any output above this
     *            value will automatically be set to this value.
     */
    void setMax(double max);

    /**
     * Get the controller's minimum magnitude.
     *
     * @return the controller's minimum magnitude.
     */
    double getMinMagnitude();

    /**
     * Set the controller's minimum magnitude.
     *
     * @param minMagnitude the controller's minimum magnitude.
     */
    void setMinMagnitude(double minMagnitude);

    /**
     * Get the controller's maximum magnitude.
     *
     * @return the controller's maximum magnitude.
     */
    double getMaxMagnitude();

    /**
     * Set the controller's maximum magnitude.
     *
     * @param maxMagnitude the controller's maximum magnitude.
     */
    void setMaxMagnitude(double maxMagnitude);

    /**
     * Reset the controller. Some controllers have no use for this method,
     * but it's there anyways because my code sucks and I'm too lazy to
     * change it.
     */
    void reset();

    /**
     * Get the controller's target value.
     *
     * @return the controller's target value.
     */
    double getTarget();

    /**
     * Set the controller's target value.
     *
     * @param target the controller's target value.
     */
    void setTarget(double target);

    /**
     * Use an input reading to determine an output.
     *
     * @param value the input the controller should calculate for.
     * @return a value calculated by the controller.
     */
    double calculate(double value);

    /**
     * Use an input reading to determine an output. Also, set the target
     * point. It's a real two-in-one, you know?
     *
     * @param value  the input the controller should calculate for.
     * @param target the value the controller should attempt to reach.
     * @return a value calculated by the controller.
     */
    double calculate(double value, double target);
}
