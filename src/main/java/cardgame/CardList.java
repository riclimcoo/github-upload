package cardgame;

import java.util.Collections;

public class CardList extends ListWrapper<Card> {

    public CardList(){
        super();
    }

    public CardList(Card ...newCards) {
        super();
        for (Card card : newCards){
            add(card);
        }
    }

    // public Suit[] getSuits() {
    //     Suit[] suitsArr = new Suit[size()];
    //     int counter = 0;
    //     for (Card card : this) {
    //         suitsArr[counter++] = card.getSuit();
    //     }
    //     return suitsArr;
    // }

    public CardList getCardsWith(CardProperty desiredProperty) {
        CardList newList = new CardList();
        for (Card card : this){
            if (card.hasProperty(desiredProperty)){
                newList.add(card);
            };
        }
        return newList;
    }

    public int countMatching(CardProperty desiredProperty) {
        int count = 0;
        for (Card card : this) {
            if (card.hasProperty(desiredProperty))
                count++;
        }
        return count;
    }

    public Card getStrongestCard() {
        if (this.size() == 0)
            return null;

        Card maxCard = get(0);
        for (Card card : this){
            if (card.canBeat(maxCard)) {
                maxCard = card;
            }
        }
        return maxCard;
    }

    public CardList getCardsWithMatchCount(int matchCount){
        for (Value value : Value.ALLVALUES){
            if (countMatching(value) == matchCount) {
                return getCardsWith(value);
            }
        }
        return new CardList();
    }

    public boolean hasSameValues(){
        if (this.isEmpty()) return false;

        Card firstCard = get(0);
        for (Card card : this){
            if (!card.hasValueOf(firstCard)){
                return false;
            }
        }
        return true;
    }

    public boolean hasSameSuits(){
        if (this.isEmpty()) return false;

        Card firstCard = get(0);
        for (Card card : this){
            if (!card.hasSuitOf(firstCard)){
                return false;
            }
        }
        return true;
    }

    public CardList getPair(){
        return getCardsWithMatchCount(2);
    }

    public CardList getTrio(){
        return getCardsWithMatchCount(3);
    }

    public CardList getQuad(){
        return getCardsWithMatchCount(4);
    }

    public boolean hasPair(){
        return !getCardsWithMatchCount(2).isEmpty();
    }

    public boolean hasTrio(){
        return !getCardsWithMatchCount(3).isEmpty();
    }

    public boolean hasQuad(){
        return !getCardsWithMatchCount(4).isEmpty();
    }

    public Boolean isPair(){
        return (hasPair() && (size() == 2));
    }

    public Boolean isTrio(){
        return (hasTrio() && (size() == 3));
    }

    public Boolean isQuad(){
        return (hasQuad() && (size() == 4));
    }

    public Boolean isTrioHouse(){
        return (size() == 5 && hasPair() && hasTrio());
    }

    public Boolean isQuadHouse(){
        return (size() == 5 && hasQuad());
    }

    public Boolean isFlush(){
        return (size() == 5 && hasSameSuits());
    }

    public Boolean isStraight(){
        if (size() != 5) return false;
        Collections.sort(this);
        int firstValueIndex = this.get(0).getValue().findIndex();
        for (int i = 0; i < 5; i++){
            Value myValue = get(i).getValue();
            Value expectedValue = Value.ALLVALUES[firstValueIndex + i];
            if (myValue != expectedValue) return false;
        }
        return true;
    }

    public CardList clone(){
        CardList clonedList = new CardList();
        clonedList.addAll(this);
        return clonedList;
    }

}
