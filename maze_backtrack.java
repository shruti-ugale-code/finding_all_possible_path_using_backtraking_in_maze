import java.util.Arrays;

public class maze_backtrack {
    public static void main(String[] args) {
        boolean[][] arr={
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
       // pathrock("",arr,0,0);
        int[][] path=new int[arr.length][arr[0].length];
        pathprint("",arr,0,0,path,1);

    }

    public static void pathrock(String a, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(a);

            return;
        }
        if (!maze[r][c]) {
            return;

        }
        maze[r][c] = false;
        if (r < maze.length - 1) {
            pathrock(a + 'D', maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {
            pathrock(a + 'R', maze, r, c + 1);
        }
        if (r > 0) {
            pathrock(a + 'U', maze, r - 1, c);
        }
        if (c > 0) {
            pathrock(a + 'L', maze, r, c - 1);
        }
        maze[r][c]=true;
    }
    public static void pathprint(String a, boolean[][] maze, int r, int c,int[][] path,int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            for(int[] arr:path) {
                path[r][c]=step;
                System.out.println(Arrays.toString(arr));


            }
            System.out.println(a);
            System.out.println();
            return;
        }
        if (!maze[r][c]) {
            return;

        }
        maze[r][c] = false;
        path[r][c]=step;
        if (r < maze.length - 1) {
            pathprint(a + 'D', maze, r + 1, c,path,step+1);
        }
        if (c < maze[0].length - 1) {
            pathprint(a + 'R', maze, r, c + 1,path,step+1);
        }
        if (r > 0) {
            pathprint(a + 'U', maze, r - 1, c,path,step+1);
        }
        if (c > 0) {
            pathprint(a + 'L', maze, r, c - 1,path,step+1);
        }
        maze[r][c]=true;
        path[r][c]=0;
    }
}