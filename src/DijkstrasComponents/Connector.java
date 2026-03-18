package DijkstrasComponents;

public class Connector {
    Edge e1;
    Edge e2;
    float weight;

    public Connector(Node n1, Node n2, float weight) {
        e1 = new Edge(n1, n2);
        e2 = new Edge(n2, n1);
        this.weight = weight;
    }
}
