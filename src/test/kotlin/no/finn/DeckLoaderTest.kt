package no.finn

import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class DeckLoaderTest {
    private val deckFileReader: DeckFileReader = mock()
    private val deckParser: DeckParser = mock()

    private val deckLoader = DeckLoader(deckFileReader, deckParser)

    @Test
    fun shouldReadFileAndParseDeck() {
        val filePath = "example-file.txt"
        val deckString = "CA, D5, H9"
        whenever(deckFileReader.read(filePath)).thenReturn(deckString)

        deckLoader.loadFromFile(filePath)

        verify(deckFileReader).read(filePath)
        verify(deckParser).parseFromString(deckString)
    }
}