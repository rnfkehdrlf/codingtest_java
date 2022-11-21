import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    quiz010()
}

fun quiz010() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val (n, l) = br.readLine().split(" ").map(String::toInt)
    val st = StringTokenizer(br.readLine(), " ")
    val arr = IntArray(n) {
        st.nextToken().toInt()
    }
    val deque = ArrayDeque<Node>(l)
    for (i in 1..n) {
        while (deque.isNotEmpty() && deque.first.index <= i - l)
            deque.removeFirst()
        while (deque.isNotEmpty() && deque.last.value >= arr[i - 1])
            deque.removeLast()
        deque.add(Node(arr[i - 1], i))
        bw.write("${deque.first().value} ")
    }
    bw.flush()
    bw.close()
}

internal class Node(var value: Int, var index: Int)