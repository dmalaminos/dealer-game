package no.finn

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeckTest {
    @Test
    fun shouldDrawCardsInCorrectOrder() {
        val firstCard = Card(CardSuit.CLUB, CardValue.TWO)
        val secondCard = Card(CardSuit.DIAMOND, CardValue.SEVEN)
        val cards = listOf(
            firstCard,
            secondCard,
            Card(CardSuit.HEART, CardValue.QUEEN)
        )

        val deck = Deck(cards)
        val firstDraw = deck.draw()
        val secondDraw = deck.draw()

        assertEquals(firstCard, firstDraw)
        assertEquals(secondCard, secondDraw)
    }
}