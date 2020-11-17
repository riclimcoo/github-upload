package cardgame;

public abstract class TrickComparator {
    protected static int PAIR_STR = 0;
    protected static int TRIO_STR = 0;
    protected static int QUAD_STR = 0;

    protected static int NULL_STR = -1;
    protected static int FLUSH_STR = 0;
    protected static int STRAIGHT_STR = 1;
    protected static int TRIOHOUSE_STR = 2;
    protected static int QUADHOUSE_STR = 3;
    protected static int ROYALFLUSH_STR = 4;

    public boolean doesFirstBeatSecond(Trick home, Trick guest) {
        if (home.getClass() == guest.getClass()){
            return home.beatsSameType(guest);
        }
        else if (getStrength(home) > getStrength(guest)){
            return true;
        }   
        else { 
            return false;
        }
    }

    public int getStrength(Trick trick){
        switch(trick.getClass().getName()){
            case ("FlushTrick"):
                return FLUSH_STR;
            case ("StraightTrick"):
                return STRAIGHT_STR;
            case ("TrioHouseTrick"):
                return TRIOHOUSE_STR;
            case ("QuadHouseTrick"):
                return QUADHOUSE_STR;
            case ("RoyalFlushTrick"):
                return ROYALFLUSH_STR;
            default:
                return NULL_STR;
        }
    }
}
