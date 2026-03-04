package DijkstrasComponents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    Map<String, List<Node>> map;
    ArrayList<Node> nodes;

    Graph() {
        map = new HashMap<>();
        nodes = new ArrayList<Node>();
    }

    // Making a node from graph requires everything to place it.
    public Node addNode(String name, String description, int posX, int posY) {
        Node node = new Node(name, description);
        node.setPosition(posX, posY);
        nodes.add(node);
        return node;
    }
    public void connectNode(Node node1, Node node2) {
        node1.connect(node2);
    }
}
