package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class HeapSort <T extends Comparable<? super T>>{
    public List<T> sort(List<T> list) {
        PriorityQueue<T> q = new PriorityQueue<>();

        for (T t : list) {
            q.add(t);
        }

        List<T> sorted = new ArrayList<>();
        while (!q.isEmpty()) {
            sorted.add(q.poll());
        }

        return sorted;
    }

    public static void main(String[] args) {
        HeapSort<Integer> hs = new HeapSort<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 5, 2, 16, 7, 34, 2, 1, 2, 3, 56, 3));
        list = hs.sort(list);
        System.out.println(list);
    }
}
