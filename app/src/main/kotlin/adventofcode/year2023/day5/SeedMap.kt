package adventofcode.year2023.day5

class SeedMap(fileName: String = "year2023/day5/seed_maps") {
    private val seedMapsRaw = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()?.readText()
        .toString().replace("\r\n".toRegex(), "\n").replace("  ", " ")

    private val maps = listOf("soil", "fertilizer", "water", "light", "temperature", "humidity", "location")

    fun lowestLocation() : Long {
        val seeds = getSeedsFromInput()
        val rangeMaps = maps.map{ createRangeMap(getMapData(it)) }
        return seeds.minOf { getDestination(rangeMaps, it) }
    }

    private fun getSeedsFromInput() : List<Long> = """seeds: (?<seeds>(\d+.+))""".toRegex().find(seedMapsRaw)
        ?.groups?.get("seeds")?.value?.split(" ")?.map {
            it.toLong()
        } ?: listOf()

    private fun getMapData(name: String) : List<Triple<Long,Long,Long>> = """$name map:\n(?<map>(\d+.+|\n)+)"""
        .toRegex().find(seedMapsRaw)?.groups?.get("map")?.value?.split("\n".toRegex())?.filter { it.isNotEmpty() }
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

    private fun getDestination(rangeMap: Map<LongRange,LongRange>, key: Long) : Long {
        var value: Long? = null
        rangeMap.forEach { (sourceRange, destinationRange) ->
            if (key in sourceRange) {
                val offset = key - sourceRange.first
                value = destinationRange.first + offset
                return@forEach
            }
        }
        return value ?: key
    }

    private fun getDestination(rangeMaps: List<Map<LongRange,LongRange>>, seed: Long) : Long {
        var destination: Long = seed
        rangeMaps.forEach {
            destination = getDestination(it, destination)
        }
        return destination
    }
}
