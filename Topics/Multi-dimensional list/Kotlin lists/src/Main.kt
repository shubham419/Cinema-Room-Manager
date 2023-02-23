fun main() {
    val inputList: MutableList<MutableList<String>> = mutableListOf()
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val strings = readLine()!!.split(' ').toMutableList()
        inputList.add(strings)
    }
    // Do not change lines above
    // Write your code here
    for (i in inputList[2].indices) {
        val x = inputList[2][i]
        if (i != inputList[2].lastIndex) {
            print("$x, ")
        } else {
            print("$x")
        }
    }
}