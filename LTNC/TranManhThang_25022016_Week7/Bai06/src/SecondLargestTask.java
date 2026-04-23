import java.util.concurrent.Callable;

public class SecondLargestTask implements Callable<Integer> {
    private int[] numArray;

    public SecondLargestTask(int[] numArray) {
        this.numArray = numArray;
    }

    @Override
    public Integer call() {
        if (numArray.length < 2) return null;
        Integer largest = numArray[0];
        Integer secondLargest = null;
        for (int i = 1; i < numArray.length; i++) {
            int current = numArray[i];
            if (current > largest) {
                secondLargest = largest;
                largest = current;
            } else if (!Integer.valueOf(current).equals(largest)) {
                if (secondLargest == null || current > secondLargest) {
                    secondLargest = current;
                }
            }
        }
        return secondLargest;
    }
}
