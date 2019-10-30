import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Pair> stack = new Stack<>();
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] result = new int[N];
        int[] tmp = new int[N];
        int[] count = new int[1000001];
        for (int i = 0; i <N ; i++) {
            int num = Integer.parseInt(st.nextToken());
            tmp[i] = num;
            count[num]++;
        }
        for (int i = 0; i <N ; i++) {
            while(!stack.isEmpty() && count[stack.peek().num]<count[tmp[i]]) {
                Pair pair = stack.pop();
                result[pair.index] = tmp[i];
            }
            stack.push(new Pair(i,tmp[i]));
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
        Pair (int index, int num) {
            this.index = index;
            this.num = num;
        }
    }
}
