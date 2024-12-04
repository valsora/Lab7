import java.util.concurrent.ForkJoinPool;

public class Ex3 {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.putGood(3);
        warehouse.putGood(70);
        warehouse.putGood(61);
        warehouse.putGood(10);
        warehouse.putGood(9);
        warehouse.putGood(72);
        warehouse.putGood(66);
        warehouse.putGood(25);
        warehouse.putGood(18);
        warehouse.putGood(100);
        warehouse.putGood(85);
        warehouse.putGood(11);
        warehouse.putGood(44);
        warehouse.putGood(70);
        warehouse.putGood(4);
        warehouse.putGood(40);
        warehouse.putGood(29);
        warehouse.putGood(150);
        warehouse.putGood(60);
        warehouse.putGood(7);
        warehouse.putGood(70);
        warehouse.putGood(93);
        warehouse.putGood(50);
        warehouse.putGood(122);
        warehouse.putGood(50);
        warehouse.putGood(67);
        warehouse.putGood(25);
        warehouse.putGood(110);
        warehouse.putGood(90);
        warehouse.putGood(20);
        warehouse.putGood(30);
        warehouse.putGood(65);
        warehouse.putGood(70);
        System.out.println(warehouse.allGoods());
        ForkJoinPool workerPool = new ForkJoinPool(3);
        long start = System.nanoTime();
        workerPool.invoke(new Worker(warehouse));
        workerPool.close();
        long end = System.nanoTime();
        System.out.println(warehouse.allGoods());
        System.out.println((double)(end - start) / 1000000);
    }
}
