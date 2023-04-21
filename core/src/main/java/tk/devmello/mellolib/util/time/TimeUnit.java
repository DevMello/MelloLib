package tk.devmello.mellolib.util.time;

public enum TimeUnit {
    /**
     * Milliseconds.
     */
    MS(1),

    /**
     * Seconds.
     */
    S(1000),

    /**
     * Minutes.
     */
    M(60000),

    /**
     * Hours.
     */
    H(3600000);

    /**
     * How many milliseconds is this time unit worth?
     */
    private final double timeInMs;

    /**
     * Create a new time unit.
     *
     * @param timeInMs the amount of time, in milliseconds, that one unit
     *                 of this time represents.
     */
    TimeUnit(double timeInMs) {
        this.timeInMs = timeInMs;
    }

    /**
     * Get the amount of milliseconds one unit of this time represents.
     *
     * @return the unit represented in milliseconds.
     */
    public double getTimeInMs() {
        return timeInMs;
    }
}
