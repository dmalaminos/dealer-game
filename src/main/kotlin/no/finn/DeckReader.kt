package no.finn

class DeckReader(private val deckFileReader: DeckFileReader) {
    fun readFromFile(filePath: String): ArrayDeque<Card> {
        val cards = deckFileReader
            .read(filePath)
            .split(CARD_SEPARATOR)
            .map { parseCard(it) }

        return ArrayDeque(cards)
    }

    private fun parseCard(cardString: String): Card {
        val suitChar = cardString.substring(0, 1)
        val suit = if (suitChar.matches(Regex("[CDHS]"))) {
            STRING_TO_CARD_SUIT.getValue(suitChar)
        } else {
            throw IllegalArgumentException("Invalid card suit $suitChar")
        }

        val valueChars = cardString.substring(1)
        val value = if (valueChars.matches(Regex("[2-9]|10|[JQKA]"))) {
            STRING_TO_CARD_VALUE.getValue(valueChars)
        } else {
            throw IllegalArgumentException("Invalid card value $valueChars")
        }

        return Card(suit, value)
    }

    companion object {
        private const val CARD_SEPARATOR = ", "

        // Helper maps for parsing card suit and value
        private val STRING_TO_CARD_SUIT: MutableMap<String, CardSuit> = HashMap()
        private val STRING_TO_CARD_VALUE: MutableMap<String, CardValue> = HashMap()

        init {
            for (suit in CardSuit.values()) {
                STRING_TO_CARD_SUIT[suit.name.substring(0, 1)] = suit
            }
            for (value in CardValue.values()) {
                if (value.pointValue < 10) {
                    STRING_TO_CARD_VALUE[value.pointValue.toString()] = value
                } else if (value == CardValue.TEN) {
                    STRING_TO_CARD_VALUE["10"] = value
                } else if (value == CardValue.JACK) {
                    STRING_TO_CARD_VALUE["J"] = value
                } else if (value == CardValue.QUEEN) {
                    STRING_TO_CARD_VALUE["Q"] = value
                } else if (value == CardValue.KING) {
                    STRING_TO_CARD_VALUE["K"] = value
                } else if (value == CardValue.ACE) {
                    STRING_TO_CARD_VALUE["A"] = value
                }
            }
        }
    }
}
