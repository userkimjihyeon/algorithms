package A3bfs;

import java.util.*;

//프로그래머스 : 게임 맵 최단거리
public class A04배열형식의최단거리 {
    public static void main(String[] args) {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}};

        int result = bfs(maps);
        System.out.println(result);
    }

    static int bfs(int[][] maps) {
        //(n,m) 도착지
        int n = maps.length;        //행 길이
        int m = maps[0].length;     //열 길이

        int[][] distance = new int[n][m];
        for(int[] row : distance) {
            Arrays.fill(row, -1);
        }

        // 상, 하, 좌, 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        //큐에 distance를 달고다니기,,,,?
        Queue<int[]> myQueue = new LinkedList<>();
        myQueue.add(new int[]{0,0});                     //myQueue : 0,
        distance[0][0] = 1;

        while(!myQueue.isEmpty()) {
            int[] cur = myQueue.poll();      //myQueue -> temp에 넣기
            int x = cur[0];
            int y = cur[1];

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<0||nx>=n||ny<0||ny>=m) continue;
                if(maps[nx][ny]==0||distance[nx][ny]!=1) continue;

                distance[nx][ny] = distance[x][y]+1;
                myQueue.add(new int[]{nx, ny});
            }
        }
        return distance[n-1][m-1];
    }
}
