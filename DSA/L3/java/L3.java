package DSA.L3.java;

import java.util.ArrayList;
import java.util.Random;

public class L3 {

    private static final Random r = new Random(); 

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        testMergeSort(n);
        testCountInv(n);
    }

    private static void testMergeSort(int n) {
        ArrayList<Integer> list = createRandomArrayList(n);
        System.out.println("IN:\t" + list);
        long start = System.currentTimeMillis();
        mergeSort(list, 0, list.size()-1);
        System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms");
        System.out.println("OUT\t" + list);
    }

    private static void testCountInv(int n) {
        ArrayList<Integer> list = createRandomArrayList(n);
        System.out.println(list);
        long start = System.currentTimeMillis();
        int inv = counsInv(list,0,list.size()-1);
        System.out.println("inv: " + inv);
        System.out.println(list);
        System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms");
    }

    private static ArrayList<Integer> createRandomArrayList(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(r.nextInt(n) + 1);
        }
        return list;
    }

    // A 3 && B 2
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

    private static int counsInv(ArrayList<Integer> A, int left, int right) {
        if(left < right) {
            int middle = (int)Math.floor((left + right) / 2f);
            int l = counsInv(A,left,middle);
            int r = counsInv(A,middle + 1,right);
            int t = mergeInv(A,left,middle,right) + l + r;
            return t;
        }
        return 0;
    }
    private static int mergeInv(ArrayList<Integer> A, int left, int middle, int right) {
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
        int inv = 0;
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
                inv = inv + n1 - left_index + 1;
                right_index++;
            }
        }
        return inv;
    }
}