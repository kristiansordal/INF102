package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort<T extends Comparable<? super T>> {
    public List<T> sort(List<T> list) {
        if (list.size() <= 1) {
            return list;
        }

        List<T> left = new ArrayList<>();
        List<T> right = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() / 2) {
                left.add(list.get(i));
            } else {
                right.add(list.get(i));
            }
        }

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    private List<T> merge(List<T> left, List<T> right) {
        List<T> list = new ArrayList<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.get(0).compareTo(right.get(0)) <= 0) {
                list.add(left.remove(0));
            } else {
                list.add(right.remove(0));
            }
        }

        while (!left.isEmpty()) {
            list.add(left.remove(0));
        }
        
        while (!right.isEmpty()) {
            list.add(right.remove(0));
        }

        return list;
    }

    public static void main(String[] args) {
        MergeSort<Integer> ms = new MergeSort<>();

        List<Integer> list = new ArrayList<>(Arrays.asList(5, 6, 2, 3, 1, 7, 4, 2, 1, 32, 4, 5, 21));
        list = ms.sort(list);
        System.out.println(list);

    }

}
