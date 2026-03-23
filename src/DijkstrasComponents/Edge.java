package DijkstrasComponents;

public class Edge {
    Node n1;
    Node n2;
    String directions;

    Edge(Node n1, Node n2, String directions) {
        this.n1 = n1;
        this.n2 = n2;
        this.directions = directions;
    }
}