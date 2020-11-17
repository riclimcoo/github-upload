package cardgame;

public class Card implements Comparable<Card> {

    private CardProperty value;
    private CardProperty suit;

    public Card(CardProperty value, CardProperty suit){
        this.value = value;
        this.suit = suit;
    }

    public String toString(){
        return String.format("%s of %s", value, suit);
    }

    public Boolean canBeat(Card challenger){
        if (this.value.equals(challenger.value)) {
            return this.suit.canBeat(challenger.suit);
        }
        else return this.value.canBeat(challenger.value);
    }

    public boolean hasStrongerSuit(Card challenger){
        return suit.canBeat(challenger.suit);
    }

    public boolean hasStrongerValue(Card challenger){
        return value.canBeat(challenger.value);
    }

    public boolean hasSuitOf(Card challenger){
        return suit.equals(challenger.suit);
    }

    public boolean hasValueOf(Card challenger){
        return value.equals(challenger.value);
    }

    public boolean hasSuitOf(Suit suitToCompare){
        return suit.equals(suitToCompare);
    }

    public boolean hasValueOf(Value valueToCompare){
        return value.equals(valueToCompare);
    }

    public Value getValue(){
        return (Value) value;
    }

    public Suit getSuit(){
        return (Suit) suit;
    }

    public static Card maxOfArray(Card[] cardArr){
        if (cardArr.length == 0) return null;

        Card maxCard = cardArr[0];
        for (int i = 1; i < cardArr.length; i++) {
            if (cardArr[i].canBeat(maxCard)) {
                maxCard = cardArr[i];
            }
        }
        return maxCard;
    }

    public boolean hasProperty(CardProperty desiredProperty){
        try {
            Value value = (Value) desiredProperty;
            return this.hasValueOf(value);
        } catch (ClassCastException e){
        }
        try{
            Suit suit = (Suit) desiredProperty;
            return this.hasSuitOf(suit);
        } catch (ClassCastException e){
            return false;
        }
    }

    @Override
    public int compareTo(Card challenger) {
        if (this.equals(challenger)) return 0;
        else if (this.canBeat(challenger)) return 1;
        else return -1;
    }
}
