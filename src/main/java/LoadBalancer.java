import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadBalancer {
    private ArrayList<Request> requests;
    private int maxLoad = 80;
    private MemberManager memberManager;
    private Strategy strategy;
    private Metric metric;

    public Response resolveRequest(Request request) throws IOException {
        while (true) {
            Member memberSelected = this.strategy.makeStrategy(memberManager.getMembers());
            memberSelected.selectMetric(this.metric);
            System.out.println("Member seleccionado: "+memberSelected.getUrl());
            if (this.isOverloaded(memberSelected)) {
                Response response = new Response(request.getUrl(),memberSelected.getUrl());
                System.out.println("Respondiendo a: " + response.getUrl()+"\nRespuesta: " + response.getResponseURL());
                return response;
            } else {
                Member newMember = memberManager.addMember();
                newMember.selectMetric(this.metric);
                memberManager.setMembers(newMember);
                System.out.println("Member sobrecargado...\nCreando "+newMember.getUrl());
            }
        }
    }

    private boolean isOverloaded(Member member) throws IOException {
        if (!member.isEnabled()) {
            memberManager.removeMember(member);
        } else return this.metric.getLoad() < maxLoad;
        return false;
    }

    public void selectStrategy(/*Strategy strategy*/) {
        boolean repeat = true;
        System.out.println("Select Strategy:\nPress 1 for RoundRobin\nPress 2 Random");
        Scanner input = new Scanner(System.in);
        while (repeat) {
            switch (input.nextInt()) {
                case 1:
                    this.strategy = new RoundRobinStrategy();
                    repeat = false;
                    break;
                case 2:
                    this.strategy = new RandomStrategy();
                    repeat = false;
                    break;
                default:
                    System.out.println("Incorrect selection.\nPress 1 for RoundRobin\nPress 2 for Random");
            }
        }
    }

    public void setMetric() {
        boolean repeat = true;
        System.out.println("Select metric:\nPress 1 for Ram Metric\nPress 2 for CPU Metric\nPress 3 for Network Metric\n" +
                "Press 4 for DiskSpace Metric");
        Scanner input = new Scanner(System.in);
        while (repeat) {
            switch (input.nextInt()) {
                case 1:
                    this.metric = new RAMMetric();
                    repeat = false;
                    break;
                case 2:
                    this.metric = new CPUMetric();
                    repeat = false;
                    break;
                case 3:
                    this.metric = new NetworkMetric();
                    repeat = false;
                    break;
                case 4:
                    this.metric = new DiskSpaceMetric();
                    repeat = false;
                    break;
                default:
                    System.out.println("Incorrect selection.\nPress 1 for Ram Metric\nPress 2 for CPU Metric" +
                            "\nPress 3 for Network Metric\nPress 4 for DiskSpace Metric");
            }
        }
    }

    public LoadBalancer(ArrayList<Request> requests, MemberManager memberManager) {
        this.requests = requests;
        this.memberManager = memberManager;
    }
}
