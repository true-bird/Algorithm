import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] num = new boolean[1000001];
        for (int i = 2; i <=1000 ; i++) {
            if(num[i]) continue;
            for (int j = i+i; j <=1000000 ; j+=i) {
                num[j] = true;
            }
        }
        int n = Integer.parseInt(br.readLine());
        while(n!=0) {
            boolean flag = false;
            for (int i = 3; i+i <=n ; i+=2) {
                if(!num[i] && !num[n-i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n-i).append("\n");
                    flag = true;
                    break;
                }
            }
            if(!flag) sb.append("Goldbach's conjecture is wrong.\n");
            n = Integer.parseInt(br.readLine());
        }
        System.out.println(sb.toString());
    }
}
