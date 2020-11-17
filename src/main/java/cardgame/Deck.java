package cardgame;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
   ArrayList<Card> cardList;
   
   public Deck(){
       cardList = new ArrayList<Card>();
        for (Suit suit : Suit.ALLSUITS){
            for (Value value: Value.ALLVALUES) {
                cardList.add(new Card(value, suit));
            }
        }
   }

   public void shuffle(){
       Collections.shuffle(cardList);
   }

   public Card draw(int i){
       Card card = peek(i);
       cardList.remove(0);
       return card;
   }

   public Card peek(int i){
       return cardList.get(i);
   }

   public Card draw(){
       return draw(0);
   }

   public Card peek(){
       return peek(0);
   }
}
