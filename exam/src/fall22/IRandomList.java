package fall22;

public interface IRandomList<T> {
    /**
     * Adds an element to this list
     * @param elem - the element to add
     */
    public void add(T elem);

    /**
     * Finds a random element in the list with uniform probability
     * (meaning all elements has the same chance of being returned).
     * 
     * If list is empty an NoSuchElementException should be thrown.
     * 
     * @return a element from the list
     */

    public T drawRandom();
}
