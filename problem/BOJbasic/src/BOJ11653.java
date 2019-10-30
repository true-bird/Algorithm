import java.io.*;

public class BOJ11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int tmp = N;
        for (int i = 2; i*i <=N ; i++) {
            while(tmp%i==0) {
                bw.write(i+"\n");
                tmp /= i;
            }
        }
        if(tmp>1) bw.write(tmp+"\n");
        bw.flush();
        bw.close();
    }
}
