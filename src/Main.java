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
        /*
        문제
        N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.

        N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.

                수의 위치가 다르면 값이 같아도 다른 수이다.

        입력
        첫째 줄에는 수의 개수 N(1 ≤ N ≤ 2,000), 두 번째 줄에는 i번째 수를 나타내는 Ai가 N개 주어진다. (|Ai| ≤ 1,000,000,000, Ai는 정수)

        출력
        좋은 수의 개수를 첫 번째 줄에 출력한다.

                예제 입력 1
        10
        1 2 3 4 5 6 7 8 9 10
        예제 출력 1
        8
        */
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