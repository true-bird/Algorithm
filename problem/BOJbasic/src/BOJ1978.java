import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            if(prime(Integer.parseInt(st.nextToken()))) result++;
        }
        System.out.println(result);
    }
    static boolean prime(int n) {
        if(n==1) return false;
        for (int i = 2; i*i <=n ; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}
