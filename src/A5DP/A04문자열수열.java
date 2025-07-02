package A5DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//백준 : 가장 긴 증가하는 부분 수열(11053)   -> 수열길이
//백준 : 가장 긴 증가하는 부분 수열 4(14002) -> 수열길이 + 수열자체
public class A04문자열수열 {
    public static void main(String[] args) {
        //arr[] 10 20 10 30 20 50
        //dp[] [1, 2, 1, 3, 2, 4]

        int[] arr = {10, 20, 10, 30, 20, 50};
        int N = 6;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        List<List<Integer>> myList = new ArrayList<>();
        for (int i=0; i<N; i++){
            myList.add(new ArrayList<>());
        }
        for (int i=0; i<dp.length; i++){
            int max = Integer.MIN_VALUE;
            boolean check = false;
            int index = -1;
            for (int j=0; j<i; j++){
                if(arr[i]>arr[j] && dp[j] > max){
                    max = dp[j];
                    index=j;
                    check = true;
                }
            }
            if(check){
                for (int a : myList.get(index)){
                    myList.get(i).add(a);
                }
                dp[i] = max + 1;
            }
            myList.get(i).add(arr[i]);
        }
        System.out.println(myList);
    }
}
