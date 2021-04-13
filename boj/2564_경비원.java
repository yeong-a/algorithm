import java.util.Scanner;

public class 경비원 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        int N = sc.nextInt();
        int[] distance = new int[N+1];
        for (int i = 0; i <= N; i++) {
            switch (sc.nextInt()) {
                case 1:
                    distance[i] = sc.nextInt();
                    break;
                case 2:
                    distance[i] = 2 * W + H - sc.nextInt();
                    break;
                case 3:
                    distance[i] = 2 * (W + H) - sc.nextInt();
                    break;
                case 4:
                    distance[i] = W + sc.nextInt();
            }
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int temp = Math.abs(distance[i] - distance[N]);
            sum += temp <= W + H ? temp : 2 * (W + H) - temp;
        }
        System.out.println(sum);
    }
}
