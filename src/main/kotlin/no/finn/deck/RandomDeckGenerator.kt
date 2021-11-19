package no.finn.deck

import no.finn.Card
import no.finn.CardSuit
import no.finn.CardValue

class RandomDeckGenerator {
    fun generate(): Deck {
        val shuffledCards = CardSuit
            .values()
            .flatMap { suit -> CardValue.values().map { Card(suit, it) } }
            .shuffled()

        return Deck(shuffledCards)
    }
}
