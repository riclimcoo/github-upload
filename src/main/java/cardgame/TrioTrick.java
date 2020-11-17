package cardgame;

public class TrioTrick extends Trick {
    Value value;

    public TrioTrick(CardList cardList) throws InvalidTrickException{
        super(cardList);
        value = cardList.get(0).getValue();
    }

    @Override
    public boolean isValid(CardList cardList){
        return cardList.isTrio();
    }

    @Override
    public boolean beatsSameType(Trick challenger) {
        TrioTrick challengerTrio = (TrioTrick) challenger;
        return value.canBeat(challengerTrio.value);
    }

    @Override
    public int length() {
        return 3;
    }
}
