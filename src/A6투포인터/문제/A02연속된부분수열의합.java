package A6투포인터.문제;

import java.util.Arrays;

//프로그래머스 : 연속된 부분 수열의 합 -> 구간의 합
public class A02연속된부분수열의합 {
    public static void main(String[] args) {
        //result = [6, 6]
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;

        int[] answer = {};
        int start = 0;
        int end = 1;
        int total = start+end;
        int startIndex = sequence.length-1;

        // 수열에서
        // 연속된 숫자의 합이 k와 일치하는 인덱스 조합 중에서
        // 길이가 짧은 부분 수열(length 짧은 것) 반환
//        -> 인덱스 조합은 temp[]에 하고, 완성시 answer[]에 저장,
//        다음 인덱스조합이 끝나면 temp[]와 answer[]의 길이 비교후 짧은것
        // 길이가 같으면 먼저 나온 수열(인덱스 작은 것) 반환
//        -> 매반복시 시작인덱스를 startIndex에 저장
//        다음 인덱스조합이 끝나면 start와 startIndex 비교후 작은것
        // 1.start랑 end를 1, 2부터 돌림
        // 2..total이 k와 같은 경우 -> answer[]에 저장

        int[] temp = new int[sequence.length];
        while(total < k) {
            //temp 리셋 위치
            for(int index : sequence) {
                //temp에 sequence[index]하나씩 저장
                if(total == k) {
                    //start를 end로, end는 start+1로
                    //

                    //answer과 temp 중 최소길이
                    //길이 같으면 start와 startIndex 중 최소값
                } else if (total > k) {

                } else if (total < k) {

                }
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}
