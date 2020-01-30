public class Tree {
    public void preOrderTraversal(Node root) {
        if (!root == null) {
            return;
        }
        System.out.prinln(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}

private class Node {
    int data;
    Node left = null;
    Node right = null;
}