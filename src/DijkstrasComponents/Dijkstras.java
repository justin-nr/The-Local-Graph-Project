package DijkstrasComponents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstras {
    public String calculate(Graph graph, String start, String end) {
        StringBuilder builder = new StringBuilder();

        int currentValue = 0;
        Node currentNode;
        ArrayList<Node> visits = new ArrayList<Node>();
//        ArrayList<Node> unVisit = ;

        Node findStart = graph.map.get(start);
        Node findEnd = graph.map.get(end);



        return builder.toString();
    }
}