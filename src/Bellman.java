import java.util.HashMap;
import java.util.Map;

public class Bellman {
    private Map<String, HashMap<String, Integer>> adj;

    public Bellman(){
        adj=new HashMap<>();
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

    public void shortesePath(String source){
        Map<String, Integer> list = new HashMap<>();
        for (String n:adj.keySet()){
            list.put(n,Integer.MAX_VALUE);
        }
        list.put(source,0);

        int iteration=adj.size()-1;
        while (iteration>0){
            for (String n:adj.keySet()){
                if (list.get(n) == Integer.MAX_VALUE)
                    continue;
                for (var entry:adj.get(n).entrySet()){
                    if (entry.getValue()+list.get(n)<list.get(entry.getKey())){
                        list.put(entry.getKey(),entry.getValue()+list.get(n));
                    }
                }
            }
            iteration--;
        }
        System.out.println("Bellman Shortest distances from " + source);

        for (var entry : list.entrySet()) {
            if (entry.getValue() == Integer.MAX_VALUE) {
                System.out.println(entry.getKey() + " -> Unreachable");
            } else {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }


}
