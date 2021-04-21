import java.util.Scanner;

public class Main {
    final static int p = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] factorial = new long[4000001];
        factorial[1] = 1;
        for (int i = 2; i < 4000001; i++) {
            factorial[i] = (factorial[i - 1] * i) % p;
        }
        int N = sc.nextInt();
        int R = sc.nextInt();
        if (R == 0 || N == 1) {
            System.out.println(1);
            System.exit(0);
        }
        long top = factorial[N] % p;
        long bottom = ((factorial[N - R] % p) * (factorial[R] % p)) % p;
        long fermat = pow(bottom, p - 2);
        System.out.println((top * fermat) % p);
    }

    static long pow(long num, long ex) {
        if (ex == 0 || num == 1) {
            return 1;
        }
        long half = pow(num, ex / 2);
        if (ex % 2 == 0) {
            return ((half % p) * (half % p)) % p;
        } else {
            return ((half * num % p) * (half % p)) % p;
        }
    }
}
