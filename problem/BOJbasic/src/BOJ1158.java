import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder("<");
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 1; i <=N ; i++) {
            queue.add(i);
        }
        while(!queue.isEmpty()) {
            for (int i = 0; i <K-1 ; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll());
            if(queue.isEmpty()) sb.append(">");
            else sb.append(", ");
        }
        System.out.println(sb.toString());
    }
}
