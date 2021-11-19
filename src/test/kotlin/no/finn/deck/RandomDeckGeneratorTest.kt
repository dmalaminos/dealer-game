package no.finn.deck

import no.finn.Card
import no.finn.CardSuit
import no.finn.CardValue
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RandomDeckGeneratorTest {

    private val randomDeckGenerator = RandomDeckGenerator()

    @Test
    fun shouldReturnedDeckWith52UniqueCards() {
        val deck = randomDeckGenerator.generate()

        val drawnCards = mutableListOf<Card>()
        assertDoesNotThrow {
            repeat(52) {
                drawnCards.add(deck.draw())
            }
        }
        assertThrows(NoSuchElementException::class.java) {
            deck.draw()
        }

        CardSuit.values().forEach { suit ->
            assertEquals(13, drawnCards.count { it.suit == suit })
        }

        CardValue.values().forEach { value ->
            assertEquals(4, drawnCards.count { it.value == value })
        }
    }
}