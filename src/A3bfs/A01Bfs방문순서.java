package A3bfs;

import java.util.*;

public class A01Bfs방문순서 {
    static List<List<Integer>> adjList; //전역변수
    static boolean[] visited;

    public static void main(String[] args) {
        int[][] nodes = {{0,2}, {0,1}, {1,3}, {2,3}, {2,4}};
        adjList = new ArrayList<>();
        visited = new boolean[5];

        for (int i=0; i<5; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i=0; i<nodes.length; i++) {
            adjList.get(nodes[i][0]).add(nodes[i][1]); //{0,2}의 0을 가져와서 adjlist의 0에 2넣기
            adjList.get(nodes[i][1]).add(nodes[i][0]); //{0,2}의 2를 가져와서 adjlist의 2에 0넣기
        }
        for(int i=0; i<adjList.size(); i++) {
            adjList.get(i).sort(Comparator.naturalOrder());
        }

        //1.큐선언 2.큐에 현재노드 add 3.방문처리
        // 4.반복문(큐가빌때까지) 4-1.temp에 큐를 꺼내기 4-2.temp출력
        // 4-3-1.반복문(인접노드리스트에서 큐에서 poll한 temp를 하나씩 꺼내기 4-3-2.
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(0); //myQueue : 0,
        visited[0]=true;

        while(!myQueue.isEmpty()) {
            int temp = myQueue.poll();      //myQueue -> temp에 넣기
            System.out.println(temp);

            for(int a : adjList.get(temp)) {
                if(!visited[a]) {
                    visited[a]=true;    //큐에 담는 시점에 true세팅해야지, 중복해서 큐에 담기지 않음.
                    myQueue.add(a);
                }
            }
        }
    }
}
