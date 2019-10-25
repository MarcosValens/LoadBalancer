import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RAMMetric implements  Metric {

    public int getLoad() throws IOException {

        String[] cmd = {"/bin/bash","-c","free | grep Mem | awk '{print $3/$2 * 100.0}'"};
        Process pb = Runtime.getRuntime().exec(cmd);
        String line;
        String result = "";
        BufferedReader input = new BufferedReader(new InputStreamReader(pb.getInputStream()));
        while ((line = input.readLine()) != null) {
            result = line;
        }
        input.close();
        String[] parts = result.split("\\.");
        return Integer.parseInt(parts[0]);
    }
}
