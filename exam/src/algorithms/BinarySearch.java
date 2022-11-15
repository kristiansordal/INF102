package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class BinarySearch<E extends Comparable<? super E>> {
    List<E> sorted;

    public BinarySearch(ArrayList<E> sorted) {
        this.sorted = sorted;
    }

    public int search(E target) {
        int lo = 0;
        int hi = sorted.size() - 1;
        int mid = 0;

        while (lo <= hi) {
            mid = hi - (hi - lo) / 2;

            if (sorted.get(mid).compareTo(target) < 0) {
                lo = mid + 1;
            } else if (sorted.get(mid).compareTo(target) > 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        throw new NoSuchElementException("Element not in list");
    }
}