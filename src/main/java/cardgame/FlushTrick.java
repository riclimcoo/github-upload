package cardgame;


public class FlushTrick extends Trick {
    Suit ourSuit;

    public FlushTrick(CardList cardList) throws InvalidTrickException {
        super(cardList);
        ourSuit = cardList.get(0).getSuit();
    }

    @Override
    public boolean isValid(CardList list) {
        if (list.size() != 5) return false;
        return list.hasSameSuits();
    }

    @Override
    public int length(){
        return 5;
    }
    
    @Override
    public boolean beatsSameType(Trick challenger){
        FlushTrick challengerFlush = (FlushTrick) challenger;
        return ourSuit.canBeat(challengerFlush.ourSuit);
    }
}
