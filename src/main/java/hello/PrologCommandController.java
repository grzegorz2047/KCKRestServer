package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PrologCommandController {

    @RequestMapping("/pl")
    public void command(@RequestParam(value = "komenda", defaultValue = "listing") String command) {
        CommandExecutor ce = new CommandExecutor();
        try {
            ce.consoleCommandExecutor("cmd /c c:\\software\\swiprolog\\bin\\swipl -s prolog2.pl -g \"" + command + ", nl, halt\"");
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}