package DSA.L4.java;

import java.util.ArrayList;
import java.util.Random;

public class L4 {

    private static final Random r = new Random();

    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        ArrayList<Integer> list = createRandomArrayList(n);
        long start = System.currentTimeMillis();
        quickSort(list,0,list.size()-1);
        System.out.println("Time: " + (System.currentTimeMillis() - start) + "ms");
    }


    // B 1
    private static void quickSort(ArrayList<Integer> A, int p, int r) {
        if (p < r) {
            int q = partition(A,p,r);
            quickSort(A,p,q-1);
            quickSort(A,q+1,r);
        }
    }
    private static int partition(ArrayList<Integer> A, int p, int r) {
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

    private static void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i,A.get(j));
        A.set(j,temp);
    }

    private static ArrayList<Integer> createRandomArrayList(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(r.nextInt(n) + 1);
        }
        return list;
    }
}