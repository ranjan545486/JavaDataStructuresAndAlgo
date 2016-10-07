package tryingsomething.Graphs;



import java.util.*;

/**
 * Created by rmukherj on 9/30/16.
 */

interface Visitor {
    public void visit(Node node);
}

class Node {
    int data;
    List<Node> neighbors;

    Node(int data, List<Node> neighbors){
        this.data = data;
        this.neighbors = neighbors;
    }
    Node(){}
}

public class TopologicalSortVisitor implements Visitor{

    private List<Node> list;

    @Override
    public void visit(Node node) {
        list.add(node);

    }

    TopologicalSortVisitor(List<Node> list){
        this.list = list;
    }

    void topologicalSort(Node origin, List<Node> list){
        Visitor visit = new TopologicalSortVisitor(list);
        dfs(origin, visit);
        Collections.reverse(list);
    }

    private void dfs(Node origin, Visitor visit) {
        Set<Node> hs = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(origin);
        hs.add(origin);
        while(!stack.isEmpty()){
            Node current = stack.pop();
            for (Node neighbor:
                 current.neighbors) {
                if (!hs.contains(neighbor)) {
                    hs.add(neighbor);
                    stack.push(neighbor);
                }
            }

            visit.visit(current);
        }
    }
}
