package spring_20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * This graph is a simple graph.
 * This means no loops or multiple edges are allowed
 * Data invariant:
 * - a is in vertices if and only if a is a key in adjecencyList
 * - if a is a neighbour of b then b is a neighbour of a
 * 
 * @author Martin Vatshelle
 *
 * @param <V>
 */
public class Graph<V> implements IGraph<V> {

	// Vertices
	private HashSet<V> vertices;
	// Edges
	private HashMap<V, HashSet<V>> adjacencyList;
	private int edges;

	/**
	 * Construct an empty graph
	 */
	public Graph() {
		this.vertices = new HashSet<V>();
		this.adjacencyList = new HashMap<V, HashSet<V>>();
	}

	public V getFirstNode() {
		return vertices().iterator().next();
	}

	@Override
	public Iterable<V> vertices() {
		return Collections.unmodifiableSet(vertices);
	}

	@Override
	public Iterable<Edge<V>> edges() {
		ArrayList<Edge<V>> edges = new ArrayList<Edge<V>>();
		HashSet<V> nodesDone = new HashSet<V>();
		for (V a : vertices()) {
			for (V b : neighbours(a)) {
				if (nodesDone.contains(b))
					continue;
				edges.add(new Edge<V>(a, b));
			}
			nodesDone.add(a);
		}
		return edges;
	}

	@Override
	public boolean adjacent(V a, V b) {
		try {
			checkVertex(a);
			checkVertex(b);
		} catch (IllegalArgumentException e) {
			return false;
		}

		return adjacencyList.get(a).contains(b);
	}

	/**
	 * Finds all edges which has one endpoint equal to v
	 * 
	 * @return all edges found
	 */
	public Iterable<Edge<V>> adjacentEdges(V v) {
		ArrayList<Edge<V>> edges = new ArrayList<Edge<V>>();
		for (V neighbour : getNeighbours(v)) {
			edges.add(new Edge<V>(v, neighbour));
		}
		return edges;
	}

	@Override
	public Iterable<V> neighbours(V v) {
		return Collections.unmodifiableSet(getNeighbours(v));
	}

	private HashSet<V> getNeighbours(V v) {
		checkVertex(v);
		return adjacencyList.get(v);
	}

	/**
	 * @return number of vertices in the graph
	 */
	public int numVertices() {
		return vertices.size();
	}

	/**
	 * @return number of edges in the graph
	 */
	public int numEdges() {
		return edges;
	}

	/**
	 * Checks that the node is in this graph, throws exception if not
	 */
	private void checkVertex(V v) {
		if (!vertices.contains(v))
			throw new IllegalArgumentException("The node " + v + " is not in this graph.");
		if (!adjacencyList.containsKey(v))
			throw new IllegalStateException("Data invariant is broken, no neighbourhoodlist for node " + v);
	}

	@Override
	public int degree(V v) {
		return getNeighbours(v).size();
	}

	// Add and remove methods
	/**
	 * Adds a vertex to the graph if not already in the graph
	 * 
	 * @param v the vertex to add
	 * @return true if a vertex was added, false otherwise
	 */
	public boolean addVertex(V v) {
		boolean changed = vertices.add(v);
		if (changed)
			adjacencyList.put(v, new HashSet<V>());
		return changed;
	}

	/**
	 * This method connects two vertices by an edge
	 * Makes sure that both a is a neighbour of b and that b is an neighbour of a
	 * 
	 * @param a,b the vertices to connect
	 * @return true if an edge was added, false otherwise
	 */
	public boolean addEdge(V a, V b) {
		HashSet<V> aNeighbours = getNeighbours(a);
		HashSet<V> bNeighbours = getNeighbours(b);
		if (a.equals(b)) {
			throw new IllegalArgumentException("Adding loops to the graph is not supported.");
		}
		// if at least one of the two edges is in the graph
		if (aNeighbours.contains(b) || bNeighbours.contains(a)) {
			// if not both of the two edges is in the graph throw Exception
			if (!aNeighbours.contains(b) || !bNeighbours.contains(a))
				throw new IllegalStateException(
						"Data invariant is broken, " + a + " and " + b + " are only added once to adjacencyList.");
			// else already has this edge so no change will be made
			return false;
		} else {
			aNeighbours.add(b);
			bNeighbours.add(a);
			edges++;
			return true;
		}

	}

	public void addEdge(Edge<V> e) {
		addEdge(e.a, e.b);
	}

	public int size() {
		return vertices.size();
	}

	/**
	 * Removes a vertex from the graph if the vertex exist
	 * 
	 * @param a the vertex to remove
	 * @return true if a vertex was removed, false otherwise
	 */
	public boolean removeVertex(V a) {
		try {
			checkVertex(a);
		} catch (IllegalArgumentException e) {
			return false;
		}
		Iterable<V> neighboursCopy = new HashSet<V>((Collection<? extends V>) neighbours(a));
		for (V b : neighboursCopy) {
			removeEdge(a, b);
		}
		vertices.remove(a);
		return true;
	}

	/**
	 * Removes an edge from the graph if the edge exist
	 * 
	 * @param a,b the pair of vertices to remove the edge from
	 * @return true if an edge was removed, false otherwise
	 */
	public boolean removeEdge(V a, V b) {
		try {
			checkVertex(a);
			checkVertex(b);
		} catch (IllegalArgumentException e) {
			return false;
		}
		boolean change = adjacencyList.get(a).remove(b);
		change = adjacencyList.get(b).remove(a) || change;
		if (change)
			edges--;
		return change;
	}

	public boolean removeEdge(Edge<V> e) {
		return removeEdge(e.a, e.b);
	}

	/**
	 * Creates a copy of the graph
	 */
	public Graph<V> clone() {
		Graph<V> g = new Graph<V>();
		for (V v : vertices)
			g.addVertex(v);
		for (Edge<V> e : edges())
			g.addEdge(e.a, e.b);
		return g;
	}
}
