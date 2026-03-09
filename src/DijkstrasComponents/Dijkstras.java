package DijkstrasComponents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstras {
    //creates an array list for the algorithm. (src =  source)
    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<int[]>> adj, int src) {
        int V = adj.size();

        //Prio queue that stores nodes(location) and edges(distance)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        //makes distance array and stores shortest distance from starting point
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

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
            int t = top[0];
            //the location being looked at
            int l = top[1];

            //if the time isn't the shortest then it continues
            if (t > distance[l])
                continue;

            //explores other times
            for (int[] p : adj.get(l)) {
                //adjacent nodes
                int o = p[0];
                //time to neighboring nodes
                int n = p[1];

                //if a shorter path is found to o (adjacent node) through l (location being looked at) then it updates
                //figuring out if going through l(location being looked at) is faster than previously known fastest route to o(adjacent node)
                if (distance[l] + n < distance[o]) {
                    //if l(location being looked at) is faster then a(adjacent node) then shortest time is updated
                    distance[o] = distance[l] + n;
                    //adds the node (o) to the prio queue
                    pq.offer(new int[]{distance [o], o});
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
    public static void addEdge(ArrayList<ArrayList<int[]>> adj, int l, int o, int n){
        //makes the graph bi-directional. saying if l(location being looked at) is connected to o(adjacent node) then o  connects to l
        //if you want to have a one way then remove second line
        adj.get(l).add(new int[]{o, n});
        adj.get(o).add(new int[]{l, n});
    }

}