package A5DP;

import java.util.Scanner;

//프로그래머스 : 멀리뛰기 -> 못품
//백준 : 계단오르기
public class A01계단관련 {
    public static void main(String[] args) {
//        우리가 n=4일 때, 계단을 오르는 방법을 구한다고 해요.
//        dp[1] = 1 → 1칸 오르는 방법은 1개 (1)
//        dp[2] = 2 → 2칸 오르는 방법은 2개 (1+1, 2)
//        dp[3] = dp[2] + dp[1] = 2 + 1 = 3
//        dp[4] = dp[3] + dp[2] = 3 + 2 = 5
//          → 결국 dp[n] = dp[n-1] + dp[n-2]로 점점 쌓여가는 거야!
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();         // 계단 개수
        int[] score = new int[n + 1]; // 각 계단 점수 (1번부터 시작)
        int[] dp = new int[n + 1];    // 각 계단까지의 최대 점수

        //계단 점수 세팅
        for (int i = 1; i <= n; i++) {
            score[i] = sc.nextInt();
        }

        //초기값 세팅 (1~3번 계단:점화식 적용에 필요한 최소계단 수)
        dp[1] = score[1];
        if(n >= 2) dp[2] = score[1] + score[2]; // 1 -> 2
        if(n >= 3) dp[3] = Math.max(score[1]+score[2], score[2]+score[3]);

        //점화식 세팅 (4~n번 계단)
        //⭐제약조건 : 3칸 연속이동 불가 -> a: 2칸 점프 / b: 2칸+1칸 점프
        for (int i=4; i<=n; i++) {
            // a: 두 칸 전에서 점프 (i-2 ➡ i)
            int a = dp[i - 2] + score[i];

            //⭐그냥 1칸 전만 보면 이전 이전 계단(i-2)도 밟았을 가능성이 있기 때문에, -> 3칸 연속 밟기라는 금지 규칙을 어기게 될 수 있어요.
            // b: 세 칸 전 ➡ i-1 ➡ i (2칸 + 1칸)
            int b = dp[i - 3] + score[i - 1] + score[i];

            // 최대 점수 선택
            dp[i] = Math.max(a, b);
        }
        System.out.println(dp[n]); //마지막계단의 최대점수 출력
    }
}
