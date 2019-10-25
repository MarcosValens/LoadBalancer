import java.util.ArrayList;
import java.util.Scanner;

public class LoadBalancer {
    private ArrayList<Request> requests;
    private int maxLoad = 80;
    private MemberManager memberManager;
    private Strategy strategy;
    private Metric metric;

    public Response resolveRequest(Request request){
        return  null;
    }

    private boolean isOverloaded(Member member){
        return true;
    }

    public void selectStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public LoadBalancer(ArrayList<Request> requests, MemberManager memberManager) {
        this.requests = requests;
        this.memberManager = memberManager;
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
}
