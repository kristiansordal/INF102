package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Kruskal {
	public <V, E extends Comparable<E>> List<Edge<V>> mst(WeightedGraph<V, E> g) {
		List<Edge<V>> edges = new ArrayList<>();
		List<Edge<V>> mst = new ArrayList<>();
		int size = g.size();


		// --- create a list of the edges and sort them, then add them to the vertices list
        g.edges().forEach(e -> edges.add(e));
		edges.sort(g); // o(m log (m))
		UnionFind<V> UF = new UnionFind<>();

		for (int i = 0; i < edges.size(); i++) { // o(n^2)
			Edge<V> current = edges.get(i);
			UF.makeSet(current.a);
			UF.makeSet(current.b);

            if (!UF.connected(current.a, current.b)) {
                UF.union(current.a, current.b);
                mst.add(current);
            }

			if (mst.size() == size - 1) {
				return mst;
			}
		}

		return mst;
	}
}