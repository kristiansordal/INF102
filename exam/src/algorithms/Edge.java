package algorithms;
/**
 * Represents an edge in a graph.
 * 
 * @author Martin Vatshelle
 *
 * @param <V>
 */
public class Edge<V> {
	// We make variables public final because we don't want edges
	// to change once they have been made
	// (we could achieve the same by having get method but not set method)
	public final V a;
	public final V b;

	public Edge(V a, V b) {
		if (a.equals(b))
			throw new IllegalArgumentException("Loops are not allowed");
		if (a == null || b == null)
			throw new IllegalArgumentException("Nodes can not be null");
		this.a = a;
		this.b = b;
	}

	// Two edges are considered equal if they connects the same two vertices.
	// so a--b is equal to b--a
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof Edge) {
			@SuppressWarnings("unchecked")
			Edge<V> e = (Edge<V>) obj;
			return equals(e.a, e.b);
		}
		return false;
	}

	/**
	 * Checks if this edge connects the two given nodes
	 * 
	 * @param a one node
	 * @param b another node
	 * @return true if the edge connects a and b
	 */
	public boolean equals(V a, V b) {
		if (this.a.equals(a) && this.b.equals(b))
			return true;
		if (this.a.equals(b) && this.b.equals(a))
			return true;

		return false;
	}

	@Override
	public int hashCode() {
		return ((a == null) ? 0 : a.hashCode()) ^ ((b == null) ? 0 : b.hashCode());
	}

	@Override
	public String toString() {
		return "(" + a.toString() + " -- " + b.toString() + ")";
	}
}
