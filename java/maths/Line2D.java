/**
 * Line2D class.
 */
public class Line2D {

    private Point2D point1;
    private Point2D point2;
    
    public Line2D(double x1, double y1, double x2, double y2) {
        this(new Point2D(x1, y1), new Point2D(x2, y2));
    }

    public Line2D(Point2D point1, Point2D point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public void setPoint1(Point2D point) {
        this.point1 = point;
    }

    public void setPoint1(double x, double y) {
        this.point1 = new Point2D(x, y);
    }

    public void setPoint2(Point2D point) {
        this.point2 = point;
    }

    public void setPoint2(double x, double y) {
        this.point2 = new Point2D(x, y);
    }

    public double getX1() { return this.point1.getX(); }
    public double getY1() { return this.point1.getY(); }
    public double getX2() { return this.point2.getX(); }
    public double getY2() { return this.point2.getY(); }
    
    /**
    * Calculate the slope of this line.
    * @return double Returns the slope value.
    */
    public double getSlope() {
        return (point2.getY() - point1.getY()) / (point2.getX() - point1.getX());
    }

    /**
    * Determine if given line is perpendicular to this one.
    * Applies when: m1 = -(1/m2)
    * @param line The second line
    * @return boolean Returns true if perpendicular.
    */
    public boolean perpendicularTo(Line2D line) {
        double m1 = getSlope();
        double m2 = line.getSlope();

        if (m1 * m2 == -1) {
            return true;
        }
        return false;
    }

    /**
    * Determine if given line is parallel to this one.
    * @param line The second line
    * @return boolean Returns true if parallel.
    */
    public boolean parallelTo(Line2D line) {
        return getSlope() == line.getSlope();
    }

    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof Line2D) {
            Line2D obj = (Line2D) object;
            return (getX1() == obj.getX1() &&
                    getY1() == obj.getY1() &&
                    getX2() == obj.getX2() &&
                    getY2() == obj.getY2()); 
        }
        return false;
    }
    
    public static void main(String[] args) {
        Line2D line = new Line2D(0, 0, 2, 2);
        System.out.println(line.getSlope());

        Line2D line2 = new Line2D(0, 0, -1, 1);
        boolean perp = line.perpendicularTo(line2);
        System.out.println(perp);

        Line2D line3 = new Line2D(0, 2, 2, 4);
        boolean parallel = line.parallelTo(line3);
        System.out.println(parallel);
    }
}
