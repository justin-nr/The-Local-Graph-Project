package DijkstrasComponents;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    String graphName;
    HashMap map;

    public Graph(){
        this.graphName = "Graph";
        map = new HashMap<>();
    }
    public Graph(String graphName){
        this.graphName = graphName;
        map = new HashMap<>();
    }

    public void insert(String key, Node nodeToAdd) {
        boolean empty = (!map.containsKey(key));

        if (empty) {
            map.put(key, nodeToAdd);
        }
    }
    public void insertIgnore(String key, Node nodeToAdd) {
        map.put(key, nodeToAdd);
    }


    @Override
    public String toString() {
        return graphName + ": {" +
                " Hash=" + map +
                '}';
    }
}
