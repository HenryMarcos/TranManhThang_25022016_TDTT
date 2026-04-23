
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TwoStageProcessing implements Supplier<List<Integer>> {
    private int arrayId;
    private int[] numArray;

    public TwoStageProcessing(int arrayId, int[] numArray) {
        this.arrayId = arrayId;
        this.numArray = numArray;
    }

    public static Boolean isPrime(Integer n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    @Override
    public List<Integer> get() {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < numArray.length; i++) {
            if (isPrime(numArray[i])) {
                ans.add(numArray[i]);
            }
        }

        System.out.println("Stage 1 - Array " + arrayId + ": " + ans);

        return ans;
    }

}
