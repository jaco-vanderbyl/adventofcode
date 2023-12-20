package year2023

/**
 * https://adventofcode.com/2023/day/3
 */
class Day03Puzzle01(fileName: String = "year2023/input_day03") {
    private val inputReader = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()
    private val schematic = inputReader?.readLines() ?: listOf()

    data class Number(val value: Int, val row: Int, val colFirst: Int, val colLast: Int)
    data class Cor(val row: Int, val col: Int)

    // What is the sum of all of the part numbers in the engine schematic?
    fun run() : Int = schematic.mapIndexed { row, str ->
        findNumbers(row, str)
    }.flatten().let { numbers ->
        createCorsAroundNumbers(numbers)
    }.map { corsAroundNumber ->
        val number = corsAroundNumber.key
        val cors = corsAroundNumber.value
        if (isPart(cors)) number.value else 0
    }.sum()

    private fun findNumbers(row: Int, str: String) = """\d+""".toRegex().findAll(str).map { match ->
        Number(match.value.toInt(), row, match.range.first, match.range.last)
    }.toList()

    private fun createCorsAroundNumbers(numbers: List<Number>) : Map<Number,List<Cor>> {
        val corsPerNumber = mutableMapOf<Number,List<Cor>>()
        numbers.forEach { number ->
            val cors = mutableListOf<Cor>()
            for (col in number.colFirst - 1..number.colLast + 1) for (offset in setOf(-1, 1)) {
                cors.add(Cor(number.row + offset, col))
            }
            cors.add(Cor(number.row, number.colFirst - 1))
            cors.add(Cor(number.row, number.colLast + 1))
            corsPerNumber[number] = cors.toList().filter { inBounds(it) }
        }
        return corsPerNumber.toMap()
    }

    private fun isPart(cors: List<Cor>) : Boolean {
        cors.forEach { if (schematic[it.row][it.col] != '.') return true }
        return false
    }

    private fun inBounds(c: Cor) : Boolean = c.row in schematic.indices && c.col in 0..<schematic[c.row].length
}
