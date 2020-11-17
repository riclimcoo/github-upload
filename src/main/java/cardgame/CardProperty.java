package cardgame;

public class CardProperty {
    private int strength;
    private String name;

    public CardProperty(String name, int strength){
        this.name = name;
        this.strength = strength;
    }

    public Boolean canBeat(CardProperty challenger){
        return strength > challenger.strength;
    }

    public Boolean equals(CardProperty challenger){
        return strength == challenger.strength;
    }

    public int getStrength(){
        return strength;
    }

    public String toString(){
        return name;
    }

}
