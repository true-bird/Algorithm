// 스티커 붙이기
// 가장 위, 가장 왼쪽
// 90 도 회전

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18808 {

    private static int N,M,K,cnt;
    private static int R,C;
    private static int[][] notebook;
    private static int[][][] stickers;

    private static boolean Check(int sr, int sc, int[][] tmp) {
        for (int i = 0; i <tmp.length; i++) {
            for (int j = 0; j <tmp[0].length ; j++) {
                if((notebook[sr+i][sc+j] & tmp[i][j])==1) return false;
            }
        }
        for (int i = 0; i <tmp.length; i++) {
            for (int j = 0; j <tmp[0].length ; j++) {
                notebook[sr+i][sc+j] |= tmp[i][j];
            }
        }
        return true;
    }

    private static int[][] Rot(int[][] tmp) {
        int[][] rot = new int[tmp[0].length][tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                rot[j][tmp.length-1-i] = tmp[i][j];
            }
        }
        return rot;
    }

    private static boolean Search(int[][] tmp) {
        int r = tmp.length;
        int c = tmp[0].length;
        if(r > N || c > M) return false;
        for (int i = 0; i <= N-r; i++) {
            for (int j = 0; j <= M-c; j++) {
                if(Check(i,j,tmp)) return true;
            }
        }
        return false;
    }

    private static void Simul(int[][] sticker) {
        int[][] tmp = sticker;
        if(Search(tmp)) return;
        for (int i = 0; i < 3; i++) {
            int[][] rTmp = Rot(tmp);
            if(Search(rTmp)) return;
            tmp = rTmp;
        }
    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        notebook = new int[N][M];
        stickers = new int[K][][];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            stickers[i] = new int[R][C];
            for (int j = 0; j < R; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < C; k++) {
                    stickers[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        // Solve
        for (int i = 0; i < K; i++) {
            Simul(stickers[i]);
        }
        // Result
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (notebook[i][j] == 1) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
