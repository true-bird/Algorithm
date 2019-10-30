import java.io.*;
import java.util.StringTokenizer;

public class BOJ9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-->0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] num = new int[n];
            long result = 0;
            num[0] = Integer.parseInt(st.nextToken());
            for (int i = 1; i <n ; i++) {
                num[i] = Integer.parseInt(st.nextToken());
                for (int j = i-1; j >=0; j--) {
                    result += gcd(num[i],num[j]);
                }
            }
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
    }
    static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
