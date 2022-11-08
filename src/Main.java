import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){

        try {
            quiz005();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void quiz005() throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] S = new long[N+1];

        long answer = 0;
        for (int i =1; i<N; i++) {
            S[i] = S[i-1] + sc.nextInt();
        }
        for(int i =0; i<=N; i++) {
            for (int j = i+1; j<=N; j++) {
                if((S[j]-S[i])%M == 0) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}