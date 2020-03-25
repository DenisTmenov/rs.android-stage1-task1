package subtask2

class MiniMaxSum {

    fun getResult(input: IntArray): IntArray {
        input.sort()
        val sum = input.sum()
        return intArrayOf(sum - input[input.size - 1], sum - input[0])
    }
}
