import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String num = br.readLine();
        if(num.equals("0")) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i <num.length() ; i++) {
            int n = num.charAt(i)-'0';
            for (int j = 2; j >=0 ; j--) {
                int sq = (int)Math.pow(2,j);
                sb.append(n/sq);
                n = n%sq;
            }
        }
        while(sb.indexOf("0")==0) {
            sb.deleteCharAt(0);
        }
        System.out.println(sb.toString());
    }
}
