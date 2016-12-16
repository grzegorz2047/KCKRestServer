package com.gmail.grzegorz2047.kckrestserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

/**
 * Plik stworzony przez grzegorz2047 14.12.2016.
 */
public class CommandExecutor {

    /**
     * Wysłanie komendy do prologu zadziała w niektórych przypadkach, gdzie nie wymagana jest interakcja np. listing
     * innych przypadków nie udało się wykonać
     * Wiecej info tutaj: http://www.swi-prolog.org/pldoc/doc_for?object=section(2%2C%20%272.4%27%2C%20swi(%27%2Fdoc%2FManual%2Fcmdline.html%27))
     *
     * @param cmd - pobiera komendę w konsoli do wykonania
     * @throws InterruptedException
     * @throws IOException
     * Po wykonaniu polecenia, zwraca wynik na ekran (konsolę)
     */
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
