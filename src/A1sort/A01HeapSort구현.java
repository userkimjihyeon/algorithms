package A1sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//트리탐색 + 재귀적호출
public class A01HeapSort구현 {
    public static void main(String[] args) {
        int[] arr = {7,6,5,8,3,5,9,1,6};
//        최초힙구성 : n*log(n)
        for(int i=arr.length/2-1; i>=0; i--) {  // n/2-1(부모노드 중 마지막노드의 인덱스)
            heapify(arr, i, arr.length);
        }

//        루트노드와 최하위노드를 자리change해가면서 재heapify
        for(int i=arr.length-1; i>=0; i--) {
//           0번째 인덱스와 마지막 인덱스의 자리change
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i); //인덱스 0부터 다시 최소 힙으로 만들어야 함
        }
//        System.out.println(Arrays.toString(arr));

//        pq를 통한 정렬방법
//        최초힙구성 : n*log(n)
        Queue<Integer> pq = new PriorityQueue<>(Arrays.asList(7,6,5,8,3,5,9,1,6));
        System.out.println(pq.poll());  //logn
        pq.add(6);  //logn


    }
    static void heapify(int[] arr, int parent, int length){
        int left = parent*2+1;
        int right = parent*2+2;
        int smallest = parent;
//        자식노드와의 비교 : 왼쪽자식노드(parent*2+1), 오른쪽자식노드(parent*2+2)
//        자식이 더 작으면 자리 change

        if(length > left && arr[smallest] > arr[left]) { //자식노드가 존재하는지 확인(총인덱스수보다 같거나작은지)
            smallest = left;
        }
        if(length > right && arr[smallest] > arr[right]) { //자식노드가 존재하는지 확인(총인덱스수보다 같거나작은지)
            smallest = right;
        }
        if(smallest!=parent) {
            int temp = arr[parent];
            arr[parent] = arr[smallest];
            arr[smallest] = temp;
            heapify(arr, smallest, length);
        }

    }
}
