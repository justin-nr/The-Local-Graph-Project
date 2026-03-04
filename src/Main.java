import JsonComponents.JsonGenerator;
import JsonComponents.JsonReader;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        new JsonGenerator("test.json");
        JsonReader root = JsonReader.arrayread("test.json");
        String d = root.getIndex(1).getName("name").asString();
        System.out.print(d);
    }
}