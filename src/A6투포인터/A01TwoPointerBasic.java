package A6투포인터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A01TwoPointerBasic {
    public static void main(String[] args) {
//        아래 배열에서 target이 될 수 있는 두 수의 조합을 모두 찾아내어라.
//        [1,9]와 [9,1]은 같은 것으로 취급
//        복잡도 n^2
        int[] nums = {7,8,9,2,4,5,1,3,6};
        int target = 10;
        List<int[]> myList = new ArrayList<>();
//        for(int i=0; i<nums.length; i++) {
//            for(int j=i+1; j<nums.length; j++) {
//                if(nums[i]+nums[j] == target) {
//                    myList.add(new int[]{nums[i], nums[j]});
//                }
//            }
//        }
//        for(int[] a : myList) {
//            System.out.println(Arrays.toString(a));
//        }

//        ⭐투포인터⭐ 기본코드암기
//        투포인터 고려사항 : 1.정렬 2.<= 3.end의 시작점(start와동시에증가(감소)하면안됨)
//        위 배열을 정렬시 : 1,2,3,4,5,6,7,8,9
//        end가 0부터 출발하는 경우(구간의 합)
//        end가 length-1부터 시작하는 경우(두수의 합)
        int start = 0;
        int end = nums.length-1;
//        정렬이 필요한 경우 : 예)두수의 합
//        정렬이 필요하지 않은 경우 : 예)구간의 합
        Arrays.sort(nums);  //n*long(n)
        //복잡도 : n
        while(start < end) { //<= 또는 < 인경우 2가지 존재
            int total = nums[start] + nums[end];
            if(total == target) {
                myList.add(new int[]{nums[start], nums[end]});
                start++; //또는 end--;
            } else if(total < target) {
                start++;
            } else if(total > target) {
                end--;
            }
        }
        for(int[] a : myList) {
            System.out.println(Arrays.toString(a));
        }
    }
}
