import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] diff = new int[n];
        int result = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n ; i++) {
            diff[i] = Math.abs(Integer.parseInt(st.nextToken())-s);
            result = gcd(diff[i],result);
        }
        System.out.println(result);
    }
    static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
