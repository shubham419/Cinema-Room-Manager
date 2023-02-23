package cinema

import java.lang.IndexOutOfBoundsException

val representation = mutableListOf<MutableList<String>>()
var rows: Int = 0
var seats: Int = 0
var rowNo: Int = 0
var seatNo: Int = 0
var noOfPurchasedTickets: Int = 0
var currentIncome: Int = 0
fun main() {
    println("Enter the number of rows:")
    rows = readln().toInt()
    println("Enter the number of seats in each row:")
    seats = readln().toInt()
    val firstColumn = mutableListOf<String>()
    repeat(seats + 1) {
        firstColumn.add("$it")
    }
    firstColumn[0] = " "
    representation.add(firstColumn)

    for (i in 1..rows) {
        val list = mutableListOf<String>()
        var check = true
        for (j in 0..seats) {
            if (check) {
                list.add("$i")
                check = false
            } else {
                list.add("s")
            }
        }
        representation.add(list)
    }
    menu()
}

fun menu() {
    println()
    println(
        "1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit"
    )
    when (readln().toInt()) {
        1 -> showSeat()
        2 -> buyTicket()
        3 -> statistics()
        0 -> exit()
    }
}

fun statistics() {
    println()
    println("Number of purchased tickets: $noOfPurchasedTickets")
    val totalSeats = rows * seats
    val percentage: Double = noOfPurchasedTickets.toDouble() / totalSeats * 100.0
    val formatPercentage = "%.2f".format(percentage)
    println("Percentage: $formatPercentage%")
    println("Current income: $$currentIncome")

    if (rows * seats < 60) {
        println("Total income: $" + rows * seats * 10)
    } else {
        val frontRows = rows / 2
        val backRow = rows - frontRows
        println("Total income: $" + (frontRows * 10 * seats + backRow * 8 * seats))
    }
    menu()
}

fun exit() {
    return
}

fun buyTicket() {
    println()
    println("Enter a row number:")
    rowNo = readln().toInt()
    println("Enter a seat number in that row:")
    seatNo = readln().toInt()
    try {
        if (representation[rowNo][seatNo] != "B") {
            println()
            print("Ticket price: ")
            if (rows * seats < 60) {
                currentIncome += 10
                print("$" + 10)
            } else {
                val frontRows = rows / 2
                if (rowNo in 0..frontRows) {
                    currentIncome += 10
                    print("$" + 10)
                } else {
                    currentIncome += 8
                    print("$" + 8)
                }
            }
            representation[rowNo][seatNo] = "B"
            noOfPurchasedTickets++
            println()
            menu()
        } else {
            println()
            println("That ticket has already been purchased!")
            buyTicket()
        }
    }
    catch (e: IndexOutOfBoundsException){
        println()
        println("Wrong input!")
        buyTicket()
    }
}

fun showSeat() {
    println()
    println("Cinema:")

    for (i in 0..rows) {
        for (j in 0..seats) {
            print(representation[i][j])
            if (j == seats) continue
            print(" ")
        }
        println()
    }
    menu()
}
