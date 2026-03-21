import DijkstrasComponents.Dijkstras;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

import static javafx.application.Application.launch;

public class Main extends Application {

    /*=====================
       Java FX run script
     =======================*/

    //find the file of the GUI window
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI.fxml"));

    @Override
    public void start(Stage stage) throws IOException {
        Label label = new Label("Columbia Sign GUI");
        Scene scene = new Scene(fxmlLoader.load(), 600, 800);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        // launch method
        launch();


        int V = 5;
        int src = 0;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        //l = location being looked at<start node>
        //a = adjacent node
        //n = time to neighboring node<weight>
        //example for first line: there is a path from 0 -> 1 and the cost is 4
        Dijkstras.addEdge (adj, 0, 1, 4);
        Dijkstras.addEdge (adj, 0, 2, 8);
        Dijkstras.addEdge (adj, 1, 4, 6);
        Dijkstras.addEdge (adj, 1, 2, 3);
        Dijkstras.addEdge (adj, 2, 3, 2);
        Dijkstras.addEdge (adj, 3, 4, 10);

        //spits out the total time from start node to end node
        ArrayList<Integer> result = Dijkstras.dijkstra(adj,src);
        for (int d: result)
            System.out.println(d+ " ");
        System.out.println();
        }

    }
