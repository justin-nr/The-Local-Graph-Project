package DijkstrasComponents;

public class Edge {

    //Variables
    String description;
    int destination;
    int direction;
    int weight;

    //creates object
    public Edge(String description,int destination, int direction, int weight) {
        //applies varibles to object
        this.weight = weight;
        this.destination = destination;
        this.direction = direction;
        this.description = description;

    }
}