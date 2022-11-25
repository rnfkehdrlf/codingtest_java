import java.util.*

fun main(args: Array<String>) {
    quiz011()
}

fun quiz011() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val A = IntArray(N) {
        sc.nextInt()
    }
    val stack = Stack<Int>()
    var num = 1
    val bf = StringBuffer()
    var result = true

    for (i in A.indices) {
        if (A[i] >= num) {
            while (A[i] >= num) {
                stack.push(num++)
                bf.append("+\n")
            }
            stack.pop()
            bf.append("-\n")
        }
        else {
            var value = stack.pop()
            if (value > A[i]) {
                println("NO")
                result = false
                break
            }
            else bf.append("-\n")

        }
    }
    if (result) println(bf.toString())
}