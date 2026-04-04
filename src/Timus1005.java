import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Timus1005 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            total += a[i];
        }

        int best = Integer.MAX_VALUE;

        int limit = 1 << n; // 2^n вариантов
        for (int mask = 0; mask < limit; mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += a[i]; // камень попал в первую кучу
                }
            }
            int diff = Math.abs(total - 2 * sum); // |S - 2*sum|
            if (diff < best) {
                best = diff;
            }
        }
        System.out.println(best);
    }
}