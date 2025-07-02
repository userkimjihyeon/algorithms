package A5DP.문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 : 내려가기
public class A03_Q2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 줄 수
        int[][] map = new int[N][3]; // 3열 고정

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        //이동 규칙: 바로 아래의 수 or 바로 아래의 수와 붙어있는 수
        //최대 점수, 최소 점수 구하기

        //DP: 현재 행(i)에서의 최대,최소값
        int[] maxDp = new int[3];   //열(3) 기준임.
        int[] minDp = new int[3];
        //max=0, min=27로 초기화
        for(int i=0; i<3; i++) {
            maxDp[i] = 0;
            minDp[i] = N*9;
        }

        //0~N행을 돌면서, map의[0],[1],[2]값 중 최대, 최소값이 위치한 자리를 저장하고, 점수를 합산하여 maxDp, minDp에 저장


    }
}
