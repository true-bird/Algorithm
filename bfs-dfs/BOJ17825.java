import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 말 4개
// 이동하는 도중은 빨간색 화살표
// 도착 칸으로 이동시 정지
// 5면체 주사위
// 이동을 마치는 칸에 말이 있으면 중복으로 불가
// 점수의 최댓값

// 모든 경우의 수
// 4 ^ 10 = 2 ^ 20

public class BOJ17825 {

    private static int[][] map;
    private static int[] dice;
    private static int[][] horse;
    private static int max;

    private static boolean Dup(int[] next) {
        if (Arrive(next)) return false;
        for (int i = 0; i < 4; i++) {
            if (horse[i][0] == next[0] && horse[i][1] == next[1]) return true;
        }
        return false;
    }

    private static int[] Move(int[] hor, int add) {
        int pos = hor[0];
        int line = hor[1];
        int[] next = new int[2];
        if (line == 0) {
            if (pos == 5) {
                line = 1;
                pos = 0;
            } else if (pos == 10) {
                line = 2;
                pos = 0;
            } else if (pos == 15) {
                line = 3;
                pos = 0;
            }
        }
        for (int i = 0; i < add; i++) {
            pos++;
            if (line == 1 || line == 3) {
                if (pos >= 4) {
                    line = 4;
                    pos = 0;
                }
            } else if (line == 2) {
                if (pos >= 3) {
                    line = 4;
                    pos = 0;
                }
            } else if (line == 4) {
                if (pos >= 3) {
                    line = 5;
                    pos = 0;
                }
            } else if (line == 5) {
                if (pos >= 1) {
                    next[0] = 1;
                    next[1] = 5;
                    return next;
                }
            } else {
                if (pos >= 20) {
                    line = 5;
                    pos = 0;
                }
            }
        }
        next[0] = pos;
        next[1] = line;
        return next;
    }

    private static boolean Arrive(int[] arr) {
        return (arr[1]==5 && arr[0]==1);
    }

    private static void DFS(int sum, int cnt) {
        if(cnt>=10) {
            if(sum>max) max = sum;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(Arrive(horse[i])) continue;
            int[] tmp = horse[i];
            int[] next = Move(horse[i], dice[cnt]);
            if (Dup(next)) continue;
            horse[i] = next;
            DFS(sum + map[horse[i][1]][horse[i][0]], cnt + 1);
            horse[i] = tmp;
        }

    }

    private static void Init() {
        horse = new int[4][2];
        map = new int[6][];
        map[0] = new int[20]; // 기본 라인
        map[1] = new int[4]; // 10 라인
        map[2] = new int[3]; // 20 라인
        map[3] = new int[4]; // 30 라인
        map[4] = new int[3]; // 25 라인
        map[5] = new int[2]; // 마지막 라인

        for (int i = 2, index = 1; i < 40; i += 2) map[0][index++] = i;
        map[1][1] = 13;
        map[1][2] = 16;
        map[1][3] = 19;
        map[2][1] = 22;
        map[2][2] = 24;
        map[3][1] = 28;
        map[3][2] = 27;
        map[3][3] = 26;
        map[4][0] = 25;
        map[4][1] = 30;
        map[4][2] = 35;
        map[5][0] = 40;
    }

    private static void Solve() {
        Init();
        DFS(0,0);
    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        dice = new int[10];
        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }
        // Solve
        Solve();
        // Result
        System.out.println(max);
    }
}