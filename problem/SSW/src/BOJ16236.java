/*
 * 문제 : 아기상어
 * 입력 : 공간의 크기 N ( 2 <= N <= 20 ), 공간의 상태
 * 출력 : 물고기를 잡아 먹을 수 있는 시간
 *
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16236 {

    static int N, result;
    static int minDis,minY,minX;
    static int curPx, curPy, curCnt;
    static int curLev = 2;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    curPx = j;
                    curPy = i;
                }
            }
        }

        while (true) {
            // 탐색
            minDis = Integer.MAX_VALUE;
            bfs();
            // 스왑
            if (minDis != Integer.MAX_VALUE) {
                map[curPy][curPx] = 0;
                curPy = minY;
                curPx = minX;
                map[curPy][curPx] = 9;
                curCnt++;
                if (curCnt >= curLev) {
                    curLev++;
                    curCnt = 0;
                }
                result += minDis;
            } else {
                break;
            }
        }
        System.out.println(result);


    }

    static void bfs() {
        int cnt = 0;
        boolean[][] visited = new boolean[N][N];
        List<Pair> list = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        visited[curPy][curPx] = true;
        q.add(new Pair(curPx, curPy));
        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair pair = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = pair.x + dx[j];
                    int ny = pair.y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[ny][nx]) continue;
                    if (map[ny][nx] > curLev) continue;
                    visited[ny][nx] = true;
                    if (map[ny][nx]>0 && map[ny][nx] < curLev) {
                        list.add(new Pair(nx,ny));
                    }
                    q.add(new Pair(nx, ny));
                }
            }
            if(!list.isEmpty()) {
                minDis = cnt;
                minX = list.get(0).x;
                minY = list.get(0).y;
                for (int i = 1; i <list.size() ; i++) {
                    if (minY > list.get(i).y) {
                        minY = list.get(i).y;
                        minX = list.get(i).x;
                    } else if (minY == list.get(i).y) {
                        if (minX > list.get(i).x) {
                            minX = list.get(i).x;
                        }
                    }
                }
                return;
            }
        }
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
