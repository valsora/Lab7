import java.util.concurrent.ForkJoinPool;

public class Ex3 {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.putGood(40);
        warehouse.putGood(120);
        warehouse.putGood(100);
        warehouse.putGood(10);
        warehouse.putGood(20);
        warehouse.putGood(50);
        warehouse.putGood(130);
        warehouse.putGood(20);
        warehouse.putGood(50);
        warehouse.putGood(120);
        warehouse.putGood(120);
        warehouse.putGood(90);
        warehouse.putGood(40);
        warehouse.putGood(120);
        warehouse.putGood(150);
        warehouse.putGood(10);
        warehouse.putGood(140);
        warehouse.putGood(70);
        warehouse.putGood(20);
        warehouse.putGood(50);
        warehouse.putGood(110);
        warehouse.putGood(20);
        System.out.println(warehouse.allGoods());
        ForkJoinPool workerPool = new ForkJoinPool(3);
        workerPool.invoke(new Worker(warehouse));
        workerPool.close();
        System.out.println(warehouse.allGoods());
    }
}
