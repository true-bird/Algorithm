import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = 0,b = 1; i <N.length() ; i++) {
            char num = N.charAt(N.length()-1-i);
            if(num<='9') result += (num-'0')*b;
            else result += (num-55)*b;
            b *= B;
        }
        System.out.println(result);
    }
}
