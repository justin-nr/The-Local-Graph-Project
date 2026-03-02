package DijkstrasComponents;

public class Node {

    String name;
    String description;
    Node start;
    Node end;


    Node(String name, String description) {
        this.name = name;
        this.description = description;
        start = null;
        end = null;
    }

}
