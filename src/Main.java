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

        long[] A = new long[N];

        long answer = 0;
        for (int i =0; i<N; i++) {
            A[i] = i+1;
        }
        long sum = 1;
        int startIndex = 0;
        int endIndex = 0;
        while (endIndex < N) {
            if (sum < N) {
                endIndex++;
                sum += A[endIndex];
            } else if (sum > N) {
                sum -= A[startIndex];
                startIndex++;
            } else {
                answer++;
                endIndex++;
                if (endIndex < N)
                    sum += A[endIndex];
            }
        }

        System.out.println(answer);
    }
}