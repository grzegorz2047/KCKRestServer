package hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Plik stworzony przez grzegorz2047 14.12.2016.
 */
public class CommandExecutor {

    public void consoleCommandExecutor(String cmd) throws InterruptedException, IOException {
        final Process p = Runtime.getRuntime().exec(cmd);

        new Thread(new Runnable() {
            public void run() {
                BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line = null;

                try {
                    while ((line = input.readLine()) != null)
                        System.out.println(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        p.waitFor();
    }

}
