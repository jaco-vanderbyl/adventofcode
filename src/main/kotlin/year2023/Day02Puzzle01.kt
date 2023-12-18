package year2023

/**
 * https://adventofcode.com/2023/day/2
 */
class Day02Puzzle01(fileName: String = "year2023/input_day02") {
    private val inputReader = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()

    // Determine which games would have been possible if the bag had been loaded with only 12 red cubes,
    // 13 green cubes, and 14 blue cubes. What is the sum of the IDs of those games?
    fun run() : Int = generateSequence { inputReader?.readLine() }.filterNot { str ->
        Regex("""(?<r>\d+) red""").findAll(str).mapNotNull { it.groups["r"]?.value?.toInt() }.max() > 12 ||
        Regex("""(?<g>\d+) green""").findAll(str).mapNotNull { it.groups["g"]?.value?.toInt() }.max() > 13 ||
        Regex("""(?<b>\d+) blue""").findAll(str).mapNotNull { it.groups["b"]?.value?.toInt() }.max() > 14
    }.mapNotNull { str ->
        Regex("""Game (?<id>\d+)""").find(str)?.groups?.get("id")?.value?.toInt()
    }.sum()
}
