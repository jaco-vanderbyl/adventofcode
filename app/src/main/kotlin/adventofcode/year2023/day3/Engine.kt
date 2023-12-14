package adventofcode.year2023.day3

class Engine(fileName: String = "year2023/day3/engine_schematic") {
    private val schematic = mutableListOf<String>()

    init {
        ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()?.useLines { schematic.addAll(it) }
    }

    fun sumOfPartNumbers() : Int = schematic.asSequence().mapIndexed { rowIndex, row ->
        """\d+""".toRegex().findAll(row).map {
            heatCors(rowIndex, it.range.first, it.range.last, it.value.toInt(), schematic.size, row.length)
        }
    }.flatten().map { heatCors ->
        heatCors.map { heatCor ->
            (schematic[heatCor.first][heatCor.second] != '.') to heatCor.third
        }.distinct().map { if (it.first) it.second else 0 }
    }.flatten().sum()

    private fun heatCors(
        row: Int, col1: Int, col2: Int, num: Int, size: Int, length: Int
    ) : List<Triple<Int,Int,Int>> {
        val heatCors = mutableListOf<Triple<Int,Int,Int>>()

        for (colIndex in col1 - 1..col2 + 1) {
            for (rowOffset in listOf(-1, 1)) heatCors.add(Triple(row + rowOffset, colIndex, num))
        }
        heatCors.add(Triple(row, col1 - 1, num))
        heatCors.add(Triple(row, col2 + 1, num))

        return heatCors.filterNot { it.first < 0 || it.first >= size || it.second < 0 || it.second >= length }
    }

    fun sumOfGearRatios() = schematic.mapIndexed { rIndex, row ->
        """\*""".toRegex().findAll(row).map {
            findParts(rIndex, it.range.first)
        }.filter { isGear(it) }.toList()
    }.flatten().sumOf { it.reduce { acc, next -> acc * next } }

    private fun isGear(parts: List<Int>) : Boolean = parts.size == 2

    private fun findParts(rIndex: Int, cIndex: Int) : List<Int> {
        val top = findPart(rIndex - 1, cIndex)
        val bottom = findPart(rIndex + 1, cIndex)
        val left = findPart(rIndex, cIndex - 1)
        val right = findPart(rIndex, cIndex + 1)
        val topLeft = if (top == null) findPart(rIndex - 1, cIndex - 1) else null
        val topRight = if (top == null) findPart(rIndex - 1, cIndex + 1) else null
        val bottomLeft = if (bottom == null) findPart(rIndex + 1, cIndex - 1) else null
        val bottomRight = if (bottom == null) findPart(rIndex + 1, cIndex + 1) else null

        return listOfNotNull(top, bottom, left, right, topLeft, topRight, bottomLeft, bottomRight).map { it.toInt() }
    }

    private fun findPart(row: Int, col: Int) : String? {
        val char = if (inBounds(row, col)) schematic[row][col] else ' '

        return when (char.isDigit()) {
            true -> "${discoverPart(Dir.LEFT, row, col - 1)}${char}${discoverPart(Dir.RIGHT, row, col + 1)}"
            false -> null
        }
    }

    private fun discoverPart(dir: Dir, row: Int, col: Int, node: String = "") : String? {
        val char = if (inBounds(row, col)) schematic[row][col] else ' '

        return when (char.isDigit()) {
            true -> when (dir) {
                Dir.LEFT ->  discoverPart(dir, row, col - 1, char + node)
                Dir.RIGHT -> discoverPart(dir, row, col + 1, node + char)
            }
            false -> node
        }
    }

    private fun inBounds(rIndex: Int, cIndex: Int) : Boolean = (
        rIndex >= 0 && rIndex < schematic.size && cIndex >= 0 && cIndex < schematic[rIndex].length
    )
}
enum class Dir { LEFT, RIGHT }
