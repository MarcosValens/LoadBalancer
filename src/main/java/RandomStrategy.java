import java.util.ArrayList;
import java.util.Random;

public class RandomStrategy implements Strategy {

    public Member makeStrategy(ArrayList<Member> members) {
        Random random = new Random();
        return members.get(random.nextInt(members.size()));
    }
}
