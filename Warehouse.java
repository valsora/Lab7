import java.util.Stack;

public class Warehouse {
    private Stack<Integer> weights;

    public Warehouse() {
        weights = new Stack<>();
    }

    public Stack<Integer> allGoods() {
        return weights;
    }

    public synchronized boolean isEmpty() {
        return weights.size() == 0;
    }

    public void putGood(int weight) {
        weights.add(weight);
    }

    public synchronized int checkWeight() {
        return weights.peek();
    }

    public synchronized int takeGood() {
        return weights.pop();
    }
}
