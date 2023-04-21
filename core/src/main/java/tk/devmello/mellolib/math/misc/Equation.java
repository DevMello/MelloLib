package tk.devmello.mellolib.math.misc;


import tk.devmello.mellolib.math.geometry.PointXY;

public interface Equation {
    /**
     * Get a Y value at a specific X value according to the equation.
     *
     * @param x the X value to "look up."
     * @return the Y value, according to the inputted X value.
     */
    double getY(double x);

    /**
     * Get a point based on an X value.
     *
     * @param x the X value to "look up."
     * @return the point, according to the inputted X value.
     */
    default PointXY getPoint(double x) {
        return new PointXY(x, getY(x));
    }
}