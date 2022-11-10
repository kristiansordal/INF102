package spring_21;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class CentralFinder implements ICentralFinder{
    private PriorityQueue<Integer> hi = new PriorityQueue<>();
    private PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder());

    @Override
    public void add(int number) {

        if (hi.isEmpty() || number > hi.peek()) {
            hi.add(number);
        } else {
            lo.add(number);
        }
        balance();
    }
    @Override
    public int removeCentralValue() {
        if (size() == 0) {
            throw new NoSuchElementException("List is empty");
        }

        balance();
        return hi.poll();
    }
    @Override
    public int size() {
        return lo.size() + hi.size();
    }

    private void balance() {
        if (hi.size() > lo.size() + 1) {
            lo.add(hi.poll());
        } else if (lo.size() > hi.size()) {
            hi.add(lo.poll());
        }
    }

    public static void main(String[] args) {
        CentralFinder cf = new CentralFinder();

		cf.add(75);
		cf.add(43);
		cf.add(-18);
		cf.add(22);
		cf.add(43);
        System.out.println(cf.removeCentralValue());
    }
}
