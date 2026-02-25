package DijkstrasComponents;

public class Edge {

    //Variables
    String label;
    String description;
    int weight;

    //creates object
    Object edge(String label, String description, int weight) {
        //applies varibles to object
        this.label = label;
        this.weight = weight;
        this.description = description;

        //returns the applied variables with object
        return edge(label, description, weight); //null as placeholder
    }
}