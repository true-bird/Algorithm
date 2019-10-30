import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String str = st.nextToken();
        Stack<Character> leftstack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        for (char ch :str.toCharArray()) {
            leftstack.push(ch);
        }
        int N = Integer.parseInt(br.readLine());
        while(N-->0) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            if(cmd=='P') {
                leftstack.push(st.nextToken().charAt(0));
            } else if(cmd=='L'){
                if(leftstack.isEmpty()) continue;
                rightStack.push(leftstack.pop());
            } else if(cmd=='D'){
                if(rightStack.isEmpty()) continue;
                leftstack.push(rightStack.pop());
            } else if(cmd=='B') {
                if(leftstack.isEmpty()) continue;
                leftstack.pop();
            }
        }
        while(!leftstack.isEmpty()) {
            sb.append(leftstack.pop());
        }
        sb.reverse();
        while(!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb.toString());
    }
}
