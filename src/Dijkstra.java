import java.util.*;

public class Dijkstra {
    private Map<String, HashMap<String, Integer>> adj;

    public Dijkstra() {
        adj = new HashMap<>();
    }

    public void addNode(String name) {
        adj.putIfAbsent(name, new HashMap<>());
    }

    public void addEdge(String source, String des, int weight) {
        addNode(source);
        addNode(des);
        adj.get(source).put(des, weight);
    }

    @Override
    public String toString() {
        return adj.toString();
    }

    public void shortestPath(String source) {
        Map<String, Integer> list = new HashMap<>();
        HashSet<String> visited = new HashSet<>();

        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (String n : adj.keySet()) {
            list.put(n, Integer.MAX_VALUE);
        }
        list.put(source, 0);

        pq.add(new AbstractMap.SimpleEntry<>(source, 0));

        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> current = pq.poll();

            String node = current.getKey();
            int dist = current.getValue();

            if (visited.contains(node)) continue;
            visited.add(node);

            for (var n : adj.get(node).entrySet()) {
                int newDist = dist + n.getValue();

                if (newDist < list.get(n.getKey())) {
                    list.put(n.getKey(), newDist);
                    pq.add(new AbstractMap.SimpleEntry<>(n.getKey(), newDist));
                }
            }
        }

        System.out.println("Shortest distances from source " + source + ":");

        for (var entry : list.entrySet()) {
            if (entry.getValue() == Integer.MAX_VALUE) {
                System.out.println(entry.getKey() + " -> unreachable");
            } else {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }
}