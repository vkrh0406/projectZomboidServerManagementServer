package projectzomboid.demo.utils;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
@Getter
public class ProjectZomboidServerManagement {

    private Boolean serverStatus = false;
    Process p;
    @PostConstruct
    public void serverStart() throws IOException {
        String cmd = "C:\\Program Files (x86)\\Steam\\steamapps\\common\\Project Zomboid Dedicated Server\\StartServer64.bat";
        p = Runtime.getRuntime().exec("cmc /c" + cmd);
        serverStatus = true;
    }

    public void serverRestart() throws IOException {
        if(serverStatus && p.isAlive()){
            p.destroy();
            serverStatus = false;
        }
        String cmd = "C:\\Program Files (x86)\\Steam\\steamapps\\common\\Project Zomboid Dedicated Server\\StartServer64.bat";
        p = Runtime.getRuntime().exec("cmc /c" + cmd);
        serverStatus = true;
    }
}
