import java.util.ArrayDeque
import java.util.LinkedList
import kotlin.properties.Delegates

fun main(args: Array<String>) {
    quiz010()
}

fun quiz010() {
/*
문제
N개의 수 A1, A2, ..., AN과 L이 주어진다.

Di = Ai-L+1 ~ Ai 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오. 이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.

입력
첫째 줄에 N과 L이 주어진다. (1 ≤ L ≤ N ≤ 5,000,000)

둘째 줄에는 N개의 수 Ai가 주어진다. (-109 ≤ Ai ≤ 109)

출력
첫째 줄에 Di를 공백으로 구분하여 순서대로 출력한다.

예제 입력 1
12 3
1 5 2 3 6 2 3 7 3 5 2 6
예제 출력 1
1 1 1 2 2 2 2 2 3 3 2 2
*/
    val list = readln().split(" ")
    val N = list.first().toInt()
    val L = list.last().toInt()

    val A = readln().split(" ").map { it.toInt() }.toTypedArray()
    var answer = arrayOfNulls<Int>(N)
    val deque = ArrayDeque<Node>()
    for (i in 0 until N) {
        val now = A[i]
        while (!deque.isEmpty() && deque.last.value > now){
            deque.removeLast()
        }
        deque.addLast(Node(i, now))
        if (deque.first.index <= i - L) {
            deque.removeFirst()
        }
        answer[i] = deque.first.value
    }
    for (i in 0 until N)
    println(answer[i])

}

class Node(var index: Int, var value: Int)