import java.util.*;
import java.lang.Math;


public class MaxSumSubsequenceNonAdj{
    private static int[] dp(int[] arr,int n){
        if(n==0){
            return new int[]{arr[n],Integer.MIN_VALUE};
        }
        if(n==1){
            return new int[]{arr[n],arr[n-1]};
        }
        int[] res = dp(arr,n-1);
        int temp = res[1];
        res[1] = Math.max(res[0],res[1]);
        res[0] = Math.max(arr[n],Math.max((temp+arr[n]),temp));
        return res;
    }
    private static int getMaxSum(int[] arr){
        int[] res = dp(arr,arr.length-1);
        return Math.max(res[0],res[1]);
    }
    private static int dp2(int[] arr, int n){
        if(n==0){
            return arr[n];
        }
        if(n==1){
            return Math.max(arr[n],arr[n-1]);
        }
        return Math.max(arr[n],Math.max(arr[n]+dp2(arr,n-2),dp2(arr,n-1)));
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int res = getMaxSum(arr);
        System.out.println("Max non adjacent sum of elements of array : " + res);
        System.out.println("Max non adjacent sum of elements of array : " + dp2(arr,arr.length-1));
    }
}