import Constants.chars
import kotlin.random.Random

fun main() {
    // Set the target string that the algorithm will try to match
    val target = "REALLY BIG AND HARD TO FIND STRING"

    // Generate a random initial string of the same length as the target
    var current = randomString(target)

    // Set the maximum number of iterations for the Hill Climbing algorithm
    val maxIterations = 1000

    // Run the Hill Climbing algorithm to optimize the current string toward the target
    runHillClimbingAlgorithm(maxIterations, target, current)
}

private fun runHillClimbingAlgorithm(maxIterations: Int, target: String, current: String) {
    var current1 = current
    // Iterate through the algorithm for a maximum of maxIterations
    for (i in 0..maxIterations) {
        // Calculate the fitness of the current string
        val bestFitness = fitness(target, current1)

        // Generate a neighboring string by modifying one character of the current string
        val newNeighbor = generateNeighbor(current1, target)

        // Calculate the fitness of the neighboring string
        val newFitness = fitness(target, newNeighbor)

        // If the new neighbor has a better fitness score, update the current string
        if (newFitness > bestFitness) {
            current1 = newNeighbor

            // If the current string matches the target, stop the algorithm
            if (current1 == target) {
                println("Target string has been found on iteration $i.! Current string --> $current1, Target: $target")
                break
            } else {
                // Otherwise, print the updated fitness information
                println("Upgraded fitness has been found on iteration $i.! Current string --> $current1, Target: $target")
            }
        }
    }
}

// Instead of simple hill climbing alghorithm where we changing random indices here we changing only diff indecies. That's make fast hill climb alghorithm more effective.
private fun generateNeighbor(current: String, target: String): String {
    var charArray = current.toCharArray()
    val newChar = Random.nextInt(from = 0, until = chars.length)

    for(i in charArray.indices) {
        if(charArray[i] != target[i]) charArray[i] = chars[newChar]
    }

    return charArray.joinToString("")
}

// Compare each character in the target and current strings and count matches
private fun fitness(target: String, current: String) = target.zip(current).count { it.first == it.second }

private fun randomString(target: String) =
    // Generate a random string of the same length as the target, using random characters
    target.map { chars.random() }.joinToString("")
