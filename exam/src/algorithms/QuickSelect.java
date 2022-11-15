package algorithms;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuickSelect<T extends Comparable<? super T>> {
    public T select(List<T> list, int left, int right, int k) {
        if (left == right) {
            return list.get(left);
        }

        Random rand = new Random();
        int pivot = rand.nextInt(left, right);
        pivot = partition(list, left, right, pivot);

        if (k == pivot) {
            return list.get(k);
        } else if (k < pivot) {
            return select(list, left, pivot - 1, k);
        } else {
            return select(list, pivot + 1, right, k);
        }
    }

    private int partition(List<T> list, int left, int right, int pivot) {
        T pivotVal = list.get(pivot);
        Collections.swap(list, pivot, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (list.get(i).compareTo(pivotVal) < 0) {
                Collections.swap(list, storeIndex++, i);
            }
        }
        Collections.swap(list, right, storeIndex);
        return storeIndex;
    }
}
