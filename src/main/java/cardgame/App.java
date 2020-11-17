package cardgame;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Card aceOfSpades = new Card(Value.ACE, Suit.SPADES);
        System.out.println(aceOfSpades);
        Deck deck = new Deck();
        deck.shuffle();
        System.out.printf("%s vs %s\n", deck.peek(0), deck.peek(1));
        Boolean isGreaterThan = deck.peek(0).canBeat(deck.peek(1));
        System.out.printf("%s\n", isGreaterThan);
    }
}
