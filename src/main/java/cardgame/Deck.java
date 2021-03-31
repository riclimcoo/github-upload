package cardgame;

import java.util.Collections;

public class Deck {
    CardList cardList;
   
    public Deck(){
        cardList = new CardList();
            for (Suit suit : Suit.ALLSUITS){
                for (Value value: Value.ALLVALUES) {
                    cardList.add(new Card(value, suit));
                }
            }
    }

    public void shuffle(){
        Collections.shuffle(cardList);
    }

    public CardList draw(int amount){
        CardList newList = new CardList();
        for (int i = 0; i < amount; i++){
            newList.add(draw());
        }
        return newList;
    }

    public Card draw(){
        Card firstCard = cardList.get(0);
        cardList.remove(0);
        return firstCard;
    }

    public Card peek(){
        return cardList.get(0);
    }

    public boolean isEmpty(){
        return cardList.isEmpty();
    }
}
