/*
* 문제 : 로봇 청소기
* 입력 : 가로 세로 크기 N,M ( 3 <= N,M <= 50 ), 청소기 좌표 r,c, 방향 d, 장소 상태
* 출력 : 청소가는 칸의 개수
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {

    static int N,M,r,c,d,result;
    static int[][] map;
    static boolean[][] visited;
    static boolean flag;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sim(r,c,d);
        System.out.println(result);
    }

    static void sim(int y, int x, int d) {
        if(!visited[y][x]) {
            visited[y][x] = true;
            result++;
        }
        for (int i = 1; i <=4 ; i++) {
            int nd = (d-i)<0? d+4-i : d-i;
            int nx = x + dx[nd];
            int ny = y + dy[nd];
            if(nx<0 || ny<0 || nx>= M || ny>= N || visited[ny][nx]) continue;
            if(map[ny][nx]==0) {
                sim(ny,nx,nd);
            }
            if(flag) return;
        }
        int nd = (d-2)<0? d+2 : d-2;
        int nx = x + dx[nd];
        int ny = y + dy[nd];
        if(nx<0 || ny<0 || nx>= M || ny>= N || map[ny][nx]==1) {
            flag = true;
            return;
        }
        sim(ny,nx,d);
    }
}
