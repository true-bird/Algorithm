import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2228 {

    static private int N,M;
    static private int[] arr;
    static private int[][][] dp;

    static private void InputData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N+1][M+1][2];
        arr = new int[N+1];
        for (int i = 1; i <= N; i++) arr[i]  = Integer.parseInt(br.readLine());
    }

    static private void Init() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j][0] = dp[i][j][1] = Integer.MIN_VALUE;
            }
        }
    }

    static private int Solve() {
        Init();
        dp[1][1][1] = arr[1];
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(j>(i+1)/2) break;
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]);
                dp[i][j][1] = Math.max(dp[i-1][j-1][0],dp[i-1][j][1]) + arr[i];
            }
        }
        return Math.max(dp[N][M][0],dp[N][M][1]);
    }

    public static void main(String[] args) throws IOException {
        InputData();
        System.out.println(Solve());
    }
}
