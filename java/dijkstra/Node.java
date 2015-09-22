import java.util.ArrayList;

public class Node implements Comparable<Node> {
    
    private String label;
    private ArrayList<Edge> adjacents = new ArrayList<Edge>();
    private double distance = Double.POSITIVE_INFINITY;
    private Node previous;

    public Node(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public ArrayList<Edge> getAdjacents() {
        return adjacents;
    }

    public double getDistance() {
        return distance;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void addEdge(Node target, double weight) {
        adjacents.add(new Edge(target, weight));
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public int compareTo(Node second) {
        return Double.compare(distance, second.getDistance());
    }
}
