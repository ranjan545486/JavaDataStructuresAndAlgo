package LinkedInQuestions.Graphs;

/**
 * Created by rmukherj on 8/23/16.
 */
import java.util.*;

class Graph {

    /**
     * Stores a list of nodes in this Graph.
     */
    private ArrayList<String> nodes = new ArrayList<String>();

    /**
     * Creates a mapping from a node to its neighbours.
     */
    private Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

    /**
     * Constructs a graph.
     */
    public Graph() {
    }

    /**
     * Adds an edge between two nodes.
     *
     * @param source      the source node.
     * @param destination the destination node, to be connected from source. Requires:
     *                    source != null, destination != null.
     */
    public void addEdge(String source, String destination) {
        // Adds a new path.
        if (!map.containsKey(source)) {
            /*
            Stores a list of neighbours for a node.
            */
            ArrayList<String> neighbours = new ArrayList<String>();
            neighbours.add(destination);
            map.put(source, neighbours);
        } else {
            // Updates a path.
            ArrayList<String> oldList = map.get(source);

            int index = 0;
            while ((index != oldList.size()) && (!oldList.get(index).equals(destination))) {
                index++;
            }
            // If the destination is not already in the path, then
            // add it to the path.
            if (index == oldList.size()) {
                oldList.add(destination);
                map.put(source, oldList);
            }
        }
        storeNodes(source, destination);
    }

    /**
     * Stores the nodes in this Graph.
     */
    private void storeNodes(String source, String destination) {
        if (!source.equals(destination)) {
            if (!nodes.contains(destination)) {
                nodes.add(destination);
            }
        }
        if (!nodes.contains(source)) {
            nodes.add(source);
        }
    }

    /**
     * Returns the neighboursList for this node.
     *
     * @param node the node where its neighbours will be searched for. Requires:
     *             node must be present in this Graph and not null.
     * @return the neighboursList for this node.
     */
    public ArrayList<String> getNeighbours(String node) {
        ArrayList<String> neighboursList;
        Set<String> keys = map.keySet();
        for (String key : keys) {
            if (key.equals(node)) {
                neighboursList = map.get(key);
                return new ArrayList<String>(neighboursList);
            }
        }
        return new ArrayList<String>();
    }

    /**
     * Checks if the node is in this Graph.
     *
     * @return true if the node is in this Graph.
     */
    public boolean memberOf(String node) {
        return nodes.contains(node);
    }

    /**
     * Returns a string representation of this Graph, in
     * the form: node => [node 1, node 2, ... , node n], which means
     * that there is a path from node to node 1, node 2, ... , node n.
     *
     * @return a string representation of this Graph.
     */
    public String toString() {
        int counter = 0;
        String string = "";
        Set<String> keys = map.keySet();
        for (String key : keys) {
            if (counter == 0) {
                string = string + key + "--->" + map.get(key).toString();
            } else {
                string = string + "\n" + key + "--->" + map.get(key).toString();
            }
            counter++;
        }
        return string;
    }
}



public class ShortestPathBFS {
    /**
     * The shortest path between two nodes in a graph.
     */
    private static ArrayList<String> shortestPath = new ArrayList<String>();

    /**
     * Finds the shortest path between two nodes (source and destination) in a graph.
     *
     * @param graph       The graph to be searched for the shortest path.
     * @param source      The source node of the graph specified by user.
     * @param destination The destination node of the graph specified by user.
     *
     * @return the shortest path stored as a list of nodes.
     * or null if a path is not found.
     * Requires: source != null, destination != null and must have a name (e.g.
     * cannot be an empty string).
     */
    public static ArrayList<String> breadthFirstSearch(Graph graph, String source,
                                                       String destination) {
        shortestPath.clear();

        // A list that stores the path.
        ArrayList<String> path = new ArrayList<String>();

        // If the source is the same as destination, I'm done.
        if (source.equals(destination) && graph.memberOf(source)) {
            path.add(source);
            return path;
        }

        // A queue to store the visited nodes.
        ArrayDeque<String> queue = new ArrayDeque<String>();

        // A queue to store the visited nodes.
        ArrayDeque<String> visited = new ArrayDeque<String>();

        queue.offer(source);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            visited.offer(vertex);

            ArrayList<String> neighboursList = graph.getNeighbours(vertex);
            int index = 0;
            int neighboursSize = neighboursList.size();
            while (index != neighboursSize) {
                String neighbour = neighboursList.get(index);

                path.add(neighbour);
                path.add(vertex);

                if (neighbour.equals(destination)) {
                    return processPath(source, destination, path);
                } else {
                    if (!visited.contains(neighbour)) {
                        queue.offer(neighbour);
                    }
                }
                index++;
            }
        }
        return null;
    }

    /**
     * Adds the nodes involved in the shortest path.
     *
     * @param src         The source node.
     * @param destination The destination node.
     * @param path        The path that has nodes and their neighbours.
     * @return The shortest path.
     */
    private static ArrayList<String> processPath(String src, String destination,
                                                 ArrayList<String> path) {

        // Finds out where the destination node directly comes from.
        int index = path.indexOf(destination);
        String source = path.get(index + 1);

        // Adds the destination node to the shortestPath.
        shortestPath.add(0, destination);

        if (source.equals(src)) {
            // The original source node is found.
            shortestPath.add(0, src);
            return shortestPath;
        } else {
            // We find where the source node of the destination node
            // comes from.
            // We then set the source node to be the destination node.
            return processPath(src, source, path);
        }
    }

}
