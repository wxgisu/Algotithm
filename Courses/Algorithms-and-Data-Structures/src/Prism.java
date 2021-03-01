import java.util.*;

class Prism {
    public static void main(String[] args) {
        Prism p = new Prism();
        String[][] edges = new String[5][3];
        edges[0] = new String[]{"A", "B", "3"};
        edges[1] = new String[]{"A", "C", "1"};
        edges[2] = new String[]{"B", "C", "4"};
        edges[3] = new String[]{"B", "D", "2"};
        edges[4] = new String[]{"C", "D", "5"};
        int res = p.minSpan(edges);
        System.out.println(res);  

    }

    class Node {
        String label;
        int dist;
        Node pre = null;
        List<Edge> edges = new ArrayList<>();
        public Node(String l, int d) {
            label = l;
            dist = d;
        }
    }
    class Edge {
        Node from;
        Node to;
        int weight;
        public Edge(Node f, Node t, int w) {
            from = f;
            to = t;
            weight = w;
        }
    }

    public int minSpan(String[][] edges) {
        if (edges == null || edges.length == 0) throw new IllegalArgumentException("There is no edge in the graph.");
        //build graph HashMap of String label to Node object
        Map<String, Node> graph = new HashMap<>();
        for (String[] edge : edges) {
            String from = edge[0];
            String to = edge[1];
            int weight = Integer.valueOf(edge[2]);

            graph.putIfAbsent(from, new Node(from, Integer.MAX_VALUE));
            graph.putIfAbsent(to, new Node(to, Integer.MAX_VALUE));

            Node fromNode = graph.get(from);
            Node toNode = graph.get(to);

            fromNode.edges.add(new Edge(fromNode, toNode, weight));
            toNode.edges.add(new Edge(toNode, fromNode, weight));
        }
        //run prism
        
        List<Edge> minTree = prism(graph);
        int res = 0;
        for (Edge e : minTree) {
            res += e.weight;
        }
        return res;
    }

    private List<Edge> prism(Map<String, Node> graph) {
        Node start = graph.values().iterator().next();
        Set<Node> visited = new HashSet<>();
        visited.add(start);
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> {
            return e1.weight - e2.weight;
        });
        pq.addAll(start.edges);
        List<Edge> minTree = new ArrayList<>();

        while(visited.size() != graph.size()) {
            Edge newEdge = pq.poll();
            Node nextNode = newEdge.to;
            if (visited.contains(nextNode)) continue;
            visited.add(nextNode);
            minTree.add(newEdge);
            for (Edge e : nextNode.edges) {
                if (!visited.contains(e.to)) {
                    pq.add(e);
                }
            }
            if(pq.size() == 0) 
                throw new IllegalArgumentException("There is no minimum spanning tree since graph is disconnected.");
        }

        return minTree;
    }

}