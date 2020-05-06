import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10775 {

    private static int G,P;
    private static int[] g;
    private static int[] gate;

    private static int docking(int index) {
        int next = gate[index];
        if(next == 0) return -1;
        if(next == index) gate[index]--;
        else gate[index] = docking(next);
        return gate[index];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        g = new int[P+1];
        gate = new int[G+1];
        for(int i=1;i<=G;i++) gate[i] = i;
        for(int i=1;i<=P;i++) g[i] = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=1;i<=P;i++) {
            if(docking(g[i])<0) break;
            cnt++;
        }
        System.out.println(cnt);

    }

}
