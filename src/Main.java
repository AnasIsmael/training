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


        Bellman graph1 = new Bellman();

        graph1.addEdge("A", "B", 4);
        graph1.addEdge("A", "C", 2);
        graph1.addEdge("B", "C", 3);
        graph1.addEdge("B", "D", 2);
        graph1.addEdge("B", "E", 3);
        graph1.addEdge("C", "B", 1);
        graph1.addEdge("C", "D", 4);
        graph1.addEdge("C", "E", 5);
        graph1.addEdge("E", "D", -5);

        System.out.println(graph);

        graph1.shortesePath("A");

    }
}