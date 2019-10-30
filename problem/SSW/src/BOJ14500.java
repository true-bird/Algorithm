import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 문제 : 테트로미노
* 입력 : 종이의 세로, 가로 크기 N,M ( 4 <= N,M <= 500 ), 종이에 쓰여진 정수 ( <= 1,000 )
* 출력 : 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값
*
* */
public class BOJ14500 {

    static int N,M;
    static int[][] map;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <M ; j++) {
                if(i+1<N && j+1 < M) {
                    int sum = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+1][j+1];
                    result = Math.max(result,sum);
                }

                if(j+3<M) {
                    int sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
                    result = Math.max(result,sum);
                }
                if(i+3<N) {
                    int sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
                    result = Math.max(result,sum);
                }

                if(i+2<N && j+1<M) {
                    result = Math.max(result,map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1]);
                    result = Math.max(result,map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+2][j]);

                    result = Math.max(result,map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1]);
                    result = Math.max(result,map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+1][j]);

                    result = Math.max(result,map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1]);
                    result = Math.max(result,map[i][j] + map[i+1][j] + map[i+2][j] + map[i][j+1]);
                    result = Math.max(result,map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i][j]);
                    result = Math.max(result,map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+2][j]);
                }
                if(i+1<N && j+2<M) {
                    result = Math.max(result,map[i][j+1] + map[i][j+2] + map[i+1][j] + map[i+1][j+1]);
                    result = Math.max(result,map[i][j+1] + map[i][j] + map[i+1][j+2] + map[i+1][j+1]);

                    result = Math.max(result,map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1]);
                    result = Math.max(result,map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+1]);

                    result = Math.max(result,map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j]);
                    result = Math.max(result,map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+2]);
                    result = Math.max(result,map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+2]);
                    result = Math.max(result,map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j]);
                }
            }
        }

        System.out.println(result);

    }
}
