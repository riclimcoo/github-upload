package cardgame;

public class Combo {
    // Order matters for ComboType enum.
    public enum ComboType {PAIR, TRIO, FLUSH,
        STRAIGHT, TRIOHOUSE, QUADHOUSE, ROYAL};
    private ComboType type;
    private CardList list;

    public Combo(Card ...cards){
       list = new CardList(cards);
       findType();
    }

     private void findType(){
        if(list.isPair()){
            type = ComboType.PAIR;
        }
        else if (list.isTrio()){
            type = ComboType.TRIO;
        }
        else if (list.isFlush() && list.isStraight()){
            type = ComboType.ROYAL;
        }
        else if (list.isFlush()){
            type = ComboType.FLUSH;
        }
        else if (list.isStraight()){
            type = ComboType.STRAIGHT;
        }
        else if (list.isTrioHouse()){
            type = ComboType.TRIOHOUSE;
        }
        else if (list.isQuadHouse()){
            type = ComboType.QUADHOUSE;
        }
        else {
            throw new InvalidComboException();
        }
    }

    public boolean beats(Combo challenger){
        if (this.type == challenger.type) {
            return beatsSame(challenger);
        }
        else if (list.size() == challenger.list.size()){
            return beatsDiff(challenger);
        }
        return false;
    }

    private boolean beatsDiff(Combo challenger){
        return (type.ordinal() > challenger.type.ordinal());
    }

    private boolean beatsSame(Combo challenger){
        switch(challenger.type){
            case TRIOHOUSE:
                return beatsTrioHouse(challenger);
            case QUADHOUSE:
                return beatsQuadHouse(challenger);
            default:
                return hasBetterMaxThan(challenger);
        }
    }

    private boolean hasBetterMaxThan(Combo challenger){
        return list.getStrongestCard().canBeat(challenger.list.getStrongestCard());
    }

    private boolean beatsTrioHouse(Combo challenger){
        Card myValue = list.getTrio().get(0);
        Card enemyValue = challenger.list.getTrio().get(0);
        return (myValue.canBeat(enemyValue));
    }

    private boolean beatsQuadHouse(Combo challenger){
        Card myValue = list.getQuad().get(0);
        Card enemyValue = challenger.list.getQuad().get(0);
        return (myValue.canBeat(enemyValue));
    }

    // Pinoy way of beating flush.
    private boolean beatsFlush(Combo challenger){
        Suit mySuit = list.get(0).getSuit();
        Suit theirSuit = challenger.list.get(0).getSuit();
        if (mySuit == theirSuit){
            return hasBetterMaxThan(challenger);
        }
        else {
            return mySuit.canBeat(theirSuit);
        }
    }

    public ComboType getType(){
        return type;
    }
}
