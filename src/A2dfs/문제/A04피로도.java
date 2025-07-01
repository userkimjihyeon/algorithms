package A2dfs.문제;

import java.util.Map;

public class A04피로도 {
    static boolean[] visited;
    static int max;

    public static void main(String[] args) {
        //각 던전마다 필요한 "최소 필요 피로도"
        //던전탐험 후 "소모 피로도"
        //하루에 1번씩 탐험가능
        //유저가 탐헐할 수 있는 최대던전수 구하기

        int k = 80;             //현재 피로도
        int[][] dungeons = {    //[최소필요피로도][소모피로도]
                {80, 20},
                {50, 40},
                {30, 10}
        };

        visited = new boolean[dungeons.length];
        int depth = 0;
        dfs(dungeons, k, depth);

        //최소필요피로도가 높은거 순서대로 탐험 및 소모피로도가 낮은거 순서대로
        //두개가 충돌되면,,,,,??
        //dfs...깊이우선탐색.... 어떤기준으로...탐색할까..
        //일단 첫번째꺼부터 돌고! 그 다음에 두번째꺼 돌고 세번째꺼 돌수 있는지??? max에 저장
        //1 -> 3 -> 2 돌수있는지? max에 저장.........
    }
    static void dfs(int[][] dungeons, int k, int depth) {
        max = Math.max(max, depth);

        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, k-dungeons[i][1], depth+1);

            }
        }
    }
}
