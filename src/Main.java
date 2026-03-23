import DijkstrasComponents.Dijkstras;
import DijkstrasComponents.Graph;
import JsonComponents.JsonReader;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new Graph("JSON_Data.JSON");
        System.out.println(graph);

        Dijkstras dijkstras = new Dijkstras(graph, JsonReader.read("JSON_Data.JSON").getString("directionTemplate"));

        String data = dijkstras.calculate("Aspen", "Day Care");
        System.out.println(data);
    }
}
