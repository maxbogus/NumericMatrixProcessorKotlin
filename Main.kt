package processor

import java.lang.Math.max

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
    val firstMatrixParams = parseMatrixParams("first ")
    val firstMatrix = parseMatrix(firstMatrixParams, "first ")
    val secondMatrixParams = parseMatrixParams("second ")
    if (firstMatrixParams.size == 1 || secondMatrixParams.size == 1) {
        println("The operation cannot be performed.")
    } else {
        val secondMatrix = parseMatrix(secondMatrixParams, "second ")

        val rows = max(firstMatrixParams[0], secondMatrixParams[0])
        val columns = max(firstMatrixParams[1], secondMatrixParams[1])

        val result = generatePrefilledMatrix(
            rows,
            columns
        )
        for (rowIndex in 0 until rows) {
            for (columnIndex in 0 until columns) {
                result[rowIndex][columnIndex] = multiplyAndSumList(
                    getFirstMatrixValue(firstMatrix, rowIndex),
                    getSecondMatrixValue(secondMatrix, columnIndex)
                )
            }
        }

        for (line in result) {
            println(line.joinToString(" "))
        }
    }
}

fun multiplyAndSumList(firstMatrixValue: List<Double>, secondMatrixValue: List<Double>): Double {
    var result = 0.0
    for (index in firstMatrixValue.indices) {
        result += firstMatrixValue[index] * secondMatrixValue[index]
    }
    return result
}

fun getFirstMatrixValue(list: List<List<Double>>, rowIndex: Int): List<Double> {
    return list[rowIndex]
}

fun getSecondMatrixValue(list: List<List<Double>>, columnIndex: Int): List<Double> {
    val result = mutableListOf<Double>()
    for (line in list) {
        result.add(line[columnIndex])
    }
    return result
}

private fun transposeMatrix(
    secondMatrixParams: List<Int>,
    secondMatrix: MutableList<List<Double>>,
    transformedMatrix: MutableList<MutableList<Double>>
) {
    for (row in 0 until secondMatrixParams[0]) {
        for (line in 0 until secondMatrixParams[1]) {
            val value = secondMatrix[row][line]
            transformedMatrix[line][row] = value
        }
    }
}

private fun generatePrefilledMatrix(
    row: Int,
    column: Int,
    value: Double = 0.0
): MutableList<MutableList<Double>> {
    val result = mutableListOf<MutableList<Double>>()
    repeat(row) {
        val line = mutableListOf<Double>()
        repeat(column) {
            line.add(value)
        }
        result.add(line)
    }
    return result
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
    val secondMatrix = parseMatrix(secondMatrixParams, "second ")

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

private fun parseMatrix(matrixParams: List<Int>, name: String = " "): MutableList<List<Double>> {
    val matrix = mutableListOf<List<Double>>()
    println("Enter ${name}matrix:")
    repeat(matrixParams[0]) {
        val line = readLine()!!.split(" ").map { it.toDouble() }
        matrix.add(line)
    }
    return matrix
}
