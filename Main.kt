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
            "1" -> matrixAddition()
            "2" -> matrixMultiplicationByConstant()
            "3" -> {}
            else -> {}
        }

    } while (input != "0")
}

fun matrixMultiplicationByConstant() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    val matrix = mutableListOf<List<Int>>()
    repeat(input[0]) {
        val line = readLine()!!.split(" ").map { it.toInt() }
        matrix.add(line)
    }
    val const = readLine()!!.toInt()
    for (line in matrix) {
        val result = mutableListOf<Int>()
        for (int in line) {
            result.add(int * const)
        }
        println(result.joinToString(" "))
    }
}

private fun matrixAddition() {
    val firstMatrixParams = readLine()!!.split(" ").map { it.toInt() }
    val firstMatrix = mutableListOf<List<Int>>()
    repeat(firstMatrixParams[0]) {
        val line = readLine()!!.split(" ").map { it.toInt() }
        firstMatrix.add(line)
    }
    val secondMatrixParams = readLine()!!.split(" ").map { it.toInt() }
    val secondMatrix = mutableListOf<List<Int>>()
    repeat(secondMatrixParams[0]) {
        val line = readLine()!!.split(" ").map { it.toInt() }
        secondMatrix.add(line)
    }

    if (firstMatrixParams != secondMatrixParams) {
        println("ERROR")
    } else {
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
