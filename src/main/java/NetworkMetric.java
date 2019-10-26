import java.io.IOException;

public class NetworkMetric implements Metric {
    public int getLoad() throws IOException {

        String[] cmd = {"ifconfig | grep MB | awk '{print (($3/10000)/50)*100;exit;}'"};
        return Util.runTime(cmd);
    }
}
