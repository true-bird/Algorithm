import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17837 {

    private static int N,K;
    private static int[][] board;
    private static int[][][] map;
    private static Chess[] chess;
    private static int[] dx = {0,1,-1,0,0};
    private static int[] dy = {0,0,0,-1,1};

    private static void Reverse(int[] pos, int idx) {
        for (int i = 1; i <= pos[0]; i++) {
            if(pos[i] == idx) {
                int l = i;
                int r = pos[0];
                while(l<r) {
                    int tmp = pos[l];
                    pos[l] = pos[r];
                    pos[r] = tmp;
                    l++;
                    r--;
                }
                return;
            }
        }
    }

    private static boolean Move(int[] pos, int idx, int nx, int ny) {
        for (int i = 1; i <= pos[0]; i++) {
            if(pos[i] == idx) {
                if(map[ny][nx][0]+(pos[0]-i+1)>=4) return false;
                for (int j = i; j <= pos[0]; j++) {
                    chess[pos[j]].x = nx;
                    chess[pos[j]].y = ny;
                    map[ny][nx][++map[ny][nx][0]] = pos[j];
                }
                pos[0] = i-1;
                return true;
            }
        }
        return false;
    }

    private static int Solve() {
        int cnt = 0;
        while(cnt<=1000) {
            cnt++;
            for (int i = 1; i <= K; i++) {
                int nx = chess[i].x + dx[chess[i].dir];
                int ny = chess[i].y + dy[chess[i].dir];
                if(nx <= 0 || ny <= 0 || nx > N || ny > N || board[ny][nx]==2) {
                    if(chess[i].dir%2==0) chess[i].dir--;
                    else chess[i].dir++;
                    nx = chess[i].x + dx[chess[i].dir];
                    ny = chess[i].y + dy[chess[i].dir];
                    if(nx <= 0 || ny <= 0 || nx > N || ny > N || board[ny][nx]==2) continue;
                }
                if(!Move(map[chess[i].y][chess[i].x],i,nx,ny)) return cnt;
                if(board[ny][nx]==1) Reverse(map[chess[i].y][chess[i].x],i);
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N+1][N+1];
        map = new int[N+1][N+1][5];
        chess = new Chess[K+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            chess[i] = new Chess(x, y, dir);
            map[y][x][0] = 1;
            map[y][x][1] = i;
        }
        // Solve
        System.out.println(Solve());
    }

    private static class Chess {
        int x,y,dir;
        private Chess(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
