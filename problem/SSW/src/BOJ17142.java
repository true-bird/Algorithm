/*
 * 문제 : 연구소 3
 * 입력 : 연구소 크기 N ( 4 <= N <= 50 ), 놓을 수 있는 바이러스 개수 M ( 1 <= M <= 10 ), 연구소 상태
 * 출력 : 모든 빈 칸에 바이러스가 있게 되는 최소 시간
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17142 {

    static int N, M, result;
    static int zeroCnt;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Pair> combList = new ArrayList<>();
    static List<Pair> virusList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virusList.add(new Pair(j, i));
                if (map[i][j] == 0) zeroCnt++;
            }
        }
        if(zeroCnt==0) {
            System.out.println(0);
            return;
        }
        result = Integer.MAX_VALUE;
        comb(0, 0);
        if (result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);

    }

    static void comb(int cnt, int start) {
        if (cnt == M) {
            result = Math.min(result, bfs());
            return;
        }
        for (int i = start; i < virusList.size(); i++) {
            combList.add(virusList.get(i));
            comb(cnt + 1, i + 1);
            combList.remove(cnt);
        }
    }

    static int bfs() {
        boolean[][] visited = new boolean[N][N];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < combList.size(); i++) {
            Pair p = combList.get(i);
            visited[p.y][p.x] = true;
            q.add(p);
        }
        int cnt = -1;
        int zero = 0;
        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair pair = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = pair.x + dx[j];
                    int ny = pair.y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[ny][nx] || map[ny][nx] == 1) continue;
                    if (map[ny][nx]==0) zero++;
                    visited[ny][nx] = true;
                    q.add(new Pair(nx, ny));
                }
            }
            if(zero==zeroCnt) return cnt+1;
        }
        return Integer.MAX_VALUE;
    }


    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
