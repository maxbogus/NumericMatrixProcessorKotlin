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
            "3" -> {
                matrixByMatrixMultiplication()
            }
            else -> {}
        }

    } while (input != "0")
}

fun matrixByMatrixMultiplication() {
    TODO("Not yet implemented")
}

fun matrixMultiplicationByConstant() {
    val input = parseMatrixParams("")
    val matrix = parseMatrix(input)
    println("Enter constant:")
    val const = readLine()!!
    println("The result is:")
    for (line in matrix) {
        val result = mutableListOf<Double>()
        for (int in line) {
            result.add(int.toDouble() * const.toDouble())
        }
        println(result.joinToString(" "))
    }
}

private fun matrixAddition() {
    val firstMatrixParams = parseMatrixParams("first ")
    val firstMatrix = parseMatrix(firstMatrixParams, "first ")
    val secondMatrixParams = parseMatrixParams("second ")
    val secondMatrix = parseMatrix(firstMatrixParams, "second ")

    if (firstMatrixParams != secondMatrixParams) {
        println("ERROR")
    } else {
        println("The result is:")
        val result = mutableListOf<MutableList<Double>>()
        for (x in 0 until firstMatrixParams[0]) {
            val line = mutableListOf<Double>()
            for (y in 0 until firstMatrixParams[1]) {
                line.add(firstMatrix[x][y].toDouble() + secondMatrix[x][y].toDouble())
            }
            result.add(line)
        }
        for (line in result) {
            println(line.joinToString(" "))
        }
    }
}

private fun parseMatrixParams(name: String = " "): List<Int> {
    println("Enter size of ${name}matrix:")
    return readLine()!!.split(" ").map { it.toInt() }
}

private fun parseMatrix(matrixParams: List<Int>, name: String = " "): MutableList<List<String>> {
    val matrix = mutableListOf<List<String>>()
    println("Enter ${name}matrix:")
    repeat(matrixParams[0]) {
        val line = readLine()!!.split(" ").map { it }
        matrix.add(line)
    }
    return matrix
}
