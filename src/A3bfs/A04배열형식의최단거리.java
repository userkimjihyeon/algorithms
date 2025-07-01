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

        //distance 2차원 배열 생성 후 -1로 깔기(기본값 0이므로 생략가능)
        int[][] distance = new int[n][m];
        for(int[] row : distance) {
            Arrays.fill(row, -1);
        }

        // 상, 하, 좌, 우
        int[] dx = {-1, 1, 0, 0};   //행 이동
        int[] dy = {0, 0, -1, 1};   //열 이동

        //큐에 distance를 달고다니기,,,,?
        Queue<int[]> myQueue = new LinkedList<>();
        myQueue.add(new int[]{0,0});
        distance[0][0] = 1;     //시작(0,0)을 1칸으로 카운팅

        while(!myQueue.isEmpty()) {
            int[] cur = myQueue.poll();      //myQueue -> temp에 넣기
            int x = cur[0];
            int y = cur[1];

            //반복문 돌면서 현재 cur에서 상하좌우 이동 -> nx,ny 세팅 -> map 범위이내여부 확인 -> 벽 0(map)여부, 방문 -1(distance)여부
            for(int i=0; i<4; i++) {
                int nx = x + dx[i]; //현재행 + 이동범위
                int ny = y + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;             //이동할 곳이 map의 범위를 벗어나면 다음 반복문으로 이동
                if(maps[nx][ny]==0 || distance[nx][ny]!=-1) continue;    //이동할 곳에 0이 있거나(=벽), 거리가 -1이 아니면(=이미방문) 다음 반복문으로 이동

                distance[nx][ny] = distance[x][y]+1;
                myQueue.add(new int[]{nx, ny});
            }
        }
        return distance[n-1][m-1];
    }
}
