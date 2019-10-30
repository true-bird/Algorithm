import java.io.*;
import java.util.StringTokenizer;

public class BOJ2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int g = GCD(a,b);
        bw.write(g+"\n"+a*b/g);
        bw.flush();
        bw.close();
    }
    static int GCD(int a,int b) {
        if(b==0) return a;
        return GCD(b,a%b);
    }
}
