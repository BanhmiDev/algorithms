import java.util.Collections;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

    private static ArrayList<Node> nodes = new ArrayList<Node>();

    public Dijkstra() {
    }

    /**
    * Calculate the shortest path
    */
    public static void run(Node start) {
        // Initialization
        start.setDistance(0.0);
        PriorityQueue<Node> nodeQueue = new PriorityQueue<Node>();
        nodeQueue.add(start);

        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.poll();

            // Loop over adjacent edges
            for (Edge edge : node.getAdjacents()) {
                // Check node weights
                Node adj = edge.getDestination();
                double distToNode = node.getDistance() + edge.getWeight();

                // Update adjacent value if min and add next node to queue
                if (distToNode < adj.getDistance()) {
                    nodeQueue.remove(adj);
                    adj.setDistance(distToNode);
                    adj.setPrevious(node);
                    nodeQueue.add(adj);
                }
            }
        }
    }

    public static List<Node> getShortestPathTo(Node target) {
        List<Node> path = new ArrayList<Node>();
        // Loop through saved previous nodes
        for (Node node = target; node != null; node = node.getPrevious()) {
            path.add(node);
        }
        Collections.reverse(path);
        return path;
    }

    public static void printResult(Node start, ArrayList<Node> nodes) {
        System.out.println("Starting node: " + start);

        for (Node n : nodes) {
            if (n.getDistance() == Double.POSITIVE_INFINITY) {
                // Not connected to starting node
                System.out.println("\nNode " + n + " not connected to " + start);
            } else {
                // Header
                System.out.println("\nTo node " + n + "\n---");

                // Print out shortest path
                System.out.println("Shortest path:");
                List<Node> path = getShortestPathTo(n);
                for (int i = 0; i < path.size(); i++) {
                    if (i == path.size()-1) { // End of path reached
                        System.out.println(path.get(i) + ";\n");
                    } else {
                        System.out.print(path.get(i) + " -> ");
                    }
                }

                // Print out distance
                System.out.println("Distance: " + n.getDistance());
            }
        }
    }
    
    public static void main(String[] args) {
        Node node1 = new Node("A"); // Starting node in this case
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        
        node1.addEdge(node2, 4.0);
        node1.addEdge(node3, 5.0);
        node2.addEdge(node4, 2.0);
        
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        
        // Dijkstra algorithm
        run(node1);

        // Print out result after algorithm execution
        printResult(node1, nodes);
    }
}
