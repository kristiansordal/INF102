package spring_20;
/**
 * This interface represents a graph
 * A graph consists of a set of vertices and edges.
 * Edges connects pairs of vertices.
 * 
 * @author Martin Vatshelle
 *
 * @param <V> The type of vertices in the graph
 */
public interface IGraph<V> {

	/**
	 * Gives a way to iterate through all vertices of this graph
	 */
	public Iterable<V> vertices();

	/**
	 * Gives a way to iterate through all edges of this graph
	 */
	public Iterable<Edge<V>> edges();

	/**
	 * Checks if two given vertices are adjacent
	 * 
	 * @return true if both vertices are in the graph and there is an edge between
	 *         them in the graph
	 */
	public boolean adjacent(V a, V b);

	/**
	 * Gives a way to iterate through the neighbours of a vertex
	 */
	public Iterable<V> neighbours(V v);

	/**
	 * Counts the number of neighbours a vertex has
	 */
	public int degree(V v);
}
