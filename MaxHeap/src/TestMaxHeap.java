import MaxHeapModel.MaxHeapDS;
import MaxHeapModel.MaxHeapTree;

public class TestMaxHeap {

    public static void main(String[] args) {
        MaxHeapTree t = new MaxHeapTree(4);
        System.out.println(t);
        MaxHeapDS m = new MaxHeapDS();
        m.insert(5);
        System.out.println(m);
        System.out.println(m.getMax());
        int max = m.extractMax();
        System.out.println(max + " " + m.isEmpty());
        m.insert(1);
        m.insert(2);
        m.insert(3);
        System.out.println(m);
        m.insert(4);
        System.out.println(m);
        m.insert(5);
        m.insert(6);
        m.insert(7);
        m.insert(8);
        m.insert(15);
        m.insert(13);
        m.insert(14);
        m.insert(12);
        m.insert(11);
        m.insert(10);
        m.insert(9);
        System.out.println(m);
        while (!m.isEmpty()) {
            System.out.println(m.extractMax());
            System.out.println(m);
        }

    }
}
