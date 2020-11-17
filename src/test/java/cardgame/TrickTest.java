package cardgame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TrickTest {
    Card queenOfDiamonds;
    Card queenOfHearts;
    Card queenOfSpades;
    Card eightOfDiamonds;
    Card eightOfHearts;
    Card eightOfSpades;
    Card aceOfSpades;
    Card twoOfSpades;
    Card threeOfSpades;
    Card fourOfSpades;
    Card fiveOfSpades;

    @Before
    public void setup(){
        queenOfDiamonds = new Card(Value.QUEEN, Suit.DIAMONDS);
        queenOfHearts = new Card(Value.QUEEN, Suit.HEARTS);  
        queenOfSpades = new Card(Value.QUEEN, Suit.SPADES);  
        eightOfDiamonds = new Card(Value.EIGHT, Suit.DIAMONDS);
        eightOfHearts = new Card(Value.EIGHT, Suit.HEARTS);
        eightOfSpades = new Card(Value.EIGHT, Suit.SPADES);
        aceOfSpades = new Card(Value.ACE, Suit.SPADES);
        twoOfSpades = new Card(Value.TWO, Suit.SPADES);
        threeOfSpades = new Card(Value.THREE, Suit.SPADES);
        fourOfSpades = new Card(Value.FOUR, Suit.SPADES);
        fiveOfSpades = new Card(Value.FIVE, Suit.SPADES);
    }

    @Test
    public void canCompairPairs(){
        Trick pairOfQueens = new PairTrick(
            new CardList (queenOfDiamonds, queenOfHearts));

        Trick pairOfEights = new PairTrick(
            new CardList (eightOfDiamonds, eightOfHearts));
        assertTrue(pairOfQueens.beatsSameType(pairOfEights));
    }

    @Test
    public void canMakeTrios(){
        Trick trioOfQueens = new TrioTrick(
            new CardList (queenOfDiamonds, 
                queenOfHearts, queenOfSpades));
        assertNotNull(trioOfQueens);  
    }

    @Test
    public void canMakeTrioHouse(){
        Trick fullHouse = new TrioHouseTrick(
            new CardList (queenOfHearts, queenOfSpades, 
                eightOfDiamonds, eightOfSpades, queenOfDiamonds));
        assertNotNull(fullHouse);  
    }

    @Test
    public void canMakeFlush(){
        Trick flush = new FlushTrick(
            new CardList (aceOfSpades, queenOfSpades, 
                threeOfSpades, eightOfSpades, twoOfSpades));
        assertNotNull(flush);  
    }

    @Test
    public void canCompareTrios(){
        Trick trioOfQueens = new TrioTrick(
            new CardList (queenOfDiamonds, 
                queenOfHearts, queenOfSpades));

        Trick trioOfEights = new TrioTrick(
            new CardList (eightOfDiamonds, 
                eightOfHearts, eightOfSpades));

        assertTrue(trioOfQueens.beatsSameType(trioOfEights));
    }

    @Test(expected = InvalidTrickException.class)
    public void shouldRejectNonmatchingPairs(){
        new PairTrick(new CardList (queenOfDiamonds, eightOfHearts));
            // Exception should be thrown here.

        assertTrue(false);
    }

    @Test(expected = InvalidTrickException.class)
    public void shouldRejectInvalidTrios(){
        new PairTrick(new CardList (queenOfDiamonds, eightOfHearts, queenOfHearts));
            // Exception should be thrown here.

        assertTrue(false);
    }

    @Test(expected = InvalidTrickException.class)
    public void shouldRejectInvalidTrioHouse(){
        new TrioHouseTrick(new CardList (queenOfDiamonds, eightOfHearts, queenOfHearts));
            // Exception should be thrown here.

        assertTrue(false);
    }

}
