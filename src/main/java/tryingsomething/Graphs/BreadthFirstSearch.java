package tryingsomething.Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by rmukherj on 9/25/16.
 */
class GraphNode{
    int val;
    GraphNode next;
    GraphNode[] neighbors;
    boolean visited;

    GraphNode(int x){
        val = x;
    }

    GraphNode(int x, GraphNode[] n){
        val = x;
        neighbors = n;
    }


}

public class BreadthFirstSearch {
    public static void main(String[] args) {
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(5);

        n1.neighbors = new GraphNode[]{n2,n3,n5};
        n2.neighbors = new GraphNode[]{n1,n4};
        n3.neighbors = new GraphNode[]{n1,n4,n5};
        n4.neighbors = new GraphNode[]{n2,n3,n5};
        n5.neighbors = new GraphNode[]{n1,n3,n4};

        breadthFirstSearch(n1, 5);
    }

    public static void breadthFirstSearch(GraphNode root, int x){
        if(root.val == x){
            System.out.println("find in root");
        }

        Queue queue = new LinkedList();
        root.visited = true;
        queue.add(root);

        while(queue.peek()!=null){
            GraphNode c = (GraphNode)queue.remove();
            for (GraphNode n:
                 c.neighbors) {
                if(!n.visited){
                    System.out.println(n + " ");
                    n.visited = true;
                    if(n.val == x){
                        System.out.println("Find " + n.val);
                        queue.add(n);
                    }
                }
            }
        }

    }

    public void Bfs(Node origin, Visitor visit){
        Set<Node> hs = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(origin);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            visit.visit(current);
            for(Node neighbor: current.neighbors){
                if(!hs.contains(neighbor)){
                    queue.add(neighbor);
                    hs.add(current);
                }
            }
        }
    }

}
