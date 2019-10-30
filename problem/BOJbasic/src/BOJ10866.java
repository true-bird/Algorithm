import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque deque = new Deque();
        int N = Integer.parseInt(st.nextToken());
        while(N-->0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push_front")) {
                deque.push_front(Integer.parseInt(st.nextToken()));
            } else if(cmd.equals("push_back")) {
                deque.push_back(Integer.parseInt(st.nextToken()));
            } else if(cmd.equals("pop_front")) {
                sb.append(deque.pop_front()).append("\n");
            } else if(cmd.equals("pop_back")) {
                sb.append(deque.pop_back()).append("\n");
            } else if(cmd.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if(cmd.equals("empty")) {
                sb.append(deque.empty()).append("\n");
            } else if(cmd.equals("front")) {
                sb.append(deque.front()).append("\n");
            } else if(cmd.equals("back")) {
                sb.append(deque.back()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    static class Deque{
        Node front = null;
        Node back = null;
        int size = 0;
        void push_front(int num) {
            size++;
            Node node = new Node(null,front,num);
            if(empty()==1) {
                front = back = node;
                return;
            }
            front.pre = node;
            front = node;
        }
        void push_back(int num) {
            size++;
            Node node = new Node(back,null,num);
            if(empty()==1) {
                front = back = node;
                return;
            }
            back.nxt = node;
            back = node;
        }
        int pop_front() {
            if(empty()==1) return -1;
            size--;
            int num = front.n;
            front = front.nxt;
            if(front==null) back=front;
            else front.pre = null;
            return num;
        }
        int pop_back() {
            if(empty()==1) return -1;
            size--;
            int num = back.n;
            back = back.pre;
            if(back==null) front=back;
            else back.nxt = null;
            return num;
        }
        int size() {
            return size;
        }
        int empty() {
            if(front==null) return 1;
            return 0;
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
            Node(Node pre, Node nxt, int n) {
                this.pre = pre;
                this.nxt = nxt;
                this.n = n;

            }
        }
    }
}
