import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
/*
문제
버블 소트 알고리즘을 다음과 같이 C++로 작성했다.

bool changed = false;
for (int i=1; i<=N+1; i++) {
    changed = false;
    for (int j=1; j<=N-i; j++) {
        if (A[j] > A[j+1]) {
            changed = true;
            swap(A[j], A[j+1]);
        }
    }
    if (changed == false) {
        cout << i << '\n';
        break;
    }
}
위 소스에서 N은 배열의 크기이고, A는 정렬해야 하는 배열이다. 배열은 A[1]부터 사용한다.

위와 같은 소스를 실행시켰을 때, 어떤 값이 출력되는지 구해보자.

입력
첫째 줄에 N이 주어진다. N은 500,000보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 A[1]부터 A[N]까지 하나씩 주어진다. A에 들어있는 수는 1,000,000보다 작거나 같은 자연수 또는 0이다.

출력
정답을 출력한다.

예제 입력 1
5
10
1
5
2
3
예제 출력 1
3
예제 입력 2
5
1
3
5
7
9
예제 출력 2
1
*/

    /*
    이 문제에서 이전 index에서 정렬된후 index를 뺀값에 1을 더하는 것은
    왼쪽으로는 1칸씩만 이동할수 있고, 왼쪽으로 한칸 움직였다는것은 루프를 한번 돌았다는 얘기.
    문제의 코드에서 구하는것은 swap이 한번도 안일어난 index이므로 정렬이 완료되었다는 뜻.
    그래서 안쪽 루프의 최대값을 구하면 되는 것이고
    1칸씩 이동하는 특성이 있으므로 index뺀값의 최댓값이 최대로 돌린 루프의 횟수.
    +1을 해주는것은 마지막 루프에서 확인차 한번 더 돌기때문.
    * */
    quiz016()
}

fun quiz016() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val N = reader.readLine().toInt()

    val A = Array(N) {
        ArrayData(reader.readLine().toInt(), it)
    }

    A.sort()
    var max = 0
    for (i in 0 until N) {
        val index = A[i].index - i
        if (index > max) {
            max = index
        }
    }

    println(max+1)
}

class ArrayData(val value: Int, val index: Int): Comparable<ArrayData> {
    override fun compareTo(other: ArrayData): Int {
        return value - other.value
    }

}