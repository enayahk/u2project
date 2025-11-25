import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardGame {

    private final List<Integer> allCards = new ArrayList<Integer>();


    private List<Integer> userSet = new ArrayList<>(6);

    private List<Integer> botSet = new ArrayList<>(6);

    private int winner = 0;
    private boolean validChoice = false;
    private int cardsLeft;
    private int userChoice = 0;
    private int botChoice = 0;
    private int tableCard = 0;


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
        int randomCard = 0;

        for (int i = 0; i < 12; i++) {
            randomCard = (int) (Math.random() * allCards.size());
            if (i % 2 == 0) {

                userSet.add(allCards.get(randomCard));
            } else {
//                System.out.println("Player two gets: " + allCards.get(randomCard));
                botSet.add(allCards.get(randomCard));
//                System.out.println("botset:" +botSet);
            }
            allCards.remove(randomCard);


        }

    }
    // will be called every time the user's turn arrives

    public void tableCard(){
        int randomCard = (int) (Math.random() * allCards.size());
        tableCard = Integer.valueOf(allCards.get(randomCard));
        System.out.println(" ");
        System.out.println("The challenger card appears! Its value is: " + tableCard);
    }
    public void printUserSet() {
        System.out.println(" ");
        System.out.println("Your card set is:" + userSet);
        if (winner <= 0) {
            System.out.println("You can't see your opponent's cards yet, though!");
        } else {
            System.out.println("Your card set is: " + userSet + ", and your opponent's set is: " + botSet);
        }


    }




    public void playerDraws(int draw) {

        if (userSet.contains(draw)) {
            validChoice = true;
            userChoice = draw;
            System.out.println("Card drawn!");
            userSet.remove(Integer.valueOf(draw));

        } else {
            System.out.print("That's not a card in your deck. Try again: ");
            Scanner s = new Scanner(System.in);
            int newDraw = s.nextInt();
            s.nextLine();
            playerDraws(newDraw);
        }
    }

    public int cardNum () {
        return userSet.size();

    }

    public void botDraws() {
        int randomChoice = (int) (Math.random() * botSet.size());
        botChoice = botSet.get(randomChoice);
        botSet.remove(Integer.valueOf(botChoice));
//        System.out.println(botChoice);
        System.out.println("Your opponent draws a card!");
//        System.out.println("Its value is: " +botChoice);

    }

    public void printBotChoice () {

        System.out.println("Your opponent drew: " +botChoice);
    }

    public void printUserChoice() {
        System.out.println("You drew: " +userChoice);
    }



    public int gameTime() {

        if (Math.abs(20 - botChoice) < Math.abs(20 - userChoice)) {
            winner = -1;
        } else if (Math.abs(20 - botChoice) > Math.abs(20 - userChoice)) {
            winner = 1;
        } else {
            winner = 0;
        }


        return winner;
    }
}

