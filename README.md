# Beat the dealer game
Solution for FINN.no's technical test.

## Requirements
- Java 8
- Kotlin 1.6

## How to run
Use your local gradle or the provided wrapper to run the game with a new shuffled deck:
```
./gradlew run
```
Or run the game with a deck file:
```
./gradlew run --args=<DECK_FILE_PATH>
```
The example input from the problem statement can be found in `src/test/resources/valid-deck.txt`.

## Assumptions
- The input deck file will always contain enough cards to finish the game with a winner (at least 4 cards)

## Possible next steps
- Validate program arguments (print usage message if too many arguments are provided)
- Validate input deck to ensure all cards are unique
- Validate input deck to ensure there are at least 4 cards
- Handle case when there are not enough cards to finish the game with a winner (remove assumption)
- Handle case when there is a tie between the two players
- Add more game rules, make the program interactive...
- Internationalization (i18n): support different locales when printing cards
- Use custom, descriptive domain exceptions instead of `IllegalArgumentException` and `IllegalStateException`
- Test deck shuffling randomness ([interesting read!](https://softwareengineering.stackexchange.com/a/147142/282413))

## Notes
Thank you for your time to review my solution!