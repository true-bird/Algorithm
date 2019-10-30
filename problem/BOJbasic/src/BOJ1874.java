import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int index = 0;
        boolean flag = false;
        while(n-->0) {
            int num = Integer.parseInt(br.readLine());
            if(flag) continue;
            if(index<num) {
                for (int i = index+1; i <=num ; i++) {
                    stack.push(i);
                    sb.append("+\n");
                }
                index = num;
                stack.pop();
                sb.append("-\n");
            } else {
                if(num==stack.pop()) {
                    sb.append("-\n");
                 } else flag = true;
            }
        }
        if(flag) System.out.println("NO");
        else System.out.println(sb.toString());
    }
}
