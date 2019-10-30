/*
* 문제 : 연산자 끼워넣기
* 입력 : 수의 개수 N ( 2 <= N <= 11 ), 수열 Ai ( 1 <= Ai <= 100 ), N-1개의 연산자의 개수
* 출력 : 최댓값, 최솟값
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {

    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] opCnt = new int[4];
    static int[] seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N ; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <4 ; i++) {
            opCnt[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,seq[0]);
        System.out.println(max);
        System.out.println(min);
    }
    static void dfs(int cnt, int result) {
        if(cnt==N-1) {
            max = Math.max(max,result);
            min = Math.min(min,result);
            return;
        }
        for (int i = 0; i <4 ; i++) {
            if(opCnt[i]==0) continue;
            opCnt[i]--;
            if(i==0) {
                dfs(cnt+1,result+seq[cnt+1]);
            } else if(i==1) {
                dfs(cnt+1,result-seq[cnt+1]);
            } else if(i==2) {
                dfs(cnt+1,result*seq[cnt+1]);
            } else if(i==3) {
                dfs(cnt+1,result/seq[cnt+1]);
            }
            opCnt[i]++;
        }
    }
}
