package cardgame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cardgame.Combo.ComboType;

import static cardgame.ConvenientCards.*;

public class ComboTest {
    @Test 
    public void shouldMakeCardList(){
        CardList myList = new CardList(threeDiamonds, fourDiamonds);
        assertFalse(myList.isEmpty());
    }

    @Test
    public void shouldMakePairCombo(){
        Combo combo = new Combo(threeDiamonds, threeHearts);
        assertNotNull(combo);
        assertEquals(ComboType.PAIR, combo.getType());
    }

    @Test
    public void canMakeFlush(){
        Combo combo = new Combo(fourSpades, 
            threeSpades, aceSpades, fiveSpades, eightSpades);
        assertEquals(ComboType.FLUSH, combo.getType());
    }

    @Test
    public void canMakeStraight(){
        Combo combo = new Combo(threeClubs, fourDiamonds, fiveDiamonds, sevenClubs, sixClubs);
        assertEquals(ComboType.STRAIGHT, combo.getType());
    }

    @Test 
    public void canComparePairs(){
        Combo pairQueen = new Combo(queenClubs, queenDiamonds);
        Combo pairAce = new Combo(aceClubs, aceDiamonds);
        assertTrue(pairAce.beats(pairQueen));
    }

    @Test 
    public void canCompareTrioHouses(){
        Combo queenHouse = new Combo(queenClubs, queenDiamonds, queenSpades, threeClubs, threeHearts);
        Combo fourHouse = new Combo(aceClubs, aceDiamonds, fourClubs, fourDiamonds, fourSpades);
        assertTrue(queenHouse.beats(fourHouse));
    }

    @Test 
    public void canCompareQuadHouses(){
        Combo queenHouse = new Combo(queenClubs, queenDiamonds, queenSpades, queenHearts, threeHearts);
        Combo fourHouse = new Combo(aceClubs, fourHearts, fourClubs, fourDiamonds, fourSpades);
        assertTrue(queenHouse.beats(fourHouse));
    }

    @Test 
    public void canCompareQuadToStraight(){
        Combo queenHouse = new Combo(queenClubs, queenDiamonds, queenSpades, queenHearts, threeHearts);
        Combo fourStraight = new Combo(fiveClubs, fourHearts, sixClubs, sevenDiamonds, eightSpades);
        assertEquals(ComboType.QUADHOUSE, queenHouse.getType());
        assertEquals(ComboType.STRAIGHT, fourStraight.getType());
        assertTrue(queenHouse.beats(fourStraight));
    }



    @Test
    public void canMakeTrioCombo(){
        Combo combo = new Combo(queenClubs, queenDiamonds, queenHearts);
        assertNotNull(combo);
        assertEquals(ComboType.TRIO, combo.getType());
    }

    @Test
    public void canMakeTrioHouse(){
        Combo combo = new Combo(fourClubs, fourHearts, kingClubs, kingHearts, kingSpades);
        assertEquals(ComboType.TRIOHOUSE, combo.getType());
    }

    @Test
    public void canMakeQuadHouse(){
        Combo combo = new Combo(kingSpades, kingClubs, fourClubs, kingHearts, kingSpades);
        assertEquals(ComboType.QUADHOUSE, combo.getType());
    }

    @Test
    public void canMakeRoyalFlush(){
        Combo combo = new Combo(tenSpades, queenSpades, jackSpades, kingSpades, aceSpades);
        assertEquals(ComboType.ROYAL, combo.getType());
    }

    @Test(expected = InvalidComboException.class)
    public void shouldRejectInvalidPair(){
        Combo combo = new Combo(threeDiamonds, fourDiamonds);
    }

    @Test(expected = InvalidComboException.class)
    public void shouldRejectInvalidTrioHouse(){
        Combo combo = new Combo(threeDiamonds, threeSpades, threeHearts, fourDiamonds, twoClubs);
    }

    @Test
    public void canCatchInvalidTrickEx(){
        try {
            Combo combo = new Combo(fiveDiamonds, eightSpades);
            assertTrue(false);
        }
        catch (InvalidComboException e){
            assertTrue(true);
        }
    }
}
