package year2023

/**
 * https://adventofcode.com/2023/day/2
 */
class Day02Puzzle02(fileName: String = "year2023/input_day02") {
    private val inputReader = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()

    // For each game, find the minimum set of cubes that must have been present.
    // What is the sum of the power of these sets?
    fun run() : Int = generateSequence { inputReader?.readLine() }.sumOf { str ->
        Regex("""(?<r>\d+) red""").findAll(str).mapNotNull { it.groups["r"]?.value?.toInt() }.max() *
        Regex("""(?<g>\d+) green""").findAll(str).mapNotNull { it.groups["g"]?.value?.toInt() }.max() *
        Regex("""(?<b>\d+) blue""").findAll(str).mapNotNull { it.groups["b"]?.value?.toInt() }.max()
    }
}
