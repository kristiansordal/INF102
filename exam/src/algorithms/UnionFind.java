package algorithms;
import java.util.HashMap;

class UnionFind <V> {
	public HashMap<V, DSUNode<V>> components = new HashMap<>();

	public void makeSet(V v) {
		if (!components.containsKey(v)) {
			components.put(v, new DSUNode<V>(v, v));
		}
	}

    public boolean connected(V v, V u) {
        return find(v).equals(find(u));
    }

	public V find(V v) {
		DSUNode<V> curr = components.get(v);
		if (!curr.parent.equals(curr.node)) {
			components.put(v, new DSUNode<V>(find(curr.parent), v));
			return components.get(v).parent;
		}
		return v;
	}

	public void union(V v, V u) {
		V x = find(v);
		V y = find(u);

		if (!x.equals(y)) {
            components.put(y, new DSUNode<V>(x, y));
		}
	}
}

class DSUNode<V> {
	public V parent;
	public V node;

	public DSUNode(V parent, V node) {
		this.parent = parent;
		this.node = node;
	}
}