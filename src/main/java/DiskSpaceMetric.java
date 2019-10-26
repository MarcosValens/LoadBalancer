import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiskSpaceMetric implements Metric {

    public int getLoad() throws IOException {
        String[] cmd = {"/bin/bash","-c","df -H /dev/sda8 | awk '{print $5 + $1}'"};
        return Util.runTime(cmd);
    }
}
