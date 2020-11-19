package cardgame;

import static cardgame.ConvenientCards.*;

import java.util.Collections;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CardList list = new CardList(eightDiamonds, fourDiamonds, fiveDiamonds, sevenClubs, sixClubs);
        Collections.sort(list);
        System.out.println(list);
        System.out.println(list.isStraight());

        // // Generator for convenient cards.
        // for (Suit suit : Suit.ALLSUITS){
        //     for (Value value : Value.ALLVALUES){
        //         System.out.printf("public static final Card %s%s = new Card(Value.%s, Suit.%s);\n", 
        //         value.toString().toLowerCase(), suit, value.toString().toUpperCase(), suit.toString().toUpperCase());
        //     }
        // }
    }
}
