/*
* 문제 : 경사로
* 입력 : 지도의 크기 N ( 2 <= N <= 100 ), 경사로의 길의 L ( 1 <= L <= N ), 지도 ( 높이 <= 10 )
* 출력 : 지나갈 수 있는 길의 개수
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14890 {

    static int N,L,result;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <N ; i++) {
            int j = 0;
            int empty = 0;
            int pre = map[i][0];
            while(j<N) {
                if(Math.abs(pre-map[i][j])>1) break;
                if(pre==map[i][j]) {
                    empty++;
                } else if(pre+1==map[i][j]) {
                    if(empty<L) break;
                    empty = 1;
                } else if(pre-1==map[i][j]) {
                    int cnt = 0;
                    while(j<N && map[i][j]==pre-1) {
                        cnt++;
                        j++;
                    }
                    j--;
                    if(cnt<L) break;
                    empty = cnt - L;
                }
                pre = map[i][j];
                j++;
            }
            if(j==N) result++;

            empty = 0;
            j = 0;
            pre = map[0][i];
            while(j<N) {
                if(Math.abs(pre-map[j][i])>1) break;
                if(pre==map[j][i]) {
                    empty++;
                } else if(pre+1==map[j][i]) {
                    if(empty<L) break;
                    empty = 1;
                } else if(pre-1==map[j][i]) {
                    int cnt = 0;
                    while(j<N && map[j][i]==pre-1) {
                        cnt++;
                        j++;
                    }
                    j--;
                    if(cnt<L) break;
                    empty = cnt - L;
                }
                pre = map[j][i];
                j++;
            }
            if(j==N) {
                result++;
            }
        }
        System.out.println(result);
    }
}
