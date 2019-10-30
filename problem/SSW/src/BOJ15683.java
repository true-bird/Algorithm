/*
 * 문제 : 감시
 * 입력 : 사무실의 크기 N,M ( 1 <= N,M <= 8 ), 사무실 칸의 정보
 * 출력 : 사각 지대의 최소 크기
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15683 {

    static int N, M;
    static int result = Integer.MAX_VALUE;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static List<CCTV> cctvList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cctvList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) cctvList.add(new CCTV(j, i, map[i][j]));
            }
        }
        dfs(0,map);
        System.out.println(result);
    }

    static void dfs(int cnt, int[][] map) {
        if (cnt == cctvList.size()) {
            int sum = 0;
            for (int i = 0; i <N ; i++) {
                for (int j = 0; j <M ; j++) {
                    if(map[i][j]==0) sum++;
                }
            }
            result = Math.min(sum,result);
            return;
        }

        int[][] tmp = new int[N][M];
        CCTV cctv = cctvList.get(cnt);
        if (cctv.num == 1) {
            for (int i = 0; i <4 ; i++) {
                for (int j = 0; j <N ; j++) {
                    tmp[j] = map[j].clone();
                }
                obser(cctv.x,cctv.y,i,tmp);
                dfs(cnt+1,tmp);
            }
        } else if(cctv.num == 2) {
            for (int i = 0; i <2 ; i++) {
                for (int j = 0; j <N ; j++) {
                    tmp[j] = map[j].clone();
                }
                if(i==0) {
                    obser(cctv.x,cctv.y,0,tmp);
                    obser(cctv.x,cctv.y,2,tmp);
                } else {
                    obser(cctv.x,cctv.y,1,tmp);
                    obser(cctv.x,cctv.y,3,tmp);
                }
                dfs(cnt+1,tmp);
            }
        } else if(cctv.num == 3) {
            for (int i = 0; i <4 ; i++) {
                for (int j = 0; j <N ; j++) {
                    tmp[j] = map[j].clone();
                }
                if(i==0) {
                    obser(cctv.x,cctv.y,0,tmp);
                    obser(cctv.x,cctv.y,1,tmp);
                } else if(i==1) {
                    obser(cctv.x,cctv.y,1,tmp);
                    obser(cctv.x,cctv.y,2,tmp);
                } else if(i==2) {
                    obser(cctv.x,cctv.y,2,tmp);
                    obser(cctv.x,cctv.y,3,tmp);
                } else if(i==3) {
                    obser(cctv.x,cctv.y,3,tmp);
                    obser(cctv.x,cctv.y,0,tmp);
                }
                dfs(cnt+1,tmp);
            }
        } else if(cctv.num == 4) {
            for (int i = 0; i <4 ; i++) {
                for (int j = 0; j <N ; j++) {
                    tmp[j] = map[j].clone();
                }
                if(i==0) {
                    obser(cctv.x,cctv.y,0,tmp);
                    obser(cctv.x,cctv.y,1,tmp);
                    obser(cctv.x,cctv.y,2,tmp);
                } else if(i==1) {
                    obser(cctv.x,cctv.y,1,tmp);
                    obser(cctv.x,cctv.y,2,tmp);
                    obser(cctv.x,cctv.y,3,tmp);
                } else if(i==2) {
                    obser(cctv.x,cctv.y,2,tmp);
                    obser(cctv.x,cctv.y,3,tmp);
                    obser(cctv.x,cctv.y,0,tmp);
                } else if(i==3) {
                    obser(cctv.x,cctv.y,3,tmp);
                    obser(cctv.x,cctv.y,0,tmp);
                    obser(cctv.x,cctv.y,1,tmp);
                }
                dfs(cnt+1,tmp);
            }
        } else if(cctv.num == 5) {
            for (int j = 0; j <N ; j++) {
                tmp[j] = map[j].clone();
            }
            obser(cctv.x,cctv.y,0,tmp);
            obser(cctv.x,cctv.y,1,tmp);
            obser(cctv.x,cctv.y,2,tmp);
            obser(cctv.x,cctv.y,3,tmp);
            dfs(cnt+1,tmp);
        }

    }

    static void obser(int x,int y,int dir, int[][] map) {
        if (dir == 0) { // 우
            for (int i = x+1; i <M ; i++) {
                if(map[y][i]==0) map[y][i] = -1;
                if(map[y][i]==6) break;
            }
        } else if (dir == 1) { // 하
            for (int i = y+1; i <N ; i++) {
                if(map[i][x]==0) map[i][x] = -1;
                if(map[i][x]==6) break;
            }
        } else if (dir == 2) { // 좌
            for (int i = x-1; i >=0 ; i--) {
                if(map[y][i]==0) map[y][i] = -1;
                if(map[y][i]==6) break;
            }
        } else if (dir == 3) { // 하
            for (int i = y-1; i >=0 ; i--) {
                if(map[i][x]==0) map[i][x] = -1;
                if(map[i][x]==6) break;
            }
        }
    }

    static class CCTV {
        int x, y, num;

        CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
