// Gaaaaaaaaaarden
// 동일한 시간 동일한 땅
// 0 : 호수, 1 : 불가능, 2 : 가능

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18809 {

    private static int N,M,G,R,max;
    private static int[][] map;
    private static int[][][] visited;
    private static int[] sel;
    private static ArrayList<Pair> lands = new ArrayList<>();
    private static Queue<Culture> q = new LinkedList<>();
    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};

    private static int BFS() {
        int flowerCnt = 0;
        int cnt = 1;
        visited = new int[N][M][2];
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Culture tmp = q.poll();
                if(visited[tmp.y][tmp.x][0]>=3) continue;
                visited[tmp.y][tmp.x][0] = 3;
                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                    if(map[ny][nx]==0 || visited[ny][nx][0]>=3 || visited[ny][nx][0]==tmp.col) continue;
                    if((tmp.col*visited[ny][nx][0])==2) {
                        if(visited[ny][nx][1]==cnt) {
                            visited[ny][nx][0] = 4;
                            flowerCnt++;
                        }
                        continue;
                    }
                    visited[ny][nx][0] = tmp.col;
                    visited[ny][nx][1] = cnt;
                    q.add(new Culture(nx,ny,tmp.col));
                }
            }
            cnt++;
        }
        return flowerCnt;
    }

    private static void Sel(int index, int g, int r) {
        if(g==G && r==R) {
            for (int i = 0; i < lands.size(); i++) {
                if(sel[i]==0) continue;
                q.add(new Culture(lands.get(i).x,lands.get(i).y,sel[i]));
            }
            int tmp = BFS();
            max = Math.max(max,tmp);
            return;
        }
        if(index==lands.size()) return;
        // pass
        Sel(index+1,g,r);
        // g
        if(g<G) {
            sel[index] = 1;
            Sel(index+1,g+1,r);
            sel[index] = 0;
        }
        // r
        if(r<R) {
            sel[index] = 2;
            Sel(index+1,g,r+1);
            sel[index] = 0;
        }

    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) lands.add(new Pair(j, i));
            }
        }
        // Solve
        sel = new int[lands.size()];
        Sel(0, 0, 0);
        System.out.println(max);
    }

    private static class Culture {
        int x,y,col;
        private Culture(int x, int y, int col) {
            this.x = x;
            this.y = y;
            this.col = col;
        }
    }

    private static class Pair {
        int x,y;
        private Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
