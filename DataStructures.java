import java.util.ArrayList;
import java.util.Collections;

public class DataStructures {

    public interface DataStructure {
        
    }
    public static void main(String[] args) {
        ArrayList<Integer> l = createShuffledList(16);
        Heap h = createHeap(l);
        System.out.println(h.A);
        h.buildMaxHeap();
        System.out.println(h.A);
        h.maxHeapInsert(20);
        System.out.println(h.A);
    }

    public static ArrayList<Integer> createShuffledList(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }

    public static Heap createHeap(ArrayList<Integer> A) {
        return new Heap(A);
    }

    public static PriorityQueue createPrioityQueue(ArrayList<Integer> A) {
        return new PriorityQueue(A);
    }

    public static BinarySearchTree createBinarySearchTree(ArrayList<Integer> A) {
        return new BinarySearchTree(A);
    }

    public static RedBlackTree createRedBlackTree(ArrayList<Integer> A) {
        return new RedBlackTree(A);
    }

    public static class Heap implements DataStructure {

        public int heapSize;
        public ArrayList<Integer> A;

        public Heap(ArrayList<Integer> A) {
            this.A = A;
            this.heapSize = A.size()-1;
        }

        public int parrent(int i) {
            return (i - 1)/2;
        }

        public int left(int i) {
            return (2 * i) + 1;
        }

        public int right(int i) {
            return (2 * i) + 2;
        }

        public void swap(int i, int j) {
            int temp = this.A.get(i);
            this.A.set(i,this.A.get(j));
            this.A.set(j,temp);
        }

        public void maxHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int largest;
            if (l <= this.heapSize && A.get(l) > A.get(i)) {
                largest = l;
            }
            else {
                largest = i;
            }
            if (r <= this.heapSize && A.get(r) > A.get(largest)) {
                largest = r;
            }
            if (largest != i) {
                swap(i,largest);
                maxHeapify(largest);
            }
        }

        public void buildMaxHeap() {
            for(int i = (A.size()/2); i >= 0 ; i--) {
                maxHeapify(i);
            }
        }

        public int heapExtractMax() {
            if (this.heapSize < 0) {
                System.out.println("Heap Underflow!!!");
                return -1;
            }
            int max = this.A.get(0);
            this.A.set(0,this.A.get(this.heapSize));
            this.heapSize--;
            maxHeapify(0);
            return max;
        }

        public void heapIncreaseKey(int i, int key) {
            if (key < this.A.get(i)) {
                System.out.println("New key is smaller than current");
                return;
            }
            this.A.set(i,key);
            while(i > 0 && A.get(parrent(i)) < A.get(i)) {
                swap(i,parrent(i));
                i = parrent(i);
            }
        }

        public void maxHeapInsert(int key) {
            this.heapSize++;
            this.A.add(-1);
            heapIncreaseKey(this.heapSize, key);
        }
    }

    public static class PriorityQueue extends Heap {
        //TODO
        public PriorityQueue(ArrayList<Integer> A) {
            super(A);
        }

        public void insert(int element) {

        }

        public int extract() {
            return -1;
        }
    }

    public static class BinarySearchTree implements DataStructure{
        private ArrayList<Integer> A;
        //TODO
        public BinarySearchTree(ArrayList<Integer> A) {
            this.A = A;
        }
    }

    public static class RedBlackTree extends BinarySearchTree {
        //TODO
        public RedBlackTree(ArrayList<Integer> A) {
            super(A);
        }
    }

}
