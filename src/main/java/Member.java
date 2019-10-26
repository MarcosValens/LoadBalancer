import java.io.IOException;
import java.net.InetAddress;

public class Member {
    private String url;
    private Metric metric;

    public void selectMetric(Metric metric) {
        this.metric = metric;
    }

    public boolean isEnabled() {
        try {
            InetAddress address = InetAddress.getByName("localhost");
            return address.isReachable(10000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Member(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
