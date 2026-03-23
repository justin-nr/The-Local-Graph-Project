import DijkstrasComponents.Dijkstras;
import DijkstrasComponents.Graph;
import JsonComponents.JsonReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends Application {
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


    public static void main(String[] args) throws FileNotFoundException {

          /*=====================
       Java FX run script
     =======================*/

        launch();


        Graph graph = new Graph("JSON_Data.JSON");
//        System.out.println(graph);

        Dijkstras dijkstras = new Dijkstras(graph, JsonReader.read("JSON_Data.JSON").getString("directionTemplate"));

        String data = dijkstras.calculate("Student Housing", "Fire Station");
        System.out.println(data);
    }
}
