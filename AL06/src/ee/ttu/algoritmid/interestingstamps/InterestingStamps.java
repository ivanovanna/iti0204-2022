package ee.ttu.algoritmid.interestingstamps;
import java.util.ArrayList;
import java.util.List;


public class InterestingStamps
{
    public static List<Integer> findStamps(int sum, List<Integer> stampOptions) throws IllegalArgumentException {

        List<Integer> result = new ArrayList<>();

        int[] number = new int[sum + 1];
        int[] lastElement = new int[sum + 1];

        for (int i = 1; i <= sum; i++) {
            number[i] = Integer.MAX_VALUE;

            for (int stamp: stampOptions) {
                if (i >= stamp && number[i - stamp] + 1 < number[i]) {
                    number[i] = number[i - stamp] + 1; lastElement[i] = stamp;
                }
            }
        }

        if (stampOptions == null) {
            throw new IllegalArgumentException();
        }
        int n = sum;
        while( n > 0 ) {
            result.add(lastElement[n]);
            n = n - lastElement[n];
        }

        return result;

    }
}
