import java.sql.SQLOutput;
import java.util.Scanner;

public class Serialization {
    /*
    Sinn: ermöglicht das einfache Abspeichern und Auslesen von kompletten Instanzen, Listen von Instanzen und
    Objektbäumen

    Voraussetzung: jede abzuspeichernde Klasseninstanz muss das Interface Serializeable implementieren (dieses Interface
    besitzt allerdings keine Methode).
    => funktioniert im Hintergrund durch Reflection

    benötigte Klassen:
        Speichern
            FileOutputStream
            ObjectOutputStream
        Laden
            FileInputStream
            ObjectInputStream
     */
    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {

        char choice;
        do{
            choice = Menu();
            switch(choice){
                case 's':
                    break;
                case 'a':
                    break;
                case 'm':
                    break;
                case 'n':
                    break;
                case 'b':
                    System.out.println("Programm wird beendet.");
                    break;
                default:
                    System.out.println("Falsche Taste gedrückt.");
                    break;
            }
        } while(choice != 'b');
    }

    public static char Menu(){
        System.out.println("s ... eine Person speichern");
        System.out.println("a ... eine Person anzeigen");
        System.out.println("m ... mehrere Personen speichern");
        System.out.println("n ... mehrere Personen anzeigen");
        System.out.println("b ... beenden");
        System.out.print("Ihre Wahl: ");
        return reader.nextLine().toLowerCase().charAt(0);
    }
}