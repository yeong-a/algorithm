import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int[] arr1 = new int[9];
            int[] arr2 = new int[9];
            boolean[] all = new boolean[19];
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            for (int i = 0; i < 9; i++) {
                int input = Integer.parseInt(st.nextToken());
                arr1[i] = input;
                all[input] = true;
            }
            int cnt = 0;
            for (int i = 1; i < 19; i++) {
                if(all[i]) {
                    continue;
                } else {
                    arr2[cnt++] = i;
                }
            }
            int count1 = 0;
            int count2 = 0;
            do {
                int score1 = 0;
                int score2 = 0;
                for (int i = 0; i < 9; i++) {
                    int tempSum = arr1[i] + arr2[i];
                    if (arr1[i] > arr2[i]) {
                        score1 += tempSum;
                    } else if (arr1[i] < arr2[i]) {
                        score2 += tempSum;
                    }
                }
                if (score1 > score2) {
                    count1++;
                } else if (score1 < score2) {
                    count2++;
                }
            } while (np(arr2));
 
            System.out.printf("#%d %d %d\n", t, count1, count2);
        }
    }
 
    public static boolean np(int[] arr) {
        int i = 8;
        while (i>0 && arr[i-1] >= arr[i]) {
            --i;
        }
        if (i == 0) {
            return false;
        }
        int j = 8;
        while (arr[i-1] >= arr[j]) {
            --j;
        }
        int temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;
 
        int k = 8;
        while (i < k) {
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
            i++;
            k--;
        }
        return true;
    }
}
