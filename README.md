# Implementation of Fast Hill Climbing Algorithm in Kotlin

## Situation
We are tasked with finding an optimal match for a target string using a Hill Climbing algorithm. The challenge involves starting with a random string of the same length as the target and iteratively improving it by modifying characters until the current string matches the target string.

## Goal
The main goal is to generate a string that exactly matches the target string `"REALLY BIG AND HARD TO FIND STRING"`. The algorithm performs a step-by-step search by altering the current string and retaining the modifications that improve the match with the target string.

## Use of Hill Climbing Algorithm
Hill Climbing is a local search algorithm used to find a better solution iteratively by evaluating neighboring solutions. In this implementation, the algorithm compares how well each neighboring string matches the target. The algorithm continues improving the solution until it either finds a perfect match or reaches the maximum number of iterations.

## Key Stages of the Process:

1. **Initialization:**  
   The algorithm begins with a randomly generated string that has the same length as the target string.

2. **Fitness Evaluation:**  
   The fitness function calculates how many characters in the current string match the corresponding characters in the target string. The fitness score increases as more characters match.

3. **Generate Neighbor:**  
   The algorithm generates a new neighboring string by randomly modifying a character from the current string that does not match the target.

4. **Comparison:**  
   The fitness of the new neighboring string is compared to the current string. If the new string has a better fitness score (more matching characters), it becomes the new current string.

5. **Iteration:**  
   This process is repeated iteratively, and the algorithm continually moves towards better solutions. It stops when either the target string is found or the algorithm reaches the maximum allowed iterations.

6. **Termination:**  
   The algorithm halts when the target string is matched perfectly or when it is no longer possible to find a better solution within the allowed iterations.

## Example of Target and Random String Matching
In this example, the target string is `"REALLY BIG AND HARD TO FIND STRING"`. The algorithm starts with a random string of the same length and gradually modifies it character by character until it matches the target string or reaches the maximum iteration count.

## Code Structure:

- **`runHillClimbingAlgorithm`**: This function drives the Hill Climbing algorithm. It iterates through the search process, updating the current string when a better neighbor is found. The algorithm terminates when the target string is matched or when the maximum number of iterations is reached.

- **`generateNeighbor`**: This function generates a new neighboring string by modifying a character that differs from the target in the current string.

- **`fitness`**: This function calculates how close the current string is to the target by counting the number of matching characters.

- **`randomString`**: This function generates the initial random string, which has the same length as the target string.

## Conclusion
This implementation of the Hill Climbing algorithm in Kotlin demonstrates a simple yet effective approach to string matching. By iteratively improving the current solution based on a fitness function, the algorithm seeks an optimal match with the target string.
