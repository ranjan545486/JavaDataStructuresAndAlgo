package tryingsomething.Graphs;

import java.util.Stack;

/**
 * Created by rmukherj on 10/5/16.
 */
class Vertex{
    public boolean wasVisited;
    public String label;

    public Vertex(String label){
        this.label = label;
        wasVisited = false;
    }
}

class GraphDFS{
    public final Integer Num_Vertices = 20;
    public Vertex[] vertices;
    public int[][] adjMatrix;
    public int numVerts;

    public GraphDFS(){
        vertices = new Vertex[Num_Vertices];
        adjMatrix = new int[Num_Vertices][Num_Vertices];
        numVerts = 0;
    }

    public void AddVertex(String label){
        vertices[numVerts] = new Vertex(label);
        numVerts++;
    }

    public void AddEdge(int start, int end)
    {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void ShowVertex(int v)
    {
        System.out.println(vertices[v].label + " ");
    }

}
public class DFS {


    public void RecursiveDFS(int v, GraphDFS gd ){
        gd.vertices[v].wasVisited = true;
        System.out.println(gd.vertices[v].label);
        for (int i = 0; i < gd.numVerts; i++) {
            if(gd.adjMatrix[i][v]>0 && gd.vertices[i].wasVisited == false){
                RecursiveDFS(i, gd);
            }
        }
    }

    public void DFSStack(GraphDFS g){
        Stack<Integer> vertexStack = new Stack<>();
        g.vertices[0].wasVisited = true;
        g.ShowVertex(0);
        vertexStack.push(0);
        int v;
        while(vertexStack.size()>0){
            v = GetAdjUnvisitedVertex(vertexStack.peek(),g);
            if(v == -1){
                vertexStack.pop();
            } else{
                g.vertices[v].wasVisited = true;
                g.ShowVertex(v);
                vertexStack.push(v);
            }
        }

        for (int j = 0; j < g.numVerts ; j++) {
            g.vertices[j].wasVisited = false;
        }

    }

    private int GetAdjUnvisitedVertex(Integer v, GraphDFS g) {
        for (int j = 0; j <=g.numVerts -1; j++)
        {
            if(g.adjMatrix[v][j] ==1 &&
                    g.vertices[j].wasVisited == false)
            {
                return j;
            }

        }

        return -1;
    }

    public void Mst(GraphDFS g){
        Stack<Integer> vertexStack = new Stack<>();
        g.vertices[0].wasVisited = true;
        vertexStack.push(0);
        int currVertex, ver;
        while(vertexStack.size()>0){
            currVertex = vertexStack.peek();
              ver = GetAdjUnvisitedVertex(vertexStack.peek(),g);
            if(ver == -1){
                vertexStack.pop();
            } else{
                g.vertices[ver].wasVisited = true;

                vertexStack.push(ver);
                g.ShowVertex(currVertex);
                g.ShowVertex(ver);
                System.out.println(" ");
            }
        }

        for (int j = 0; j < g.numVerts ; j++) {
            g.vertices[j].wasVisited = false;
        }


    }

    public static void main(String[] args) {
        GraphDFS g = new GraphDFS();
        g.AddVertex("A");
        g.AddVertex("B");
        g.AddVertex("C");
        g.AddVertex("D");
        g.AddVertex("E");
        g.AddVertex("F");
        g.AddVertex("G");
        g.AddVertex("H");
        g.AddVertex("I");
        g.AddVertex("J");
        g.AddVertex("K");
        g.AddVertex("L");
        g.AddVertex("M");
        g.AddEdge(0,1);
        g.AddEdge(1,2);
        g.AddEdge(2,3);
        g.AddEdge(0,4);
        g.AddEdge(4,5);
        g.AddEdge(5,6);
        g.AddEdge(0,7);
        g.AddEdge(7,8);
        g.AddEdge(8,9);
        g.AddEdge(0,10);
        g.AddEdge(10,11);
        g.AddEdge(11,12);
        DFS d = new DFS();
        d.RecursiveDFS(0,g);
        System.out.println(" gap");
        d.DFSStack(g);
        System.out.println("gap 2");
        d.Mst(g);



    }
}
