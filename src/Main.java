import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        quiz003();
    }

    static void quiz003() throws IOException {
        /*
        문제
        수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
        입력
        첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
        출력
        총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
        제한
        1 ≤ N ≤ 100,000
        1 ≤ M ≤ 100,000
        1 ≤ i ≤ j ≤ N
         */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());

        int[] S = new int[suNo+1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int sum = 0;
        for (int i =1; i<=suNo; i++) {
            sum += Integer.parseInt(stringTokenizer.nextToken());
            S[i] = sum;
        }
        for (int k = 0; k<quizNo; k++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i-1]);
        }
    }
}