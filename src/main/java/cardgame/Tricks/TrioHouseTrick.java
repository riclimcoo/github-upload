package cardgame;

public class TrioHouseTrick extends Trick {
    private Value value;

    public TrioHouseTrick(CardList cardList) throws InvalidComboException{
        super(cardList);
        value = cardList.getTrio().get(0).getValue();
    }

    public boolean isValid(CardList cardList){
        if (cardList.size() != length()) return false;
        return !cardList.getTrio().isEmpty();
    }

    public int length() {
        return 5;
    }

    @Override
    protected boolean beatsSameType(Trick trick) {
        TrioHouseTrick challenger = (TrioHouseTrick) trick;
        return this.value.canBeat(challenger.value);
    }

}
