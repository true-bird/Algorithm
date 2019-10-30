import java.io.*;
import java.util.ArrayList;

public class BOJ17103 {
    static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> prime = new ArrayList<>();
        boolean[] num = new boolean[MAX+1];
        for (int i = 2; i <=MAX ; i++) {
            if(num[i]) continue;
            prime.add(i);
            if(i>Math.sqrt(MAX)) continue;
            for (int j = i+i; j <=MAX ; j+=i) {
                num[j] = true;
            }
        }
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            int result = 0;
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i <prime.size() ; i++) {
                int n = prime.get(i);
                if(2*n>N) break;
                if(!num[N-n]) result++;
            }
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
    }
}
