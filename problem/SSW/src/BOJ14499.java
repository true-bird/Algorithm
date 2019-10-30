/*
* 문제 : 주사위 굴리기
* 입력 : 지도 크기 N,M ( 1 <= N,M <= 20 ), 주사위 놓을 좌표 x,y ( <= N-1,M-1 ), 명령의 개수 ( 1 <= K <= 1,000 )
* 출력 : 주사위 윗 면에 쓰여 있는 수 ( 바깥 이동은 무시 )
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14499 {

    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice = {0, 0, 0, 0, 0, 0};
    static int[] col = {2, 3};
    static int[] row = {1, 4};
    static int[] cur = {5, 0};
    static int[] dx = {0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int dir = Integer.parseInt(st.nextToken());
            if (x + dx[dir] < 0 || y + dy[dir] < 0 || x + dx[dir] >= M || y + dy[dir] >= N) continue;
            x += dx[dir];
            y += dy[dir];
            if (dir == 1) {
                int[] tmpCol = {cur[1], cur[0]};
                cur = col.clone();
                col = tmpCol;
            } else if (dir == 2) {
                int[] tmpCur = {col[1], col[0]};
                col = cur.clone();
                cur = tmpCur;
            } else if (dir == 3) {
                int[] tmpCol = {cur[1], cur[0]};
                cur = row.clone();
                row = tmpCol;
            } else if (dir == 4) {
                int[] tmpCur = {row[1], row[0]};
                row = cur.clone();
                cur = tmpCur;
            }
            if (map[y][x] == 0) {
                map[y][x] = dice[cur[0]];
            } else {
                dice[cur[0]] = map[y][x];
                map[y][x] = 0;
            }
            System.out.println(dice[cur[1]]);
        }


    }
}
