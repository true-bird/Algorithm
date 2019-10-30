import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        String str = br.readLine();
        int result = 0;
        for(char ch : str.toCharArray()) {
            if(ch=='(') {
                stack.push(-1);
            } else {
                int n = stack.pop();
                if(n==-1) n = 1;
                else {
                    stack.pop();
                    result += n+1;
                }
                if(stack.isEmpty()) continue;
                if(stack.peek()==-1) stack.push(n);
                else stack.push(stack.pop()+n);
            }
        }
        System.out.println(result);
    }
}
