import java.util.ArrayList;
import java.util.List;

public class CardGame {


    private List<Integer> userSet = new ArrayList<>(6);

    private List<Integer> botSet = new ArrayList<>(6);

    private boolean winner = false;

    public List<Integer> getUserSet() {
        return userSet;
    }

    public void initializeSets() {
        for (int i = 6; i > 0; i--) {
            int indexer = 0;
            userSet.add(indexer, (int) (Math.random()*20));
            botSet.add(indexer, (int) (Math.random()*20));
            indexer++;


        }
    }

    public void printUserSet() {
        System.out.println("Your card set is:" + userSet);
        if (winner ) {
            System.out.println("You can't see your opponent's cards yet, though!");
        } else


    }

}
