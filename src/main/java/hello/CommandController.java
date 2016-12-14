package hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/odbieram")
    public Command command(@RequestParam(value = "komenda", defaultValue = "World") String command) {

        String[] tab = new String[]{"A", "B", "C"};

        StringBuilder finalcommand = new StringBuilder();
        String[] splitted = command.split(" ");
        for (int i = 0; i < splitted.length; i++) {
            finalcommand.append(splitted[i]);
            if (i != splitted.length - 1) {
                finalcommand.append(",");
            }
        }
        StringBuilder varbuild = new StringBuilder();
        for (int i = 0; i < splitted.length; i++) {
            if (i >= 3) {
                break;
            }
            varbuild.append(tab[i]);
            varbuild.append(",");
        }
//        String toprolog = "listing(akcja)";
        String toprolog = "rozkaz(" + varbuild.toString() + "[" + finalcommand.toString() + "],[])";
        System.out.println(toprolog);

        /*return new Command(counter.incrementAndGet(),
                String.format(template, "rozkaz(A,B,C,[" + finalcommand.toString() + "],[])"));*/
        CommandExecutor ce = new CommandExecutor();
        try {
            ce.consoleCommandExecutor("cmd /c c:\\software\\swiprolog\\bin\\swipl -s prolog2.pl -g \"" + toprolog + ", nl, halt\"");
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return new Command(counter.incrementAndGet(),
                toprolog);
    }


}