import java.util.Scanner;

public class Messwerte {

    private double[] messwerte;
    private String einheit;

    Scanner scan = new Scanner(System.in);

    public Messwerte(String einheit) {
        setEinheit(einheit);
    }

    public void setMesswerte() {
        System.out.println("Für wie viele Tage möchten Sie Messwerte eintragen? (Alte werden gelöscht!)");
        int messwerteCount = scan.nextInt();

        System.out.println("In welcher Einheit sollen die Messwerte gespeichert werden? (°F, °C)");
        setEinheit(scan.next());

        deleteMesswerte();

        this.messwerte = new double[messwerteCount];
        for (int i = 0; i<this.messwerte.length; i++) {
            System.out.println("Bitte geben Sie den Messwert für Tag " + (i+1) + " ein: (Ohne Einheit)");
            this.messwerte[i] = scan.nextDouble();
        }
    }

    public void getMesswerte() {
        if (this.messwerte == null) {
            System.out.println("Es wurden keine Daten gefunden, die Angezeigt werden können!");
        }
        else {
            System.out.println("Hier sind die Daten der letzten " + this.messwerte.length + " Tage:");
            for (int i = 0; i<this.messwerte.length; i++) {
                System.out.println("Tag " + (i+1) + ": "+ this.messwerte[i] + " " + this.einheit);
            }
        }

    }

    public void convertToFahrenheit() {
        if (this.messwerte == null) {
            System.out.println("Es wurden keine Daten gefunden, die konvertiert werden können!");
        } else {
            for (int i = 0; i<this.messwerte.length; i++) {
                this.messwerte[i] = ((this.messwerte[i] * 9/5) + 32);
            }
            setEinheit("°F");
        }
    }



    public void convertToCelsius() {
        if (this.messwerte == null) {
            System.out.println("Es wurden keine Daten gefunden, die konvertiert werden können!");
        } else {
            for (int i = 0; i<this.messwerte.length; i++) {
                this.messwerte[i] = ((this.messwerte[i] - 32) * 9/5);
            }
            setEinheit("°C");
        }
    }

    public boolean isArrayEmpty() {
        return (messwerte == null);
    }

    public double getLowestVal() {
        double highestVal = 90000000;
        for (int i = 0; i<messwerte.length; i++) {
            if (messwerte[i] < highestVal) {
                highestVal = messwerte[i];
            }
        }
        return highestVal;
    }

    public double getHighestVal() {
        double highestVal = -9000000;
        for (int i = 0; i<messwerte.length; i++) {
            if (messwerte[i] > highestVal) {
                highestVal = messwerte[i];
            }
        }
        return highestVal;
    }


    private void deleteMesswerte () {
        this.messwerte = null;
    }

    private void setEinheit(String einheit) {
        this.einheit = einheit;
    }
    public String getEinheit() {
        return this.einheit;
    }

    public int getArrayLength() {
        return messwerte.length;
    }





}
