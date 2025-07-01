package A3bfs.문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2644 {
    public static void main(String[] args) throws IOException {
        //부모-나 : 1촌
        //조부모-나 : 2촌
        //아버지형제-나 : 3촌

        //n: 전체 사람수 -> 노드
        //서로 다른 두 사람의 번호 -> 이 두사람의 촌수 구하기(-> 최단거리)
        //m: 부모자식들간의 관계의 개수 -> 간선
        //x y: 부모자식간의 관계(x: y의 부모번호)
        //촌수없으면 -1

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        boolean[] visited = new boolean[n+1];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            adjList.add(new ArrayList<>());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i=0; i<m; i++) {
            String[] lines = br.readLine().split(" ");
            int x = Integer.parseInt(lines[0]);
            int y = Integer.parseInt(lines[1]);

            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }

        for(int i=1; i<=n; i++) {
            adjList.get(i).sort(Comparator.naturalOrder());
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();
        visited[a] = true;
        distance[a] = 0;
        queue.add(a);

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int next : adjList.get(current)) {
                if(!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }
        //7, 3(a, b) 관계의 촌수 구하기(최단거리 구하기)
        System.out.println(distance[b]);
    }
}
