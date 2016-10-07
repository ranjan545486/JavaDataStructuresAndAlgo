package tryingsomething.Graphs;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by rmukherj on 9/25/16.
 * //This is a sample program to find the minimum wire length between two component in a electrical circuits
 */

class NodeSP{
    public int label; // this node's label (parent node in path tree)
    public int weight; // weight of edge to this node (distance to start)


    public NodeSP(int v, int w){
        label = v;
        weight = w;
    }
}
public class ShortestPath {

    public static Scanner in;
    public static int n, m; //n = vertices, m = edges
    public static LinkedList[] graph;
    public static int start, end;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        System.out.println("Enter no of components and wires in a circuit");
        n = in.nextInt();
        m = in.nextInt();

        //initialise adjacency list structure to empty lists:
        graph = new LinkedList[n];
        for (int i = 0; i < n ; i++) {
            graph[i] = new LinkedList();
        }

        //add each edge twice once for each endpoint
        for (int i = 0; i < m; i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            int w = in.nextInt();
            graph[v1].add(new NodeSP(v2,w));
            graph[v2].add(new NodeSP(v1,w));
        }

        //input starting and ending vertices:
        System.out.println("Enter the start and end for which length is to be minimized");

        start = in.nextInt();
        end = in.nextInt();

        shortest();


    }

    public static void shortest(){
        boolean[] done = new boolean[n];
        NodeSP[] table = new NodeSP[n];
        for (int count = 0; count < n; count++) {
            int min = Integer.MAX_VALUE;
            int minNode = -1;
            for (int i = 0;i<n;i++){
                if(!done[i] && table[i].weight<min){
                    min = table[i].weight;
                    minNode = i;
                }


            }

            done[minNode] = true;

            ListIterator iter = graph[minNode].listIterator();
            while(iter.hasNext()){
                NodeSP nd = (NodeSP)iter.next();
                int v = nd.label;
                int w = nd.weight;
                if (!done[v] && table[minNode].weight + w < table[v].weight)
                {
                    table[v].weight = table[minNode].weight + w;
                    table[v].label = minNode;
                }
            }
        }

        for (int i = 0; i < n; i++)
        {
            if (table[i].weight < Integer.MAX_VALUE)
            {
                System.out.print("Wire from " + i + " to " + start
                        + " with length " + table[i].weight + ": ");
                int next = table[i].label;
                while (next >= 0)
                {
                    System.out.print(next + " ");
                    next = table[next].label;
                }
                System.out.println();
            } else
                System.out.println("No wire from " + i + " to " + start);
        }
    }

    public static void displayGraph()
    {
        for (int i = 0; i < n; i++)
        {
            System.out.print(i + ": ");
            ListIterator nbrs = graph[i].listIterator(0);
            while (nbrs.hasNext())
            {
                NodeSP nd = (NodeSP) nbrs.next();
                System.out.print(nd.label + "(" + nd.weight + ") ");
            }
            System.out.println();
        }
    }

}
