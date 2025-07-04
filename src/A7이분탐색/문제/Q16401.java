package A7이분탐색.문제;

import java.util.Arrays;

//백준 : 과자나눠주기(answer 찾은후에도 계속 탐색)
public class Q16401 {
    public static void main(String[] args) {
        int people = 4;
        int snack = 3;
        int[] arr = {10, 10, 15};

        //1명에게 줄 수 있는 막대과자의 최대길이(1개). 조각을 낼 수 있지만 합치는건 불가능.
        int answer = 0;
        int start = 1;
        int end = Arrays.stream(arr).max().getAsInt();

        // 이분탐색 : mid로 나눠서 탐색
        while (start <= end) {
            int mid = (start + end) / 2;    // 7 (과자길이 : 0~15)
            int total = 0;

            //arr[mid]부터 arr[end]까지 개수가 3개 이상인지? => 이게아니궁... 0~15
            for (int a : arr) {    //0~2
                total += a / mid;               //total :과자를 중간값으로 나눈 몫의 누적합
            }

            if(total >= people) {       //최대막대길이를 구하므로 -> break대신 2가지 분기로 나눔
                answer = mid;
                start = mid+1;
            } else if(total < people) {
                end = mid-1;
            }
        }
        System.out.println(answer);     // 7
    }
}
