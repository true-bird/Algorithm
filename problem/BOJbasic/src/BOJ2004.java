import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int twoSum = 0;
        int fiveSum = 0;
        for (long i = 5; i <=n ; i*=5) {
            fiveSum += n/i;
            fiveSum -= m/i;
            fiveSum -= (n-m)/i;
        }
        for (long i = 2; i <=n ; i*=2) {
            twoSum += n/i;
            twoSum -= m/i;
            twoSum -= (n-m)/i;
        }
        System.out.println(Math.min(twoSum,fiveSum));
    }
}
