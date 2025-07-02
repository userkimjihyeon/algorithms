package A3bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 : 숨바꼭질(1697)
public class A05비노드형식의최단거리 {
    public static void main(String[] args) {
        //n : 수빈 (5)
        //k : 동생 (17)
        //위치가 x일때
        //1.걷기 -> x-1
        //2.x+1
        //3.순간이동 -> x*2
        //수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇초후?
        //5 -> 10 -> 9 -> 18 -> 17

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());

        int max = 100001;
        boolean[] visited = new boolean[max];
        int[] distance = new int[max];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n]=true;
        distance[n] = 0;    //시작위치 0으로 설정

        while(!queue.isEmpty()) {
            int now = queue.poll(); //현재위치
            if(now == k) { break; }

            int[] nextPos = {now-1, now+1, now*2};  //약간 상하좌우 느낌?
            for(int next : nextPos) {
                if(next >= 0 && next < max && !visited[next]) {
                    visited[next]=true;
//                      다음위치    =    현재위치+1
                    distance[next] = distance[now]+1;   //distance: 시작위치부터 이동시간
                    queue.add(next);
                }
            }
        }
    }
}
