import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 문제 : 단어 정렬
 * 입력 : 단어의 개수 N ( 1<=N<=20,000 ), 문자열 ( <= 50 )
 * 출력 : 정렬 결과
 *
 */

public class step9_BOJ1181 {

    static int N;
    static LinkedList<String>[] str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        String[] list = new String[N];
        str = new LinkedList[51];
        for(int i=0;i<=50;i++) {
            str[i] = new LinkedList<String>();
        }
        for(int i=0;i<N;i++) {
            list[i]=br.readLine();
        }
        Arrays.sort(list);

        for(String s :list) {
            if(!str[s.length()].contains(s)) {
                str[s.length()].add(s);
            }
        }
        for(int i=1;i<=50;i++) {
            if(str[i].size()==0) continue;
            if(str[i].size()>1) {
                for(String s : str[i]) {
                    bw.write(s+"\n");
                }
            } else {
                bw.write(str[i].poll()+"\n");
            }
        }
        bw.flush();

    }


}
