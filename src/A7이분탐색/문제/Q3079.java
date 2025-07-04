package A7이분탐색.문제;

import java.util.Arrays;

public class Q3079 {
    public static void main(String[] args) {
        //예제2) 7, 10, {3,8,3,6,9,2,4}, 8
        int desk = 7;
        int people = 10;
        int[] arr = {3,8,3,6,9,2,4};    //각 심사대 소요시간
        Arrays.sort(arr);   //2,3,3,4,6,8,9

        //마지막 사람은 빈곳, 시간이적은곳을 기다려서 심사받음.
        int answer = 0;
        int start = 1;
        int end = arr.length;     // 7

        //1. 심사대중에서 최소시간과 mid를 비교해서
        //2. 1턴돌고 다음인원을 최소시간순서대로 할당
        while(start <= end) {
            int midIdx = (start+end) / 2;      // 4

            for(int a : arr) {

            }

            if() {

            }
        }
        System.out.println(answer); // 8
    }
}
