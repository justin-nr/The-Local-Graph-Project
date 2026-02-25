package DijkstrasComponents;

public class Edge {

    //Variables
    String label;
    String description;
    String direction;
    int weight;

    //creates object
    Object edge(String label, String description, String direction, int weight) {
        //applies varibles to object
        this.label = label;
        this.weight = weight;
        this.direction = direction;
        this.description = description;

        //returns the applied variables with object
        return edge(label, description, direction, weight); //null as placeholder
    }
}