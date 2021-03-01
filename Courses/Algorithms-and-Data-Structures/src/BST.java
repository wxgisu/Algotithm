import java.util.*;

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
        if (root == null) {
            System.out.print("tree is empty.");
            return;
        }
        dfsIn(root);
    }

    private void dfsIn(Node cur) {
        if (cur == null) {
            System.out.println("this is the end of a branch");
            return;
        }

        dfsIn(cur.left);
        System.out.println(cur.data);
        dfsIn(cur.right);
        System.out.println("this is the end of subtree " + cur.data);
    }

    public void dfsPost() {
        if (root == null) {
            System.out.print("tree is empty.");
            return;
        }
        dfsPost(root);
    }

    private void dfsPost(Node cur) {
        if (cur == null) {
            System.out.println("this is the end of a branch");
            return;
        }

        dfsPost(cur.left);
        dfsPost(cur.right);
        System.out.println(cur.data);
        System.out.println("this is the end of subtree " + cur.data);
    }

    public void dfsPreUsingStack() {
        if (root == null) {
            System.out.print("tree is empty.");
            return;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);

        while (! stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.data);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
    }

    public void dfsInUsingStack() {
        if (root == null) {
            System.out.print("tree is empty.");
            return;
        }
        LinkedList<Node> stack = new LinkedList<>();
        Node cur = root;

        while(! stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.data);
            cur = cur.right;
        }
    }

    public void dfsPostUsingStack() {
        if (root == null) {
            System.out.print("tree is empty.");
            return;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        LinkedList<Node> res = new LinkedList<>();
        
        while(! stack.isEmpty()) {
            Node cur = stack.pop();
            res.push(cur);
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }

        while(! res.isEmpty()) {
            System.out.println(res.pop().data);
        }
    }

    public void bfs() {

    }

    public void search(int val) {

    }
}