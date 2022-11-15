package fall22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class  RandomList<T> implements IRandomList<T>{
    public List<T> list = new ArrayList<>();

    @Override
    public void add(T elem) {
        list.add(elem);
        
    }

    @Override
    public T drawRandom() {
        Random rand = new Random();
        Collections.swap(list, rand.nextInt(list.size() - 1), list.size() - 1);
        return list.get(list.size() - 1);
    }
    
}
