package tryingsomething.Graphs;

import java.util.*;

/**
 * Created by rmukherj on 10/1/16.
 */
public class DetectCycleVisitor implements Visitor {

    private Set<Node> visited;
    boolean cycleDetected;

    public static void main(String[] args) {
        List<Node> ard = new ArrayList<>();
        ard.add(new Node(4,new ArrayList<Node>()));
        Node n1 = new Node(4,ard);
        n1.data = 4;
        //Node n2 = new Node(4,ard);
       // Node n3 = new Node(6,new ArrayList<>());
       // Node n4 = new Node(4,ard);
        //n2.data = 5;
        //n3.data = 6;
        //n4.data = 4;

        List<Node> arr = new ArrayList<>();
        arr.add(n1);
       // arr.add(n2);
       // arr.add(n3);
       // arr.add(n4);
        Node node = new Node(4, ard);
        DetectCycleVisitor dsc = new DetectCycleVisitor();
        boolean tr = dsc.detectCycle(node);
        System.out.println(tr);
    }

    DetectCycleVisitor(){}

    DetectCycleVisitor(Boolean cycleDetected, Set<Node> visited){
        this.visited = visited;
        this.cycleDetected = cycleDetected;
    }

    public void visit(Node node){
        visited.add(node);
        for(Node neighbor : node.neighbors){
            if(visited.contains(neighbor)){
                //cycleDetected = true;
                detectCycle(neighbor);
            }
        }
    }

    public boolean detectCycle(Node neighbor) {
        Set<Node> visited = new HashSet<>();
        Visitor visit = new DetectCycleVisitor(false, visited);
        dfs(neighbor,visit);
        return((DetectCycleVisitor)visit).cycleDetected;

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
