import java.util.*;
import java.lang.*;

public class LongestPalindromicSubsequence{
    
    private static int[][] getLongestPalinSub(String s){
        int len = s.length();
        int[][] arr = new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len-i;j++){
                int k = j + i;
               // if(i<=j){
                    if(j==k){
                        arr[j][k] = 1;
                    }else{
                        if(s.charAt(j)==s.charAt(k)){
                            arr[j][k] = arr[j+1][k-1]+2;
                        }else{
                            arr[j][k] = Math.max(arr[j][k-1],arr[j+1][k]);
                        }
                    }
               // }
            }
        }
        return arr;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[][] arr = getLongestPalinSub(s);
        System.out.println("The length of the longest palindromic subsequece is : " + arr[0][arr.length-1]);
    }
}