/**
 * Basic Vector3 operations.
 */
public class Vector {

    public double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vector add(Vector vec) {
        return new Vector(x + vec.x,
                          y + vec.y,
                          z + vec.z);
    }

    public Vector subtract(Vector vec) {
        return new Vector(x - vec.x,
                          y - vec.y,
                          z - vec.z);
    }

    public Vector multiply(double scalar) {
        return new Vector(x * scalar,
                          y * scalar,
                          z * scalar);
    }

    public double scalarProduct(Vector vec) {
        return x * vec.x + y * vec.y + z * vec.z;
    }

    public Vector vectorProduct(Vector vec) {
        return new Vector(y * vec.z - vec.y * z,
                          z * vec.x - vec.z * x,
                          x * vec.y - vec.x * y);
    }

    public double length() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof Vector) {
            Vector obj = (Vector) object;
            return (x == obj.x &&
                    y == obj.y &&
                    z == obj.z); 
        }
        return false;
    }

    public static void main(String args[]) {
        Vector vec = new Vector(1, 2, 3);

        double r = vec.length();
        System.out.println(r);

        Vector vec2 = new Vector(1, 2, 3);
        boolean equal = vec.equals(vec2);
        System.out.println(equal);
    }

}
