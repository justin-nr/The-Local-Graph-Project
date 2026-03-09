import JsonComponents.JsonGenerator;
import JsonComponents.JsonReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        new JsonGenerator("test.json");
//        JsonReader root = JsonReader.arrayread("test.json");
//        String d = root.getIndex(1).getName("name").asString();
//        String e = root.getIndex(2).getName("name").asString();
//        String f = root.getIndex(3).getName("name").asString();
//        System.out.print(d);
//        System.out.print(e);
//        System.out.print(f);

        int V = 5;
        int src = 0;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        //l = location being looked at<start node>
        //a = adjacent node
        //n = time to neighboring node<weight>
        //example for first line: there is a path from 0 -> 1 and the cost is 4
        Dijkstras.addEdge (adj, 0, 1, 4);
        Dijkstras.addEdge (adj, 0, 2, 8);
        Dijkstras.addEdge (adj, 1, 4, 6);
        Dijkstras.addEdge (adj, 1, 2, 3);
        Dijkstras.addEdge (adj, 2, 3, 2);
        Dijkstras.addEdge (adj, 3, 4, 10);

        //spits out the total time from start node to end node
        ArrayList<Integer> result = Dijkstras.dijkstra(adj, src);
        for (int i = 0; i < result.toArray().length; i ++) {
            System.out.println("Node " + i + " distance " + result.get(i));
        }

    }
}