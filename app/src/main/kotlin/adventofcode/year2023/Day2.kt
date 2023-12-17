package adventofcode.year2023

/**
 * https://adventofcode.com/2023/day/2
 */
class Day2(fileName: String = "adventofcode/year2023/input_day2") {
    private val gameLog = mutableListOf<String>()

    init {
        ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()?.useLines { gameLog.addAll(it) }
    }

    fun puzzle1(redMax: Int = 12, greenMax: Int = 13, blueMax: Int = 14) : Int = gameLog.filterNot { str ->
        Regex("""(?<r>\d+) red""").findAll(str).mapNotNull { it.groups["r"]?.value?.toInt() }.max() > redMax ||
        Regex("""(?<g>\d+) green""").findAll(str).mapNotNull { it.groups["g"]?.value?.toInt() }.max() > greenMax ||
        Regex("""(?<b>\d+) blue""").findAll(str).mapNotNull { it.groups["b"]?.value?.toInt() }.max() > blueMax
    }.mapNotNull { str ->
        Regex("""Game (?<id>\d+)""").find(str)?.groups?.get("id")?.value?.toInt()
    }.sum()

    fun puzzle2() : Int = gameLog.sumOf { str ->
        Regex("""(?<r>\d+) red""").findAll(str).mapNotNull { it.groups["r"]?.value?.toInt() }.max() *
        Regex("""(?<g>\d+) green""").findAll(str).mapNotNull { it.groups["g"]?.value?.toInt() }.max() *
        Regex("""(?<b>\d+) blue""").findAll(str).mapNotNull { it.groups["b"]?.value?.toInt() }.max()
    }
}
