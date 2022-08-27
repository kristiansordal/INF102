package weeklytasks.week1;

import java.util.ArrayList;
import java.util.Collections;
// import java.io.FileWriter;
// import java.io.IOException;

public class task1 {
    private static <T> Boolean compare(Integer x, Integer y) {
        return x >= y;
    }

    public static Integer threeSumLargest(ArrayList<Integer> list) {
    // public static long threeSumLargest(ArrayList<Integer> list) {
        int n = list.size();
        Integer largest = 0;

        long start1 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    Integer num1 = list.get(i);
                    Integer num2 = list.get(j);
                    Integer num3 = list.get(k);

                    if (num1 != num2 && num1 != num3 && num2 != num3) {
                        Integer num = (num1 + num2 + num3);
                        if (compare(num, largest)) {
                            largest = num;
                        }
                    }
                }
            }
        }
        long end1 = System.nanoTime();
        System.out.println("Elapsed time: " + (end1 - start1) + " nanoseconds");
        System.out.println(largest);
        return largest;
        // return (end1 - start1);
    }

    public static Integer fastThreeSumLargest(ArrayList<Integer> list) {
    // public static long fastThreeSumLargest(ArrayList<Integer> list) {
        long start2 = System.nanoTime();
        int size = list.size();
        Collections.sort(list);

        Integer largest = list.get(size - 1) + list.get(size - 2) + list.get(size - 3);
        long end2 = System.nanoTime();

        System.out.println("Elapsed time: " + (end2 - start2) + " nanoseconds");
        System.out.println(largest);
        return largest;
        // return (end2 - start2);
    }

    public static <T> void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(8);
        list.add(19);
        list.add(-1);
        list.add(27);
        list.add(3);
        list.add(9);
        list.add(-40);

        threeSumLargest(list);
        fastThreeSumLargest(list);

        // try {
        //     FileWriter myWriter1 = new FileWriter("task1timefast.txt");
        //     for (int i = 0; i <= 25; i++) {
        //         long largest = fastThreeSumLargest(list);
        //         myWriter1.write("(" + i + "," + largest + ")");
        //     }
        //     myWriter1.close();

        // } catch (IOException e) {
        //     System.out.println("An error occurred.");
        //     e.printStackTrace();
        // }
    }
}
