package cardgame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {
    Deck deck = new Deck();

    @Test
    public void shouldPeek(){
        Card firstCard = deck.peek();
        assertEquals(firstCard, deck.peek());
        deck.draw();
        Card secondCard = deck.draw();
        assertNotEquals(firstCard, secondCard);
    }
}
