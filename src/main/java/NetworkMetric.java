import java.io.IOException;

/*
* ES NECESARIO INSTALAR NET-TOOLS PARA USAR ESTA METRICA ($sudo apt install net-tools)
* */

public class NetworkMetric implements Metric {

    public int getLoad() throws IOException {
        String[] cmd = {"ifconfig | grep MB | awk '{print (($3/10000)/50)*100;exit;}'"};
        return Util.runTime(cmd);
    }
}
