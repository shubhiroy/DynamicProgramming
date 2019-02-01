import java.util.*;
import java.lang.*;

public class BuySellStocks{
    private static int[][] getStockProfit(int[] stocks, int k){
        int len = stocks.length;
        int[][] res = new int[k+1][len];
        for(int i=0;i<len;i++){
            res[0][i] = 0;
        }
        for(int i=0;i<=k;i++){
            res[i][0] = 0;
        }
        for(int i=1;i<=k;i++){
            for(int j=1;j<len;j++){
                //System.out.println("in j");
                int notSell = res[i][j-1];
                int m = 0;
                int sell = 0;
                while (m<j){
                    sell = Math.max(sell,(stocks[j]-stocks[m]+res[i-1][m]));
                    m++;
                }
                res[i][j] = Math.max(sell,notSell);
            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of transaction to be done : ");
        int k = sc.nextInt();
        System.out.print("Enter the total no. of stocks : ");
        int n = sc.nextInt();
        int[] stocks = new int[n];
        System.out.println("Enter the value of stocks on each day . ");
        for(int i=0;i<n;i++){
            stocks[i] = sc.nextInt();
        }
        int[][] res = getStockProfit(stocks,k);
        int bestProfit = res[k][stocks.length-1];
        System.out.println("Best profit by doing "+ k +" transactions on the given stocks is : " + bestProfit);
    }
}