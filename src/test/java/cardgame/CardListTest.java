package cardgame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import static cardgame.ConvenientCards.*;

public class CardListTest {
    @Test
    public void canPrint(){
        CardList list = new CardList(threeHearts, fourSpades, fiveHearts);
        assertEquals("[Three of Hearts, Four of Spades, Five of Hearts]", list.toString());
    }

}
