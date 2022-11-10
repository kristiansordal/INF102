package spring_21;

/**
 * A CentralFinder is a data structure that holds a collection integers.
 * The main purpose of the data structure is to be able to remove a central value.
 * That is a value x in the collection such that: 
 * - at most size()/2 values are higher than x and
 * - at most size()/2 values are lower than x.
 * 
 * @author Martin Vatshelle
 *
 */
public interface ICentralFinder {

	/**
	 * Adds a number to this collection
	 * @param number - the number to add
	 */
	public void add(int number);
	
	/**
	 * Finds a central value in this collection and removes it from the collection
	 * 
	 * If the collection is empty, throw NoSuchElementException
	 * 
	 * @return a central value from this collection
	 */
	public int removeCentralValue();
	
	/**
	 * The number of integers in this collection
	 * @return
	 */
	public int size();
	
}
