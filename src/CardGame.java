import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardGame {

    private final List<Integer> allCards = new ArrayList<Integer>();



    private List<Integer> userSet = new ArrayList<>(6);

    private List<Integer> botSet = new ArrayList<>(6);

    private boolean winner = false;
    private boolean validChoice = false;
    private int cardsLeft;
    private int userChoice = 0;
    private int botChoice = 0;


    public List<Integer> getUserSet() {
        return userSet;
    }
// creates initial cardsets, for now length 6 -- might change mind
    public void initializeSets() {
//        for (int i = 6; i > 0; i--) {
//            int indexer = 0;
//            userSet.add(indexer, (int) (Math.random()*20));
//            botSet.add(indexer, (int) (Math.random()*20));
//            indexer++;
        for (int i = 1; i <= 20; i++) {
            allCards.add(i);
        }

        for (int i = 0; i < 12; i++) {
            int randomCard = (int)(Math.random()*allCards.size());
            if (i % 2 == 0) {
                System.out.println("Player one gets: " + allCards.get(randomCard));
                userSet.add(allCards.get(randomCard));
            }
            else {
//                System.out.println("Player two gets: " + allCards.get(randomCard));
                botSet.add(allCards.get(randomCard));
            }
            allCards.remove(randomCard);


        }
    }
    // will be called every time the user's turn arrives

    public void printUserSet() {
        System.out.println("Your card set is:" + userSet);
        if (!winner) {
            System.out.println("You can't see your opponent's cards yet, though!");
        } else {
            System.out.println("Your card set is: " +userSet+", and your opponent's set is: " +botSet);
        }





    }


    public void playerDraws(int draw) {
        if (userSet.contains(draw))
        {
            validChoice = true;
        }
        if (validChoice == true){
            userChoice = draw;
            System.out.println("Card drawn!");

        } else {
            System.out.println("That's not a card in your deck. Try again.");
        }
    }

}
