package tk.devmello.mellolib.math.geometry;
public class PointSlope extends SlopeIntercept {

    /**
     * Create a new {@code PointSlope} instance.
     *
     * @param point the point to use.
     * @param slope the slope to use.
     */
    public PointSlope(PointXY point, double slope) {
        super(slope, (slope * -point.x()) + point.y());
    }
}