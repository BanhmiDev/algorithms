public class Graph {
    private int vertices;
    private int edges;
    private boolean[][] matrix;

    public Graph(int vertices) {
        this(vertices, 0);
    }

    public Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        this.matrix = new boolean[vertices][vertices];
    }

    public int getVertices() { return vertices; }
    public int getEdges() { return edges; }
    
    public void addUndirectedEdge(int v, int w) {
        if (!matrix[v][w]) edges++;
        matrix[v][w] = true;
        matrix[w][v] = true;
    }

    public void addDirectedEdge(int v, int w) {
        if (!matrix[v][w]) edges++;
        matrix[v][w] = true;
    }
    
    public boolean contains(int v, int w) {
        return matrix[v][w];
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < vertices; i++) {
            str += "\n";
            for (int j = 0; j < vertices; j++) {
                // Translate boolean to integer for better reading
                int value = (matrix[i][j]) ? 1 : 0;
                str += "[" + value + "]";
            }
        }
        return str;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        System.out.println(g);
        g.addDirectedEdge(0, 2);
        System.out.println(g);
    }
}
