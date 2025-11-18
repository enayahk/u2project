import javax.smartcardio.Card;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CardGame c = new CardGame();
        c.initializeSets();
        c.printUserSet();
        System.out.println("");
        System.out.println("What card would you like to draw from your deck?");
        int draw = scan.nextInt();
        c.playerDraws(draw);
    }
}