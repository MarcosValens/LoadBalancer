import java.util.ArrayList;

public class MemberManager {
    private ArrayList<Member> members;
    public Member addMember() {
        return new Member("Member"+this.members.size());
    }

    public void removeMember(Member member) {
        members.remove(member);
    }

    public MemberManager(ArrayList<Member> members) {
        this.members = members;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }
}
