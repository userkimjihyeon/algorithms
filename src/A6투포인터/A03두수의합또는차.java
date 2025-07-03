package A6투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 : 두 용액
public class A03두수의합또는차 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 총 개수: N
        int N = Integer.parseInt(br.readLine());
        // arr: N개의 정수
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬
        Arrays.sort(arr);   //-99 -2 -1 44 98

        //arr를 조합해서 0에 가장 가까운 조합 출력하기
        //1. start+end이 양수일때, sum보다 작으면 sum을 교체
        //2. start+end이 음수일때, sum보다 크면 sum을 교체
        int start = 0;
        int end = N-1;
        int answerStart = 0;
        int answerEnd = N-1;

        int min = Integer.MAX_VALUE;    //최소diff 생성

        while(start < end) {
            //조합, 절대값 저장
            int sum = arr[start] + arr[end];
            int diff = Math.abs(sum);

            //기존최소 조합과 현재 조합중 현재가 더 0과 가까우면
            if(diff < min) {
                min = diff;         //최소조합 갱신
                answerStart = start;    //현재 -> 최소 start,end 저장
                answerEnd = end;
            }
            if(sum < 0) {   //음수면 start 우로이동
                start++;
            } else {        //양수 or 0이면 end 좌로이동
                if (sum == 0) {break;}
                end--;
            }
        }
        System.out.println(arr[answerStart] + " " + arr[answerEnd]);
    }
}
