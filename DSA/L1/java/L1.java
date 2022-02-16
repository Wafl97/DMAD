import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class L1 {

    public static void main(String[] args) {
        for (int i = 2; i <= 128; i = i * 2) {
            e1(i);
        }
    }
    private static void e1(int n){
        long start = System.currentTimeMillis();
        System.out.println("n = " + n);
        statistic(n);
        probability(n);
        long stop = System.currentTimeMillis();
        long diff = stop - start;
        System.out.println("Time: " + diff);
    }

    // A 4
    private static ArrayList<Integer> permutation(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }

    // A 5
    // this function is O(n)
    private static int cycles(ArrayList<Integer> list){
        int count = 0;
        int max = list.size();
        for(int i = 0; i < max; i++) {
            int origin = list.get(i);
            if(origin != -1) {
                int j = origin;
                int num;
                do {
                    num = list.get(j);
                    list.set(j,-1);
                    j = num;
                } while (num != origin);
                count++;
            }
        }
        return count;
    }

    // B 2
    private static void statistic(int n){
        int[] stats = new int[n];
        for(int i = 0; i < 1000000; i ++) {
            ArrayList<Integer> list = permutation(n);
            int count = cycles(list);
            stats[count-1]++;
        }
        System.out.println(Arrays.toString(stats));
    }
    private static void probability(int n){
        float H = 0f;
        for(int i = 1; i <= n; i++){
            H += 1f / i;
        }
        System.out.println("statistic: " + H);
    }
}
