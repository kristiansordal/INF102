package lecture2;

import java.util.ArrayList;
import java.util.List;

public interface ListReverser {
    // @Override
    public static <T> List<T> reverse(List<T> list) {
        List<T> newList = new ArrayList<>();

        for (T t : list) {
            newList.add(0,t);
        }
        return newList;
    }
}
