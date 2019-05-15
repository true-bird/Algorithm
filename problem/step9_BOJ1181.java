import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 문제 : 단어 정렬
 * 입력 : 단어의 개수 N ( 1<=N<=20,000 ), 문자열 ( <= 50 )
 * 출력 : 정렬 결과
 *
 */

public class step9_BOJ1181 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        String[] list = new String[N];

        for(int i=0;i<N;i++) {
            list[i]=br.readLine();
        }
        Arrays.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()) return o1.length() - o2.length(); // 길이 정렬
                if(o1 != o2) return o1.compareTo(o2); // 문자 정렬
                return 0;
            }
        });

        for(int i=0;i<list.length;i++) {
            if(i+1 < list.length && list[i].equals(list[i+1])) {
                continue;
            }
            bw.write(list[i]+"\n");
        }
        bw.flush();
    }
}
