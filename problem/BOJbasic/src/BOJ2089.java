import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        int sign = 0;
        int cnt = 0;
        boolean carry = false;
        if(num<0) {
            sign = 1;
            num = Math.abs(num);
        }
        while(num!=0) {
            int cur = num & 1;
            if(carry) {
                if (cur == 1) cur = 0;
                else {
                    cur = 1;
                    carry = false;
                }
            }
            if(cnt%2!=sign) {
                if(cur==1) carry = true;
            }
            sb.append(cur);
            num = num>>1;
            cnt++;
        }
        if(carry) {
            sb.append(1);
            if(cnt%2!=sign) sb.append(1);
        }
        if(cnt==0) System.out.println(0);
        else System.out.println(sb.reverse().toString());
    }
}
