import java.util.ArrayList;

public class RoundRobinStrategy implements Strategy {
    private int nextNode;

    public Member makeStrategy(ArrayList<Member> members) {

        if (this.nextNode == members.size()) {
            this.nextNode = 0;
        }
        this.nextNode++;
        return members.get(this.nextNode - 1);
    }
}
