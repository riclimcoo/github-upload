package cardgame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @Test
    public void shouldPrintAceOfSpades(){
        Card aceOfSpades = new Card(Value.ACE, Suit.SPADES);
        assertEquals("Can stringify cards.", "Ace of Spades", aceOfSpades.toString());
    }

    @Test
    public void canCompareCards(){
        Card KingOfDiamonds = new Card(Value.KING, Suit.DIAMONDS);
        Card ThreeOfHearts = new Card(Value.THREE, Suit.HEARTS);
        assertTrue("King of Diamonds beats Three of Hearts",
            KingOfDiamonds.canBeat(ThreeOfHearts));
    }

}
