package no.finn

class DeckLoader(
    private val deckFileReader: DeckFileReader,
    private val deckParser: DeckParser
) {
    fun loadFromFile(filePath: String): Deck {
        val deckString = deckFileReader.read(filePath)
        return deckParser.parseFromString(deckString)
    }
}
