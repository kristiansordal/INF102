package weeklytasks.week1;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.io.FileWriter;
import java.io.IOException;

public class task2 {
    public static Boolean twoSum(List<Integer> list){
    // public static long twoSum(List<Integer> list){
        int n = list.size();
        Boolean containsTwo = false;
        Integer sum = 0;

        long start2 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            Integer num1 = list.get(i);

            for (int j = 0; j < n; j++) {
                Integer num2 = list.get(i);
                if (num1 - num2 == sum) {
                    containsTwo = true;
                }
            }
        }

        long end2 = System.nanoTime();
        System.out.println("Elapsed time: " + (end2 - start2));

        return containsTwo;
        // return (end2 - start2);
    }

    public static Boolean fastTwoSum(List<Integer> list) {
    // public static long fastTwoSum(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>();
        int n = list.size();
        Integer sum = 0;
        Boolean containsTwo = false;

        long start1 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            Integer num = list.get(i);

            if (set.isEmpty()) {
                set.add(num);
            } else if (!set.contains(sum - num)) {
                set.add(num);
            } else {
                containsTwo = true;
            }
        }

        long end1 = System.nanoTime();
        System.out.println("Elapsed time: " + (end1 - start1));

        return containsTwo;
        // return (end1 - start1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(-10);
        list.add(-8);
        list.add(-4);
        list.add(-1);
        list.add(5);
        list.add(8);
        list.add(18);
        list.add(20);
        list.add(40);

        // Boolean sumsTwo = fastTwoSum(list);
        // System.out.println(sumsTwo);

        // sumsTwo = twoSum(list);
        // System.out.println(sumsTwo);

        // try {
        //     FileWriter myWriter1 = new FileWriter("task2timefast.txt");
        //     for (int i = 0; i <= 25; i++) {
        //         long largest = fastTwoSum(list);
        //         myWriter1.write("(" + i + "," + largest + ")");
        //     }
        //     myWriter1.close();

        // } catch (IOException e) {
        //     System.out.println("An error occurred.");
        //     e.printStackTrace();
        // }
    }
}
