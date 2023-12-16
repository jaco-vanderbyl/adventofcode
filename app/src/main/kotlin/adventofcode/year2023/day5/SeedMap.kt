package adventofcode.year2023.day5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking

class SeedMap(fileName: String = "year2023/day5/seed_maps") {
    private val inputStr = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()?.readText()
        .toString().replace("\r\n".toRegex(), "\n").replace("  ", " ")

    private val maps = listOf("soil", "fertilizer", "water", "light", "temperature", "humidity", "location")

    data class MapRange(val destinationStart: Long, val sourceStart: Long, val rangeSize: Long)
    data class SeedRange(val start: Long, val rangeSize: Long)

    fun lowestLocation(): Long {
        val seeds = getSeedData()
        val rangeMaps = maps.map { createRangeMap(getMapRangeData(it)) }
        return seeds.minOf { getLocation(rangeMaps, it) }
    }

    fun lowestLocationGivenSeedRanges(): Long {
        val seedRanges = getSeedRangeData()
        val rangeMaps = maps.map { createRangeMap(getMapRangeData(it)) }
        var lowestLocation = Long.MAX_VALUE

        return runBlocking(Dispatchers.Default) {
            val locations = seedRanges.map { seedRange ->
                val range = seedRange.start..<seedRange.start + seedRange.rangeSize

                async {
                    for (seed in range) {
                        val location = getLocation(rangeMaps, seed)
                        if (location < lowestLocation) lowestLocation = location
                    }
                    lowestLocation
                }
            }.awaitAll()
            return@runBlocking locations.min()
        }
    }

    private fun getSeedData(): List<Long> = """seeds: (?<seeds>(\d+.+))""".toRegex().find(
        inputStr
    )?.groups?.get("seeds")?.value?.split(" ")?.map {
        it.toLong()
    } ?: throw IllegalArgumentException()

    private fun getSeedRangeData(): List<SeedRange> = """\d+ \d+""".toRegex().findAll(
        """seeds: (?<seeds>(\d+.+))""".toRegex().find(inputStr)?.groups?.get("seeds")?.value ?: ""
    ).map {
        val seedValues = it.value.split(" ")
        SeedRange(seedValues[0].toLong(), seedValues[1].toLong())
    }.toList()

    private fun getMapRangeData(name: String) : List<MapRange> = """$name map:\n(?<map>(\d+.+|\n)+)"""
        .toRegex().find(inputStr)?.groups?.get("map")?.value?.split("\n".toRegex())?.filter { it.isNotEmpty() }
        ?.map {
            val mapValues = it.split(" ")
            MapRange(mapValues[0].toLong(), mapValues[1].toLong(), mapValues[2].toLong())
        } ?: throw IllegalArgumentException()

    private fun createRangeMap(ranges: List<MapRange>) : Map<LongRange,LongRange> {
        val rangeMap = mutableMapOf<LongRange,LongRange>()
        ranges.forEach {
            val sourceRange = it.sourceStart..<it.sourceStart + it.rangeSize
            val destinationRange = it.destinationStart..<it.destinationStart + it.rangeSize
            rangeMap[sourceRange] = destinationRange
        }
        return rangeMap.toMap()
    }

    private fun getDestination(rangeMap: Map<LongRange,LongRange>, key: Long) : Long {
        var value: Long? = null
        rangeMap.forEach { (sourceRange, destinationRange) ->
            if (key in sourceRange) {
                value = destinationRange.first + (key - sourceRange.first)
                return@forEach
            }
        }
        return value ?: key
    }

    private fun getLocation(rangeMaps: List<Map<LongRange,LongRange>>, seed: Long) : Long {
        var destination: Long = seed
        rangeMaps.forEach {
            destination = getDestination(it, destination)
        }
        return destination
    }
}
