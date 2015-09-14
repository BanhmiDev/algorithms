import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class Graph {
    private int vertices;
    private int edges;
    private Map<Integer, List<Integer>> adj;
    
    public Graph(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        this.adj = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < vertices; i++) {
            adj.put(i, new LinkedList<Integer>());
        }
    }

    public void addUndirectedEdge(int v, int w) {
        List<Integer> vList = adj.get(v);
        //vList.add(w);
        List<Integer> wList = adj.get(w);
        wList.add(v);

        // Alternative:
        adj.get(v).add(w);
    }

    public void addDirectedEdge(int v, int w) {
        List<Integer> list = adj.get(v);
        list.add(w);
    }

    @Override
    public String toString() {
        String str = "";
        // Loop through vertices
        for (int i = 0; i < vertices; i++) {
            str += i + " adjacent to ";
            List<Integer> list = adj.get(i);
            
            if (list.size() == 0) {
                str += "-";
            } else {
                for (int j = 0; j < list.size(); j++) {
                    str += list.get(j) + ", ";
                }
            }
            
            str += "\n";
        }
        return str;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        System.out.println(g);
        g.addUndirectedEdge(0, 1);
        System.out.println(g);
    }
}
