package no.finn

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class DeckFileReaderTest {
    private val deckFileReader = DeckFileReader()

    @Test
    fun shouldReadContentFromValidDeckFile() {
        val deckString = deckFileReader.read("src/test/resources/valid-deck.txt")

        assertEquals("CA, D5, H9, HQ, S8", deckString)
    }

    @Test
    fun shouldFailToReadUnexistingDeckFile() {
        assertThrows(IllegalArgumentException::class.java) {
            deckFileReader.read("src/test/resources/unexisting-file.txt")
        }
    }
}