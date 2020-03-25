package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {

        if (sadArray.isNotEmpty()) {
            val happyList = sadArray.toMutableList()

            var flag = true
            var i = 1


            while (flag) {
                if (happyList.size > 2 && happyList.size > i + 1) {
                    if (happyList[i - 1] + happyList[i + 1] < happyList[i]) {

                        happyList.removeAt(i)
                        if (i > 1) {
                            i--
                        }
                    } else {
                        i++
                    }
                } else {
                    flag = false
                }
            }

            return happyList.toIntArray()
        } else {
            return sadArray
        }
    }
}
