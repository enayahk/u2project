import javax.smartcardio.Card;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CardGame c = new CardGame();
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
        c.printUserSet();
        System.out.println("--------------");
        System.out.println("What card would you like to draw from your deck?");
        int draw = scan.nextInt();
        c.playerDraws(draw);
        System.out.println("--------------");
        c.botDraws();
//        c.printUserSet();
        System.out.println("");


    }
}