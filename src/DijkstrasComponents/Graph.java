package DijkstrasComponents;
import JsonComponents.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
//hi
public class Graph {
    HashMap<String, Node> map;

    public Graph(String fileName) {
        map = new HashMap<String, Node>();

        JsonReader reader;
        try {
           reader = JsonReader.read(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        };
//        System.out.println(reader);

        // loopNumber for the reader.
        int loopNumber = 0;
        ArrayList<String> nodeNames = new ArrayList<String>();

        // Getting all the node names for nodeNames.
        while (reader.getName("nodes").getIndex(loopNumber) != null) {
            String name = reader.getName("nodes").getIndex(loopNumber).asString();
            Node node = new Node(name);
            map.put(name, node);
            nodeNames.add(name);
            loopNumber ++;
        }
//        System.out.println(nodeNames);

        // Loops through all the node names.
        for (int i = 0; i < nodeNames.size(); i ++) {
            String indexed = nodeNames.get(i);
//            System.out.println(indexed);


            if (reader.getName("edges").getName(indexed).raw() != null) {
                JsonReader obj = reader.getName("edges").getName(indexed);
                int currentIndex = 0;

                // while there is an array in the edge, we will loop through them and make set them up.
                while (obj.getIndex(currentIndex) != null) {
                    // Getting the resulting "to" and "weight" for connection setup.
                    String to = obj.getIndex(currentIndex).getString("to");
                    float weight = Float.parseFloat(obj.getIndex(currentIndex).getString("weight"));

//                    System.out.println(to + " | " + weight);

                    // Both nodes for the connection.
                    Node n1 = map.get(indexed);
                    Node n2 = map.get(to);

                    String directions = obj.getIndex(currentIndex).getString("direction");
                    String revDirections = obj.getIndex(currentIndex).getString("reverseDirection");

//                    System.out.println("Move from: " + n1.name + " | " + n2.name + ": " + directions + " | " + revDirections);

                    // Validates whether we can make the connection or not.
                    // Basically checking if there is already a connection made here.
                    boolean validateConnection = n1.allowConnection(n2);
                    if (validateConnection) {
                        Connector connector = new Connector(n1, n2, weight, directions, revDirections);
//                        System.out.println(n1.name);
                        n1.connectors.add(connector);
                        n2.connectors.add(connector);
                    }
                    currentIndex ++;
                }
            }
        }
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
