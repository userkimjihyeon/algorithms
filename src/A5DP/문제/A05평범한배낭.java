package A5DP.문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A05평범한배낭 {
    public static void main(String[] args) throws IOException {
//        1.중복제거 2.배낭을바깥for문(뒤->앞)
        // 입력 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: N, K 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품 수
        int K = Integer.parseInt(st.nextToken()); // 배낭 최대 무게

        // arr[i][0] = 무게, arr[i][1] = 가치
        int[][] arr = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 무게
            arr[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        // DP 배열: dp[j] = 무게 j일 때 최대 가치
        int[] dp = new int[K + 1];

        for (int i = 1; i <= N; i++) {                          //1~물품수
            int weight = arr[i][0];
            int value = arr[i][1];

            // 뒤에서부터 갱신 (0-1 Knapsack은 반드시 역순)
            for (int j = K; j >= weight; j--) {                 //target~현재물건무게
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }
        }

    }
}
