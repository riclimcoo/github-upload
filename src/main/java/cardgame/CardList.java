package cardgame;

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

    public Suit[] getSuits() {
        Suit[] suitsArr = new Suit[size()];
        int counter = 0;
        for (Card card : this) {
            suitsArr[counter++] = card.getSuit();
        }
        return suitsArr;
    }

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

    public Boolean hasCardsWithCount(int count){
        CardList list = getCardsWithMatchCount(count);
        return !list.isEmpty();
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

    public Boolean isPair(){
        return (hasCardsWithCount(2) && (size() == 2));
    }

    public Boolean isTrio(){
        return (hasCardsWithCount(3) && (size() == 3));
    }

    public Boolean isQuad(){
        return (hasCardsWithCount(4) && (size() == 4));
    }

    public CardList clone(){
        CardList clonedList = new CardList();
        clonedList.addAll(this);
        return clonedList;
    }
}
