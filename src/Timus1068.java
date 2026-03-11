import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Timus1068 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long sum = 0;

        if (n >= 1) {
            // сумма от 1 до n
            sum = (long) n * (n + 1) / 2;
        } else {
            // сумма от n до 1
            for (int i = n; i <= 1; i++) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}