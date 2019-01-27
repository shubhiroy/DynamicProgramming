import java.util.*;
import java.lang.*;

public class CuttingRod{

    private static int[][] getCutPriceList(int len, int[] cuts, int[] price){
        int[][] arr = new int[(cuts.length+1)][(len+1)];
        for(int i=0;i<(cuts.length+1);i++){
            arr[i][0] = 0;
        }
        for(int i=1;i<=len;i++){
            arr[0][i] = 0;
        }
        for(int i=1;i<(cuts.length+1);i++){
            for(int j=1;j<=len;j++){
                //System.out.print(" h ");
                if(cuts[i-1]<=j){
                    arr[i][j] = Math.max(arr[(i-1)][j],arr[i][(j-cuts[i-1])]+price[(i-1)]);
                }else{
                    arr[i][j] = arr[(i-1)][j];
                }
            }
        }
        return arr;
    }

    private static int getCutPieces(int len, int[] cuts, int[][] arr, ArrayList<Integer> pieces){
       // ArrayList<Integer> pieces = new ArrayList<>();
        int i = arr.length-1, j = arr[0].length-1;
        while(i>0 && j>0){
            if(len<cuts[0]){
                break;
            }
            if(arr[i][j]==arr[i-1][j]){
                i = i-1;
            }else{
                len = len - cuts[i-1];
                pieces.add(cuts[i-1]);
                j = j - cuts[i-1];
            }
        }
        if(len==0){
            return 1;
        }else{
            return 0;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total length of the rod : ");
        int len = sc.nextInt();
        System.out.print("Enter the no. of pieces : ");
        int n = sc.nextInt();
        int[] cuts = new int[n];
        int[] price = new int[n];
        System.out.println("Enter the length of the pieces . ");
        for(int i=0;i<n;i++){
            cuts[i] = sc.nextInt();
        }
        System.out.println("Enter the price of the pieces . ");
        for(int i=0;i<n;i++){
            price[i] = sc.nextInt();
        }
        int[][] priceList = getCutPriceList(len,cuts,price);
        ArrayList<Integer> pieces = new ArrayList<>();
        int res = getCutPieces(len,cuts,priceList,pieces);
        if(res==1){
            System.out.println("The cut pieces are "+pieces);
        }else{
            System.out.println("The rod cann't be cut into the given pieces !!!");
        }
    }
}