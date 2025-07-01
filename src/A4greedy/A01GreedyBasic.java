package A4greedy;

import java.util.Arrays;
import java.util.Comparator;

//greedy : 현재로서 최적의 해를 선택했을때, 전체의 최적의 해를 보장하는 알고리즘.
public class A01GreedyBasic {
    public static void main(String[] args) {
//        1,5,10,20의 숫자가 있을때, 조합하여 99를 만들 수 있는 조합중 가장 짧은 조합의 길이
//        99를 20으로 나눔(4) 10(1) 5(1) 1(4)
        Integer[] arr = {1, 5, 10, 20};
        int target = 99;
        int total = 0;

        Arrays.sort(arr, Comparator.reverseOrder());    //20, 10, 5, 1
        for(int a : arr) {
            int remain = target/a;//4
            total += remain;//19
            target -= remain*a;//99-80-
        }

        System.out.println(total);
    }
}
