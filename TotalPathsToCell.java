import java.util.*;
import java.lang.*;

public class TotalPathsToCell{

    private static int calcPath(int r, int c){
        int[][] pathTracker = new int[r][c];
        for(int i=0;i<c;i++){
            pathTracker[0][i] = 1;
        } 
        for(int i=0;i<r;i++){
            pathTracker[i][0] = 1;
        } 
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                pathTracker[i][j] = pathTracker[i-1][j] + pathTracker[i][j-1];
            }
        }
        return pathTracker[r-1][c-1];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of rows no. : ");
        int r = sc.nextInt();
        System.out.print("Enter the no. of column no. : ");
        int c = sc.nextInt();
        int pathWays = calcPath(r,c);
        System.out.print("No. of different ways to reach cell " + r + "-" + c + " is : " + pathWays);
    }
}