import java.util.*;



class Dijkstra {
    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();
        String[][] edges = new String[7][3];
        edges[0] = new String[]{"A", "B", "3"};
        edges[1] = new String[]{"A", "D", "2"};
        edges[2] = new String[]{"A", "C", "4"};
        edges[3] = new String[]{"B", "D", "6"};
        edges[4] = new String[]{"B", "E", "1"};
        edges[5] = new String[]{"C", "D", "1"};
        edges[6] = new String[]{"D", "E", "5"};
        int sd = d.shortestDistance(edges, "A", "E");
        List<String> sp = d.shortestPath(edges, "A", "C");
        System.out.println(sd);
        System.out.println(sp);
        System.out.println(d.hasCycle(edges));


        Dijkstra d2 = new Dijkstra();
        String[][] edges2 = new String[4][3];
        edges2[0] = new String[]{"A", "B", "2"};
        edges2[1] = new String[]{"B", "C", "2"};
        edges2[2] = new String[]{"B", "D", "2"};
        edges2[3] = new String[]{"D", "C", "2"};
        System.out.println(d2.hasCycle(edges2));

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

    public int shortestDistance(String[][] edges, String source, String target) {
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
        //run Dijkstra algorithm
        Node sourceNode = graph.get(source);
        sourceNode.dist = 0;
        Node targetNode = graph.get(target);
        int res = dijkstra(graph, sourceNode, targetNode);
        return res;
    }

    private int dijkstra(Map<String, Node> graph, Node source, Node target) {
        int res;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            return n1.dist - n2.dist;
        });
        Set<Node> visited = new HashSet<>();
        pq.add(source);
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            visited.add(cur);
            //update distance of source to cur node's adjacnets via cur node
            for (Edge e : cur.edges) {
                Node adj = e.to;
                if (visited.contains(adj)) continue;
                int newDist = cur.dist + e.weight;
                if (newDist < adj.dist) {
                    adj.dist = newDist;
                    adj.pre = cur;
                }
                pq.add(adj);
            }
        }
        res = target.dist;
        return res;        
    }

    public List<String> shortestPath(String[][] edges, String source, String target) {
        //build graph
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
        Node sourceNode = graph.get(source);
        sourceNode.dist = 0;
        Node targetNode = graph.get(target);
        //Dijkstra
        dijkstra(graph, sourceNode, targetNode);
        //build path
        List<String> res = new ArrayList<>();
        LinkedList<String> stack = new LinkedList<>();
        Node tracker = targetNode;
        while(tracker != null) {
            stack.push(tracker.label);
            tracker = tracker.pre;
        }
        while(!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public boolean hasCycle(String[][] edges) {
        //build graph
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

        Set<Node> visited = new HashSet<>();
        Iterator<Node> nodes = graph.values().iterator();
        while(nodes.hasNext()) {
            Node cur = nodes.next();
            if (visited.contains(cur)) continue;
            if(hasCycle(graph, cur, null, visited))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Map<String, Node> graph, Node cur, Node parent, Set<Node> visited) {   
        visited.add(cur);
        for (Edge edge : cur.edges) {
            Node adj = edge.to;
            if (adj == parent) continue;
            if (visited.contains(adj)) return true;
            if (hasCycle(graph, adj, cur, visited)) return true;
        }
        return false;
    }



}   
    