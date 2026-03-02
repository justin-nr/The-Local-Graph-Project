package JsonComponents;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.FormattingStyle;
import com.google.gson.GsonBuilder;

public class JsonGenerator {

    //the builder is what gets the formatting
    Gson gson = new GsonBuilder()
            .setFormattingStyle(FormattingStyle.PRETTY) //makes good formatting
            .create(); //creates GSON instance


    public JsonGenerator(String filename) {
        //get the JSON writer going
        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(filename))) {

            String line = gson.toJson(null); //null for now
            //makes it write in the data it has
            bWriter.write(line);

            bWriter.newLine();

        } catch (IOException e) {
            System.out.print("issue saving file");
            e.printStackTrace();
        }
    }

      /*
    =================================
    Retriever and Sender Class.
    =================================
     */




}
