package A5DP;

import java.util.Arrays;

public class A02동전관련 {
    public static void main(String[] args) {
//        1,4,5의 숫자가 있을때, 조합하여 13를 만들 수 있는 조합중 가장 짧은 조합의 길이
        Integer[] coins = {1, 4, 5};
        int target = 13;
//        greedy로 문제를 풀경우 : 5*2 + 1*3 -> 5개 동전
//        dfs,bfs -> 시간초과 또는 메모리초과
//        dp로 문제를 풀경우 : 4*2 + 5*1 -> 3개 동전
//        점화식 : f(n) = (Min(f(n-n1), f(n-n2))) + 1
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 10000);
        dp[0] = 0;

//        i -> 작은 금액부터 최소 동전 개수를 미리 저장해가면서, **마지막에 target(13)**을 만들기 위한 재료.
        for (int i = 1; i <= target; i++) {       // 모든 금액 i에 대해
            for (int coin : coins) {              // 가능한 모든 동전을 돌면서
                if (i - coin >= 0) {              // 현재금액(i)에서 현재동전(coin)을 뺀 값이, 음수 안 되게 조건 체크
                    //⭐이전 금액 i - coin까지 최소 동전 수 + 현재 동전 1개
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);  //+1은 동전개수임! (+coin은 금액이므로 아님)
                }
            }
        }
        // 결과 출력
        if (dp[target] > target) {
            System.out.println("불가능");
        } else {
            System.out.println("최소 동전 개수: " + dp[target]);  // 👉 정답: 3
        }
    }
}
