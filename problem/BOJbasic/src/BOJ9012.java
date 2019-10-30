import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int T = Integer.parseInt(br.readLine());
        label:
        while(T-->0) {
            String str = br.readLine();
            for(char ch : str.toCharArray()) {
                if(ch=='(') {
                    stack.push('(');
                } else {
                    if(!stack.isEmpty()) stack.pop();
                    else {
                        sb.append("NO\n");
                        continue label;
                    }
                }
            }
            if(!stack.isEmpty()) sb.append("NO\n");
            else {
                sb.append("YES\n");
            }
            stack.clear();
        }
        System.out.println(sb.toString());
    }
}
