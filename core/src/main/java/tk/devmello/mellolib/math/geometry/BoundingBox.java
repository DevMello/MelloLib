package tk.devmello.mellolib.math.geometry;

public class BoundingBox {

    private BoundingBox() {}

    public static boolean validate(double number, double min, double max) {
        return (min - 0.01) <= number && number <= (max + 0.01);
    }

    public static boolean isPointInBox(
        PointXY point,
        double minX,
        double minY,
        double maxX,
        double maxY
    ) {
        if (point == null) return false;

        double x = point.x();
        double y = point.y();

        boolean validX = validate(x, minX, maxX);
        boolean validY = validate(y, minY, maxY);

        return validX && validY;
    }

    public static boolean isPointInLine(PointXY point, Line line) {
        return isPointInBox(
            point,
            line.getMinX(),
            line.getMinY(),
            line.getMaxX(),
            line.getMaxY()
        );
    }
}
