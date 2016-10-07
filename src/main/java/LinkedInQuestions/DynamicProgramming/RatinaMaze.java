package LinkedInQuestions.DynamicProgramming;

/**
 * Created by rmukherj on 10/1/16.
 */
public class RatinaMaze {
    int count = 0;

    boolean isSafe(int[][] maze, int x, int y, int[][] sol, int N){
        //if (x,y outside maze) return false

        boolean b =
                (x>=0 && x< N && y>=0 && y< N &&
                        maze[x][y] == 0 && sol[x][y]==0);
        if(b)
        {
            sol[x][y] = 1;
        }

        return b;

    }

    // a recursive utility function to solve Maze
    void solveMazeUtil(int[][] maze, int x, int y, int[][] sol, int N){
        if(x==N-1 && y == N-1){
            count = count + 1;
        }

        if(isSafe(maze, x+1, y, sol, N) == true){
            solveMazeUtil(maze, x+1, y, sol, N);
        }
        if (isSafe(maze, x, y + 1 ,sol, N) == true)
            solveMazeUtil(maze, x, y + 1, sol, N);
        if (isSafe(maze, x-1, y, sol, N) == true)
            solveMazeUtil(maze, x - 1, y, sol, N);
        if (isSafe(maze, x, y-1, sol, N) == true)
            solveMazeUtil(maze, x, y - 1, sol, N);

        sol[x][y]=0;
    }

    public static void main(String args[])
    {
        RatinaMaze rat = new RatinaMaze();
       // Scanner in = new Scanner(System.in);
        int N = 2;//in.nextInt();
        int[][] maze = new int[N][N];
        for(int row = 0; row< N; row++){
            for(int col = 0 ;col< N; col++)
                maze[row][col] = 0;//in.nextInt();
        }
//        int sol[][] = { {1, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0}
        int[][] sol = {{1,0},
                {1,0}
        };
        rat.solveMazeUtil(maze,0,0,sol,N);
        System.out.println(rat.count);
    }

}
