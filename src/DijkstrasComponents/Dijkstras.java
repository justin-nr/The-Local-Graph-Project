package DijkstrasComponents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstras {
    //creates an array list for the algorithm. (src =  source)
    static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Edge>> adj, int src) {
        int V = adj.size();

        //Prio queue that stores nodes(location) and edges(distance)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        //makes distance array and stores shortest distance from starting point
        int[] distance = new int[V];
        //if it spits out the max_value, that means there is no path to the node
        Arrays.fill(distance, Integer.MAX_VALUE);

        //creates start point
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        //sets distance from source to itself as 0 in the queue
        distance[src] = 0;
        //source node with a distance of 0
        //will always give you the node with the shortest distance
        pq.offer(new int[]{0, src});

        //process the priority queue until queue is empty
        while (!pq.isEmpty()) {
            //removes the closest known node
            int[] top = pq.poll();
            //shortest known time to reach the location
            int currentDistance = top[0];
            //the location being looked at
            int node = top[1];

            //if the time isn't the shortest then it continues
            if (currentDistance > distance[node])
                continue;

            //explores other times
            for (Edge edge : adj.get(node)) {
                //adjacent nodes
                int neighbor = edge.destination;
                //time to neighboring nodes
                int weight = edge.weight;

                //if a shorter path is found to o (adjacent node) through l (location being looked at) then it updates
                //figuring out if going through l(location being looked at) is faster than previously known fastest route to o(adjacent node)
                if (distance[node] + weight < distance[neighbor]) {
                    //if l(location being looked at) is faster then a(adjacent node) then shortest time is updated
                    distance[neighbor] = distance[node] + weight;
                    parent[neighbor] = node;
                    //adds the node (o) to the prio queue
                    pq.offer(new int[]{distance [neighbor], neighbor});
                }
            }
        }
        //puts distance into an arraylist and spits it out 🤪
        ArrayList<Integer> result = new ArrayList<>();
        for (int d : distance)
            result.add(d);
        //returns shortest distance from the source
        return result;
    }

    //add edge method
//    public static void addEdge(ArrayList<ArrayList<int[]>> adj, int l, int a, int n){
//        //makes the graph bi-directional. saying if l(location being looked at) is connected to o(adjacent node) then o  connects to l
//        //if you want to have a one way then remove second line
//        adj.get(l).add(new int[]{a, n});
//        adj.get(a).add(new int[]{l, n});
//    }

    //add edge method using json information
    public static void addEdge(ArrayList<ArrayList<Edge>> adj,
                               int from,
                               int to,
                               int weight,
                               String description) {
        //makes the graph bi-directional. saying if l(location being looked at) is connected to o(adjacent node) then o  connects to l
        //if you want to have a one way then remove second line
        adj.get(from).add(new Edge(to, weight, description));
        adj.get(to).add(new Edge(from, weight, description));
    }

}
