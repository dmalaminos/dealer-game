package no.finn

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class DeckReaderTest {
    private val deckFileReader: DeckFileReader = mock()
    private val deckReader = DeckReader(deckFileReader)

    private val filePath = "some-deck-file.txt"

    @Test
    fun shouldParseValidDeckFromFile() {
        whenever(deckFileReader.read(filePath)).thenReturn("C10, CA, D5, DJ, H9, HQ, S2, SK")

        val deck = deckReader.readFromFile(filePath)

        val expectedDeck = ArrayDeque(
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
    fun shouldFailToParseInvalidCardSuit() {
        whenever(deckFileReader.read(filePath)).thenReturn("C10, X5, H2")

        assertThrows(IllegalArgumentException::class.java) {
            deckReader.readFromFile(filePath)
        }
    }

    @Test
    fun shouldFailToParseInvalidCardValue() {
        whenever(deckFileReader.read(filePath)).thenReturn("C10, S1, H2")

        assertThrows(IllegalArgumentException::class.java) {
            deckReader.readFromFile(filePath)
        }
    }
}