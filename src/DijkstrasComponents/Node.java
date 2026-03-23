package DijkstrasComponents;

import java.util.ArrayList;

public class Node {
    String name;

    public Node closestNode;
    public float closestWeight = 999999999f;

    public ArrayList<Connector> connectors;

    public Node (String name) {
        connectors = new ArrayList<Connector>();
        this.name = name;
    }

    public boolean allowConnection(Node n2) {
        for (Connector connector : connectors) {
            Edge edge = connector.e1;
            if (edge.n1 == n2 || edge.n2 == n2) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "N_" + name;
    }
}
