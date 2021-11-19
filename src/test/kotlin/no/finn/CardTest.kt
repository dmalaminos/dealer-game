package no.finn

import no.finn.CardSuit.*
import no.finn.CardValue.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CardTest {

    @Test
    fun shouldRepresentCardsAsString() {
        assertEquals("C9", Card(CLUB, NINE).toString())
        assertEquals("D10", Card(DIAMOND, TEN).toString())
        assertEquals("HJ", Card(HEART, JACK).toString())
        assertEquals("SQ", Card(SPADE, QUEEN).toString())
        assertEquals("CK", Card(CLUB, KING).toString())
        assertEquals("DA", Card(DIAMOND, ACE).toString())
        assertEquals("H2", Card(HEART, TWO).toString())
    }
}