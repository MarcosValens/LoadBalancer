import java.io.IOException;

public class DiskSpaceMetric implements Metric {

    public int getLoad() throws IOException {
        String[] cmd = {"/bin/bash", "-c", "df -H /dev/sda8 | awk '{print $5 + $1}'"};
        return Util.runTime(cmd);
    }
}
