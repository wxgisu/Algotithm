import java.util.*;

public class Graph {
    
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode("A");
        g.addNode("B");
        g.addNode("C");
        g.addNode("D");
        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.addEdge("D", "C");
        System.out.println(g.hasCycle());
    }
    
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();
        Node toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();
        adjacencyList.get(fromNode).add(toNode);
    }

    public void print() {
        for (Node source : adjacencyList.keySet()) {
            List<Node> targets = adjacencyList.get(source);
            if (!targets.isEmpty()) {
                System.out.println(source.toString() + " is connected to " + targets);
            }
        }
    }

    public void removeNode(String label) {
        Node node = nodes.get(label);
        if (node == null) 
            return;
        for (Node n : adjacencyList.keySet()) 
            adjacencyList.get(n).remove(node);
        adjacencyList.remove(node);
        nodes.remove(label);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null) 
            return;
        adjacencyList.get(fromNode).remove(toNode);
    }

    public void dfs(String root) {
        Node node = nodes.get(root);
        if (node == null) 
            return;
        // dfs(node, new HashSet<>());
        dfsIterative(node);
    }

    private void dfs(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);

        for (Node n : adjacencyList.get(root)) {
            if (!visited.contains(n))
                dfs(n, visited);
        }
    }

    private void dfsIterative(Node root) {
        Set<Node> visited = new HashSet<>();
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            if (visited.contains(cur)) continue;
            System.out.println(cur.toString());
            visited.add(cur);
            for (Node adj : adjacencyList.get(cur)) {
                if (!visited.contains(adj)) {
                    stack.push(adj);
                }
            }

        }
    }

    public void bfs(String root) {
        Node node = nodes.get(root);
        if (node == null) return;
        bfs(node);
    }

    private void bfs(Node root) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (visited.contains(cur)) continue;
            System.out.println(cur.toString());
            visited.add(cur);
            for (Node adj : adjacencyList.get(cur)) {
                if (!visited.contains(adj)) 
                    q.add(adj);
            }
        }
    }

    public List<String> topologicalSort(String root) {
        List<String> sortedNodes = new ArrayList<>();
        if (nodes.get(root) == null) return sortedNodes;
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for (Node node : nodes.values()) {
            // topologicalSort(node, visited, stack);
            topologicalSortIterative(node, visited, stack);
        }

        while(!stack.isEmpty()) 
            sortedNodes.add(stack.pop().label);

        return sortedNodes;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
        if (visited.contains(node))
            return;
        visited.add(node);
        for (Node adj : adjacencyList.get(node)) 
            topologicalSort(adj, visited, stack);
        stack.push(node);
    }

    private void topologicalSortIterative(Node node, Set<Node> visited, Stack<Node> storageStack) {
        if (visited.contains(node)) return;
        Stack<Node> traverseStack = new Stack<>();
        Stack<Node> retrackStack = new Stack<>();
        traverseStack.push(node);
        while(!traverseStack.isEmpty()) {
            Node cur = traverseStack.pop();
            if (visited.contains(cur)) continue;
            visited.add(cur);
            retrackStack.push(cur);
            for (Node adj : adjacencyList.get(cur)) {
                if (!visited.contains(adj)) 
                    traverseStack.push(adj);
            }
        }
        while(!retrackStack.isEmpty()) {
            storageStack.push(retrackStack.pop());
        }
    }

    public boolean hasCycle() {
        Set<Node> all = new HashSet<>();
        all.addAll(adjacencyList.keySet());
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        
        while(!all.isEmpty()) {
            Node n = all.iterator().next();
            if (hasCycle(n, all, visiting, visited))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node start, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        if (visited.contains(start)) return false;
        if (visiting.contains(start)) return true;
        all.remove(start);
        visiting.add(start);
        for(Node adj : adjacencyList.get(start)) {
            if (hasCycle(adj, all, visiting, visited))
                return true;
        }
        visiting.remove(start);
        visited.add(start);
        return false;
    }
    
 




} 



























































   // public boolean hasCycle() {
    //     Set<Node> all = new HashSet<>();
    //     all.addAll(nodes.values());
    //     Set<Node> visiting = new HashSet<>();
    //     Set<Node> visited = new HashSet<>();
    //     while (!all.isEmpty()) {
    //         Node cur = all.iterator().next();
    //         if (hasCycle(cur, all, visiting, visited)) 
    //             return true;
    //     }
    //     return false;
    // }

    // private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
    //     all.remove(node);
    //     visiting.add(node);
    //     for (Node adj : adjacencyList.get(node)) {
    //         if (visited.contains(adj)) continue;
    //         if (visiting.contains(adj)) return true;
    //         if (hasCycle(adj, all, visiting, visited)) return true;
    //     }
    //     visiting.remove(node);
    //     visited.add(node);
    //     return false;
    // }