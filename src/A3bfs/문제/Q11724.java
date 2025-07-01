package A3bfs.문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q11724 {
    static List<List<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        //n 정점개수
        //m 간선개수
        //u, v 주어진 양 끝점
        //연결요소의 개수 구하기
//각 정점의 최대,최소를 기록 -> 다음최소가 현재최대보다 크면, 연결요소의 개수 카운팅하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
        for(int i=0; i<m; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        System.out.println(adjList);
    }
}
