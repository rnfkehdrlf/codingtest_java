import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        try {
            quiz006();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void quiz006() throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long answer = 1;
        long sum = 1;
        int startIndex = 1;
        int endIndex = 1;
        while (endIndex < N) {
            if (sum < N) {
                endIndex++;
                sum += endIndex;
            } else if (sum > N) {
                sum -= startIndex;
                startIndex++;
            } else {
                answer++;
                endIndex++;
                sum += endIndex;
            }
        }

        System.out.println(answer);
    }
}