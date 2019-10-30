/*
* 문제 : 낚시왕
* 입력 : 격자판의 크기 R,C ( 2 <= R,C < = 100 ), 상어의 수 M ( 0 <= M <= RxC ), 상어 정보
* 출력 : 잡은 상어 크기의 합
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17143 {

    static int R,C,M,result;;
    static int position = -1;
    static Shark[][] map;
    static HashMap<Integer,Shark> sharkList = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Shark[R][C];

        for (int i = 0; i <M ; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(r,c,s,d,z);
            sharkList.put(shark.z,shark);
            map[r][c] = shark;
        }
        if(M==0) System.out.println(0);
        else {
            while(position<C-1) {
                sim();
            }
            System.out.println(result);
        }
    }
    static void sim() {
        // 낚시왕 이동
        position++;
        // 포획
        for (int i = 0; i <R ; i++) {
            if(map[i][position]!=null) {
                result += map[i][position].z;
                sharkList.remove(map[i][position].z);
                map[i][position]=null;
                break;
            }
        }
        // 상어 이동
        PriorityQueue<Shark>[][] tmp = new PriorityQueue[R][C];
        for (int i = 0; i <R ; i++) {
            for (int j = 0; j <C ; j++) {
                tmp[i][j] = new PriorityQueue<>();
            }
        }

        for (Shark shark : sharkList.values()) {
            map[shark.r][shark.c]=null;
            int dir = shark.d;
            if(dir==1) { // 위
                int rest = shark.r;
                int dis = shark.s-rest;
                if(dis<=0) {
                    shark.r = rest-shark.s;
                } else {
                    boolean rot = false;
                    while(dis>R-1) {
                        dis -= (R-1);
                        rot = !rot;
                    }
                    if(rot) shark.r = R-1-dis;
                    else {
                        shark.r = dis;
                        shark.d = 2;
                    }
                }
            } else if(dir==2) { // 아래
                int rest = R-1-shark.r;
                int dis = shark.s-rest;
                if(dis<=0) {
                    shark.r = R-1-(rest-shark.s);
                } else {
                    boolean rot = false;
                    while(dis>R-1) {
                        dis -= (R-1);
                        rot = !rot;
                    }
                    if(rot) shark.r = dis;
                    else {
                        shark.r = R-1-dis;
                        shark.d = 1;
                    }
                }
            } else if(dir==3) { // 오른쪽
                int rest = C-1-shark.c;
                int dis = shark.s-rest;
                if(dis<=0) {
                    shark.c = C-1-(rest-shark.s);
                } else {
                    boolean rot = false;
                    while(dis>C-1) {
                        dis -= (C-1);
                        rot = !rot;
                    }

                    if(rot) shark.c = dis;
                    else {
                        shark.c = C-1-dis;
                        shark.d = 4;
                    }
                }
            } else if(dir==4) { // 왼쪽
                int rest = shark.c;
                int dis = shark.s-rest;
                if(dis<=0) {
                    shark.c = rest-shark.s;
                } else {
                    boolean rot = false;
                    while(dis>C-1) {
                        dis -= (C-1);
                        rot = !rot;
                    }
                    if(rot) shark.c = C-1-dis;
                    else {
                        shark.c = dis;
                        shark.d = 3;
                    }
                }
            }
            tmp[shark.r][shark.c].add(shark);
        }
        // 상어 제거
        for (int i = 0; i <R ; i++) {
            for (int j = 0; j <C ; j++) {
                if(!tmp[i][j].isEmpty()) {
                    map[i][j] = tmp[i][j].poll();
                    while(!tmp[i][j].isEmpty()) {
                        sharkList.remove(tmp[i][j].poll().z);
                    }
                }
            }
        }
    }

    static class Shark implements Comparable<Shark> {
        int r,c,s,d,z;
        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public int compareTo(Shark o) {
            return o.z-this.z;
        }
    }
}
