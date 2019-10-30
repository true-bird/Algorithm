/*
* 문제 : 사다리 조작
* 입력 : 세로선의 개수 N, 가로선의 개수 M, 가로선을 놓을 수 있는 위치의 개수 H ( 2 <= N <= 10, 1 <= H <= 30, 0 <= M <= (N-1)xH )
*   가로선의 정보 a,, b ( 1 <= a <= H, 1 <= b <= N-1 )
* 출력 : i번의 세로선의 결과가 i번이 나오도록 하기 위한 가로선의 최소 갯수
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15684 {

    static int N,M,H,result;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H+1][N+1];
        if(M>0) {
            for (int i = 0; i <M ; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1; // 오른쪽으로
                map[a][b+1] = -1; // 왼쪽으로
            }
        }
        // 조합
        while(!dfs(1,1,0)) {
            result++;
            if(result>3) {
                result = -1;
                break;
            }
        }
        System.out.println(result);
    }
    static boolean dfs(int x, int y, int cnt) {
        if(cnt==result) {
            if(sim()) return true;
            else return false;
        }
        for (int i = y; i <=H ; i++) {
            for (int j = x; j <N ; j++) {
                if(map[i][j]!=0 || map[i][j+1]!=0) continue;
                map[i][j] = 1;
                map[i][j+1] = -1;
                if(dfs(j,i,cnt+1)) return true;
                map[i][j] = 0;
                map[i][j+1] = 0;
            }
            x = 1;
        }
        return false;
    }
    // 시뮬레이션
    static boolean sim() {
        for (int i = 1; i <=N ; i++) {
            int x = i;
            for (int j = 1; j <=H ; j++) {
                if(map[j][x]==1) x++;
                else if(map[j][x]==-1) x--;
            }
            if(x!=i) return false;
        }
        return true;
    }
}
