/*
* 문제 : 시험 감독
* 입력 : 시험장 개수 ( 1 <= N <= 1,000,000 ), 응시자 수 ( 1 <= Ai <= 1,000,000 ),
* 총 감독관 감시 응시자 수 B, 부감독관 감시 응시자 수 C ( 1 <= B,C <= 1,000,000 )
* 출력 : 필요 감독관 최소 수
*
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13458 {

    static int N, B, C;
    static int[] room;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        room = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            room[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            if (room[i] == 0) continue;
            result++;
            if (room[i] > B) {
                result += (room[i] - B) / C;
                if ((room[i] - B) % C != 0) result++;
            }
        }

        System.out.println(result);
    }
}
