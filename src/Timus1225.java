import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Timus1225 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        int n = Integer.parseInt(line);

        if (n == 1 || n == 2) {
            System.out.println(2);
            return;
        }

        long[] dp = new long[n + 1];
        dp[1] = 2;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}