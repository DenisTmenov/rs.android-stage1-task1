package subtask4

class StringParser {

    fun getResult(inputString: String): Array<String> {
        val result: MutableList<String> = ArrayList()
        val numbers: MutableList<Int> = ArrayList()
        val sequence: MutableList<Char> = ArrayList()
        val brackets = arrayListOf<Char>('(', ')', '[', ']', '<', '>')
        for (i in inputString.indices) {
            if (brackets.contains(inputString[i])) {
                sequence.add(inputString[i])
                numbers.add(i)
            }
        }

        for (ch in sequence.indices) {
            if (sequence[ch] == '(') {
                var count = 0
                for (i in ch until sequence.size) {
                    if (sequence[i] == '(') {
                        count++
                        continue
                    } else if (sequence[i] == ')') {
                        count--
                        if (count < 1) {
                            result.add(inputString.substring(numbers[ch] + 1, numbers[i]))
                            break
                        }
                    }
                }
            } else if (sequence[ch] == '[') {
                var count = 0
                for (i in ch until sequence.size) {
                    if (sequence[i] == '[') {
                        count++
                        continue
                    } else if (sequence[i] == ']') {
                        count--
                        if (count < 1) {
                            result.add(inputString.substring(numbers[ch] + 1, numbers[i]))
                            break
                        }
                    }
                }
            } else if (sequence[ch] == '<') {
                var count = 0
                for (i in ch until sequence.size) {
                    if (sequence[i] == '<') {
                        count++
                        continue
                    } else if (sequence[i] == '>') {
                        count--
                        if (count < 1) {
                            result.add(inputString.substring(numbers[ch] + 1, numbers[i]))
                            break
                        }
                    }
                }
            }
        }

        return result.toTypedArray()
    }
}
