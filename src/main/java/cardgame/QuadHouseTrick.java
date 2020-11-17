package cardgame;

public class QuadHouseTrick extends Trick {
    private Value value;

    public QuadHouseTrick(CardList cardList) throws InvalidTrickException{
        super(cardList);
        value = cardList.getQuad().get(0).getValue();
    }

    public boolean isValid(CardList cardList){
        if (cardList.size() != length()) return false;
        return !cardList.getQuad().isEmpty();
    }

    public int length() {
        return 5;
    }

    @Override
    protected boolean beatsSameType(Trick trick) {
        QuadHouseTrick challenger = (QuadHouseTrick) trick;
        return this.value.canBeat(challenger.value);
    }

}
