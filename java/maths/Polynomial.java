/**
 * Polynomial class with integer coefficients.
 */
public class Polynomial {
    private int[] coeffs;

    public Polynomial(int[] coeffs) {
        this.coeffs = coeffs;
    }

    /**
    * Evaluate the polynomial.
    * @return int Returns the result of the operation.
    */
    public int evaluate(int x) {
        int n = coeffs.length;
        int result = coeffs[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            result = x * result + coeffs[j];
        }
        
        return result;
    }

    /**
    * Get degree of the polynomial.
    * @return int Returns the degree of the polynomial.
    */
    public int degree() {
        return coeffs.length - 1;
    }

    /**
    * Differentiate polynomial.
    * @return Polynomial Returns the derived polynomial.
    */
    public Polynomial differentiate() {
        int derivedCoeffs[] = new int[coeffs.length-1];
        for (int i = coeffs.length-1; i > 0; i--) {
            derivedCoeffs[i-1] = coeffs[i] * i;
        }

        return new Polynomial(derivedCoeffs);
    }

    @Override
    public String toString() {
        String str = Integer.toString(coeffs[0]);
        for (int i = 1; i < coeffs.length; i++) {
            str += " + " + coeffs[i] + "x^" + i;
        }
        
        return str;
    }

    public static void main(String args[]) {
        int[] array = {3, 4, 2, 5};
        Polynomial poly = new Polynomial(array);
        System.out.println(poly);

        int solve = poly.evaluate(2);
        System.out.println(solve);
        
        Polynomial derived = poly.differentiate();
        System.out.println(derived);
    }
}
