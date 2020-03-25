package subtask3

class BillCounter {


    private val success = "Bon Appetit"

    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val sumByTwo = (bill.sum() - bill[k])/ 2

        return if (sumByTwo != b) (b - sumByTwo).toString()
        else success
    }
}
