import java.util.*;
import java.lang.*;


public class LongestCommonSubsequence{

    private static int[][] createMatrix(String a, String b){
        int[][] arr = new int[b.length()+1][a.length()+1];
        for(int i=0;i<=a.length();i++){
            arr[0][i] = 0;
        }
        for(int j=0;j<=b.length();j++){
            arr[j][0] = 0;
        }
        for(int i=1;i<=b.length();i++){
            for(int j=1;j<=a.length();j++){
                if(a.charAt(j-1)==b.charAt(i-1)){
                    arr[i][j] = arr[i-1][j-1] + 1;
                }else{
                    arr[i][j] = Math.max(arr[i-1][j],arr[i][j-1]);
                }
            }
        }
        return arr;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int[][] arr = createMatrix(a,b);
        String s = "";
        int c = 0;
        for(int i=arr.length-1;i>0;){
            for(int j=arr[0].length-1;j>0;){
                if(arr[i][j]!=arr[i-1][j] && arr[i][j]!=arr[i][j-1]){
                    s = Character.toString(a.charAt(j-1)) + s;
                    i = i-1;
                    j = j-1;
                    c++;
                }else if(arr[i][j]==arr[i-1][j]){
                    i = i-1;
                }else if(arr[i][j]==arr[i][j-1]){
                    j = j-1;
                }
            }
        }
        System.out.println("Length of longest common subsequence " + s + " is : " + c);
    }
    
}