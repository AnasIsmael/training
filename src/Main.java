public class Main {
    public static void main(String[] args) {
        Dijkstra graph = new Dijkstra();

        // بناء graph
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("C", "B", 1);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 8);
        graph.addEdge("C", "E", 10);
        graph.addEdge("D", "E", 2);

        // تشغيل ديكسترا
        graph.shortestPath("A");

    }
}