package adventofcode.year2023.day2

class CubeGameAnalyser(fileName: String = "year2023/day2/cube_games_log") {
    private val gameLog = mutableListOf<String>()

    init {
        ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()?.useLines { gameLog.addAll(it) }
    }

    fun sumOfGameIds(redMax: Int, greenMax: Int, blueMax: Int) : Int = gameLog.filterNot { str ->
        Regex("""(?<r>\d+) red""").findAll(str).mapNotNull { it.groups["r"]?.value?.toInt() }.max() > redMax ||
        Regex("""(?<g>\d+) green""").findAll(str).mapNotNull { it.groups["g"]?.value?.toInt() }.max() > greenMax ||
        Regex("""(?<b>\d+) blue""").findAll(str).mapNotNull { it.groups["b"]?.value?.toInt() }.max() > blueMax
    }.mapNotNull { str ->
        Regex("""Game (?<id>\d+)""").find(str)?.groups?.get("id")?.value?.toInt()
    }.sum()

    fun sumOfGameSetPowers() : Int = gameLog.sumOf { str ->
        Regex("""(?<r>\d+) red""").findAll(str).mapNotNull { it.groups["r"]?.value?.toInt() }.max() *
        Regex("""(?<g>\d+) green""").findAll(str).mapNotNull { it.groups["g"]?.value?.toInt() }.max() *
        Regex("""(?<b>\d+) blue""").findAll(str).mapNotNull { it.groups["b"]?.value?.toInt() }.max()
    }
}
