import java.util.Scanner;
 
class Solution {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[] pointer = {'^', 'v', '<', '>'};
    static int nowR, nowC, nowDir;
 
    static void shot(char[][] map) {
        int bulletR = nowR + dir[nowDir][0];
        int bulletC = nowC + dir[nowDir][1];
 
        while (bulletR >= 0 && bulletR < map.length && bulletC >= 0 && bulletC < map[0].length) {
            if (map[bulletR][bulletC] == '#') {
                break;
            } else if (map[bulletR][bulletC] == '*') {
                map[bulletR][bulletC] = '.';
                break;
            }
            bulletR += dir[nowDir][0];
            bulletC += dir[nowDir][1];
        }
    }
 
    static void move(char[][] map) {
        int nextR = nowR + dir[nowDir][0];
        int nextC = nowC + dir[nowDir][1];
        if (nextR >= 0 && nextR < map.length && nextC >= 0 && nextC < map[0].length && map[nextR][nextC] == '.') {
            map[nowR][nowC] = '.';
            nowR = nextR;
            nowC = nextC;
        }
        map[nowR][nowC] = pointer[nowDir];
    }
 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            char[][] map = new char[H][W];
            for (int i = 0; i < H; i++) {
                String str = sc.next();
                for (int j = 0; j < W; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
                        nowR = i;
                        nowC = j;
                        switch (map[i][j]) {
                        case '^':
                            nowDir = 0;
                            break;
                        case 'v':
                            nowDir = 1;
                            break;
                        case '<':
                            nowDir = 2;
                            break;
                        case '>':
                            nowDir = 3;
                        }
                    }
                }
            }
            int N = sc.nextInt();
            String str = sc.next();
            for (int i = 0; i < N; i++) {
                if (str.charAt(i) == 'U') {
                    nowDir = 0;
                    move(map);
                } else if (str.charAt(i) == 'D') {
                    nowDir = 1;
                    move(map);
                } else if (str.charAt(i) == 'L') {
                    nowDir = 2;
                    move(map);
                } else if (str.charAt(i) == 'R') {
                    nowDir = 3;
                    move(map);
                } else {
                    shot(map);
                }
            }
            System.out.print("#" + t + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}
