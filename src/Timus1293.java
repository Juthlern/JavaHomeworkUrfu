import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Timus1293 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long result = N * A * B * 2;
        System.out.println(result);
    }
}