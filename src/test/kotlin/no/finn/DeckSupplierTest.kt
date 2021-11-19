package no.finn

import no.finn.CardSuit.*
import no.finn.CardValue.*
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

class DeckSupplierTest {
    private val deckFileReader: DeckFileReader = mock()
    private val deckParser: DeckParser = mock()
    private val randomDeckGenerator: RandomDeckGenerator = mock()

    private val deckSupplier = DeckSupplier(deckFileReader, deckParser, randomDeckGenerator)

    @Test
    fun shouldReadFileAndParseDeck() {
        val filePath = "example-file.txt"
        val deckString = "CA, D5, H9"
        whenever(deckFileReader.read(filePath)).thenReturn(deckString)

        deckSupplier.fromFile(filePath)

        verify(deckFileReader).read(filePath)
        verify(deckParser).parseFromString(deckString)
    }

    @Test
    fun shouldGenerateRandomDeck() {
        val expectedDeck = Deck(listOf(Card(HEART, ACE)))
        whenever(randomDeckGenerator.generate()).thenReturn(expectedDeck)

        val deck = deckSupplier.random()

        verify(randomDeckGenerator).generate()
        assertEquals(expectedDeck, deck)
    }
}