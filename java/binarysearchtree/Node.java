class Node {

    public Node left; // public for the lazy
    public Node right;
    
    private int value;
    
    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void insertChild(int val) {
        if (value > val) {
            if (left == null) {
                left = new Node(val, null, null);
            } else {
                left.insertChild(val);
            }
        } else {
            if (right == null) {
                right = new Node(val, null, null);
            } else {
                right.insertChild(val);
            }
        }
    }
}
