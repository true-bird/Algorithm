import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ4195 {

    private static int[] parent;
    private static int[] cnt;

    public static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if(u==v) return;
        parent[u] = v;
        cnt[v] += cnt[u];
    }

    public static int find(int u) {
        if(parent[u]==u) return u;
        return parent[u] = find(parent[u]);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        HashMap<String,Integer> hashmap;
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            int F = Integer.parseInt(br.readLine());
            hashmap = new HashMap<>();
            cnt = new int[F*2+1];
            parent = new int[F*2+1];
            for(int i=1,index=1;i<=F;i++) {
                st = new StringTokenizer(br.readLine());
                String[] strs = {st.nextToken(),st.nextToken()};
                for(int j=0;j<2;j++) {
                    if(!hashmap.containsKey(strs[j])) {
                        cnt[index] = 1;
                        parent[index] = index;
                        hashmap.put(strs[j], index++);
                    }
                }
                int u = hashmap.get(strs[0]);
                int v = hashmap.get(strs[1]);
                union(u,v);
                sb.append(cnt[find(v)]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
