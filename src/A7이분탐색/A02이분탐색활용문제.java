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
        int[] intArr = {70, 80, 30, 40, 100};
        int total = 450;
//        Arrays.sort(intArr);
        int max = Arrays.stream(intArr).max().getAsInt();
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = i + 1;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int sum = 0;
            int idx = (start + end) / 2;
            for (int num : intArr) {
                sum += Math.min(num, arr[idx]); //70,50->50
            }

            if (sum == total) {
                answer = idx;
                break;
            } else if (sum > total) {
                end = idx - 1;
            } else {
                start = idx + 1;
                answer = idx;
            }
        }
        System.out.println(arr[answer]);
    }
}
