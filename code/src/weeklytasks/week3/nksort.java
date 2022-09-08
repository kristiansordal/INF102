package weeklytasks.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nksort {
    // private static List<T> swap()

    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            int j = i + 1;
            boolean swap = false;
            T curr = list.get(i);
            T next = list.get(j);

            while (next.compareTo(curr) == -1) {
                swap = true;
                next = list.get(++j);
            }

            if (swap) {
                list.set(i, next);
                list.set(j, curr);
            }
        }
    }

    public static <T> void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4)) {
        };

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
