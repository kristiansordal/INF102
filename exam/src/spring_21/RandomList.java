package spring_21;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomList<T> implements IRandomList<T>{
    private ArrayList<T> list;
    private Random rand = new Random();

    public void add (T elem){
        list.add(elem);
    }

    public T removeRandom(){
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        Collections.swap(list, rand.nextInt(list.size()), list.size() - 1);
        return list.remove(list.size() - 1);
    }
} 
        
