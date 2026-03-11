import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Timus1083 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String excls = st.nextToken(); // строка вида "!", "!!", "!!!"
        int k = excls.length();        // количество восклицательных знаков

        long result = 1;
        for (int i = n; i > 0; i -= k) {
            result *= i;
        }
        System.out.println(result);
    }
}