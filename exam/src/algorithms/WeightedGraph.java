package algorithms;
import java.util.Comparator;
import java.util.HashMap;

/**
 * This class is a weighted graph where each edge has a weight.
 * This class also work as a Comparator for Edges by using the natural
 * order of the edge weights to compare edges.
 * 
 * @author Martin Vatshelle, Olav Bakken
 *
 * @param <V> Type of vertices
 * @param <E> Type of weights, needs to be comparable
 */
public class WeightedGraph<V, E extends Comparable<E>> extends Graph<V> implements Comparator<Edge<V>> {

	private HashMap<Edge<V>, E> edgeWeight;

	/**
	 * Constructs an empty weighted graph
	 */
	public WeightedGraph() {
		super();
		edgeWeight = new HashMap<Edge<V>, E>();
	}

	/**
	 * Gets the edge weight between a pair of vertices
	 */
	public E getWeight(V a, V b) {
		return getWeight(new Edge<V>(a, b));
	}

	/**
	 * Gets the edge weight of a given edge
	 */
	public E getWeight(Edge<V> e) {
		return edgeWeight.get(e);
	}

	/**
	 * Sets the weight of the edge between a pair of vertices
	 * If there is no edge between those vertices an exception is thrown
	 */
	public void setWeight(V a, V b, E weight) {
		if (!adjacent(a, b))
			throw new IllegalArgumentException("These edges are not adjacent.");
		edgeWeight.put(new Edge<V>(a, b), weight);
	}

	@Override
	public boolean addEdge(V a, V b) {
		throw new UnsupportedOperationException("Weighted graphs need to use the weighted version of add.");
	}

	/**
	 * @param a,b    the pair of vertices to add an edge between
	 * @param weight the weight of the edge
	 * @return true if an edge was added, false otherwise
	 */
	public boolean addEdge(V a, V b, E weight) {
		if (weight == null)
			throw new IllegalArgumentException("Edge weights can not be null.");
		if (super.addEdge(a, b)) {
			setWeight(a, b, weight);
			return true;
		}
		return false;
	}

	public boolean addEdge(Edge<V> e, E weight) {
		return addEdge(e.a, e.b, weight);
	}

	@Override
	public boolean removeEdge(V a, V b) {
		return removeEdge(new Edge<V>(a, b));
	}

	@Override
	public boolean removeEdge(Edge<V> e) {
		boolean changed = super.removeEdge(e);
		if (changed)
			edgeWeight.remove(e);
		return changed;
	}

	@Override
	public int compare(Edge<V> o1, Edge<V> o2) {
		return getWeight(o1.a, o1.b).compareTo(getWeight(o2.a, o2.b));
	}

	@Override
	public WeightedGraph<V, E> clone() {
		WeightedGraph<V, E> g = new WeightedGraph<V, E>();
		for (V v : vertices())
			g.addVertex(v);
		for (Edge<V> e : edges())
			g.addEdge(e.a, e.b, getWeight(e));
		return g;
	}
}
