package DSA.L2.java;

import java.util.ArrayList;
import java.util.Random;

public class L2 {

    private static final Random r = new Random();

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int value = Integer.parseInt(args[1]);
        testInsertionSort(n);
        testMergeSort(n);
        insertionSortCases(n);
        testBinarySearch(n,value);
        testNewInsertionSort(n);
    }

    // A 3
    private static void insertionSort(ArrayList<Integer> A) {
        for(int j = 1; j < A.size(); j++) {
            int key = A.get(j);
            int i = j - 1;
            while(i >= 0 && A.get(i) > key) {
                A.set(i + 1, A.get(i));
                i--;
            }
            A.set(i + 1, key);
        }
    }

    // A 6
    private static void mergeSort(ArrayList<Integer> A, int left, int right) {
        if(left < right) {
            int middle = (int)Math.floor((left + right) / 2f);
            mergeSort(A,left,middle);
            mergeSort(A,middle + 1,right);
            merge(A,left,middle,right);
        }
    }
    private static void merge(ArrayList<Integer> A, int left, int middle, int right) {
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

    // B 1
    private static void insertionSortCases(int n) {
        ArrayList<Long> B = new ArrayList<>();
        ArrayList<Long> W = new ArrayList<>();
        ArrayList<Long> R = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            B.add(insertionSortBestCase(n));
            W.add(insertionSortWorstCase(n));
            R.add(insertionSortRandomCase(n));
        }
        System.out.println("B\t" + B);
        System.out.println("W\t" + W);
        System.out.println("R\t" + R);
    }

    // B 3
    private static int binarySearch(ArrayList<Integer> A, int left, int right, int value) {
        if (right >= left) {
            int middle = left + (right - left) / 2;
            System.out.println(A.get(middle));
            if (A.get(middle) == value) return middle;
            else if (A.get(middle) > value) return binarySearch(A,left,middle-1,value);
            else return binarySearch(A,middle+1,right,value);
        }
        return -1;
    }

    // B 4
    private static void newInsertionSort(ArrayList<Integer> A) {
        int key; int i; int j; int location;
        for(i = 1; i < A.size(); i++) {
            key = A.get(i);
            j = i - 1;
            location = newBinarySearch(A,0,j,key);
            while(j >= location) {
                A.set(j + 1, A.get(j));
                j--;
            }
            A.set(j + 1, key);
        }
    }
    private static int newBinarySearch(ArrayList<Integer> A, int left, int right, int value) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (value == A.get(mid))
                return mid + 1;
            else if (value > A.get(mid))
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    private static long insertionSortBestCase(int n) {
        ArrayList<Integer> list = createArrayList(n);
        long start = System.currentTimeMillis();
        insertionSort(list);
        return (System.currentTimeMillis() - start);
    }

    private static long insertionSortWorstCase(int n) {
        ArrayList<Integer> list = createReverseArrayList(n);
        long start = System.currentTimeMillis();
        insertionSort(list);
        return (System.currentTimeMillis() - start);
    }

    private static long insertionSortRandomCase(int n) {
        ArrayList<Integer> list = createRandomArrayList(n);
        long start = System.currentTimeMillis();
        insertionSort(list);
        return (System.currentTimeMillis() - start);
    }

    private static void testBinarySearch(int n, int value) {
        ArrayList<Integer> list = createRandomArrayList(n);
        mergeSort(list,0,list.size()-1);
        System.out.println("Input:\t" + list);
        System.out.println("Value:\t" + value);
        int index = binarySearch(list,0,list.size()-1,value);
        System.out.println("Index:\t" + index);
    }

    private static void testNewInsertionSort(int n) {
        ArrayList<Integer> list = createRandomArrayList(n);
        System.out.println("Input:\t" + list);
        newInsertionSort(list);
        System.out.println("Output:\t" + list);
        System.out.println("Sorted: " + validateSort(list));
    }

    private static void testInsertionSort(int n) {
        ArrayList<Integer> list = createRandomArrayList(n);
        System.out.println("Input:\t" + list);
        insertionSort(list);
        System.out.println("Output:\t" + list);
        System.out.println("Sorted: " + validateSort(list));
    }

    private static void testMergeSort(int n) {
        ArrayList<Integer> list = createRandomArrayList(n);
        System.out.println("Input:\t" + list);
        mergeSort(list,0,list.size()-1);
        System.out.println("Output:\t" + list);
        System.out.println("Sorted: " + validateSort(list));
    }

    private static ArrayList<Integer> createArrayList(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        return list;
    }

    private static ArrayList<Integer> createReverseArrayList(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            list.add(i);
        }
        return list;
    }

    private static ArrayList<Integer> createRandomArrayList(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(r.nextInt(n) + 1);
        }
        return list;
    }

    private static boolean validateSort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}