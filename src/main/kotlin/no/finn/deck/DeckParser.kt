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
        val suitChar = cardString.substring(0, 1)
        val suit = if (suitChar.matches(Regex(SUIT_REGEX))) {
            STRING_TO_CARD_SUIT.getValue(suitChar)
        } else {
            throw IllegalArgumentException("Invalid card suit $suitChar")
        }
        return suit
    }

    private fun parseValue(cardString: String): CardValue {
        val valueChars = cardString.substring(1)
        val value = if (valueChars.matches(Regex(VALUE_REGEX))) {
            STRING_TO_CARD_VALUE.getValue(valueChars)
        } else {
            throw IllegalArgumentException("Invalid card value $valueChars")
        }
        return value
    }

    companion object {
        private const val CARD_SEPARATOR = ", "
        private const val SUIT_REGEX = "[CDHS]"
        private const val VALUE_REGEX = "[2-9]|10|[JQKA]"

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
