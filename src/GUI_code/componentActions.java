package GUI_code;
import DijkstrasComponents.Dijkstras;
import JsonComponents.JsonReader;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.io.FileNotFoundException;
import java.util.ArrayList;
public class componentActions {

    //find the components in the FXML file (choiceBoxes)
    @FXML
    private ChoiceBox<String> choiceBox_1;

    @FXML
    private ChoiceBox<String> choiceBox_2;

    //buttons
    @FXML
    private Button button_1;

    //text areas
    @FXML
    private TextArea textArea_1;

    //initialize is hard coded for some reason
    //it will run on startup pretty much
    @FXML
    public void initialize() throws FileNotFoundException {
        //runs any scripts that need to be run on application startup
        fillChoiceBox();
        textArea_1.setEditable(false);

    }

    //make the array
    ArrayList<String> nodeNames = new ArrayList<>();

    //code to fill the choice boxes with choices
    @FXML
    public void fillChoiceBox() throws FileNotFoundException {
        //count the amount of stuff in the array
        int indexCount = 19;

        //read the file
        JsonReader reader = JsonReader.read("Nodes.JSON");

        //loop through all index's to get all information
        for (int i = 0; i < indexCount; i++) {
            //read everything in the array
            String name = reader.getName("nodes").getIndex(i).raw().getAsString();

            //put information into a new array
            nodeNames.add(name);
        }

        //load information from the array into the two choice boxes
        choiceBox_1.getItems().addAll(nodeNames);
        choiceBox_2.getItems().addAll(nodeNames);

    }

    //code for the button
    @FXML
    public void onClick(ActionEvent event) {

        //get the user chosen values in the choice boxes
        String startLocation = choiceBox_1.getValue();
        String endLocation = choiceBox_2.getValue();

        //check if null
        if (startLocation == null && endLocation == null) {
            //error handling
            textArea_1.appendText("missing locations\n");
            return;
        }

        //convert the values into the index
        int indexStartLocation = nodeNames.indexOf(startLocation);
        int indexEndLocation = nodeNames.indexOf(endLocation);

        //plug the index's into the algorithm
        ArrayList<Integer> list = Dijkstras.dijkstra(null, indexStartLocation); //null for placeholder

        int result = list.get(indexEndLocation);
        textArea_1.appendText(String.valueOf(result));

        textArea_1.appendText("found location\n");

    }
}
