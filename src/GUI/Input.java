package GUI;

import java.util.Map;
import java.util.Scanner;
//hi
public class Input {
    Scanner scan;

    public Input() {
        scan = new Scanner(System.in);
    }

    public String returnText(String question) {
        System.out.println(question);
        String data = scan.nextLine();
        if (data.equals(question)) {
            data = scan.nextLine();
        }
        return data;
    }
    public  Object returnNode(String question, Map map) {
        System.out.println(question + " - " + map);
        String data = scan.nextLine();
        if (data.equals(question)) {
            data = scan.nextLine();
        }

        if (!map.containsKey(data)) {
            while (!map.containsKey(data)) {
                System.out.println("Must be a valid search." + map);
                data = scan.nextLine();
            }
        }

        return map.get(data);
    }
}
