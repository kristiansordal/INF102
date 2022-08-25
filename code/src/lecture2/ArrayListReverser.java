package lecture2;
import java.util.ArrayList;
import java.util.List;

public class ArrayListReverser implements ListReverser{
    public static void main(String[] args) {
        ArrayListReverser rev = new ArrayListReverser();
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);
        System.out.println(rev.reverse(list));
    }

    // @Override
    public <T> List<T> reverse(List<T> list) {
        List<T> newList = new ArrayList<>();

        for (T t : list) {
            newList.add(0,t);
        }
        return newList;
    }
}
