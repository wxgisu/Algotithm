import java.util.*;
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
        // bt.dfsPre();
        bt.dfsPostUsingStack();

        //Arrays.sort
        double[] arr = {0.4, 0.1, 0.5};
        Integer[] index = {0, 1, 2};
        Arrays.sort(index, (i1, i2) -> {
            if (arr[i1]>arr[i2]) return -1;
            return 1;
        });

        for (int i=0; i<index.length; i++) {
            System.out.println(index[i]);
        }

        //array slice
        int[] arr1 = {1,2,3,4,5};
        int[] arrSlice = Arrays.copyOfRange(arr1, 0, 3); // {1, 2, 3}
        for (int i=0; i<arrSlice.length; i++) {
            System.out.println(arrSlice[i]);
        }
        
        //list slice
        List<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        System.out.println(al);
        System.out.println(al.subList(0,2));



    }
}