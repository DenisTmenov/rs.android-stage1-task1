package subtask5

class HighestPalindrome {

    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        val list = ArrayList<String>()
        for (i in 1..k) {
            if (list.isEmpty()) {
                list.addAll(changeOneChar(digitString))
            } else {
                val tempList = ArrayList<String>()
                for (item in list) {
                    tempList.addAll(changeOneChar(item))
                }
                list.addAll(tempList)
            }
        }
        return list.filter { isPalindrome(it) }.max() ?: "-1"
    }

    private fun isPalindrome(digitString: String): Boolean {
        return digitString == digitString.reversed()
    }

    private fun changeOneChar(digitString: String): ArrayList<String> {
        val result = ArrayList<String>()

        for (index in digitString.indices) {
            if (index < digitString.length - 1) {
                result.add(digitString.replaceRange(index + 1, index + 2, digitString[index].toString()))
            }
        }
        result.add(
            digitString.replaceRange(
                0,
                1,
                digitString[1].toString()
            )
        )
        result.add(
            digitString.replaceRange(
                digitString.length - 2,
                digitString.length - 1,
                digitString.last().toString()
            )
        )

        val max = digitString.max()
        for (index in digitString.indices) {
            if (index < digitString.length - 1) {
                result.add(digitString.replaceRange(index, index + 1, max.toString()))
            }
        }

        result.add(
            digitString.replaceRange(
                digitString.length - 1,
                digitString.length,
                max.toString()
            )
        )

        return result.distinct() as ArrayList<String>
    }
}
