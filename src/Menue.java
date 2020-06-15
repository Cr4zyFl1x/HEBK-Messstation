import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class Menue {

    Messwerte messwerte = new Messwerte("°C");
    Scanner scan = new Scanner(System.in);

    public void call() {
        while (true) {
            hauptmenu();
        }
    }

    private void hauptmenu() {
        System.out.println("--------------->> Wetterstation <<---------------");
        System.out.println("Willkommen,");
        System.out.println("welche Aktion möchte Sie durchführen?");
        System.out.println("");
        System.out.println("1. Messwerte abrufen");
        System.out.println("2. Messwerte speichern (Alte Überschreiben)");
        System.out.println("3. Messwerte konvertieren (Derzeitige Einheit: " + messwerte.getEinheit() + ")");
        System.out.println("4. Messwertstatistik aufrufen");
        System.out.println("5. Programm beenden");
        System.out.println("--------------->> Wetterstation <<---------------");
        System.out.println();
        System.out.println("Bitte wählen Sie Ihre Aktion:");

        switch (scan.nextInt()) {
            case 1:
                messwerte.getMesswerte();
                break;
            case 2:
                messwerte.setMesswerte();
                break;
            case 3:
                einheitWaelen();
                break;
            case 4:
                messwertStatistik();
                break;
            case 5:
                System.exit(0);
                break;
        }
    }

    private void messwertStatistik() {
        if (!messwerte.isArrayEmpty()) {
            System.out.println("Niedrigster Wert der letzten " + messwerte.getArrayLength() + " Tage: " + messwerte.getLowestVal() + " " + messwerte.getEinheit());
            System.out.println("Höchster Wert der letzten " + messwerte.getArrayLength() + " Tage: " + messwerte.getHighestVal() + " " + messwerte.getEinheit());
        } else {
            System.out.println("Es sind keine Werte vorhanden!");
        }
    }

    private void einheitWaelen() {
        System.out.println("Bitte geben Sie die Einheit an, in die die Messwerte konvertiert werden sollen:");
        String e = scan.next();
        switch (e) {
            case "°F":
                if (!e.equals(messwerte.getEinheit())) {
                    messwerte.convertToFahrenheit();
                }

                break;
            case "°C":
                if (!e.equals(messwerte.getEinheit())) {
                    messwerte.convertToCelsius();
                }
                break;
            default:
                System.out.println("Diese Einheit existiert nicht!");
        }
    }


}
