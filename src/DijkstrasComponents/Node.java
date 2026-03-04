package DijkstrasComponents;

import java.util.ArrayList;

public class Node {

    String name;
    String description;
    ArrayList<Node> connections;

    private int x;
    private int y;

    Node(String name, String description) {
        this.name = name;
        this.description = description;
        connections = new ArrayList<Node>();
    }

    // This connects the nodes.
    public void connect(Node otherNode) {
        connections.add(otherNode);
        otherNode.connections.add(otherNode);
    }

    //Sets the position of the node on a 2d plane (map).
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int[] getPosition() {
        return new int[]{x, y};
    }
}
