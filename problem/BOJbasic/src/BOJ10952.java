import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a,b;
        while(((a = Integer.parseInt(st.nextToken())) != 0)  && ((b = Integer.parseInt(st.nextToken())) != 0)) {
            sb.append(a+b).append("\n");
            st = new StringTokenizer(br.readLine());
        }
        System.out.println(sb.toString());
    }
}
