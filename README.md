# Advent of Code
Kotlin app with [Advent of Code](https://adventofcode.com/) exercises.

## Requirements
* [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

## Build the project and run tests
It is recommended to open the project in the latest released version of
[Intellij IDEA](https://www.jetbrains.com/idea/download) (Community or Ultimate Edition), which will
automatically install the appropriate version of Gradle — the required build tool for the project.

### IntelliJ IDEA
Clone the repo and open the project in IntelliJ IDEA. The IDE will automatically build the project
and run tests.

### Gradle Wrapper
To build manually, clone the repo, change to the project root directory, and run the following command from console:
```
$ ./gradlew build
```
In Windows:
```
$ .\gradlew.bat build
```
_The Gradle Wrapper is the preferred way of starting a Gradle build. The Wrapper downloads (if needed) and then
invokes a specific version of Gradle declared in the build._
