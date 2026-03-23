package DijkstrasComponents;

import java.util.*;

public class Dijkstras {

    Graph graph;
    String directionTemplate;

    public Dijkstras(Graph graph, String directionTemplate) {
        this.graph = graph;
        this.directionTemplate = directionTemplate;
//        System.out.println(directionTemplate);
    }

    public String calculate(String start, String end) {

        // This will be used later down the code when we are mapping out the directions.
        StringBuilder builder = new StringBuilder();

        float currentWeight = 0;
        Node currentNode = null;

//        ArrayList<Node> visited = new ArrayList<Node>();
        ArrayList<Node> unVisited = new ArrayList<Node>();

        for (Map.Entry<String, Node> entry : graph.map.entrySet()) {
            entry.getValue().closestWeight = 999999999f;
            entry.getValue().closestNode = null;
            unVisited.add(entry.getValue());
        }

        if (!graph.map.containsKey(start) || !graph.map.containsKey(end)) {
            throw new RuntimeException("Both start and end arguments have to be valid components of graph.map");
        }

        Node findStart = graph.map.get(start);
        Node findEnd = graph.map.get(end);

        findStart.closestWeight = 0f;
        currentNode = findStart;

        while (!unVisited.isEmpty()) {
//             TODO Make a simple table system before completing.
            unVisited.remove(currentNode);
            currentWeight = currentNode.closestWeight;

            for (Connector connector : currentNode.connectors) {
                Edge e1 = connector.e1;

                Node otherNode;

                if (currentNode == e1.n1) {
                    otherNode = e1.n2;
                } else {
                    otherNode = e1.n1;
                }

//                System.out.println(otherNode.closestWeight > currentWeight + connector.weight);
                if (currentWeight + connector.weight < otherNode.closestWeight) {
                    otherNode.closestNode = currentNode;
                    otherNode.closestWeight = currentWeight + connector.weight;
                }
            }

            // Gets the next node with the lowest weight in unvisited.
            
            float lowestWeight = 9999999999999.99999f;
            Node nextNode = null;
            for (Node node : unVisited) {

//                System.out.println(node.name + ", "  + node.closestWeight);

                if (node.closestWeight < lowestWeight) {
                    lowestWeight = node.closestWeight;
                    nextNode = node;
                }
            }
            if (nextNode != null) {
                currentNode = nextNode;
                currentWeight = nextNode.closestWeight;
            }
        }

        for (Map.Entry<String, Node> entry : graph.map.entrySet()) {
            Node node = entry.getValue();
//            System.out.println(node.name + ", " + node.closestNode + ", " + node.closestWeight);
        }

//        System.out.println(unVisited);

        Node lastNode = findEnd.closestNode;
        Connector lastConnector = getConnectorFromNodes(lastNode, lastNode.closestNode);
        String directionBasedOnNode = getDirectionBasedOnNode(lastConnector, lastNode.closestNode);
        float distance = lastConnector.weight;
        builder.append(directionTemplate
                .replace("{current}", lastNode.name)
                .replace("{directions}", directionBasedOnNode)
                .replace("{weight}", "" + lastConnector.weight)
                .replace("{destination}", findEnd.name));
        while (lastNode != null) {
            float addingDistance = 0;

            if (lastNode != null && lastNode.closestNode != null) {
                lastConnector = getConnectorFromNodes(lastNode, lastNode.closestNode);
                directionBasedOnNode = getDirectionBasedOnNode(lastConnector, lastNode.closestNode);
                addingDistance = lastConnector.weight;
                builder.insert(0, directionTemplate
                        .replace("{current}", lastNode.closestNode.name)
                        .replace("{directions}", directionBasedOnNode)
                        .replace("{weight}", "" + lastNode.closestWeight)
                        .replace("{destination}", lastNode.name)
                + " -->\n");
            }

            lastNode = lastNode.closestNode;

            if (lastNode != null) {
                distance += addingDistance;
                System.out.println("Adding? " + addingDistance + " | " + distance);
            }
        }
        if (distance > 0.0f) {
            builder.append(" | ~").append(distance).append("ft");
        } else {
            builder.append(" | Um dude, you're already here???");
        }

        return builder.toString();
    }

    public Connector getConnectorFromNodes(Node n1, Node n2) {
        for (Connector connector : n1.connectors) {
            Edge e1 = connector.e1;
            if (e1.n1 == n2 || e1.n2 == n2) {
                return connector;
            }
        }
        return null;
    }
    public String getDirectionBasedOnNode(Connector connector, Node node) {
        Edge e1 = connector.e1;
        Edge e2 = connector.e2;
        if (node == e1.n1) {
            return e1.directions;
        } else {
            return e2.directions;
        }
    }
}