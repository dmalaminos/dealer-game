package no.finn

class DeckSupplier(
    private val deckFileReader: DeckFileReader,
    private val deckParser: DeckParser,
    private val randomDeckGenerator: RandomDeckGenerator
) {
    fun fromFile(filePath: String): Deck {
        val deckString = deckFileReader.read(filePath)
        return deckParser.parseFromString(deckString)
    }

    fun random(): Deck = randomDeckGenerator.generate()
}
