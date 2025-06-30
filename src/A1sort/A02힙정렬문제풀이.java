package A1sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class A02힙정렬문제풀이 {
    public static void main(String[] args) {
//        int k = 3;
//        int[] score = {10, 100, 20, 150, 1, 100, 200};
//        Solution sol = new Solution();
//        int[] result = sol.solution(k, score);
//        System.out.println(Arrays.toString(result));

        int n = 3;
        int[] works = {4, 3, 3};

        Solution2 sol = new Solution2();
        long result = sol.solution(n, works);
        System.out.println(result);
    }
//    프로그래머스 : 명예의 전당
//static class Solution {
//    public int[] solution(int k, int[] score) {
//        //명예의 전당 점수개수 k
//        //1일~마지막날 출연가수들의 점수 score
//        //k크기의 명예의전당 배열 생성
//        //score값을 1일차 넣고, 배열 중 최소값을 answer에 추가
//        int[] answer = new int[score.length];
//        Queue<Integer> pq = new PriorityQueue<>();
//        for(int i=0; i<score.length; i++) {
//            pq.add(score[i]);       //pq에 값 넣기
//            //명예의 전당 점수 갱신
//            if(pq.size() > k) {     //pq크기가 명예의전당 개수가 더크면
//                pq.poll();          //최소점수 꺼내기
//            }
//            //일일 최소점수 기록
//            answer[i] = pq.peek();
//        }
//        return answer;
//    }
//}

//    프로그래머스 : 야근 지수
static class Solution2 {
    public long solution(int n, int[] works) {
        long answer = 0;
        //야근시간 n
        //각일에 대한 작업량 works
        //야근피로도 : 야근을 시작한 시점에서 남은 일의 작업량을 제곱한 합계
        //야근 피로도를 최소화한 값 answer

        //works 내림차순 정렬해서 peak()-1씩 하면 될듯
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        //pq에 answer값 넣기
        for(int i=0; i<works.length; i++) {
            pq.offer(works[i]);
        }
        //pq의 max-1하기 (남은시간 n)
        for(int i=0; i<n; i++) {         //0~3
            int max = pq.poll();         //pq 최댓값 꺼내서 max에 넣기
            if(max > 0) {                //max가 0보다 크면
                pq.offer(max-1);      //max-1을 pq에 넣기
            }
        }
        for(int i=0; i<works.length; i++) {
            //pq각 값에 제곱해서 합계 answer에 저장
            int temp = pq.poll();
            answer += temp*temp;
        }

        return answer;
    }
}
}
