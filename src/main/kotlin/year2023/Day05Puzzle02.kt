package year2023

import kotlin.math.abs

/**
 * https://adventofcode.com/2023/day/5
 */
class Day05Puzzle02(fileName: String = "year2023/input_day05") {
    private val inputReader = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()

    // Consider all the initial seed numbers listed in the ranges on the first line of the almanac.
    // What is the lowest location number that corresponds to any of the initial seed numbers?
    fun run(): Long {
        val inputStr = inputReader?.readText()?.replace("\r\n", "\n")?.replace("  ", " ") ?: ""
        val seeds = Seeds(ranges = getSeedRanges(inputStr))
        val maps = Maps(ranges = MapType.entries.map { mapType -> getMapRanges(inputStr, mapType) }.flatten())
        return maps.lowestLocation(seeds) ?: throw IllegalArgumentException()
    }

    enum class MapType { SOIL, FERTILIZER, WATER, LIGHT, TEMPERATURE, HUMIDITY, LOCATION }

    data class SeedRange(val start: Long, val rangeSize: Long) {
        val range = start..<(start + rangeSize)
    }

    data class MapRange(val mapType: MapType, val destinationStart: Long, val sourceStart: Long, val rangeSize: Long) {
        val source = sourceStart..<(sourceStart + rangeSize)
        val destination = destinationStart..<(destinationStart + rangeSize)
        val first = minOf(source.first, destination.first)
        val last = maxOf(source.last, destination.last)
    }

    class Seeds(private val ranges: List<SeedRange>) {
        val minRangeSize: Long = ranges.minOf { it.rangeSize }

        fun inRange(seed: Long) : Boolean {
            ranges.forEach { if (seed in it.range) return true }
            return false
        }
    }

    class Maps(private val ranges: List<MapRange>) {
        private val fullRange = ranges.minOf { it.first }..ranges.maxOf { it.last }

        /**
         * Using the smallest seed range size as the step size,
         * step over the location range until a location that maps to a legit seed is found,
         * then recursively adjust the range and step-size, until the lowest location is found.
         */
        fun lowestLocation(seeds: Seeds, range: LongRange = fullRange, step: Long = seeds.minRangeSize) : Long? {
            // As range sizes are reduced recursively, ensure that range can be stepped through at least twice.
            val halfRangeDiff = abs((range.last - range.first + 2) / 2)
            val newStep = if (step <= halfRangeDiff) step else halfRangeDiff

            var lastLocation = range.first
            for (location in range step newStep) {
                if (seeds.inRange(findSeed(location))) {
                    // The range size has been reduced to 1; the seed with the lowest location has been found.
                    if (range.last - range.first == 0L) return location

                    // A location that maps to a legit seed has been found in the range.
                    // The lowest location must be somewhere in the last step; set range accordingly for the next pass.
                    // The next pass will start to reduce the step sizes, and this condition will never be true again.
                    if (step <= halfRangeDiff) return lowestLocation(seeds, (location - newStep)..location, newStep)

                    // The lowest location is either in the first or second half of the range.
                    // Try the first half first, and proceed to the second half if the first yields nothing.
                    val midRange = range.first + abs((location - range.first) / 2) + 1
                    return when (val firstHalf = lowestLocation(seeds, range.first..<midRange, newStep)) {
                        null -> lowestLocation(seeds, midRange..location, newStep)
                        else -> firstHalf
                    }
                }
                lastLocation = location
            }

            // The step size will not always be a factor of the range size.
            // Ensure that the remainder at the end of the range is searched.
            if (lastLocation < range.last) return lowestLocation(seeds, lastLocation..range.last, newStep)

            return null
        }

        private fun findSeed(location: Long) : Long {
            var value = location
            MapType.entries.reversed().forEach { mapType -> value = lookupSource(mapType, value) }
            return value
        }

        private fun lookupSource(mapType: MapType, destination: Long) : Long {
            ranges.filter { mapRange -> mapRange.mapType == mapType }.forEach { mapRange ->
                if (destination in mapRange.destination) {
                    return mapRange.source.first + (destination - mapRange.destination.first)
                }
            }
            return destination
        }
    }

    private fun getSeedRanges(str: String): List<SeedRange> = """\d+ \d+""".toRegex().findAll(
        """seeds: (?<seeds>(\d+.+))""".toRegex().find(str)?.groups?.get("seeds")?.value ?: ""
    ).map {
        val seedValues = it.value.split(" ")
        SeedRange(seedValues[0].toLong(), seedValues[1].toLong())
    }.toList()

    private fun getMapRanges(str: String, mapType: MapType) : List<MapRange> {
        return """${mapType.name.lowercase()} map:\n(?<map>(\d+.+|\n)+)""".toRegex().find(
            str
        )?.groups?.get("map")?.value?.split("\n".toRegex())?.filter { it.isNotEmpty() }?.map {
            val mapValues = it.split(" ")
            MapRange(mapType, mapValues[0].toLong(), mapValues[1].toLong(), mapValues[2].toLong())
        } ?: throw IllegalArgumentException()
    }
}
