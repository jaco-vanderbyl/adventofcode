package year2023

import kotlin.math.abs

/**
 * https://adventofcode.com/2023/day/5
 */
class Day05Puzzle02(fileName: String = "year2023/input_day05") {
    private val inputReader = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()

    enum class MapTypes { SOIL, FERTILIZER, WATER, LIGHT, TEMPERATURE, HUMIDITY, LOCATION }

    data class SeedRange(val start: Long, val rangeSize: Long) {
        val range = start..<(start + rangeSize)
    }

    data class MapRange(val mapType: MapTypes, val destinationStart: Long, val sourceStart: Long, val rangeSize: Long) {
        val sourceRange = sourceStart..<(sourceStart + rangeSize)
        val destinationRange = destinationStart..<(destinationStart + rangeSize)
        fun max() : Long = maxOf(sourceRange.last, destinationRange.last)
    }

    class Seeds(private val ranges: List<SeedRange>) {
        val minRangeSize: Long = ranges.minOf { it.rangeSize }

        fun isSeedInRange(seed: Long) : Boolean {
            ranges.forEach { if (seed in it.range) return true }
            return false
        }
    }

    class Maps(private val ranges: List<MapRange>) {
        private val locationRange = 0..ranges.maxOf { it.max() }

        fun lowestLocation(seeds: Seeds, range: LongRange = locationRange, step: Long = seeds.minRangeSize) : Long? {
            val halfRangeDiff = abs((range.last - range.first) / 2)
            var newStep = if (step <= halfRangeDiff) step else halfRangeDiff
            if (newStep < 1) newStep = 1L

            var lastLocation = range.first
            for (location in range step newStep) {
                if (seeds.isSeedInRange(findSeed(location))) {
                    if (range.last - range.first == 0L) return location

                    if (step <= halfRangeDiff) return lowestLocation(seeds, (location - newStep)..location, newStep)

                    val midRange = range.first + abs((location - range.first) / 2)
                    return when (val firstHalf = lowestLocation(seeds, range.first..midRange, newStep)) {
                        null -> lowestLocation(seeds, (midRange + 1)..location, newStep)
                        else -> firstHalf
                    }
                }
                lastLocation = location
            }

            if (lastLocation < range.last) return lowestLocation(seeds, lastLocation..range.last, newStep)

            return null
        }

        private fun findSeed(location: Long) : Long {
            var value = location
            MapTypes.entries.reversed().forEach { mapType -> value = lookupSource(mapType, value) }
            return value
        }

        private fun lookupSource(mapType: MapTypes, destination: Long) : Long {
            ranges.filter { mapRange -> mapRange.mapType == mapType }.forEach { mapRange ->
                if (destination in mapRange.destinationRange) {
                    return mapRange.sourceRange.first + (destination - mapRange.destinationRange.first)
                }
            }
            return destination
        }
    }

    // Consider all the initial seed numbers listed in the ranges on the first line of the almanac.
    // What is the lowest location number that corresponds to any of the initial seed numbers?
    fun run(): Long {
        val inputStr = inputReader?.readText()?.replace("\r\n", "\n")?.replace("  ", " ") ?: ""
        val seeds = Seeds(ranges = getSeedRanges(inputStr))
        val maps = Maps(ranges = MapTypes.entries.map { mapType -> getMapRanges(inputStr, mapType) }.flatten())
        return maps.lowestLocation(seeds) ?: throw IllegalArgumentException()
    }

    private fun getSeedRanges(str: String): List<SeedRange> = """\d+ \d+""".toRegex().findAll(
        """seeds: (?<seeds>(\d+.+))""".toRegex().find(str)?.groups?.get("seeds")?.value ?: ""
    ).map {
        val seedValues = it.value.split(" ")
        SeedRange(seedValues[0].toLong(), seedValues[1].toLong())
    }.toList()

    private fun getMapRanges(str: String, mapType: MapTypes) : List<MapRange> {
        return """${mapType.name.lowercase()} map:\n(?<map>(\d+.+|\n)+)""".toRegex().find(
            str
        )?.groups?.get("map")?.value?.split("\n".toRegex())?.filter { it.isNotEmpty() }?.map {
            val mapValues = it.split(" ")
            MapRange(mapType, mapValues[0].toLong(), mapValues[1].toLong(), mapValues[2].toLong())
        } ?: throw IllegalArgumentException()
    }
}
