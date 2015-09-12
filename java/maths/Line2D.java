/**
 * Line2D class.
 * TODO: Advance to Point class (?)
 */
public class Line2D {

    private double x1;
    private double y1;
    private double x2;
    private double y2;
    
    public Line2D (double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void setPoint1(double x, double y) {
        this.x1 = x;
        this.y1 = y;
    }

    public void setPoint2(double x, double y) {
        this.x2 = x;
        this.y2 = y;
    }

    public double getX1() { return this.x1; }
    public double getY1() { return this.y1; }
    public double getX2() { return this.x2; }
    public double getY2() { return this.y2; }
    
    /**
    * Calculate the slope of this line.
    * @return double Returns the slope value.
    */
    public double getSlope() {
        return (y2-y1)/(x2-x1);
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
            return (x1 == obj.getX1() &&
                    y1 == obj.getY1() &&
                    x2 == obj.getX2() &&
                    y2 == obj.getY2()); 
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
