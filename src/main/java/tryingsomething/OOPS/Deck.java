package tryingsomething.OOPS;

import java.util.Random;
import java.util.Stack;

/**
 * Created by rmukherj on 10/6/16.
 */
public class Deck {
    Stack<Card> cardStack = new Stack<>();

    private static Random rand = new Random();

    public Deck(){
        populateDeckWithCards();
        shuffle();
    }

    private void shuffle() {
        //fisher yates
        for (int i = cardStack.size() - 1; i >0 ; i--) {


            int swapindex = rand.nextInt(i);

            Card temp = cardStack.get(i);
            cardStack.set(i, cardStack.get(swapindex));
            cardStack.set(swapindex, temp);
        }

    }

    private void populateDeckWithCards() {
        for (int i = 0; i < 4 ; i++) {
            for (int j = 1; j < 14 ; j++) {
                cardStack.push(new Card(i,j));
            }

        }
    }

    public void deal(String dealtype, int numberofpersons) {
        //Seperate dealtype classes can be created
        if (dealtype.equals("ace")) {
            int i = 1;
            while (!cardStack.isEmpty()) {
                //Seperate person classes can be created
                Card card = cardStack.pop();

                System.out.println();
                int person = i % numberofpersons;
                if (person == 0) {
                    person = 4;
                }

                System.out.print("Person: " + person + " cardsymbol: ");
                if (card.cardSymbol == 0) {
                    System.out.print("Spade");
                } else if (card.cardSymbol == 1) {
                    System.out.print("heart");
                } else if (card.cardSymbol == 2) {
                    System.out.print("diamond");
                } else {
                    System.out.print("club");
                }

                if (card.cardNumber == 1) {
                    System.out.print(" cardnumber: ace");
                } else if (card.cardNumber == 11) {
                    System.out.print("cardnumber: Jack");
                } else if (card.cardNumber == 12) {
                    System.out.print("cardnumber: Queen");
                } else if (card.cardNumber == 13) {
                    System.out.print("cardnumber: King");
                } else {
                    System.out.print("cardnumber: " + card.cardNumber);
                }

                i++;
            }
        }
    }

}
