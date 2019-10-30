import java.io.*;
import java.util.StringTokenizer;

public class BOJ1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M  = Integer.parseInt(st.nextToken());
        int N  = Integer.parseInt(st.nextToken());
        boolean[] num = new boolean[N+1];
        for (int i = 2; i <=N ; i++) {
            if(num[i]) continue;
            if(i>=M) bw.write(i+"\n");
            for (int j = i+i; j <=N ; j=j+i) {
                num[j] = true;
            }
        }
        bw.flush();
        bw.close();
    }
}
