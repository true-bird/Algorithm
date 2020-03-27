import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17779 {

    private static int N,total;
    private static int[][] map;
    private static int[][] sum;

    private static int Cal(int x, int y, int d1, int d2) {
        int[] cnt = new int[6];
        // 1번 선거구
        for (int i = 1; i <=d1; i++) {
            cnt[1] += sum[y-i][x+i-1];
        }
        for (int i = 1; i < y-d1 ; i++) {
            cnt[1] += sum[i][x+d1];
        }
        // 3번 선거구
        for (int i = 0; i <=d2; i++) {
            cnt[3] += sum[y+i][x+i-1];
        }
        for (int i = y+d2+1; i <= N; i++) {
            cnt[3] += sum[i][x+d2-1];    
        }
        // 2번 선거구
        for (int i = 1; i <y-d1 ; i++) {
            cnt[2] += sum[i][N] - sum[i][x+d1];    
        }
        for (int i = 0; i <=d2; i++) {
            cnt[2] += sum[y-d1+i][N] - sum[y-d1+i][x+d1+i];
        }
        // 4번 선거구
        for (int i = y+d2+1; i <=N ; i++) {
            cnt[4] += sum[i][N] - sum[i][x+d2-1];
        }
        for (int i = 0; i <d1; i++) {
            cnt[4] += sum[y+d2-i][N] - sum[y+d2-i][x+d2+i];
        }
        cnt[5] = total - cnt[1] - cnt[2] - cnt[3] - cnt[4];
        Arrays.sort(cnt);
        return cnt[5]-cnt[1];
    }

    private static int Solve() {
        // Divide
        int min = Integer.MAX_VALUE;
        for (int y = 2; y <= N-1; y++) {
            for (int x = 1; x <= N-2; x++) {
                for (int d1 = 1; d1 < N; d1++) {
                    if(y - d1 < 1 || x + d1 >= N) break;
                    for (int d2 = 1; d2 < N; d2++) {
                        if(y + d2 > N || x + d1+ d2 > N) break;
                        int tmp = Cal(x,y,d1,d2);
                        if(tmp<min) min =  tmp;
                    }
                }
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N+2][N+2];
        sum = new int[N+2][N+2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i][j-1] + map[i][j];
                total += map[i][j];
            }
        }
        System.out.println(Solve());
    }
}
