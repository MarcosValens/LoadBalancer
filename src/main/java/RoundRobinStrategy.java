import java.util.ArrayList;

public class RoundRobinStrategy implements Strategy {
    private int nextNode;

    public Member makeStrategy(ArrayList<Member> members) {
        this.nextNode++;
        if (this.nextNode > members.size()+1){
            this.nextNode = 1;
        }
        return members.get(this.nextNode-1);
    }
}
