import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String num = br.readLine();
        int result = 0;
        for (int i = num.length()-1; i >=0 ; i--) {
            int n = (num.length()-1-i)%3;
            result += (num.charAt(i)-'0')*Math.pow(2,n);
            if(i==0 || n==2) {
                sb.append(result);
                result = 0;
            }
        }
        System.out.println(sb.reverse().toString());
    }
}
