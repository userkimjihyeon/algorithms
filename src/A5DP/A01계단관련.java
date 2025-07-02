package A5DP;

import java.util.Scanner;

//프로그래머스 : 멀리뛰기 -> 못품
//백준 : 계단오르기
public class A01계단관련 {
    public static void main(String[] args) {
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

        //점화식 세팅 (3~n번 계단)
        //⭐제약조건 : 3칸 연속이동 불가 -> a: 2칸 점프 / b: 2칸+1칸 점프
        for (int i=3; i<=n; i++) {        //i: 계단(4~n)
//                  2칸전최댓값   현재칸점수
            int a = dp[i - 2] + score[i];
//                 3칸전최댓값   1칸전점수    현재칸점수      => ⭐연속3칸 밟지 않기 위한 설정
            int b = dp[i-3] + score[i-1] + score[i];

            // 최대 점수 선택
            dp[i] = Math.max(a, b);
        }
        System.out.println(dp[n]); //마지막계단의 최대점수 출력
    }
}
