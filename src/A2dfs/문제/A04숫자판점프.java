package A2dfs.문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class A04숫자판점프 {
    //전역변수
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] arr = new int[5][5];
    static Set<String> staticSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
//    백준 : 숫자판 점프 (DFS, 상하좌우, 중복제거set)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<5; i++){
            String[] temp = br.readLine().split(" ");
            for (int j=0; j<5; j++){
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                dfs(String.valueOf(arr[i][j]), i, j);
            }
        }
        System.out.println(staticSet.size());
    }
    static void dfs(String temp, int x, int y){
//        문자의길이가 6이 되었을때 set에 add
        if(temp.length()==6){
            staticSet.add(temp);
            return;
        }
//        상하좌우 검사후에 dfs()호출
        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<5 && ny>=0 && ny<5){
                dfs(temp+arr[nx][ny], nx, ny);
            }
        }

    }

}
