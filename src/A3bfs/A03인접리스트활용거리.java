package A3bfs;

import java.util.*;

//        프로그래머스 : 가장먼노드
//        ⭐과제 - 백준 : 촌수계산
public class A03인접리스트활용거리 {
    static List<List<Integer>> adjList;

    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = { {3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2} };

        int result = solution(n, vertex);
        System.out.println(result);  // 정답: 3
    }

    static public int solution(int n, int[][] edge) {
        adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        // 정점 번호순 방문 정렬 (옵션)
        for (int i = 1; i <= n; i++) {
            adjList.get(i).sort(Comparator.naturalOrder());
        }

        // 거리 배열 -1로 초기화
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);  // 방문안한곳은 -1로 깔아두기

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        distance[1] = 0;  // 시작 노드 거리 = 0

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : adjList.get(current)) {
                if (distance[next] == -1) {  // 아직 방문 안 했으면
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }

        // 최댓값 거리 찾기
        int max = Arrays.stream(distance).max().getAsInt();

        // 최댓값과 같은 거리의 노드 개수 세기
        int answer = 0;
        for (int d : distance) {
            if (d == max) answer++;
        }

        return answer;
    }
}