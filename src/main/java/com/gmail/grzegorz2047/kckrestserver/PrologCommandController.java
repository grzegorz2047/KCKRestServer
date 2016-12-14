package com.gmail.grzegorz2047.kckrestserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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