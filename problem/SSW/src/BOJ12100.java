/*
 * 문제 : 2048 (Easy)
 * 입력 : 보드의 크기 N ( 1 <= N <= 20 ), 게임판 초기 상태, ( 2의 제곱꼴 )
 * 출력 : 최대 5번 이동시켜서 얻을 수 있는 가장 큰 블록
 * 풀이
 * - 이동
 *   - 0 이외의 값 뽑아서 배열에 저장
 *   - 뽑은 값 0으로 교체
 * - 합치기 ( 배열 안에서 )
 *   - 두 값 일치 시 2배 후 삭제
 * - 그리기
 *   - 배열 크기만큼 다시 대입
 * 주의
 * - y 증가 : 아래로
 * - 매개변수 배열 복사
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

final class BOJ12100 {

    private static int N;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        // input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, map);
        System.out.println(result);
    }

    private static void dfs(int cnt, int[][] map) {
        if (cnt == 5) {
            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(map[i][j], max);
                }
            }
            result = Math.max(max, result);
            return;
        }
        for (int n = 0; n < 4; n++) {
            dfs(cnt + 1, shift(n, map));
        }
    }


    private static int[][] shift(int dir, int[][] tmpMap) {
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = tmpMap[i].clone();
        }
        switch (dir) {
            case 0: // 위로
                for (int i = 0; i < N; i++) {
                    List<Integer> tmp = new ArrayList<>();
                    for (int j = 0; j < N; j++) {
                        if (map[j][i] > 0) {
                            tmp.add(map[j][i]);
                            map[j][i] = 0;
                        }
                    }
                    for (int j = 0; j < tmp.size() - 1; j++) {
                        if (tmp.get(j).equals(tmp.get(j + 1))) {
                            tmp.set(j, tmp.get(j) * 2);
                            tmp.remove(j + 1);
                        }
                    }
                    for (int j = 0; j < tmp.size(); j++) {
                        map[j][i] = tmp.get(j);
                    }
                }
                break;
            case 1: // 아래로
                for (int i = 0; i < N; i++) {
                    List<Integer> tmp = new ArrayList<>();
                    for (int j = N - 1; j >= 0; j--) {
                        if (map[j][i] > 0) {
                            tmp.add(map[j][i]);
                            map[j][i] = 0;
                        }
                    }
                    for (int j = 0; j < tmp.size() - 1; j++) {
                        if (tmp.get(j).equals(tmp.get(j + 1))) {
                            tmp.set(j, tmp.get(j) * 2);
                            tmp.remove(j + 1);
                        }
                    }
                    for (int j = 0; j < tmp.size(); j++) {
                        map[N - 1 - j][i] = tmp.get(j);
                    }
                }
                break;
            case 2: // 왼쪽으로
                for (int i = 0; i < N; i++) {
                    List<Integer> tmp = new ArrayList<>();
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] > 0) {
                            tmp.add(map[i][j]);
                            map[i][j] = 0;
                        }
                    }
                    for (int j = 0; j < tmp.size() - 1; j++) {
                        if (tmp.get(j).equals(tmp.get(j + 1))) {
                            tmp.set(j, tmp.get(j) * 2);
                            tmp.remove(j + 1);
                        }
                    }
                    for (int j = 0; j < tmp.size(); j++) {
                        map[i][j] = tmp.get(j);
                    }
                }
                break;
            case 3: // 왼쪽으로
                for (int i = 0; i < N; i++) {
                    List<Integer> tmp = new ArrayList<>();
                    for (int j = N - 1; j >= 0; j--) {
                        if (map[i][j] > 0) {
                            tmp.add(map[i][j]);
                            map[i][j] = 0;
                        }
                    }
                    for (int j = 0; j < tmp.size() - 1; j++) {
                        if (tmp.get(j).equals(tmp.get(j + 1))) {
                            tmp.set(j, tmp.get(j) * 2);
                            tmp.remove(j + 1);
                        }
                    }
                    for (int j = 0, cnt = N - 1; j < tmp.size(); j++) {
                        map[i][N - 1 - j] = tmp.get(j);
                    }
                }
                break;
        }
        return map;
    }
}





