public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        Tree t = new Tree();
        // System.out.println(t.getRoot());
        t.setRoot(10);
        // System.out.println(t.getRoot().data);
        // t.dfsPreOrder();
        t.bfs();
        t.add(20);
        t.bfs();
    }
}