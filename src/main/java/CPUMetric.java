import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CPUMetric implements Metric {

    public int getLoad() throws IOException {

        String[] cmd = {"/bin/bash", "-c", "top -b -n1 | grep \"Cpu(s)\" | awk '{print $2 + $4}'"};
        return Util.runTime(cmd);
    }
}

