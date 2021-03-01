import java.util.*;

class TestNode {
    String label;
    int val;
    public TestNode(String s, int v){
        label = s;
        val = v;
    }
}

class TestPriorityQueue {

    public static void main(String[] args) {
        TestPriorityQueue t = new TestPriorityQueue();
        TestNode A = new TestNode("A", 3);
        TestNode B = new TestNode("B", 2);
        TestNode C = new TestNode("C", 4);
        t.enQueue(A);
        t.enQueue(B);
        t.enQueue(C);
        A.val = 1;
        t.showQueue();

    }
    
    PriorityQueue<TestNode> pq = new PriorityQueue<>((n1, n2) -> {
        return n1.val - n2.val;
    });

    public void enQueue(TestNode n) {
        pq.add(n);
    }

    public void showQueue() {
        while(!pq.isEmpty()) {
            System.out.println(pq.poll().label);
        }
    }

    
}