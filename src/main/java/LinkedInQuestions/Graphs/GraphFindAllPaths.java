package LinkedInQuestions.Graphs;

import java.util.*;

/**
 * Created by rmukherj on 8/14/16.
 */
class GraphFindAllPaths<T> implements Iterable<T> {

    /* A map from nodes in the graph to sets of outgoing edges.  Each
    * set of edges is represented by a map from edges to doubles.
    */
    private final Map<T, Map<T, Double>> graph = new HashMap<T, Map<T, Double>>();

    /**
     *  Adds a new node to the graph. If the node already exists then its a
     *  no-op.
     *
     * @param node  Adds to a graph. If node is null then this is a no-op.
     * @return      true if node is added, false otherwise.
     */
    public boolean addNode(T node) {
        if (node == null) {
            throw new NullPointerException("The input node cannot be null.");
        }
        if (graph.containsKey(node)) return false;

        graph.put(node, new HashMap<T, Double>());
        return true;
    }


    public void addEdge (T source, T destination, double length) {
        if (source == null || destination == null) {
            throw new NullPointerException("Source and Destination, both should be non-null.");
        }
        if (!graph.containsKey(source) || !graph.containsKey(destination)) {
            throw new NoSuchElementException("Source and Destination, both should be part of graph");
        }
        /* A node would always be added so no point returning true or false */
        graph.get(source).put(destination, length);
    }

    public void removeEdge (T source, T destination) {
        if (source == null || destination == null) {
            throw new NullPointerException("Source and Destination, both should be non-null.");
        }
        if (!graph.containsKey(source) || !graph.containsKey(destination)) {
            throw new NoSuchElementException("Source and Destination, both should be part of graph");
        }
        graph.get(source).remove(destination);
    }

    public Map<T, Double> edgesFrom(T node) {
        if (node == null) {
            throw new NullPointerException("The node should not be null.");
        }
        Map<T, Double> edges = graph.get(node);
        if (edges == null) {
            throw new NoSuchElementException("Source node does not exist.");
        }
        return Collections.unmodifiableMap(edges);
    }



    @Override
    public Iterator<T> iterator() {
        return graph.keySet().iterator();
    }
}

class FindAllPaths<T>{
    private final GraphFindAllPaths<T> graph;

    public FindAllPaths(GraphFindAllPaths<T> graph) {
        if (graph == null) {
            throw new NullPointerException("The input graph cannot be null.");
        }
        this.graph = graph;
    }

    private void validate (T source, T destination) {

        if (source == null) {
            throw new NullPointerException("The source: " + source + " cannot be  null.");
        }
        if (destination == null) {
            throw new NullPointerException("The destination: " + destination + " cannot be  null.");
        }
        if (source.equals(destination)) {
            throw new IllegalArgumentException("The source and destination: " + source + " cannot be the same.");
        }
    }

    public List<List<T>> getAllPaths(T source, T destination) {
        validate(source, destination);

        List<List<T>> paths = new ArrayList<List<T>>();
        recursive(source, destination, paths, new LinkedHashSet<T>());
        return paths;
    }

    // so far this dude ignore's cycles.
    private void recursive (T current, T destination, List<List<T>> paths, LinkedHashSet<T> path) {
        path.add(current);

        if (current == destination) {
            paths.add(new ArrayList<T>(path));
            path.remove(current);
            return;
        }

        final Set<T> edges  = graph.edgesFrom(current).keySet();

        for (T t : edges) {
            if (!path.contains(t)) {
                recursive (t, destination, paths, path);
            }
        }

        path.remove(current);
    }

    public static void main(String[] args) {
        GraphFindAllPaths<String> graphFindAllPaths = new GraphFindAllPaths<String>();
        graphFindAllPaths.addNode("A");
        graphFindAllPaths.addNode("B");
        graphFindAllPaths.addNode("C");
        graphFindAllPaths.addNode("D");

        graphFindAllPaths.addEdge("A", "B", 10);
        graphFindAllPaths.addEdge("A", "C", 10);
        graphFindAllPaths.addEdge("B", "D", 10);
        graphFindAllPaths.addEdge("C", "D", 10);

        graphFindAllPaths.addEdge("B", "C", 10);
        graphFindAllPaths.addEdge("C", "B", 10);

        FindAllPaths<String> findAllPaths = new FindAllPaths<String>(graphFindAllPaths);
        List<List<String>> paths = new ArrayList<List<String>>();

        // ABD
        List<String> path1 = new ArrayList<String>();
        path1.add("A"); path1.add("B"); path1.add("D");

        // ABCD
        List<String> path2 = new ArrayList<String>();
        path2.add("A"); path2.add("B"); path2.add("C"); path2.add("D");

        //ACD
        List<String> path3 = new ArrayList<String>();
        path3.add("A"); path3.add("C"); path3.add("D");

        //ABCD
        List<String> path4 = new ArrayList<String>();
        path4.add("A"); path4.add("C"); path4.add("B"); path4.add("D");

        paths.add(path1);
        paths.add(path2);
        paths.add(path3);
        paths.add(path4);

        findAllPaths.getAllPaths("A", "D");
        System.out.println(findAllPaths.getAllPaths("A", "D"));

        //assertEquals(paths, findAllPaths.getAllPaths("A", "D"));
    }

}

