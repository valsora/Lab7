import java.util.ArrayList;
import java.util.concurrent.*;

public class Ex2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}};
        ExecutorService threadPool = Executors.newFixedThreadPool(matrix.length);
        ArrayList<Future<Integer>> threadResults = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            threadResults.add(threadPool.submit(new SubArrayMax(matrix[i])));
        }
        threadPool.shutdown();
        int max = 0;
        for (Future<Integer> future : threadResults) {
            if (future.get() > max) max = future.get();
        }
        System.out.println(max);
    }
}
