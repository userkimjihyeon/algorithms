package A7이분탐색;

import java.util.Arrays;

public class A01BinarySearchBasic {
    public static void main(String[] args) {
////        이분탐색은 사전에 데이터가 오름차순 정렬이 되어야함.
//        int[] arr = {1,3,5,7,9,11,13,15,17,19};
////        System.out.println(Arrays.binarySearch(arr, 17));   //arr에서 17을 찾겠다
//        int target = 17;
//        int answer = -1;
//        int start = 0;
//        int end = arr.length-1;   //10
//
//        while(start <= end) {
//            int mid = (start+end) / 2;
//
//            if(arr[mid] == target) {
//                answer = mid;
//                break;
//            } else if (arr[mid] > target) { //target이 중간 좌측
//                end = mid-1;
//            } else if (arr[mid] < target) { //target이 중간 우측
//                start = mid+1;
//            }
//        }
//        System.out.println(answer);     // 8

//        응용case : 배열(탐색의대상)을 직접 설정.
//        target이 arr에 있다면 index값을 리턴하고, 없다면 있어야할 자리index를 return.
        int[] arr = {1,3,5,7,9,11,13,15,17,19};
        int target = 2;
        int answer = -1;

        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = (start+end) / 2;
            System.out.println("현재 중간값 : " + mid);  //4, 1, 0

            if(target == arr[mid]) {
                answer = mid;
//                조건에 맞는 값을 찾았어도 최소값/최대값을 위해 이분탐색을 계속 진행할 수 있음. -> A02이분탐색활용문제
                break;
            } else if(target > arr[mid]) {  //target이 중간보다 크면 -> 시작점+1
                start = mid+1;
////                조건에 딱 맞는 값이 없을 수도 있는 경우 -> 문제에 따라 다름
//                answer = mid;
            } else {
                end = mid-1;
////                조건에 딱 맞는 값이 없을 수도 있는 경우 -> 문제에 따라 다름
//                answer = mid;
            }
        }
        System.out.println(answer); // -1

    }
}
