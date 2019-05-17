import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : 곱셈
 * 입력 : A,B,C ( 2,147,483,647 이하의 자연수 (int 자료형))
 * 출력 : A를 B번 곱한 수를 C로 나누 나머지
 *
 *
 */
public class BOJ1629 {

    static int A,B,C;
    static int r0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        r0 = A%C;
        long result = new BOJ1629().r(B);
        System.out.println(result);
    }
    public long r(int num) {
        // B가 2147... 이면 약 21억번 곱셈 발생 => 2초 초과
        // A = aC + r0
        // A*A = (aC + r0)(aC + r0) => r0r0 / C
        // AAA = (aC + r0)(bC + r1) => r0r1 / C =
        // AAAA= (aC + r0)(cC + r2) => r0r2 / C = r1r1 / C
        // 41 -> 20 -> 10 -> 5 -> 2 -> 1
        // 20 + 20 + 1
        // 10 + 10
        // 5 + 5
        // 2 + 2 + 1
        // 1 + 1
        if(num==1) return r0;
        long pr = r(num/2);
        long re = (pr*pr)%C;
        if(num%2==0) return re;
        else return (r0*re)%C;
    }
}
