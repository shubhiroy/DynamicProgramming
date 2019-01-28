import java.util.*;
import java.lang.*;

public class LongestBitonicSubsequence{

    private static int[] getLongestIncSubsequence(int[] arr){
        int len = arr.length;
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            res[i] = 1;
        }
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i] && res[i]<=res[j]){
                    res[i] = res[j] + 1;
                }
            }
        }
        return res;
    }

    private static int[] rGetLongestIncSubsequence(int[] arr){
        int len = arr.length;
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            res[i] = 1;
        }
        for(int i=len-2;i>=0;i--){
            for(int j=len-1;j>i;j--){
                if(arr[j]<arr[i] && res[i]<=res[j]){
                    res[i] = res[j] + 1;
                }
            }
        }
        return res;
    }

    private static int getBitonicSequenceLength(int[] arr, int[] rArr){
        int max = 2;
        for(int i=0;i<arr.length;i++){
            int sum = arr[i] + rArr[i];
            if(max<sum){
                max = sum;
            }
        }
        return max-1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of values : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the values . ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int[] res = getLongestIncSubsequence(arr);
        int[] rRes = rGetLongestIncSubsequence(arr);
        int maxBitonic = getBitonicSequenceLength(res,rRes);
        System.out.println("Maximum length of the bitonic sequence is " + maxBitonic);
    }
}