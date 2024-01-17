package ee.ttu.algoritmid.fibonacci;

import java.math.BigInteger;

    public class AL01B {

        /**
         * Estimate or find the exact time required to compute the n-th Fibonacci number.
         *
         * @param n The n-th number to compute.
         * @return The time estimate or exact time in YEARS.
         */
        public String timeToComputeRecursiveFibonacci(int n) {

            double startTime = System.nanoTime();// start time
            recursiveF(10); // turn on program
            double endTime = System.nanoTime(); // end time
            double a = ((endTime - startTime) / Math.pow(1.6, 20)) / 1000000000; // math pow raises n 1.60 (golden ratio) 1000000000 nanoseconds in one minute
            return String.valueOf( a * Math.pow(1.6, n) / 31536000);// 31536000 nano sec. per year
        }
        /**
         * Compute the Fibonacci sequence number recursively.
         * (You need this in the timeToComputeRecursiveFibonacci(int n) function!)
         * @param n The n-th number to compute.
         * @return The n-th Fibonacci number as a string.
         */
        public BigInteger recursiveF(int n) {
            if (n <= 1)
                return BigInteger.valueOf(n);
            return recursiveF(n - 1).add(recursiveF(n - 2));
        }
    }



