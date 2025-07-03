package A6투포인터;

//프로그래머스 : 숫자의 표현 -> 구간의 합
//프로그래머스 : 연속된 부분 수열의 합 -> 구간의 합
public class A02수열의범위 {
    public static void main(String[] args) {
        //자연수 n을 연속한 자연수들로 표현하는 방법의 수
        //ex) 자연수 15 -> 4가지
        int n = 15;

        //1<n까지 순회
        //1부터 누적합을 계산해서
        //sum<n -> end++
        //sum>n -> 종료하고, start++ 및 end는 start+1위치로 이동
        //sum==n -> total++, start++ 및 end는 start+1위치로이동
        //근데이제..end가 여러개야...
        int total = 1; //자기자신(15) 포함
        int start = 1;
        int end = 2;
        int sum = start + end;
        while(end < n) {
//            System.out.println(start + ":" + end + "=" + sum);
            if (sum == n) {         //같으면
//                System.out.println("같음");
                total++;
                start++;
                end = start+1;
                sum = start + end;  //리셋
//                System.out.println(total);
            } else if (sum < n) {   //작으면
//                System.out.println("작음");
                end++;
                sum += end;
            } else if (sum > n) {   //크면
//                System.out.println("큼");
                start++;
                end = start+1;
                sum = start + end;  //리셋
            }
        }
        System.out.println(total);
    }
}
