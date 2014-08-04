package de.mpw.webformularhelper;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Markus on 30.07.2014.
 */
class Namen {
    private final ArrayList<String> frauen;
    private final ArrayList<String> maenner;
    private final ArrayList<String> nachnamen;
    private final Random random;

    public static String getMail() {
        return new RandomString(10).nextString();
    }

    public int getDay() {
        return random.nextInt(28);
    }

    public static String getPasswort() {
        return new RandomString(10).nextString().concat("1");
    }

    public Namen() {
        Scanner scannerFrauen;
        Scanner scannerMaenner;
        Scanner scannerNachnamen;

        scannerFrauen = new Scanner((getClass().getResourceAsStream("frauen.txt")));
        scannerMaenner = new Scanner(getClass().getResourceAsStream("maenner.txt"));
        scannerNachnamen = new Scanner(getClass().getResourceAsStream("nachname.txt"));

        frauen = new ArrayList<String>();
        maenner = new ArrayList<String>();
        nachnamen = new ArrayList<String>();

        while (scannerFrauen.hasNext()) {
            frauen.add(scannerFrauen.next());
        }
        scannerFrauen.close();

        while (scannerMaenner.hasNext()) {
            maenner.add(scannerMaenner.next());
        }
        scannerMaenner.close();
        while (scannerNachnamen.hasNext()) {
            nachnamen.add(scannerNachnamen.next());
        }
        scannerNachnamen.close();
        System.out.println("Maenner" + maenner.size() + " Frauen" + frauen.size() + " Nachnamen" + nachnamen.size());
        random = new Random();

    }

    public String getVorname(boolean b) {
        if (b) {
            return frauen.get(random.nextInt(frauen.size()));
        } else {
            return maenner.get(random.nextInt(maenner.size()));
        }
    }

    public String getNachname() {
        return nachnamen.get(random.nextInt(nachnamen.size()));
    }

    public int getYear() {
        return random.nextInt(60) + 1940;
    }

    public int getMonth() {
        return random.nextInt(11);
    }

    public String getPlz() {
        return "10117";
    }
}
