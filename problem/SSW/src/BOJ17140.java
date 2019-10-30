/*
 * 문제 : 이차원 배열과 연산
 * 입력 : A[r][c]에 들어있는 값이 k가 되기 위한 최소시간 ( 1 <= r,c,k <= 100 ), 배열A에 들어있는 수
 * 출력 : A[r][c]에 들어있는 값이 k가 되기 위한 최소시간
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17140 {

    static int r, c, k,result;
    static int[][] map = new int[100][100];
    static int rSize;
    static int cSize;
    static PriorityQueue<Pair> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.cnt == o2.cnt) {
                    return o1.num - o2.num;
                } else {
                    return o1.cnt - o2.cnt;
                }
            }
        });

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rSize = cSize = 3;

        while(result<=100) {
            if(map[r-1][c-1]==k) break;
            if(rSize>=cSize) RowOper();
            else ColOper();
        }

        if(result>100) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    static void RowOper() {
        int maxSize = 0;
        for (int i = 0; i < rSize; i++) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < cSize; j++) {
                if(map[i][j]==0) continue;
                if (hashMap.containsKey(map[i][j])) {
                    hashMap.replace(map[i][j], hashMap.get(map[i][j]) + 1);
                } else {
                    hashMap.put(map[i][j], 1);
                }
                map[i][j] = 0;
            }

            for (int key : hashMap.keySet()) {
                pq.add(new Pair(key, hashMap.get(key)));
                if(pq.size()>=50) break;
            }

            int cnt = 0;
            while (!pq.isEmpty()) {
                Pair pair = pq.poll();
                map[i][cnt++] = pair.num;
                map[i][cnt++] = pair.cnt;
            }
            maxSize = Math.max(maxSize,cnt);
        }
        cSize = maxSize;
        result++;
    }
    static void ColOper() {
        int maxSize = 0;
        for (int i = 0; i < cSize; i++) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < rSize; j++) {
                if(map[j][i]==0) continue;
                if (hashMap.containsKey(map[j][i])) {
                    hashMap.replace(map[j][i], hashMap.get(map[j][i]) + 1);
                } else {
                    hashMap.put(map[j][i], 1);
                }
                map[j][i] = 0;
            }

            for (int key : hashMap.keySet()) {
                pq.add(new Pair(key, hashMap.get(key)));
                if(pq.size()>=50) break;
            }

            int cnt = 0;
            while (!pq.isEmpty()) {
                Pair pair = pq.poll();
                map[cnt++][i] = pair.num;
                map[cnt++][i] = pair.cnt;
            }
            maxSize = Math.max(maxSize,cnt);
        }
        rSize = maxSize;
        result++;
    }

    static class Pair {
        int num, cnt;
        Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
