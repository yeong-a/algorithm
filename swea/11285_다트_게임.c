#include <math.h>

void main() {
    int T, N, s, x, y;
    scanf("%d", &T);
    for (int i = 1; i <= T; i++) {
        s = 0;
        scanf("%d", &N);
        for (int j = 0; j < N; j++) {
            scanf("%d %d", &x, &y);
            double d = sqrt(x * x + y * y);
            if (!d) {
                s += 10;
            }
            else if (d <= 200) {
                s += 11 - ceil(d / 20);
            }
        }
        printf("#%d %d\n", i, s);
    }
}
