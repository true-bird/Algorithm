import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack();
        int N = Integer.parseInt(st.nextToken());
        while(N-->0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            } else if(command.equals("pop")) {
                sb.append(stack.pop()).append("\n");
            } else if(command.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if(command.equals("empty")) {
                sb.append(stack.empty()).append("\n");
            } else if(command.equals("top")) {
                sb.append(stack.top()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static class Stack {
        Node top = null;
        int size = 0;

        int pop() {
            if(empty()==1) return -1;
            int n = top.num;
            top = top.pre;
            size--;
            return n;
        }

        void push(int n) {
            Node node = new Node(top,n);
            top = node;
            size++;
        }

        int empty() {
            if(top==null) return 1;
            else return 0;
        }

        int size() {
            return size;
        }

        int top() {
            if(empty()==0) return top.num;
            else return -1;
        }

        class Node {
            Node pre;
            int num;
            Node(Node pre, int num) {
                this.pre = pre;
                this.num = num;
            }
        }

    }

}
