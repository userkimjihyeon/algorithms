package A5DP;

import java.util.Scanner;

//백준 : 평범한 배낭(12865), 배낭문제들...
//백준 : 호텔(동전관련)
public class A05배낭문제 {
    public static void main(String[] args) {
        //주어진 데이터를 중복해서 사용할 수 있는지 구분 필요.
        //c : 목표고객증가수 12
        //n : 도시 개수 2
        //홍보비용(coins) 유인고객수(target)
        //3 5
        //1 1
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();  // 최소 고객 수(12)
        int N = sc.nextInt();  // 도시 수(2)

        int[] costs = new int[N];
        int[] customer = new int[N];

        for (int i = 0; i < N; i++) {
            costs[i] = sc.nextInt();       // i번째 도시의 비용(3)
            customer[i] = sc.nextInt();    // i번째 도시에서 확보 가능한 고객 수(5)
        }

        //C명 늘리기 위한 최소한의 투자비용?
        //12명 -> 3원(5명)*2=10명 + 1원(1명)*2=2명
        //비용을 하나씩 증가하면서 C보다 크면 전단계
        //next도시의 비용을 써서 같은 계산 반복

        int[] dp = new int[C+1];
        for(int i=0; i<=C; i++) {
            for(int cost : costs) {
                if(i-cost >= 0) {
                    dp[i] = Math.min(dp[i], dp[i-cost]-1);
                }
            }
        }

    }
}
