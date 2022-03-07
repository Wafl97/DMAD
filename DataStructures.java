import java.util.ArrayList;

public class DataStructures {

    public interface DataStructure {
        
    }
    public static void main(String[] args) {
        System.out.println("TEST");
        
    }

    public static class PriorityQueue implements DataStructure {
        private ArrayList<Integer> A;

        PriorityQueue(ArrayList<Integer> A) {
            this.A = A;
        }

        public void build(ArrayList<Integer> A) {
            heapify(A);
        }

        public int extractMax() {
            return -1;
        }

        public void insert(int n) {

        }

        public void increaseKey(int index, int value) {
            
        }

        private void heapify(ArrayList<Integer> A) {

        }

        public void display() {
            System.out.println(this.A);
        }
    }
}
