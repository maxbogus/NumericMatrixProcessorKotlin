package processor

fun main() {
    do {
        println(
            """
            1. Add matrices
            2. Multiply matrix by a constant
            3. Multiply matrices
            0. Exit
        """.trimIndent()
        )
        val input = readLine()!!
        when (input) {
            "1" -> {
                matrixAddition()
            }
            "2" -> {
                matrixMultiplicationByConstant()
            }
            "3" -> {}
            else -> {}
        }

    } while (input != "0")
}

fun matrixMultiplicationByConstant() {
    println("Enter size of matrix:")
    val input = readLine()!!.split(" ").map { it.toInt() }
    val matrix = mutableListOf<List<Int>>()
    println("Enter matrix:")
    repeat(input[0]) {
        val line = readLine()!!.split(" ").map { it.toInt() }
        matrix.add(line)
    }
    println("Enter constant:")
    val const = readLine()!!.toInt()
    println("The result is:")
    for (line in matrix) {
        val result = mutableListOf<Int>()
        for (int in line) {
            result.add(int * const)
        }
        println(result.joinToString(" "))
    }
}

private fun matrixAddition() {
    println("Enter size of first matrix:")
    val firstMatrixParams = readLine()!!.split(" ").map { it.toInt() }
    val firstMatrix = mutableListOf<List<Int>>()
    println("Enter first matrix:")
    repeat(firstMatrixParams[0]) {
        val line = readLine()!!.split(" ").map { it.toInt() }
        firstMatrix.add(line)
    }
    println("Enter size of second matrix:")
    val secondMatrixParams = readLine()!!.split(" ").map { it.toInt() }
    val secondMatrix = mutableListOf<List<Int>>()
    println("Enter second matrix:")
    repeat(secondMatrixParams[0]) {
        val line = readLine()!!.split(" ").map { it.toInt() }
        secondMatrix.add(line)
    }

    if (firstMatrixParams != secondMatrixParams) {
        println("ERROR")
    } else {
        println("The result is:")
        val result = mutableListOf<MutableList<Int>>()
        for (x in 0 until firstMatrixParams[0]) {
            val line = mutableListOf<Int>()
            for (y in 0 until firstMatrixParams[1]) {
                line.add(firstMatrix[x][y] + secondMatrix[x][y])
            }
            result.add(line)
        }
        for (line in result) {
            println(line.joinToString(" "))
        }
    }
}
