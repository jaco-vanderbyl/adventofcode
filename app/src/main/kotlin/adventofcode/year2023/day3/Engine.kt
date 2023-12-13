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
}
