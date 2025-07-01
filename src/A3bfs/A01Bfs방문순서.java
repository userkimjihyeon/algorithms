package A3bfs;

import java.util.*;

public class A01Bfs방문순서 {
    static List<List<Integer>> adjList; //전역변수
    static boolean[] visited;

    public static void main(String[] args) {
        int[][] nodes = {{0,2}, {0,1}, {1,3}, {2,3}, {2,4}};

        //0. 전역변수 생성
        adjList = new ArrayList<>();
        visited = new boolean[5];   //노드 수 만큼
        //1. 인접리스트 만들기
        for (int i=0; i<5; i++) {
            adjList.add(new ArrayList<>());
        }
        //2. 양방향 연결
        for (int i=0; i<nodes.length; i++) {
            adjList.get(nodes[i][0]).add(nodes[i][1]); //{0,2}의 0을 가져와서 adjlist의 0에 2넣기
            adjList.get(nodes[i][1]).add(nodes[i][0]); //{0,2}의 2를 가져와서 adjlist의 2에 0넣기
        }
        //3. 정렬
        for(int i=0; i<adjList.size(); i++) {
            adjList.get(i).sort(Comparator.naturalOrder());
        }

        // 1.큐 선언 2.큐에 시작노드 add 3.시작노드 방문처리
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(0); //myQueue : 0,
        visited[0]=true;

        // 4.반복문(큐가빌때까지) 4-1.temp에 현재노드 꺼내기 4-2.temp출력
        while(!myQueue.isEmpty()) {
            int temp = myQueue.poll();
            System.out.println(temp);   //방문순서 출력

            // 4-3-1.반복문(현재노드의 인접리스트 순서대로) 4-3-2.방문 안한 노드면 -> 방문처리 및 큐 add
            for(int a : adjList.get(temp)) {
                if (!visited[a]) {
                    visited[a]=true;    //큐에 담는 시점에 true세팅해야지, 중복해서 큐에 담기지 않음.
                    myQueue.add(a);
                }
            }
        }
    }
}
