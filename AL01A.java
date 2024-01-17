package ee.ttu.algoritmid.fibonacci;

import java.math.BigInteger;

public class AL01A {
    /**
     * Compute the Fibonacci sequence number.
     *
     * @param n The number of the sequence to compute.
     * @return The n-th number in Fibonacci series.
     */
    public String iterativeF(int n) {
        if (n == 0) {
            return "0";
        }
        long first = 0;
        long  second = 1;
        BigInteger FIRST = BigInteger.valueOf(first);
        BigInteger SECOND = BigInteger.valueOf(second);
        BigInteger result;
        for (long  i = 2; i <= n; i++) {
            result = FIRST.add(SECOND);
            FIRST = SECOND;
            SECOND = result;
        }

        return String.valueOf(SECOND);
    }
}




