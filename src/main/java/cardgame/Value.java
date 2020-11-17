package cardgame;

public class Value extends CardProperty{
    protected static final Value THREE = new Value("Three", 0);
    protected static final Value FOUR = new Value("Four", 1);
    protected static final Value FIVE = new Value("Five", 2);
    protected static final Value SIX = new Value("Six", 3);
    protected static final Value SEVEN = new Value("Seven", 4);
    protected static final Value EIGHT = new Value("Eight", 5);
    protected static final Value NINE = new Value("Nine", 6);
    protected static final Value TEN = new Value("Ten", 7);
    protected static final Value JACK = new Value("Jack", 8);
    protected static final Value QUEEN = new Value("Queen", 9);
    protected static final Value KING = new Value("King", 10);
    protected static final Value ACE = new Value("Ace", 11);
    protected static final Value TWO = new Value("Two", 12);
    protected static final Value[] ALLVALUES = {THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE, TWO};

    public Value(String name, int strength){
        super(name, strength);
    }
}
