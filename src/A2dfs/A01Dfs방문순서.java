package A2dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class A01Dfs방문순서 {
    static List<List<Integer>> adjList; //전역변수
    static boolean[] visited;

    public static void main(String[] args) {
//        방문할 수 있는 점이 여러개인경우, 정점번호가 작은것을 먼저 방문
//        출발은 0부터 dfs로 방문시 방문순서 : 0->1->3->2->4
        int[][] nodes = {{0,2}, {0,1}, {1,3}, {2,3}, {2,4}};
        //인접리스트 : 리스트에 각 nodes의 인덱스별로 자식노드를 담기
        //0: 2,1
        //1: 0,3
        //2: 0,3,4
        //3: 1,2
        //4: 2
//        인접리스트(adjList)를 활용해서 인접한 노드를 빠르게 접근
        adjList = new ArrayList<>();
//        visited = new boolean[nodes.length];  //간선수(X)
        visited = new boolean[5];               //정점수(O)

        for (int i=0; i<5; i++) {
            adjList.add(new ArrayList<>());     //adjList에 빈리스트 5개 생성
        }
        for (int i=0; i<nodes.length; i++) {
//            단방향
            adjList.get(nodes[i][0]).add(nodes[i][1]); //0: 2
//            양방향
            adjList.get(nodes[i][1]).add(nodes[i][0]); //2: 0
        }

//        System.out.println(adjList);
//        정점번호가 작은것부터 방문하기 위한 정렬 : [[2, 1], [0, 3], [0, 3, 4], [1, 2], [2]] -> [[1, 2], [0, 3], [0, 3, 4], [1, 2], [2]]
        for(int i=0; i<adjList.size(); i++) {
            adjList.get(i).sort(Comparator.naturalOrder());
        }
//        System.out.println(adjList);

        dfs(0); //0부터 출발

    }
    static void dfs(int start) {
        System.out.println(start);
        visited[start] = true;
//        인접리스트를 순회할때는 보통 향상된 for문 사용
        for(int a : adjList.get(start)) {
            if(!visited[a]) {
                dfs(a);
            }
        }
    }
}

//둘다 DFS,BFS 사용가능
//백준 : DFSBFS 1260
//백준 : 연결요소의 개수 11724
