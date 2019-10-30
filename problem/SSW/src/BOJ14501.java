/*
* 문제 : 퇴사
* 입력 : 일 수 N ( 1 <= N <= 15 ), 상담 기간 Ti ( 1 <= Ti <= 5 ), 금액 Pi ( <= 1,000 )
* 출력 : 최대 이익 출력
*
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {

    static int N,result;
    static int[][] sche;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sche = new int[2][N];
        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(br.readLine());
            sche[0][i] = Integer.parseInt(st.nextToken());
            sche[1][i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        System.out.println(result);
    }
    static void dfs(int x, int sum) {
        if(x>=N) { // 기간 초과 시 최대 이익 확인
            result = Math.max(result,sum);
            return;
        }
        if(x+sche[0][x]<=N) { // 가능한 상단일때만 상담
            dfs(x + sche[0][x],sum+sche[1][x]);
        }
        dfs(x+1,sum); // 상담 안하는 경우
    }
}
