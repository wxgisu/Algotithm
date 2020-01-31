public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        /* Tree
        Tree t = new Tree();
        // System.out.println(t.getRoot());
        t.setRoot(10);
        // System.out.println(t.getRoot().data);
        // t.dfsPreOrder();
        t.bfs();
        t.add(20);
        t.bfs();
        */
        BST bt = new BST();
        bt.add(100);
        bt.add(80);
        bt.add(60);
        bt.add(90);
        bt.add(150);
        bt.add(140);
        bt.add(200);
        bt.dfsPre();

    }
}