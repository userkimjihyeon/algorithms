package A3bfs;

import java.util.*;

public class A02Bfs최단거리 {
//    전역변수
    static List<List<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        int[][] nodes = {{0,2}, {0,1}, {1,3}, {2,3}, {2,4}};

        adjList = new ArrayList<>();
        visited = new boolean[5];

        for (int i=0; i<5; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i=0; i<nodes.length; i++) {
            adjList.get(nodes[i][0]).add(nodes[i][1]);
            adjList.get(nodes[i][1]).add(nodes[i][0]);
        }

        for(int i=0; i<adjList.size(); i++) {
            adjList.get(i).sort(Comparator.naturalOrder());
        }

//        Queue 안에 Integer가 아니라 int[]을 담아서 0번째는 노드번호, 1번째는 distance설계 가능. -> A04참고
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(0);
        visited[0]=true;

        int[] distance = new int[5];
        int target=4;

        while(!myQueue.isEmpty()) {
            int temp = myQueue.poll();

            for(int a : adjList.get(temp)) {
                if(!visited[a]) {
                    visited[a]=true;        //큐에 담는 시점에 true세팅해야지, 중복해서 큐에 담기지 않음.
                    myQueue.add(a);
//                   이웃노드의 거리 : 현재노드+1
                    distance[a] = distance[temp]+1;
//                   만약에 찾고자하는 target이 정해져 있으면 break;
                    if(a==target) { break; }
                }
            }
        }
//       target : 거리배열[4]까지의 최단거리 (거리배열을 만들기. -> 배열크기는 4.......? 배열이 다 돌면 거리측정?...count++.......?)
        System.out.println(distance[target]);   //2
    }
}
