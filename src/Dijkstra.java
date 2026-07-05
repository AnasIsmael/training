import java.util.*;

public class Dijkstra {
    private Map<String,HashMap<String,Integer>> adj;

    public Dijkstra(){
        adj=new HashMap<>();
    }
    public void addNode(String name){
        adj.putIfAbsent(name,new HashMap<>());
    }
    public void addEdge(String source,String des,int weight){
        addNode(source);
        addNode(des);
        adj.get(source).put(des, weight);
    }
    @Override
    public String toString() {
        return adj.toString();
    }
    public void shortestPath(String source){
        Map<String,Integer>list=new HashMap<>();
        HashSet<String> visited=new HashSet<>();
        for(String n:adj.keySet()){
            list.put(n,Integer.MAX_VALUE);
        }
        list.put(source,0);



        while (visited.size()<adj.size()) {
            int min=Integer.MAX_VALUE;
            String current=null;
            for (var n : list.entrySet()) {
                if (n.getValue() < min && !visited.contains(n.getKey())) {
                    min = n.getValue();
                    current = n.getKey();
                }
            }
            visited.add(current);

            for (var n : adj.get(current).entrySet()) {
                if (n.getValue()+list.get(current)<list.get(n.getKey())){
                    list.put(n.getKey(),n.getValue()+list.get(current));
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
