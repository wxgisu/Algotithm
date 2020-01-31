
public class BST {
    Node root = null;

    public void add(int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }
        //dfs pre order, find first empty node, add new node
        dfsPreAdd(root, val);
    }

    private Node dfsPreAdd(Node cur, int val) {
        //cur is null: insert
        if ( cur == null) {
            cur = new Node(val);
            return cur;
        }
        //cur is not null: decide left or right
        if (val <= cur.data) {
            cur.left = dfsPreAdd(cur.left, val);     
        } else {
            cur.right = dfsPreAdd(cur.right, val);
        }
        return cur;
    }

    public void delete(int val) {

    }

    public void dfsPre() {
        if (root == null) {
            System.out.print("tree is empty.");
            return;
        }
        dfsPre(root);
    }

    private void dfsPre(Node cur) {
        if (cur == null) {
            System.out.println("this is the end of a branch.");
            return;
        }
        System.out.println(cur.data);
        dfsPre(cur.left);
        dfsPre(cur.right);
        System.out.println("this is the end of subtree " + cur.data);
    }

    public void dfsIn() {

    }

    public void dfsPost() {

    }

    public void bfs() {

    }

    public void search(int val) {

    }
}