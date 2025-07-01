package A2dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//        백준 : 트리의 부모찾기(11725)
public class A03트리관련 {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        adjList = new ArrayList<>();
        visited = new boolean[n+1];     //정점이 1부터 시작
        for(int i=0; i<=n; i++) {       //정점이 1부터 시작
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++) {      //인접리스트 개수 : 정점(X) 간선(O)
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        //[[], [6, 4], [4], [6, 5], [1, 2, 7], [3], [1, 3], [4]]

//        정렬
//        for(int i=0; i<adjList.size(); i++) {
//            adjList.get(i).sort(Comparator.naturalOrder());
//        }

        parent = new int[n+1];
        dfs(1);
        for(int i=2; i<parent.length; i++) {
            System.out.println(parent[i]);      //parent[2번 인덱스]부터 출력
        }
    }

    static void dfs(int start) {
        visited[start] = true;

        for(int a : adjList.get(start)) {
            if(!visited[a]) {
                parent[a] = start;          //parent[자식 인덱스]에 부모노드 담기
                dfs(a);
            }
        }
    }
}
