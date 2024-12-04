import java.util.Arrays;
import java.util.concurrent.Callable;

public class SubArrayMax implements Callable<Integer> {
    private int[] arr;

    public SubArrayMax(int[] arr) {
        this.arr = arr;
    }

    public Integer call() {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        System.out.println(Arrays.toString(arr) + " " + max);
        return max;
    }
}
