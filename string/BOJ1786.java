import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1786 {

    private static char[] T,P;
    private static int[] pi;
    private static int cnt;


    private static void Init() {
        pi = new int[P.length];
        int p = 0;
        for (int i = 1; i < pi.length; i++) {
            while(p>0 && P[p]!=P[i]) p = pi[p-1];
            if(P[p]==P[i]) p++;
            pi[i] = p;
        }
    }

    private static StringBuilder Solve() {
        Init();
        StringBuilder sb = new StringBuilder();
        int p = 0;
        for (int i = 0; i < T.length; i++) {
            while(p>0 && P[p]!=T[i]) p = pi[p-1];
            if(P[p]==T[i]) p++;
            if(p==pi.length) {
                p = pi[p-1];
                sb.append(i-P.length+2).append(" ");
                cnt++;
            }
        }
        return sb;
    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = br.readLine().toCharArray();
        P = br.readLine().toCharArray();
        // Solve
        String result = Solve().toString().trim();
        // Result
        System.out.println(cnt);
        System.out.println(result);
    }
}
