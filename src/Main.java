import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        try {
            quiz008();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void quiz008() throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long A[] = new long[N];
        long answer = 0;

        for (int i =0; i<N; i++) {
            A[i] = sc.nextLong();
        }
        Arrays.sort(A);

        for (int k = 0; k<N; k++) {
            int startIndex = 0;
            int endIndex = N - 1;
            long find = A[k];
            while (startIndex < endIndex) {
                if (A[startIndex] + A[endIndex] == find) {
                    if (startIndex != k && endIndex != k) {
                        answer++;
                        break;
                    } else if (startIndex == k) {
                        startIndex++;
                    } else if (endIndex == k) {
                        endIndex--;
                    }
                } else if (A[startIndex] + A[endIndex] > find) {
                    endIndex--;
                } else {
                    startIndex++;
                }
            }
        }
        /* 이건 틀림.
        for (int i = 0; i<N; i++) {
            int startIndex = 0;
            int endIndex = N - 1;
            long K = A[i];
            while (startIndex < endIndex) {
                if (A[startIndex] + A[endIndex] == K) {
                    if (A[startIndex] != K && A[endIndex] != K) {
                        answer++;
                        break;
                    } else if (A[startIndex] == K) {
                        startIndex++;
                    } else if (A[endIndex] == K) {
                        endIndex--;
                    }
                } else if (A[startIndex] + A[endIndex] > K) {
                    endIndex--;
                } else {
                    startIndex++;
                }
            }
        }*/
        System.out.println(answer);
    }
}