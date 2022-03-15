package DSA.L6.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class L6 {


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = n / 50;
        time(n,k);
        k = n;
        time(n,k);
        k = 50 * n;
        time(n,k);
    }

    private static void time(int n, int k) {
        System.out.println("n="+n+" k="+k);
        ArrayList<Integer> list = createRandomList(n,k);
        long start = System.currentTimeMillis();
        countingSort(list,k);
        System.out.println("Time: "+(System.currentTimeMillis()-start)+"ms");
    }

    private static ArrayList<Integer> createRandomList(int n, int k) {
        Random r = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(r.nextInt(k));
        }
        Collections.shuffle(list);
        return list;
    }

    private static void countingSort(ArrayList<Integer> A, int k) {
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            C.add(0);
        }
        for (int i = 0; i < A.size(); i++) {
            B.add(0);
        }
        for (int j = 0; j < A.size(); j++) {
            C.set(A.get(j), C.get(A.get(j)) + 1);
        }
        for (int i = 1; i <= k; i++) {
            C.set(i, C.get(i) + C.get(i - 1));
        }
        for (int j = A.size() - 1; j >= 0; j--) {
            B.set(C.get(A.get(j)) - 1, A.get(j));
            C.set(A.get(j), C.get(A.get(j)) - 1);
        }
        Collections.copy(A, B);
    }

}