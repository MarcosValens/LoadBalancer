import java.util.ArrayList;

public class MemberManager {

    private ArrayList<Member> members;

    public Member addMember() {
        return new Member("Member" + (this.members.size() + 1));
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

    public void setMembers(Member member) {
        this.members.add(member);
    }
}
