import java.math.BigInteger;
import java.math.BigDecimal;

public class BinomialDistribution {

    private int n;
    private double p;

    public BinomialDistribution(int n, double p) {
        this.n = n;
        this.p = p;
    }

    public BigInteger getBinomialCoefficient(int n, int k) {
        // n! / (k! * (n-k)!)
        BigInteger nFactorial = Maths.getBigFactorial(n);
        BigInteger kFactorial = Maths.getBigFactorial(k);
        BigInteger nkFactorial = Maths.getBigFactorial(n-k);
        
        return nFactorial.divide(kFactorial.multiply(nkFactorial));
    }

    public double getExpectedProhability(int k) {
        // (n k) * p^k * (1-p)^(n-k)
        BigDecimal coefficient = new BigDecimal(getBinomialCoefficient(n, k));
        double prob = Math.pow(p, k) * Math.pow(1-p, n-k);

        return coefficient.multiply(new BigDecimal(prob)).doubleValue();
    }

    public static void main(String args[]) {
        
    }


}
