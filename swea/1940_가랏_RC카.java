import java.util.Scanner;
 
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int distance = 0;
            int nowSpeed = 0;
            for (int i = 0; i < N; i++) {
                int command = sc.nextInt();
                int speed;
                switch (command) {
                case 0:
                    distance += 1 * nowSpeed;
                    break;
                case 1:
                    speed = sc.nextInt();
                    nowSpeed += speed;
                    distance += 1 * nowSpeed;
                    break;
                case 2:
                    speed = sc.nextInt();
                    if (nowSpeed < speed) {
                        nowSpeed = 0;
                    } else {
                        nowSpeed -= speed;
                    }
                    distance += 1 * nowSpeed;
                    break;
                }
            }
            System.out.printf("#%d %d\n", t, distance);
        }
        sc.close();
    }
}