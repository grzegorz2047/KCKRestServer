package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
public class StandardPrologCommandController {

    @RequestMapping("/standard")
    public void command(@RequestParam(value = "komenda", defaultValue = "listing") String command) {
        CommandExecutor ce = new CommandExecutor();
        try {
            ce.consoleCommandExecutor("cmd /c \"c:\\Program Files (x86)\\swipl\\bin\\swipl\" -s prolog2.pl -g \"" + command + ", nl, halt\"");
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("robie ");
    }
}