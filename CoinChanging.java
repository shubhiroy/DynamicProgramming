import java.util.*;
import java.lang.*;

public class CoinChanging{
    private static int[][] getChange(int total, int[] coins){
        int len = coins.length;
        int[][] changer = new int[len][total+1];
        for(int i=0;i<len;i++){
            changer[i][0] = 0;
        }
        for(int i=0;i<=total;i++){
            changer[0][i] = i;
        }
        for(int i=1;i<len;i++){
            for(int j=1;j<=total;j++){
                if(j>=coins[i]){
                    changer[i][j] = Math.min(changer[i][j-coins[i]],changer[i-1][j])+1;
                }else{
                    changer[i][j] = changer[i-1][j];
                }
            }
        }
        return changer;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total amount : ");
        int total = sc.nextInt();
        System.out.print("Enter total no. of coins : ");
        int totalCoins = sc.nextInt();
        int[] coins = new int[totalCoins+1];
        coins[0] = 1;
        System.out.println("Enter the value of coins");
        for(int i = 1;i<=totalCoins;i++){
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins);
        int[][] changer = getChange(total,coins);
        totalCoins = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=changer.length-1;i>1;){
            for(int j=changer[0].length-1;j>0;){
                if(total<coins[1]){
                    break;
                }
                if(changer[i][j-1]<=changer[i-1][j] && total>=coins[i]){
                    arr.add(coins[i]);
                    total = total - coins[i];
                    j = j-coins[i];
                    totalCoins++ ;
                }else{
                    i = i-1;
                }
            }
            if(total<coins[1]){
                break;
            }
        }
        if(total>0){
            System.out.println("Amount cann't be converted into coins !!! ");
        }else{
            System.out.println("Total no. of coins is "+totalCoins+" => "+arr);
        }
    }
}