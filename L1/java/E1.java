import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class E1 {

    public static void main(String[] args){
        long start = System.currentTimeMillis();
        int n = 64;
        System.out.println("n = " + n);
        test(n);
        statistic(n);
        long stop = System.currentTimeMillis();
        long diff = stop - start;
        System.out.println("Time: " + diff);
    }

    // A L4
    private static ArrayList<Integer> permutation(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }

    // A L5
    // this function is n log n
    private static int cycles(ArrayList<Integer> list){
        int count = 0; // The amount of cycles
        int max = list.size();
        for(int i = 0; i < max; i++){ // At most this will go n times, if we have only length 1 cycle
            int origin = list.get(i); // First number in new cycle
            if(origin != -1){ // Check if it is part of an existing cycle
                int j = origin; // The iterator used for jumping places
                int num;
                while (true){ // At most this will go n times, if we have 1 n lenght cycle
                    num = list.get(j); // Get new number from indexing with old number
                    list.set(j,-1); // Mark as part of a cycle
                    if (num == origin){ //Cycle complete
                        count++; // Increase count
                        break; // Go find start of new cycle
                    }
                    j = num % max; // Loop around the list, as to not go out of bounds
                }
            }
        }
        return count;
    }

    // B L2
    private static void test(int n){
        int[] stats = new int[n];
        for(int i = 0; i < 1000000; i ++) {
            ArrayList<Integer> list = permutation(n);
            int count = cycles(list);
            stats[count-1]++;
        }
        System.out.println(Arrays.toString(stats));
    }
    private static void statistic(int n){
        float H = 0f;
        for(int i = 1; i <= n; i++){
            H += 1f / i;
        }
        System.out.println("statistic: " + H);
    }
}
