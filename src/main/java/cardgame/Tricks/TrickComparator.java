package cardgame;

public abstract class TrickComparator {
    // change to trick ordering.
    protected static int PAIR_STR = 0;
    protected static int TRIO_STR = 0;
    protected static int QUAD_STR = 0;

    protected static int NULL_STR = -1;
    protected static int FLUSH_STR = 0;
    protected static int STRAIGHT_STR = 1;
    protected static int TRIOHOUSE_STR = 2;
    protected static int QUADHOUSE_STR = 3;
    protected static int ROYALFLUSH_STR = 4;

    public static boolean doesFirstBeatSecond(Trick home, Trick guest) {
        if (home.getClass() == guest.getClass()){
            System.out.println("hello");
            return home.beatsSameType(guest);
        }
        else if (getStrength(home) > getStrength(guest)){
            return true;
        }   
        else { 
            System.out.println("hi");
            System.out.printf("%s, %s", getStrength(home), getStrength(guest));
            return false;
        }
    }

    public static int getStrength(Trick trick){
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
