package spring_21;

public interface IRandomList<T> {

	/**
	 * Adds an element to this List
	 * @param elem - the element to add 
	 */
	public void add(T elem);

	/**
	 * Finds a random element in the list with uniform probability
	 * (meaning all elements has the same chance of being returned).
	 * Remove this element from the list and return it.
	 * 
	 * If list is empty an NoSuchElementException should be thrown.
	 * 
	 * @return the random element which has been removed from the list
	 */
	public T removeRandom();
}