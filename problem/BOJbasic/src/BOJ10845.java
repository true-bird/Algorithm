import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue queue = new Queue();
        int N = Integer.parseInt(st.nextToken());
        while(N-->0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                queue.push(num);
            } else if(cmd.equals("pop")) {
                sb.append(queue.pop()).append("\n");
            } else if(cmd.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if(cmd.equals("empty")) {
                sb.append(queue.empty()).append("\n");
            } else if(cmd.equals("front")) {
                sb.append(queue.front()).append("\n");
            } else if(cmd.equals("back")) {
                sb.append(queue.back()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    static class Queue {
        Node front = null;
        Node back = null;
        int size;
        void push(int num) {
            size++;
            Node node = new Node(back,null,num);
            if(empty()==1) {
                front = back = node;
                return;
            }
            back.nxt = node;
            back = node;
        }
        int pop() {
            if(empty()==1) return -1;
            size--;
            int num = front.n;
            front = front.nxt;
            if(front==null) back=front;
            else front.pre = null;
            return num;
        }

        int size() {
            return size;
        }

        int empty() {
            if(front==null) return 1;
            else return 0;
        }
        int front() {
            if(empty()==1) return -1;
            return front.n;
        }
        int back() {
            if(empty()==1) return -1;
            return back.n;
        }


        class Node {
            Node pre;
            Node nxt;
            int n;
            Node(Node pre, Node nxt,int n) {
                this.pre = pre;
                this.nxt = nxt;
                this.n = n;
            }
        }
    }
}
