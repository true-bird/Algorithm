import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        while(N!=0) {
            int n = N%B;
            if(n>=10) sb.append((char)(n+55));
            else sb.append(n);
            N /= B;
        }
        System.out.println(sb.reverse().toString());
    }
}
