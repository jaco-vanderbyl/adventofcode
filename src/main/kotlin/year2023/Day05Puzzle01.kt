package year2023

/**
 * https://adventofcode.com/2023/day/5
 */
class Day05Puzzle01(fileName: String = "year2023/input_day05") {
    private val inputReader = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()

    enum class MapTypes { SOIL, FERTILIZER, WATER, LIGHT, TEMPERATURE, HUMIDITY, LOCATION }

    data class MapRange(val mapType: MapTypes, val destinationStart: Long, val sourceStart: Long, val rangeSize: Long) {
        val sourceRange = sourceStart..<(sourceStart + rangeSize)
        val destinationRange = destinationStart..<(destinationStart + rangeSize)
    }

    class Maps(private val ranges: List<MapRange>) {
        fun findLocation(seed: Long) : Long {
            var value = seed
            MapTypes.entries.forEach { mapType -> value = lookupDestination(mapType, value) }
            return value
        }

        private fun lookupDestination(mapType: MapTypes, source: Long) : Long {
            ranges.filter { mapRange -> mapRange.mapType == mapType }.forEach { mapRange ->
                if (source in mapRange.sourceRange) {
                    return mapRange.destinationRange.first + (source - mapRange.sourceRange.first)
                }
            }
            return source
        }
    }

    // What is the lowest location number that corresponds to any of the initial seed numbers?
    fun run(): Long {
        val inputStr = inputReader?.readText()?.replace("\r\n", "\n")?.replace("  ", " ") ?: ""
        val seeds = getSeeds(inputStr)
        val maps = Maps(ranges = MapTypes.entries.map { mapType -> getMapRanges(inputStr, mapType) }.flatten())
        return seeds.minOf { seed -> maps.findLocation(seed) }
    }

    private fun getSeeds(str: String): List<Long> = """seeds: (?<seeds>(\d+.+))""".toRegex().find(
        str
    )?.groups?.get("seeds")?.value?.split(" ")?.map {
        it.toLong()
    } ?: throw IllegalArgumentException()

    private fun getMapRanges(str: String, mapType: MapTypes) : List<MapRange> {
        return """${mapType.name.lowercase()} map:\n(?<map>(\d+.+|\n)+)""".toRegex().find(
            str
        )?.groups?.get("map")?.value?.split("\n".toRegex())?.filter { it.isNotEmpty() }?.map {
            val mapValues = it.split(" ")
            MapRange(mapType, mapValues[0].toLong(), mapValues[1].toLong(), mapValues[2].toLong())
        } ?: throw IllegalArgumentException()
    }
}
