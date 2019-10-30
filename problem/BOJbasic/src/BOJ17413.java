import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        boolean flag = false;
        for(char ch : str.toCharArray()) {
            if(flag) {
                if(ch=='>') flag = false;
                sb.append(ch);
            } else {
                if(ch==' ' || ch=='<') {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(ch);
                    if(ch=='<') flag = true;
                } else  stack.push(ch);
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
