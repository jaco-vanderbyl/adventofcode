package year2023

/**
 * https://adventofcode.com/2023/day/3
 */
class Day03Puzzle02(fileName: String = "year2023/input_day03") {
    private val inputReader = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()
    private val schematic = inputReader?.readLines() ?: listOf()

    enum class Dir { LEFT, RIGHT }

    fun run() = schematic.mapIndexed { row, str ->
        findGears(row, str)
    }.flatten().sumOf { gears ->
        gears.reduce { acc, next -> acc * next }
    }

    private fun findGears(row: Int, str: String) : List<List<Int>> = """\*""".toRegex().findAll(str).map { match ->
        findPartsAroundCor(row, col = match.range.first)
    }.filter { parts ->
        isGear(parts)
    }.toList()

    private fun findPartsAroundCor(row: Int, col: Int) : List<Int> {
        val top = findPart(row - 1, col)
        val bottom = findPart(row + 1, col)
        val left = findPart(row, col - 1)
        val right = findPart(row, col + 1)
        val topLeft = if (top == null) findPart(row - 1, col - 1) else null
        val topRight = if (top == null) findPart(row - 1, col + 1) else null
        val bottomLeft = if (bottom == null) findPart(row + 1, col - 1) else null
        val bottomRight = if (bottom == null) findPart(row + 1, col + 1) else null

        return listOfNotNull(top, bottom, left, right, topLeft, topRight, bottomLeft, bottomRight).map { it.toInt() }
    }

    private fun findPart(row: Int, col: Int) : String? {
        val char = if (inBounds(row, col)) schematic[row][col] else ' '
        return when (char.isDigit()) {
            true -> "${findPartialPart(Dir.LEFT, row, col - 1)}${char}${findPartialPart(Dir.RIGHT, row, col + 1)}"
            false -> null
        }
    }

    private fun findPartialPart(dir: Dir, row: Int, col: Int, partialPart: String = "") : String {
        val char = if (inBounds(row, col)) schematic[row][col] else ' '
        return when (char.isDigit()) {
            true -> when (dir) {
                Dir.LEFT -> findPartialPart(dir, row, col - 1, partialPart = char + partialPart)
                Dir.RIGHT -> findPartialPart(dir, row, col + 1, partialPart = partialPart + char)
            }
            false -> partialPart
        }
    }

    private fun isGear(parts: List<Int>) : Boolean = parts.size == 2

    private fun inBounds(row: Int, col: Int) : Boolean = row in schematic.indices && col in 0..<schematic[row].length
}
