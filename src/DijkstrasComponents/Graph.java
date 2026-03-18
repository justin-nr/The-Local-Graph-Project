package DijkstrasComponents;
import JsonComponents.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Graph {
    HashMap<String, Node> map;
    ArrayList<Connector> connectors;

    public Graph(String fileName) {
        map = new HashMap<String, Node>();
        connectors = new ArrayList<Connector>();

        JsonReader reader;
        try {
           reader = JsonReader.read(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        };
        System.out.println(reader);

        int number = 0;
        ArrayList<String> nodeNames = new ArrayList<String>();
        while (reader.getName("nodes").getIndex(number) != null) {
            String name = reader.getName("nodes").getIndex(number).asString();
            Node node = new Node(name);
            map.put(name, node);
            nodeNames.add(name);
            number ++;
        }
        number = 0;
        System.out.println(nodeNames);
        for (int i = 0; i < nodeNames.size(); i ++) {
            String indexed = nodeNames.get(i);
//            System.out.println(indexed);

            if (reader.getName("edges").getName(indexed).raw() != null) {
                JsonReader obj = reader.getName("edges").getName(indexed);
                int currentIndex = 0;
                while (obj.getIndex(currentIndex) != null) {
                    String to = obj.getIndex(currentIndex).getString("to");
                    float weight = Float.parseFloat(obj.getIndex(currentIndex).getString("weight"));

                    System.out.println(to + " | " + weight);

                    Node n1 = map.get(indexed);
                    Node n2 = map.get(to);

                    Connector connector = new Connector(n1, n2, weight);

                    connectors.add(connector);

                    currentIndex ++;
                }
            }
        }
    }

    public ArrayList<Node> getNodes() {
//        for (int i = 0; i < ; i ++) {
//
//        }
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
