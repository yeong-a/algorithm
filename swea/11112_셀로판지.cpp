#include <iostream>
#include <math.h>
using namespace std;
 
int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int N;
    cin >> N;
    for (int i = 1; i <= N; i++) {
        int p, q, r, a, b, c, d;
        cin >> p >> q >> r >> a >> b >> c >> d;
        if (p - r >= a && p + r <= c && q + r <= d && q - r >= b) {
            printf("#%d NY\n", i);
        } else if ((pow(p - a, 2) + pow(q - d, 2) <= r*r) && (pow(p - c, 2) + pow(q - d, 2) <= r*r) 
                    && (pow(p - a, 2) + pow(q - b, 2) <= r*r) && (pow(p - c, 2) + pow(q - b, 2) <= r*r)) {
            printf("#%d YN\n", i);
        } else {
            printf("#%d YY\n", i);
        }
    }
    return 0;
}
