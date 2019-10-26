import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RAMMetric implements  Metric {

    public int getLoad() throws IOException {

        String[] cmd = {"/bin/bash", "-c", "free | grep Mem | awk '{print $3/$2 * 100.0}'"};
        return Util.runTime(cmd);
    }
}
