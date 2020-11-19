package cardgame;

public class PairTrick extends Trick {
    Card strongestCard;

    public PairTrick(CardList cardList) throws InvalidComboException{
        super(cardList);
        strongestCard = cardList.getStrongestCard();
    }

    public boolean isValid(CardList cardList){
        return cardList.isPair();
    }

    public int length(){
        return 2;
    }

    @Override
    public boolean beatsSameType(Trick challenger){
        PairTrick challengingPair = (PairTrick) challenger;
        return strongestCard.canBeat(challengingPair.strongestCard);       
    }

}
