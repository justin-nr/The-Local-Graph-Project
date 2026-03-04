package DijkstrasComponents;

public class Node {

    String name;
    String description;
    Node start;
    Node end;

    private int x;
    private int y;
    Node(String name, String description) {
        this.name = name;
        this.description = description;
        start = null;
        end = null;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int[] getPosition() {
        return new int[]{x, y};
    }
}
