import DijkstrasComponents.Graph;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new Graph("JSON_Data.JSON");
        System.out.println(graph);
    }
}
