package no.finn

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PlayerTest {
    @Test
    fun shouldCalculateScoreForHand() {
        val hand = listOf(
            Card(CardSuit.CLUB, CardValue.TWO),
            Card(CardSuit.DIAMOND, CardValue.THREE),
            Card(CardSuit.HEART, CardValue.FOUR),
            Card(CardSuit.SPADE, CardValue.FIVE),
            Card(CardSuit.CLUB, CardValue.SIX),
            Card(CardSuit.DIAMOND, CardValue.SEVEN),
            Card(CardSuit.HEART, CardValue.EIGHT),
            Card(CardSuit.SPADE, CardValue.NINE),
            Card(CardSuit.CLUB, CardValue.TEN),
            Card(CardSuit.DIAMOND, CardValue.JACK),
            Card(CardSuit.HEART, CardValue.QUEEN),
            Card(CardSuit.SPADE, CardValue.KING),
            Card(CardSuit.CLUB, CardValue.ACE)
        )
        val sammy = Player("Sammy")
        hand.forEach { sammy.takeCard(it) }

        assertEquals(95, sammy.handScore)
    }

    @Test
    fun shouldCalculateScoreForEmptyHand() {
        val sammy = Player("Sammy")
        assertEquals(0, sammy.handScore)
    }
}