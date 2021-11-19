package no.finn.deck

import no.finn.Card
import no.finn.CardSuit
import no.finn.CardValue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class DeckParserTest {
    private val deckParser = DeckParser()

    @Test
    fun shouldParseValidDeckFromFile() {
        val deck = deckParser.parseFromString("C10, CA, D5, DJ, H9, HQ, S2, SK")

        val expectedDeck = Deck(
            listOf(
                Card(CardSuit.CLUB, CardValue.TEN),
                Card(CardSuit.CLUB, CardValue.ACE),
                Card(CardSuit.DIAMOND, CardValue.FIVE),
                Card(CardSuit.DIAMOND, CardValue.JACK),
                Card(CardSuit.HEART, CardValue.NINE),
                Card(CardSuit.HEART, CardValue.QUEEN),
                Card(CardSuit.SPADE, CardValue.TWO),
                Card(CardSuit.SPADE, CardValue.KING)
            )
        )
        assertEquals(expectedDeck, deck)
    }

    @Test
    fun shouldFailToParseEmptyDeck() {
        assertThrows(IllegalStateException::class.java) {
            deckParser.parseFromString("")
        }
    }

    @Test
    fun shouldFailToParseInvalidCardSuit() {
        assertThrows(IllegalArgumentException::class.java) {
            deckParser.parseFromString("C10, X5, H2")
        }
    }

    @Test
    fun shouldFailToParseInvalidCardValue() {
        assertThrows(IllegalArgumentException::class.java) {
            deckParser.parseFromString("C10, S1, H2")
        }
    }
}