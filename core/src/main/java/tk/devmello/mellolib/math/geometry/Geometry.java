package tk.devmello.mellolib.math.geometry;




public class Geometry {
    public static final double METERS_TO_INCHES = 39.37;

    public static final double INCHES_TO_METERS = 1 / METERS_TO_INCHES;

    public static double METERS_TO_CENTIMETERS = 100;

    public static final double CENTIMETERS_TO_METERS = 1 / METERS_TO_INCHES;

    public static final double CENTIMETERS_TO_INCHES =
            CENTIMETERS_TO_METERS * METERS_TO_INCHES;

    public static final double INCHES_TO_CENTIMETERS =
            1 / CENTIMETERS_TO_INCHES;

    /**
     * Tolerance used in determining if two {@link PointXY}s are equivalent.
     *
     * <p>
     * This tolerance value is used like so:
     * <code><pre>
     * public boolean equals(Object obj) {
     *     if (obj instanceof PointXY) {
     *         PointXY point = (PointXY) obj;
     *
     *         boolean sameX = Equals.soft(x, point.x(),
     *                 Geometry.tolerancePointXY);
     *         boolean sameY = Equals.soft(y, point.y(),
     *                 Geometry.tolerancePointXY);
     *
     *         return sameX && sameY;
     *     }
     *
     *     return super.equals(obj);
     * }
     * </pre></code>
     * </p>
     */
    public static final double tolerancePointXY = 0.01;

    /**
     * Tolerance used in determining if two {@link PointXYZ}s are equivalent.
     *
     * <p>
     * This tolerance value is used like so:
     * <code><pre>
     * public boolean equals(Object obj) {
     *     if (obj instanceof PointXYZ) {
     *         PointXYZ point = (PointXYZ) obj;
     *
     *         boolean sameX = Equals.soft(x, point.x(),
     *                 Geometry.tolerancePointXY);
     *         boolean sameY = Equals.soft(y, point.y(),
     *                 Geometry.tolerancePointXY);
     *
     *         return sameX && sameY;
     *     }
     *
     *     return super.equals(obj);
     * }
     * </pre></code>
     * </p>
     */
    public static final double tolerancePointXYZ = 0.01;

    /**
     * Tolerance used in determining if two {@code Angle}s are equivalent.
     */
    public static Angle toleranceAngle = Angle.fromDeg(0.01);

    /**
     * Tolerance used in determining if three or more {@code PointXY}s are
     * collinear.
     */
    public static final double toleranceCollinear = 0.01;

    /**
     * Tolerance used in determining if two lines are parallel.
     */
    public static final double toleranceParallel = 0.01;

    /**
     * Tolerance used in determining if two lines are perpendicular.
     */
    public static final double tolerancePerpendicular = 0.01;

    /**
     * Tolerance used in determining if a line is vertical.
     */
    public static final double toleranceIsVertical = 0.01;

    /**
     * Tolerance used in determining if a given {@code PointXY} is at the
     * same position as one of a rectangle's four points. This is used in
     * detecting if a point is contained within a shape.
     */
    public static final double toleranceRectangleReference = 0.01;

    /**
     * Tolerance used in determining if two {@code Rectangle}s are equal.
     */
    public static final double toleranceRectangle = 0.01;

    /**
     * Tolerance used in determining if two {@code Translation}s are equal.
     */
    public static final double toleranceTranslation = 0.01;

    /**
     * The format {@code PointXY} will use in {@link PointXY#toString()}.
     */
    public static final String formatPointXY = "(%s, %s)";

    /**
     * The format {@code PointXYZ} will use in {@link PointXYZ#toString()}.
     */
    public static final String formatPointXYZ = "(%s, %s, %s deg)";

    /**
     * The format {@code Angle} will use in {@link Angle#toString()}.
     */
    public static final String formatAngle = "%s deg";


    public static final String formatRange = "%s%s, %s%s";



    private Geometry() {}
}