/*
* 문제 : 뱀
* 입력 : 보드의 크기 N ( 2 <= N <= 100 ), 사과의 개수 K ( 0 <= K <= 100 ),
*  사과의 위치, 뱀의 방향 변환 횟수 L ( 1 <= L <= 100 ), 방향 변환 정보 ( X <= 10,000 [오름차순] )
* 출력 : 게임 끝나는 시간
* 풀이
* - 시뮬레이션
*   - 벽에 충돌할 때
*   - 자신과 충돌할 때
*   - 사과를 먹을 때
*   - 방향을 전환할 때
* - 머리와 꼬리 이동
*   - 머리 : 방향 전환 전까지 기존의 방향으로 이동
*   - 꼬리 : 머리의 방향 자취에 따라 이동
* - 맵 상에 머리의 다음 방향을 기록
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3190 {

    static int N,K,L;
    static int[][] map;
    static char[] dirInfo = new char[10001];
    static int result;
    static int[] dx = {1,0,-1,0}; // R 은 증가
    static int[] dy = {0,1,0,-1}; // L 은 감소

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        for (int i = 0; i <N+1 ; i++) {
            for (int j = 0; j <N+1 ; j++) {
                map[i][j] = -1;
            }
        }
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i <K ; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            map[row][col] = 4;
        }
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i <L ; i++) {
            st = new StringTokenizer(br.readLine());
            dirInfo[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
        }
        // 시뮬레이션
        int hx = 1;
        int hy = 1;
        int tx = 1;
        int ty = 1;
        int dir = 0;
        map[hy][hx] = dir;
        // 0,1,2,3 : 상하좌우
        // 4: 사과
        // -1 : 빈 곳
        while(true) {
            result++;
            hx += dx[dir];
            hy += dy[dir];
            if(hx <= 0 || hy <= 0 || hx >= N+1 || hy >= N+1) { // 벽 충돌
                break;
            }
            if(map[hy][hx]!=-1 && map[hy][hx]!=4) { // 자신과 충돌
                break;
            }

            if(map[hy][hx]==-1) { // 꼬리 이동
                int d = map[ty][tx];
                map[ty][tx] = -1;
                tx += dx[d];
                ty += dy[d];
            }
            // 방향 전환
            if(dirInfo[result]=='L') {
                dir--;
                if(dir<0) dir += 4;
            } else if(dirInfo[result]=='D') {
                dir++;
                if(dir>3) dir -= 4;
            }
            map[hy][hx] = dir; // 방향 자취 남기기
        }
        System.out.println(result);
    }
}
