package MaxHeapModel;

public class MaxHeapTree {
    private int value;
    private MaxHeapTree left_;
    private MaxHeapTree right_;
    private MaxHeapTree parent_;


    public MaxHeapTree(int key) {
        setValue(key);
        setLeft_(null);
        setRight_(null);
        setParent_(null);
    }

    void setLeft_(MaxHeapTree left_) {
        this.left_ = left_;
    }


    void setParent_(MaxHeapTree parent_) {
        this.parent_ = parent_;
    }

    void setRight_(MaxHeapTree right_) {
        this.right_ = right_;
    }

    void setValue(int value) {
        this.value = value;
    }

    MaxHeapTree getLeft_() {
        return left_;
    }

    MaxHeapTree getParent_() {
        return parent_;
    }


    MaxHeapTree getRight_() {
        return right_;
    }

    int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "   Key" + getValue() + "  ";
    }

}
