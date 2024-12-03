// import java.util.Arrays;
import java.util.concurrent.Callable;

public class SubArrayCounter implements Callable<Integer> {
    private int[] arr;

    public SubArrayCounter(int[] arr) {
        this.arr = arr;
    }

    public Integer call() {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        // System.out.println(Arrays.toString(arr) + " " + sum);
        return sum;
    }
}
