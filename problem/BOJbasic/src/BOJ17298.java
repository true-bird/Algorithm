import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Pair> stack = new Stack<>();
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] result = new int[st.countTokens()];
        for (int i = 0; i <N ; i++) {
            int num = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek().num<num) {
                Pair pair = stack.pop();
                result[pair.index] = num;
            }
            stack.add(new Pair(i,num));
        }
        while(!stack.isEmpty()) {
            Pair pair = stack.pop();
            result[pair.index] = -1;
        }
        for (int i = 0; i <result.length ; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
    static class Pair {
        int index, num;
        Pair (int index, int num){
            this.index = index;
            this.num = num;
        }
    }
}
