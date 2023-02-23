fun main() {
    // Do not touch code below
    val inputList: MutableList<MutableList<String>> = mutableListOf()
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val strings = readLine()!!.split(' ').toMutableList()
        inputList.add(strings)
    }
    // write your code here
    val left = inputList.first().first()
    val right = inputList.first().last()
    val top = inputList.last().first()
    val bottom = inputList.last().last()

    println("$left $right")
    println("$top $bottom")
}