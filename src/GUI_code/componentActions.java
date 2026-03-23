package GUI_code;
import DijkstrasComponents.Dijkstras;
import DijkstrasComponents.Graph;
import JsonComponents.JsonReader;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class componentActions {
    //variables
    private double mouseYOffset;
    private double mouseXOffset;


    //find the components in the FXML file (choiceBoxes)
    @FXML
    private ComboBox<String> choiceBox_1;

    @FXML
    private ComboBox<String> choiceBox_2;

    //buttons
    @FXML
    private Button button_1;

    @FXML
    private Button close_button;

    //text areas
    @FXML
    private TextArea textArea_1;

    //HBox
    @FXML
    private HBox dragBar;

    Dijkstras dijkstras;

    //initialize is hard coded for some reason
    //it will run on startup pretty much
    @FXML
    public void initialize() throws FileNotFoundException {
        //runs any scripts that need to be run on application startup
        fillChoiceBox();
        textArea_1.setEditable(false);

        dijkstras = new Dijkstras(new Graph("JSON_Data.JSON"), JsonReader.read("JSON_Data.JSON").getString("directionTemplate"));

        /*
        =====================
        Window Dragging Code
        =====================
         */

        //on mouse click
        dragBar.setOnMousePressed(mouseEvent -> {
            mouseXOffset = mouseEvent.getSceneX();
            mouseYOffset = mouseEvent.getSceneY();
        });

        //initiate dragging
        dragBar.setOnMouseDragged(mouseEvent -> {
            Stage stage = (Stage) dragBar.getScene().getWindow();

            stage.setX(mouseEvent.getScreenX() - mouseXOffset);
            stage.setY(mouseEvent.getScreenY() - mouseYOffset);
        });

    }

    //make the array
    ArrayList<String> nodeNames = new ArrayList<>();

    //code to fill the choice boxes with choices
    @FXML
    public void fillChoiceBox() throws FileNotFoundException {


        //count the amount of stuff in the array
        int indexCount = 38;

        //read the file
        JsonReader reader = JsonReader.read("JSON_Data.JSON");

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

        //get the algorithm


        //get the user chosen values in the choice boxes
        String startLocation = choiceBox_1.getValue();
        String endLocation = choiceBox_2.getValue();

        //check if null
        if (startLocation == null || endLocation == null) {
            //error handling
            textArea_1.appendText("missing locations\n");
            return;
        }

        textArea_1.appendText("found location\n");

        //get and output the text into application console
        String data = dijkstras.calculate(startLocation, endLocation);
        textArea_1.setText(String.valueOf(data));

    }

    //close an application script
    @FXML
    public void closeApplication(ActionEvent event) {
        //close the application
        javafx.application.Platform.exit();
    }
}