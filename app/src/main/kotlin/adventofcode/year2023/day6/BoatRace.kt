package adventofcode.year2023.day6

class BoatRace(fileName: String = "year2023/day6/races") {
    private val races = mutableListOf<String>()

    init {
        ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()?.useLines { races.addAll(it) }
    }

    fun betterStrategyPart1() = strategyProduct(times = getValues(row = 0), records = getValues(row = 1))
    fun betterStrategyPart2() = strategyProduct(times = listOf(getValue(row = 0)), records = listOf(getValue(row = 1)))

    private fun strategyProduct(times: List<Long>, records: List<Long>) : Long = times.mapIndexed { index, time ->
        countBetterStrategies(time, records[index])
    }.reduce { acc, i -> acc * i }

    private fun getValues(row: Int) : List<Long> = """\d+""".toRegex().findAll(races[row])
        .map { it.value.toLong() }.toList()

    private fun getValue(row: Int) : Long = """\d+""".toRegex().findAll(races[row])
        .map { it.value }.reduce { acc, i -> "$acc$i" }.toLong()

    private fun countBetterStrategies(time: Long, record: Long) : Long {
        var count = 0L
        for (it in 1..<time) {
            if ((time - it) * it > record) count++
        }
        return count
    }
}
