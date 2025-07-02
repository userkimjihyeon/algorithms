package A5DP.문제;

import java.util.Arrays;
import java.util.Scanner;

//백준 : 동전 2
public class Q2294 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Integer[] coins = new Integer[n];
        for (int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(sc.nextLine());
        }

        //a,b,c조합으로 k가 되게하는 최소동전개수 (불가능한 경우 -1)
        int[] dp = new int[k + 1];  //i원을 만들기 위한 최소 동전 개수
        Arrays.fill(dp, 10000); //최소 갱신을 위한 큰 값 세팅
        dp[0] = 0; //0원은 0개 필요

        for (int i=1; i<=k; i++) {      //1원~k원
            for (int coin : coins) {    //1,5,12
                if (i-coin>=0) {
//                    dp[i] = Math.min()
                }
            }
        }

    }
}
