package no.finn.deck

import no.finn.Card
import no.finn.CardSuit.*
import no.finn.CardValue.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeckTest {
    @Test
    fun shouldDrawCardsInCorrectOrder() {
        val firstCard = Card(CLUB, TWO)
        val secondCard = Card(DIAMOND, SEVEN)
        val cards = listOf(
            firstCard,
            secondCard,
            Card(HEART, QUEEN)
        )

        val deck = Deck(cards)
        val firstDraw = deck.draw()
        val secondDraw = deck.draw()

        assertEquals(firstCard, firstDraw)
        assertEquals(secondCard, secondDraw)
    }

    @Test
    fun shouldHaveSameHashcodeForSameDecks() {
        val cards = listOf(
            Card(CLUB, TWO),
            Card(DIAMOND, SEVEN),
            Card(HEART, QUEEN)
        )

        val firstDeck = Deck(cards)
        val secondDeck = Deck(cards)

        assertEquals(firstDeck.hashCode(), secondDeck.hashCode())
    }
}