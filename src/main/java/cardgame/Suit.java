package cardgame;

public class Suit extends CardProperty{
    protected static final Suit DIAMONDS = new Suit("Diamonds", 0);
    protected static final Suit CLUBS = new Suit("Clubs", 1);
    protected static final Suit HEARTS = new Suit("Hearts", 2);
    protected static final Suit SPADES = new Suit("Spades", 3);
    protected static final Suit[] ALLSUITS = {DIAMONDS, CLUBS, HEARTS, SPADES};
    
    private Suit(String name, int strength){
        super(name, strength);
    }
}
