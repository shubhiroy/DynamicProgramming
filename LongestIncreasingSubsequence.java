import java.util.*;
import java.lang.*;

public class LongestIncreasingSubsequence{

    private static int getLongestIncSubseq(int[] arr){
        int len = arr.length;
        int[] resArr = new int[len];
        for(int i=0;i<resArr.length;i++){
            resArr[i] = 1;
        }
        for(int i=1;i<len;i++){
            int count = 0;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i] && resArr[i]<=resArr[j]){
                    resArr[i] = resArr[j] + 1;
                }
            }
        }
        int res = 0;
        for(int i=0;i<resArr.length;i++){
            if(res<resArr[i]){
                res = resArr[i];
            }
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of inputs : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the values");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int res = getLongestIncSubseq(arr);
        System.out.println("Length of the longest increasing subsequence is : "+res);
    }
}