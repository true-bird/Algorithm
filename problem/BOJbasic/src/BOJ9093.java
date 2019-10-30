import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int T = Integer.parseInt(st.nextToken());
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                String str = st.nextToken();
                for(char ch : str.toCharArray()) {
                    stack.push(ch);
                }
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
