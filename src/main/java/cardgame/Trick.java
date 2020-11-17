package cardgame;

public abstract class Trick {
    private CardList cardList;
    protected static final int DIFF_TYPE = -2;
    protected static final int STRONGER = 1;
    protected static final int SAME = 0;
    protected static final int WEAKER = -1;

    public Trick(CardList cardList) throws InvalidTrickException {
        if (isValid(cardList)){
            this.cardList = cardList;
        }
        else {
            throw new InvalidTrickException();
        }
    }

    public int compareTo(Trick challenger){
        if (this.getClass() == challenger.getClass()){
            if (beatsSameType(challenger)){
                return STRONGER;
            }
            else {
                return WEAKER;
            }
        }
        else return DIFF_TYPE;
    }

    protected abstract boolean beatsSameType(Trick challenger);

    public abstract int length();

    public boolean hasSameLength(Trick challenger){
        return challenger.length() == this.length();
    }

    public abstract boolean isValid(CardList cardArray);

    public CardList getList(){
        return cardList.clone();
    }
}