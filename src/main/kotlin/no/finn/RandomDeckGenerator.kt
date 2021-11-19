package no.finn

class RandomDeckGenerator {
    fun generate(): Deck {
        val shuffledCards = CardSuit
            .values()
            .flatMap { suit -> CardValue.values().map { Card(suit, it) } }
            .shuffled()

        return Deck(shuffledCards)
    }
}
