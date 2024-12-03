import java.util.ArrayList;
import java.util.concurrent.*;

public class Ex1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int nThreads = 5;
        int subArrLength = (int)Math.ceil((double)arr.length / nThreads);
        ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
        ArrayList<Future<Integer>> threadResults = new ArrayList<>();
        for (int i = 0; i < nThreads; i++) {
            int[] subArr = new int[subArrLength];
            for (int j = 0; j < subArrLength; j++) {
                if (j + i * subArrLength < arr.length) subArr[j] = arr[j + i * subArrLength];
            }
            threadResults.add(threadPool.submit(new SubArrayCounter(subArr)));
        }
        threadPool.shutdown();
        int sum = 0;
        for (Future<Integer> future : threadResults) {
            sum += future.get();
        }
        System.out.println(sum);
    }
}
