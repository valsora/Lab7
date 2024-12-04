import java.util.concurrent.RecursiveAction;

public class Worker extends RecursiveAction {
    private Warehouse warehouse;

    public Worker(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void compute() {
        int totalWeight = 0;
        if (!warehouse.isEmpty()) {
            while (totalWeight + warehouse.checkWeight() <= 150) {
                totalWeight += warehouse.takeGood();
                if (warehouse.isEmpty()) break;
            }
            System.out.println(Thread.currentThread().getName() + " несёт " + totalWeight + "кг");
            try {
                Thread.sleep(totalWeight * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!warehouse.isEmpty()) invokeAll(new Worker(warehouse), new Worker(warehouse), new Worker(warehouse));
    }
}
