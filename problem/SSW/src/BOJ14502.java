/*
* 문제 : 연구소
* 입력 : 지도의 크기 N,M ( 3 <= N,M <= 8 ), 지도의 모양 ( 2 <= 바이러스 수 <= 10 , 3<= 빈칸의 수 )
* 출력 : 안전 영역의 최대 크기
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14502 {

    static int N,M,result;
    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static int wallCount;
    static int visitedCount;
    static List<Pair> list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();
        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) wallCount++;
                if(map[i][j]==2) list.add(new Pair(j,i));
            }
        }
        comb(0,0,0);
        System.out.println(result);
    }
    static void comb(int cnt, int x, int y) {
        if(cnt==3) {
            visitedCount = 0;
            visited = new boolean[N][M];
            for (int i = 0; i <list.size() ; i++) {
                Pair pair = list.get(i);
                dfs(pair.x,pair.y);
            }
            int safe = (N*M)-wallCount-3-list.size()-visitedCount;
            result = Math.max(result,safe);
            return;
        }

        for (int i = y; i <N ; i++) {
            for (int j = x; j <M ; j++) {
                if(map[i][j]==0) {
                    map[i][j] = 1;
                    comb(cnt+1,j,i);
                    map[i][j] = 0;
                }
            }
            x = 0;
        }
    }

    static void dfs(int x, int y) {
        for (int i = 0; i <4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx >= M || ny >= N || visited[ny][nx]) continue;
            if(map[ny][nx]==0) {
                visited[ny][nx] = true;
                visitedCount++;
                dfs(nx,ny);
            }
        }
    }

    static class Pair {
        int x,y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
