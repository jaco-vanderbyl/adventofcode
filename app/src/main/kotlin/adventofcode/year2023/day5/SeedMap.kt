package adventofcode.year2023.day5

class SeedMap(fileName: String = "year2023/day5/seed_maps") {
    private val seedMapsRaw = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()?.readText()
        .toString().replace("\r\n".toRegex(), "\n").replace("  ", " ")

    private val inputRegexes = listOf(
        """seed-to-soil map:\n(?<map>(\d+.+|\n)+)""".toRegex(),
        """soil-to-fertilizer map:\n(?<map>(\d+.+|\n)+)""".toRegex(),
        """fertilizer-to-water map:\n(?<map>(\d+.+|\n)+)""".toRegex(),
        """water-to-light map:\n(?<map>(\d+.+|\n)+)""".toRegex(),
        """light-to-temperature map:\n(?<map>(\d+.+|\n)+)""".toRegex(),
        """temperature-to-humidity map:\n(?<map>(\d+.+|\n)+)""".toRegex(),
        """humidity-to-location map:\n(?<map>(\d+.+|\n)+)""".toRegex(),
    )

    fun lowestLocation() : Long {
        val seeds = getSeedsFromInput()
        val initRangeMaps = mutableListOf<Map<LongRange,LongRange>>()
        val rangeMaps = mutableListOf<Map<LongRange,LongRange>>()

        inputRegexes.mapTo(initRangeMaps) { regex -> createRangeMap(getMapsFromInput(regex)) }
        initRangeMaps.mapTo(rangeMaps) { rangeMap -> fillRangeMap(rangeMap, maxIndexOf(initRangeMaps)) }

        return seeds.minOf { getDestination(rangeMaps, it) }
    }

    private fun getSeedsFromInput() : List<Long> = """seeds: (?<seeds>(\d+.+))""".toRegex().find(seedMapsRaw)
        ?.groups?.get("seeds")?.value?.split(" ")?.map {
            it.toLong()
        } ?: listOf()

    private fun getMapsFromInput(regex: Regex) : List<Triple<Long,Long,Long>> = regex.find(seedMapsRaw)
        ?.groups?.get("map")?.value?.split("\n".toRegex())?.filter { it.isNotEmpty() }
        ?.map {
            val mapValues = it.split(" ")
            Triple(mapValues[0].toLong(), mapValues[1].toLong(), mapValues[2].toLong())
        } ?: listOf()

    private fun createRangeMap(ranges: List<Triple<Long,Long,Long>>) : Map<LongRange,LongRange> {
        val rangeMap = mutableMapOf<LongRange,LongRange>()
        ranges.forEach {
            rangeMap[it.second..<it.second + it.third] = it.first..<it.first + it.third
        }
        return rangeMap.toSortedMap(compareBy { it.first }).toMap()
    }

    private fun maxIndexOf(rangeMaps: List<Map<LongRange,LongRange>>) : Long = rangeMaps.map { map ->
        map.keys.map {it.last } }.maxOf { it.max() }

    private fun fillRangeMap(rangeMap: Map<LongRange,LongRange>, maxIndex: Long) : Map<LongRange,LongRange> {
        val newRangeMap = mutableMapOf<LongRange,LongRange>()
        var first = 0L
        var last = 0L

        rangeMap.keys.toList().sortedBy { it.first }.forEach {
            if (first < it.first) newRangeMap[first..<it.first] = first..<it.first
            first = it.last + 1
            last = it.last
        }
        if (last < maxIndex) newRangeMap[last + 1..maxIndex] = last + 1..maxIndex

        return (rangeMap.toMutableMap() + newRangeMap).toSortedMap(compareBy { it.first }).toMap()
    }

    private fun getDestination(rangeMap: Map<LongRange,LongRange>, key: Long) : Long {
        var value: Long? = null
        rangeMap.forEach { (sourceRange, destinationRange) ->
            if (key in sourceRange) {
                val offset = key - sourceRange.first
                value = destinationRange.first + offset
                return@forEach
            }
        }
        return value ?: throw IndexOutOfBoundsException()
    }

    private fun getDestination(rangeMaps: List<Map<LongRange,LongRange>>, seed: Long) : Long {
        var destination: Long = seed
        rangeMaps.forEach {
            destination = getDestination(it, destination)
        }
        return destination
    }
}
