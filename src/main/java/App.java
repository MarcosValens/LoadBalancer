import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {
        Request request1 = new Request("request1");
        Request request2 = new Request("request2");
        Request request3 = new Request("request3");
        Request request4 = new Request("request4");
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(request1);
        requests.add(request2);
        requests.add(request3);
        requests.add(request4);
        Member member1 = new Member("member1");
        ArrayList<Member> members = new ArrayList<>();
        members.add(member1);
        MemberManager memberManager = new MemberManager(members);
        LoadBalancer loadBalancer = new LoadBalancer(requests,memberManager);
        loadBalancer.setMetric();
        loadBalancer.selectStrategy();
        for (Request request:requests) {
            loadBalancer.resolveRequest(request);
        }
    }
}
