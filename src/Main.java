import DijkstrasComponents.Dijkstras;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;

import static javafx.application.Application.launch;

public class Main extends Application {

    /*=====================
       Java FX run script
     =======================*/

    //find the file of the GUI window
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI.fxml"));

    //this small script start the GUI application
    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

    }

    public static void main(String[] args) {

        // launch method for the GUI
        launch();



        int V = 5;
        int src = 0;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        //l = location being looked at<start node>
        //o = adjacent node
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
