import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 50 x ( 50 x 50 + 50 x 50 + 50 x 50 )
// 50 x 750 = 37500

public class BOJ17822 {

    private static int N,M,T;
    private static int[][] map;
    private static int x,d,k;

    private static void Search(boolean[][] check) {
        boolean find = false;
        int sum, cnt;
        sum = cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(map[i][j]==0) continue;
                sum += map[i][j];
                cnt++;
                if(check[i][j]) {
                    map[i][j] = 0;
                    find = true;
                }
            }
        }
        if(find) return;
        double avg = (double)sum/cnt;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(map[i][j]==0) continue;
                if(map[i][j]>avg) map[i][j]--;
                else if(map[i][j]<avg) map[i][j]++;
            }
        }
    }

    private static void Check() {
        boolean[][] check = new boolean[N+1][M+1];
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if(map[i][j] == map[i][j+1]) check[i][j] = check[i][j+1] = true;
                if(map[i+1][j] == map[i][j]) check[i+1][j] = check[i][j] = true;
            }
            if(map[i][M] == map[i][1]) check[i][M] = check[i][1] = true;
            if(map[i+1][M] == map[i][M]) check[i+1][M] = check[i][M] = true;
        }
        for (int j = 1; j < M; j++) {
            if(map[N][j] == map[N][j+1]) check[N][j] = check[N][j+1] = true;
        }
        if(map[N][M] == map[N][1]) check[N][M] = check[N][1] = true;
        Search(check);
    }

    private static void Rot(int index) {
        // 0 : 시계 방향
        // 1 : 반시계 방향
        int tmp;
        for (int n = 0; n < k; n++) {
            if(d==0) {
                tmp = map[index][M];
                for (int i = M; i > 1; i--) {
                    map[index][i] = map[index][i-1];
                }
                map[index][1] = tmp;
            } else {
                tmp = map[index][1];
                for (int i = 2; i <= M; i++) {
                    map[index][i-1] = map[index][i];
                }
                map[index][M] = tmp;
            }
        }
    }

    private static void Sim() {
        for (int i = 1; i <= N ; i++) {
            if (i % x != 0) continue;
            Rot(i);
        }
        Check();
    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // Solve
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            Sim();
        }
        // Result
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                answer += map[i][j];
            }
        }
        System.out.println(answer);
    }
}