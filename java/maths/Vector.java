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

    /**
    * Vector addition.
    * @param vec The second vector
    * @return Vector returns the new vector.
    */
    public Vector add(Vector vec) {
        return new Vector(x + vec.x,
                          y + vec.y,
                          z + vec.z);
    }

    /**
    * Vector subtraction.
    * @param vec The second vector
    * @return Vector Returns the new vector.
    */
    public Vector subtract(Vector vec) {
        return new Vector(x - vec.x,
                          y - vec.y,
                          z - vec.z);
    }

    /**
    * Multiply by scalar.
    * @param scalar The scalar
    * @return Vector Returns the new vector.
    */
    public Vector multiply(double scalar) {
        return new Vector(x * scalar,
                          y * scalar,
                          z * scalar);
    }

    /**
    * Calculate the scalar product (dot).
    * a∗b = |a|·|b|·cos(φ)
    * Perpendicular vectors: a*b = 0
    * Parallel vectors: a*b = ± |a|·|b| (+ same direction, - opposite direction)
    * @param vec The second vector
    * @return double Returns the result of the operation.
    */
    public double scalarProduct(Vector vec) {
        return x * vec.x + y * vec.y + z * vec.z;
    }

    /**
    * Calculate the vector product (cross).
    * The new vector c is perpendicular to the given vectors.
    * It also has the length of |c| = |a|·|b|·sin(φ).
    * @param vec The second vector
    * @return Vector Returns the new vector.
    */
    public Vector vectorProduct(Vector vec) {
        return new Vector(y * vec.z - vec.y * z,
                          z * vec.x - vec.z * x,
                          x * vec.y - vec.x * y);
    }

    /**
    * Calculate the length of this vector.
    * @return double Returns the length of this vector.
    */
    public double length() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    /**
    * Check if a given vector is perpendicular to this vector.
    * @param vec The second vector
    * @return boolean Returns true if both vectors are perpendicular.
    */
    public boolean perpendicular(Vector vec) {
        return scalarProduct(vec) == 0;
    }

    /**
    * Calculate a triple product.
    * @param b Second vector
    * @param c Third vector
    * @return double Returns the result of the operation.
    */
    public double tripleProduct(Vector b, Vector c) {
        Vector firstFactor = vectorProduct(b);
        return firstFactor.scalarProduct(c);
    }

    /**
    * Calculate the angle between this vector and the given vector.
    * Approach: a*b = |a|·|b|·cos(φ)
    * Therefore: cos(φ) = a*b/(|a|·|b|)
    * @param vec The second vector
    * @return double Returns the angle.
    */
    public double angleBetween(Vector vec) {
        double dividend = scalarProduct(vec);
        double divisor = length() * vec.length();
        double result = dividend/divisor;
        return Math.toDegrees(Math.acos(result));
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
        // TODO: better test cases
        Vector vec = new Vector(1, 2, 3);
        double r = vec.length();
        System.out.println(r);

        Vector vec2 = new Vector(5, 3, 3);
        boolean equal = vec.equals(vec2);
        System.out.println(equal);

        Vector vec3 = new Vector(3, 4, 2);
        double triple = vec.tripleProduct(vec2, vec3);
        System.out.println(triple);

        double angle = vec.angleBetween(vec2);
        System.out.println(angle);
    }

}
