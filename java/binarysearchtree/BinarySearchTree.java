class BinarySearchTree {

    private Node root = null;

    public BinarySearchTree(Node root) {
        this.root = root;
    }
    
    public void getInorder(Node node) {
        if (node != null) {
            getInorder(node.left);
            System.out.println(node.getValue());
            getInorder(node.right);
        }
    }

    public void getPreorder(Node node) {
        if (node != null) {
            System.out.println(node.getValue());
            getPreorder(node.left);
            getPreorder(node.right);
        }        
    }

    public void getPostorder(Node node) {
        if (node != null) {
            getPostorder(node.left);
            getPostorder(node.right);
            System.out.println(node.getValue());
        }        
    }
    
    public void insert(int value) {
        if (root == null) {
            root = new Node(value, null, null);
        } else {
            root.insertChild(value);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(null);
        bst.insert(5);
        bst.insert(1);
        bst.insert(7);
        bst.getInorder(bst.root);
    }
}
