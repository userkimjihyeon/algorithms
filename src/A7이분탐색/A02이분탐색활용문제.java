package A7이분탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//백준 : 예산
//백준 : 과자나눠주기(answer 찾은후에도 계속 탐색)
//백준 : 입국심사
public class A02이분탐색활용문제 {
    public static void main(String[] args) throws IOException {
        // 120 110 140 150 => [1, 2, 3, ..., 150]
        int answer = -1;
        int[] intArr = {120, 110, 140, 150};
        int total = 485;

//        Arrays.sort(intArr);
        int max = Arrays.stream(intArr).max().getAsInt();
        int[] arr = new int[max];       // [1, 2, 3, ..., 150]
        for (int i = 0; i < max; i++) {
            arr[i] = i + 1;
        }

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

//            sum : 예산요청의 누적합(중간값이 더 작으면 교체)
            int sum = 0;
            for (int num : intArr) {
                sum += Math.min(num, arr[mid]);
            }

            if (sum == total) {
                answer = mid;
                break;
            } else if (sum > total) {   //예산초과 -> 상한액 작게
                end = mid - 1;
            } else {                    //예산미만 -> 상한액 크게
                start = mid + 1;
                answer = mid;   //하는 이유? 이때까지 가능했다는 뜻
            }
        }
        System.out.println(arr[answer]);
    }
}
