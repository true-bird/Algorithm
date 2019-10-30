/*
* 문제 : 미세먼지 안녕!
* 입력 : 집의 크기 R,C ( 6 <= R,C <= 50 ), 목표 시간 T ( 1 <= T <= 1,000 ), 미세먼지 및 공기 청정기 위치 정보
* 출력 : T초 후 남아있는 미세먼지 양
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17144 {

    static int R,C,T,result;
    static int[][] map;
    static int[][] tmp;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[] cPos = new int[2];


    public static void main(String[] args) throws IOException {
        BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0,cnt = 0; i <R ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <C ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==-1) {
                    cPos[cnt] = i;
                    cnt ++;
                }
            }
        }
        while(T-->0) {
            dust();
            cleaner();
        }
        for (int i = 0; i <R ; i++) {
            for (int j = 0; j <C ; j++) {
                if(map[i][j]>0) result+= map[i][j];
            }
        }
        System.out.println(result);
    }
    static void cleaner() {
        for (int i = cPos[0]-2; i >=0 ; i--) {
            map[i+1][0] = map[i][0];
        }
        for (int i = cPos[1]+2; i <R ; i++) {
            map[i-1][0] = map[i][0];
        }
        
        for (int i = 1; i <=C-1 ; i++) {
            map[0][i-1] = map[0][i];
            map[R-1][i-1] = map[R-1][i];
        }

        for (int i =1; i <=cPos[0] ; i++) {
            map[i-1][C-1] = map[i][C-1];
        }
        for (int i = R-2; i >=cPos[1]; i--) {
            map[i+1][C-1] = map[i][C-1];
        }

        for (int i = C-2; i >0 ; i--) {
            map[cPos[0]][i+1] = map[cPos[0]][i];
            map[cPos[1]][i+1] = map[cPos[1]][i];
        }

        map[cPos[0]][1] = 0;
        map[cPos[1]][1] = 0;

    }

    static void dust() {

        tmp = new int[R][C];
        for (int i = 0; i <R ; i++) {
            for (int j = 0; j <C ; j++) {
                if(map[i][j]>0) diffusion(j,i);
            }
        }
        for (int i = 0; i <R ; i++) {
            for (int j = 0; j <C ; j++) {
                map[i][j] += tmp[i][j];
            }
        }
    }

    static void diffusion(int x, int y) {
        int cnt = 0;
        for (int i = 0; i <4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny <0 || nx >= C || ny >= R || map[ny][nx]==-1) continue;
            cnt++;
            tmp[ny][nx] += map[y][x]/5;
        }
        map[y][x] -= (map[y][x]/5)*cnt;
    }

}
