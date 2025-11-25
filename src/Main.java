import javax.smartcardio.Card;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CardGame c = new CardGame();
        int points = 0;
        int winCond = 6;
        System.out.println("Card game rules : You will be dealt a set of 6 cards.");
        System.out.println("Match one of them to the table card so that the value is as close to 20 as possible.");
        System.out.println("You cannot see your opponent's deck.");
        System.out.println("The closest to 20 wins one point. If you run out of cards or your opponent reaches 3 points before you, you lose.");
        System.out.println("--------------");
        System.out.println("There exists a nightmare difficulty if you dare... Will you take the chance? y/n: ");
        if ((scan.nextLine()).contains("y")) {
            System.out.println("Good luck..");
        } else if ((scan.nextLine()).contains("n")) {
            System.out.println("A wise decision.");
        }
             c.initializeSets();
//        for (int i = 6; i > 0; i--) {
        while (winCond > 0 && points <= 3 && c.cardNum() > 0) {
//            while (points > 3 && (c.cardNum()) > 0) {
                c.tableCard();
                c.printUserSet();
                System.out.println("--------------");
                System.out.println("What card would you like to draw from your deck?");
                int draw = scan.nextInt();
                c.playerDraws(draw);
                System.out.println("--------------");
                c.botDraws();
//        c.printUserSet();
                System.out.println("");
                c.printBotChoice();
                c.printUserChoice();
                if (c.gameTime() == 1) {
                    System.out.println("Your card was closer to 20. +1 point.");
                } else if (c.gameTime() == 0) {
                    System.out.println("Draw. No points awarded.");
                } else if (c.gameTime() == -1) {
                    System.out.println("Your opponent's card was closer to 20. -1 point.");
                }

            points =+ c.gameTime();
        }

        System.out.println("--------------");
        System.out.println("Your total points:" +points);
        if (points < 3) {
            System.out.println("You lost to your opponent. An unfortunate failure.");
        } else if (points == 3) {
            System.out.println("A winner!");
        }

        }




    }
