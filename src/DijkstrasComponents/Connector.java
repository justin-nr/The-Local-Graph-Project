package DijkstrasComponents;
//hi
public class Connector {
    Edge e1;
    Edge e2;
    float weight;

    public Connector(Node n1, Node n2, float weight, String directions, String revDirection) {
        if (n1 == n2) {
            throw new RuntimeException("Nodes cannot connect to themselves.");
        }

        e1 = new Edge(n1, n2, directions);
        e2 = new Edge(n2, n1, revDirection);
        this.weight = weight;
    }
}
