import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Util {

    static int runTime(String[] cmd) throws IOException {
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
