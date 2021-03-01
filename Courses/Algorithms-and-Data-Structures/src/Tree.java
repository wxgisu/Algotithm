import java.util.*;

public class Tree {
    Node root = null;

    public void setRoot(int data) {
        root = new Node(data);
    }

    public Node getRoot() {
        return root;
    }

    public void dfsPreOrder() {
        dfsPreOrder(root);
    }

    private void dfsPreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data);
        dfsPreOrder(root.left);
        dfsPreOrder(root.right);
    }

    public void bfs() {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node cur = q.poll();
            System.out.println(cur.data);
            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }
    }

    public Boolean contains(int val) {

        return false;
    }

    public void add(int val) {
        if (root == null) {
            setRoot(val);
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur = q.poll();
            if (cur.left == null) {
                cur.left = new Node(val);
                return;
            } else {
                q.add(cur.left);
            }
            if (cur.right == null) {
                cur.right = new Node(val);
                return;
            } else {
                q.add(cur.right);
            }
        }
    }
}

