package no.finn.deck

import no.finn.Card
import no.finn.CardSuit
import no.finn.CardValue

class DeckParser {
    fun parseFromString(deckString: String): Deck {
        check(deckString.isNotEmpty()) { "Deck string is empty" }

        val cards = deckString
            .split(CARD_SEPARATOR)
            .map { parseCard(it) }

        return Deck(cards)
    }

    private fun parseCard(cardString: String): Card {
        val suit = parseSuit(cardString)
        val value = parseValue(cardString)

        return Card(suit, value)
    }

    private fun parseSuit(cardString: String): CardSuit {
        val suitChar = cardString.substring(SUIT_INDEX, VALUE_INDEX)
        return STRING_TO_CARD_SUIT[suitChar] ?: throw IllegalArgumentException("Invalid card suit $suitChar")

    }

    private fun parseValue(cardString: String): CardValue {
        val valueChars = cardString.substring(VALUE_INDEX)
        return STRING_TO_CARD_VALUE[valueChars] ?: throw IllegalArgumentException("Invalid card value $valueChars")
    }

    companion object {
        private const val CARD_SEPARATOR = ", "
        private const val SUIT_INDEX = 0
        private const val VALUE_INDEX = 1

        // Helper maps for parsing card suit and value
        private val STRING_TO_CARD_SUIT: Map<String, CardSuit> = CardSuit.values().associateBy { it.toString() }
        private val STRING_TO_CARD_VALUE: Map<String, CardValue> = CardValue.values().associateBy { it.toString() }
    }
}
