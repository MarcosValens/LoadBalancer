import java.util.ArrayList;
import java.util.Random;

public class RandomStrategy {
    public Member selectedMember(ArrayList<Member> members){
        Random random = new Random();
        return members.get(random.nextInt(members.size()));
    }
}
