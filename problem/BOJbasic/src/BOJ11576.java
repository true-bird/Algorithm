import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int dec = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <m ; i++) {
            int n = Integer.parseInt(st.nextToken());
            dec += n*(int)Math.pow(A,m-1-i);
        }
        while(dec!=0) {
            sb.insert(0," "+dec%B);
            dec /= B;
        }
        System.out.println(sb.toString().trim());
    }
}
