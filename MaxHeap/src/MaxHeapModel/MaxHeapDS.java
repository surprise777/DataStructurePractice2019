package MaxHeapModel;

import java.util.ArrayList;


public class MaxHeapDS {
    private ArrayList<MaxHeapTree> heap;
    private int hSize;

    public MaxHeapDS() {
        this.heap = new ArrayList<>();
        this.hSize = 0;
    }

    private int gethSize() {
        return hSize;
    }

    public boolean isEmpty() {
        return gethSize() == 0;
    }

    public void insert(int key) {
        MaxHeapTree newNode = new MaxHeapTree(key);
        this.heap.add(newNode);
        if (this.isEmpty()) {
            this.hSize++;
        } else {
            this.hSize++;
            MaxHeapTree p = this.heap.get(gethSize() / 2 - 1);
            newNode.setParent_(p);
            if (gethSize() % 2 == 0)
                p.setLeft_(newNode);
            else
                p.setRight_(newNode);
            maxHeapifyUp(gethSize());//using recursion
        }
    }

    public int getMax() {
        return isEmpty() ? -1 : this.heap.get(0).getValue();

    }

    public int extractMax() {
        if (isEmpty())
            return -1;
        else if (gethSize() == 1) {
            this.hSize--;
            return (this.heap.remove(0).getValue());
        }
        MaxHeapTree lastNode = this.heap.get(gethSize() - 1);
        MaxHeapTree removeNode = this.heap.get(0);
        int maxKey = removeNode.getValue();
        swapTree(lastNode, removeNode);
        if (gethSize() % 2 == 1)
            lastNode.getParent_().setRight_(null);
        else
            lastNode.getParent_().setLeft_(null);
        this.heap.remove(gethSize() - 1);
        this.hSize--;
        if (!isEmpty())
            maxHeapifyDown(1);//using recursion
        return maxKey;
    }

    private void maxHeapifyUp(int index) { //recursion main part
        MaxHeapTree currNode = this.heap.get(index - 1);
        MaxHeapTree parentNode = currNode.getParent_();
        if (index != 1 && currNode.getValue() > parentNode.getValue()) {
            swapTree(currNode, parentNode);
            maxHeapifyUp(index / 2);
        }
    }

    private void maxHeapifyDown(int index) { //recursion main part
        if (index <= gethSize() / 2) {
            MaxHeapTree currNode = this.heap.get(index - 1);
            MaxHeapTree lChild = currNode.getLeft_();
            MaxHeapTree rChild = currNode.getRight_();
            MaxHeapTree swapChild = (lChild == null ?
                    (rChild == null ? currNode : rChild) :
                    (rChild == null ? lChild :
                            (lChild.getValue() >= rChild.getValue() ? lChild : rChild)));
            int next = (lChild == null ?
                    (rChild == null ? index : 2 * index + 1) :
                    (rChild == null ? 2 * index :
                            (lChild.getValue() >= rChild.getValue() ? 2 * index : 2 * index + 1)));
            if (currNode.getValue() < swapChild.getValue())
                swapTree(currNode, swapChild);
            maxHeapifyDown(next);
        }
    }

    private void swapTree(MaxHeapTree c, MaxHeapTree p) {
        int tempV = c.getValue();
        c.setValue(p.getValue());
        p.setValue(tempV);
    }

    @Override
    public String toString() {
        String form = "MaxHeap:";
        int i = 0;
        while (i <= gethSize() - 1) {
            form = String.format("%s%s", form, this.heap.get(i));
            i++;
        }

        return form;
    }
}
