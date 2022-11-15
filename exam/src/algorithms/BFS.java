package algorithms;

import java.util.HashSet;
import java.util.LinkedList;

public class BFS<V> {
    public V furthest(Graph<V> g, V root) {
        HashSet<V> found = new HashSet<>();
        LinkedList<V> toSearch = new LinkedList<>();
        V furthest = root;

        while (!toSearch.isEmpty()) {
            // --- change to removefirst and we'll have DFS
            V next = toSearch.removeLast();
            if (found.contains(next)) {
                continue;
            }

            found.add(next);
            furthest = next;
            g.neighbours(next).forEach(n -> toSearch.add(n));
        }

        return furthest;
    }
}
