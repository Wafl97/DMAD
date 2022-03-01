import java.util.ArrayList;
import java.util.Collections;

public class Sorting {

    public interface SortingAlgorithm {
        void sort(ArrayList<Integer> list);
    }

    public interface RecursiveSortingAlgorithm {
        void sort(ArrayList<Integer> list, int l, int r);
    }

    public static class Sorter {
        public static void use(SortingAlgorithm sortingAlgorithm, String name, int n) {
            ArrayList<Integer> list = createRandomList(n);
            long start = System.currentTimeMillis();
            sortingAlgorithm.sort(list);
            System.out.println("Time: " + (System.currentTimeMillis() - start) + "ms\tWith " + name + " Sort");
        }

        public static void use(RecursiveSortingAlgorithm sortingAlgorithm, String name, int n) {
            ArrayList<Integer> list = createRandomList(n);
            long start = System.currentTimeMillis();
            sortingAlgorithm.sort(list, 0, list.size()-1);
            System.out.println("Time: " + (System.currentTimeMillis() - start) + "ms\tWith " + name + " Sort");
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println("n = " + n);

        Sorter.use(Sorting::insertionSort,"Insertion", n);
        Sorter.use(Sorting::mergeSort, "Merge", n);
        Sorter.use(Sorting::bubbleSort,"Bubble", n);
        Sorter.use(Sorting::quickSort,"Quick", n);
        //Sorter.use(list -> heapSort(list), n);
    }

    public static ArrayList<Integer> createRandomList(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }

    //O(n^2) worst case
    //O(n) best case
    public static void insertionSort(ArrayList<Integer> A) {
        for(int j = 1; j < A.size(); j++) {
            int key = A.get(j);
            int i = j - 1;
            while(i >= 0 && A.get(i) > key) {
                A.set(i + 1, A.get(i));
                i = i - 1;
            }
            A.set(i + 1, key);
        }
    }

    //O(n log n) worst and best case
    public static void mergeSort(ArrayList<Integer> A, int left, int right) {
        if(left < right) {
            int middle = (int)Math.floor((left + right) / 2f);
            mergeSort(A,left,middle);
            mergeSort(A,middle + 1,right);
            merge(A,left,middle,right);
        }
    }
    public static void merge(ArrayList<Integer> A, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        ArrayList<Integer> L = new ArrayList<>();
        ArrayList<Integer> R = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            L.add(A.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            R.add(A.get(middle + j + 1));
        }
        int left_index = 0;
        int right_index = 0;
        for (int sorted_index = left; sorted_index < right || left_index < n1 || right_index < n2; sorted_index++) {
            if (left_index == n1) {
                A.set(sorted_index, R.get(right_index));
                right_index++;
            }
            else if (right_index == n2) {
                A.set(sorted_index, L.get(left_index));
                left_index++;
            }
            else if (L.get(left_index) <= R.get(right_index)) {
                A.set(sorted_index, L.get(left_index));
                left_index++;
            }
            else {
                A.set(sorted_index, R.get(right_index));
                right_index++;
            }
        }
    }
    
    //O(n^2) worst case
    //O(n) best case
    public static void bubbleSort(ArrayList<Integer> A) {
        for(int i = 0; i < A.size(); i++) {
            for(int j = A.size() - 1; j > i; j--) {
                if(A.get(j) < A.get(j - 1)) {
                    swap(A,j,j - 1);
                }
            }
        }
    }
    public static void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i,A.get(j));
        A.set(j,temp);
    }


    //O(n^2) worst case
    //O(n log n) best case
    public static void quickSort(ArrayList<Integer> A, int p, int r) {
        if (p < r) {
            int q = partition(A,p,r);
            quickSort(A,p,q-1);
            quickSort(A,q+1,r);
        }
    }
    public static int partition(ArrayList<Integer> A, int p, int r) {
        int x = A.get(r);
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A.get(j) <= x) {
                i++;
                swap(A,i,j);
            }
        }
        swap(A,i+1,r);
        return i + 1;
    }
}