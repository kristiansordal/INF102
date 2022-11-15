package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSort<T extends Comparable<? super T>> {
    public void sort(List<T> list) {
        if (list.size() <= 1) {
            return;
        }

        List<T> fst = new ArrayList<>();
        List<T> snd = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                fst.add(list.get(i));
            } else {
                snd.add(list.get(i));
            }
        }

        sort(fst);
        sort(snd);

        for (int i = list.size() - 1; i >= 0; i--) {
            if (!fst.isEmpty() && (snd.isEmpty() || fst.get(fst.size() -
                    1).compareTo(snd.get(snd.size() - 1)) < 0)) {
                list.set(i, fst.remove(fst.size() - 1));
            } else {
                list.set(i, snd.remove(snd.size() - 1));
            }
        }
    }

    public static void main(String[] args) {
        MergeSort<Integer> ms = new MergeSort<>();

        List<Integer> list = new ArrayList<>(Arrays.asList(5, 6, 2, 3, 1, 7, 4, 2, 1, 32, 4, 5, 21));
        ms.sort(list);
        System.out.println(list);

    }

}
