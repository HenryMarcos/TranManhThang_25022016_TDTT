
import java.util.concurrent.Callable;

public class CountPrimeTask implements Callable<Integer> {
    int[] numArray;

    public CountPrimeTask(int[] numArray) {
        this.numArray = numArray;
    }

    public static Boolean isPrime(Integer n) {
        if (n < 2) return false;
        if (n == 2) return true;
        for (int i = 2; i <= Math.sqrt(n) + 1; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    @Override
    public Integer call() {
        Integer ans = 0;
        for (int i = 0; i < numArray.length; i++) {
            if (isPrime(numArray[i])) ans += 1;
        }
        return ans;
    }
    
}
