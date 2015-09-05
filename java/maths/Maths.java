import java.math.BigInteger;

public final class Maths {

    public static BigInteger getBigFactorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n must be greater or equal to zero.");
        
        BigInteger factorial = BigInteger.ONE;
        for (int i = n; i > 1; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }
}
