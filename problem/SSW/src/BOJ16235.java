/*
* 문제 : 나무 재테크
* 입력 : 땅 크기 N ( 1 <= N <= 10), 나무 개수 M ( 1 <= M <= N^2 ), 목표 해 K ( 1 <= K <= 1,000 )
    겨울 양분 배열 A ( 1 <= A <= 100 ), 나무 정보 x,y,나이 ( 1 <= 나이 <= 10 )
* 출력 : K년이 지난 후 살아남은 나무의 수
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16235 {

    static int N,M,K,result;
    static int[][] A;
    static int[][] map;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {1,0,-1,1,-1,1,0,-1};
    static PriorityQueue<Integer>[][] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i <N ; i++) {
            Arrays.fill(map[i],5);
        }

        A = new int[N][N];
        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <N ; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        trees = new PriorityQueue[N][N];
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <N ; j++) {
                trees[i][j] = new PriorityQueue<>();
            }
        }
        for (int i = 0; i <M ; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            trees[y-1][x-1].add(age);
        }
        for (int i = 0; i <K ; i++) {
            result = sim();
        }
        System.out.println(result);

    }
    static int sim() {
        int result = 0;
        // 봄
        int[][] tmp = new int[N][N];
        List<treeInfo> list = new ArrayList<>();
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <N ; j++) {
                if(trees[i][j].size()!=0) {
                    PriorityQueue<Integer> pq = new PriorityQueue();
                    while(!trees[i][j].isEmpty()) {
                        int tree = trees[i][j].poll();
                        if(tree<=map[i][j]) {
                            result++;
                            map[i][j] -= tree;
                            pq.add(tree+1);
                            if((tree+1)%5==0) {
                                list.add(new treeInfo(j,i,tree+1));
                            }
                        } else {
                            tmp[i][j] += tree/2;
                        }
                    }
                    trees[i][j] = pq;
                }
            }
        }
        // 여름
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <N ; j++) {
                map[i][j] += tmp[i][j];
            }
        }
        // 가을
        for (int i = 0; i <list.size() ; i++) {
            treeInfo tree = list.get(i);
            for (int j = 0; j <8 ; j++) {
                int nx = tree.x + dx[j];
                int ny = tree.y + dy[j];
                if(nx<0 || ny<0 || nx>= N || ny>=N) continue;
                trees[ny][nx].add(1);
                result++;
            }
        }
        // 겨울
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <N ; j++) {
                map[i][j] += A[i][j];
            }
        }
        return result;
    }


    static class treeInfo {
        int x,y,age;
        treeInfo(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }
}
