package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort <T extends Comparable<? super T>> {

    public List<T> sort(List<T> list) {
        int left = 0;
        int right = list.size() - 1;
        return qsort(list, left, right);
    }

    private List<T> qsort(List<T> list, int left, int right) {
        if (left >= right || left < 0) {
            return list;
        }

        int pivot = partition(list, left, right);

        qsort(list, left, pivot - 1);
        qsort(list, pivot + 1, right);

        return list;
    }

    private int partition(List<T> list, int left, int right) {
        T pivot = list.get(right);

        int tmp = left - 1;
        for (int i = left; i < right; i++) {
            if (list.get(i).compareTo(pivot) <= 0) {
                Collections.swap(list, ++tmp, i);
            }
        }

        Collections.swap(list, ++tmp, right);
        System.out.println("pivot: " +pivot +" left: " +left+ " right: "+right+" list: " + list);
        return tmp;
    }

    public static void main(String[] args) {
        QuickSort<Integer> qs = new QuickSort<>();

        List<Integer> list = new ArrayList<>(Arrays.asList(4,7,15,1,9,3,6,12,2));
        list = qs.sort(list);
        System.out.println(list);
    }
}
