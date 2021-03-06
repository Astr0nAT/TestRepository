import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

public class Exceptions_Filemanagement {

    // Exceptionhandling
    // => auf Ausnahmesituationen reagieren können

    /*
        1.
            try{
                Codezeile 1
                Codezeile 2 => passiert z.B. hier eine Exception werden die darunterliegenden Befehle nicht mehr
                                ausgeführt. Es wird zum passenden catch-Block gesprungen
                Codezeile 3
                usw.
            }
            catch(<Exceptionklasse1> var){
                => es können beliebig viele catch-Blöcke vorhanden sein
                Meldung ausgeben
                Loggen
            }
            catch(<Exceptionklasse2> var){
                Meldung ausgeben
                Loggen
            }
            <finally{
                dieser Bereich wird immer ausgeführt
                bei Fehler, aber auch wenn kein Fehler passiert
                hier werden Ressourcen wieder freigegeben
            }>

            Exceptionklassen: Basisklasse: Exception
                                => es existiert eine Vererbungshierarchie bei den Exceptionklassen
                                bei Bedarf kann man auch eigene Exceptionklassen schreiben

            throw, throws ... hiermit kann eine Exception im Programmcode geworfen werden

     */

    /*
        Directory- und Filemanagement
            Klassen um mit Verzeichnisses bzw. Dateien zu arbeiten.

            alle Instanzen sind normalerweise nur im RAM vorhanden
            => wird das Programm beendet gehen alle Daten verloren
            => Lösung: in einer Datei oder Datenbank abspeichern

            Package:    io ... alte Klassen für input/output
                        nio ... neue Klassen für input/output

                        wichtige Klassen: Files, Paths
     */

    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {

        char choice;
        String filename = null;
        BufferedWriter writer = null;
        String text;

        do{
            choice = Menu();
            switch(choice){
                case 'e':
                    System.out.print("Dateiname: ");
                    filename = reader.nextLine();
                    createFile(filename);
                    break;
                case 'ö':
                    System.out.print("Zu öffnende Datei: ");
                    filename = reader.nextLine();
                    writer = openFile(filename);
                    break;
                case 'd':
                    // Datei wurde geöffnet (Menüpunkt 'ö')
                    if(writer != null){
                        do {
                            System.out.print("Ihr Text (end zum Beenden): ");
                            text = reader.nextLine();
                            if(!text.toLowerCase().equals("end")){
                                appendText(text, writer);
                            }
                        }
                        while(!text.toLowerCase().equals("end"));
                    }
                    else{
                        if((filename != null) && (!filename.isEmpty())){
                            do {
                                System.out.print("Ihr Text (end zum Beenden): ");
                                text = reader.nextLine();
                                if(!text.toLowerCase().equals("end")){
                                    appendText(text, filename);
                                }
                            }while(!text.toLowerCase().equals("end"));
                        }
                        else{
                            System.out.println("Keine Datei erzeugt bzw. keine Datei geöffnet!");
                        }
                    }
                    break;
                case 'a':
                    printContent(filename);
                    break;
                case 'z':
                    printAllLines(filename);
                    break;
                case 'l':
                    deleteFile(filename);
                    break;
                case 'c':
                    createDirectory(reader.nextLine());
                    break;
                case 'b':
                    System.out.println("Programm wird beendet");
                    break;
                default:
                    System.out.println("Falsche Taste gedrückt");
                    break;
            }
        }
        while(choice != 'b');
    }

    private static char Menu(){
        System.out.println("e ... Datei erzeugen");
        System.out.println("ö ... Datei öffnen");
        System.out.println("d ... Daten in die Datei schreiben");
        System.out.println("a ... Datei komplett ausgeben");
        System.out.println("z ... Datei zeilenweise ausgeben");
        System.out.println("l ... Datei löschen");
        System.out.println("b ... Beenden");
        System.out.print("Ihre Wahl: ");
        return reader.nextLine().toLowerCase().charAt(0);
    }

    private static void createFile(String filename){
        try {
            Files.createFile(Paths.get(filename));
        }
        catch(FileAlreadyExistsException e){
            System.out.println("Fehler: Datei exisitiert bereits!");
        }
        catch(IOException e){
            // aussagekröftige Fehlermeldung anzeigen
            System.out.println("Fehler: IO-Fehler");
            // Fehlermeldung von JAVA
            // System.out.println(e.getMessage());
            // Stacktrace ist sehr Wichtig, aber nicht für den Benutzer (Logging)
            // e.printStackTrace();
        }
    }

    private static BufferedWriter openFile(String filename){
        try{
            return Files.newBufferedWriter(Paths.get(filename), StandardOpenOption.APPEND);
        }
        catch(IOException e){
            System.out.println("Fehler: Datei konnte nicht geöffnet werden.");
        }
        return null;
    }

    private static void appendText(String text, BufferedWriter writer){
        try{
            writer.write(text + "\n");
            writer.flush();
        }
        catch(IOException e){
            System.out.println("Fehler: Text konnte nicht in der Datei abgelegt werden!");
        }
    }

    private static void appendText(String text, String filename){
        try{
            text += "\n";
            Files.write(Paths.get(filename), text.getBytes(), StandardOpenOption.APPEND);
        }
        catch(IOException e){
            System.out.println("Fehler: Text konnte nicht in der Datei abgelegt werden!");
        }
    }

    private static void printContent(String filename){
        try{
            System.out.println(Files.readString(Paths.get(filename)));
        }
        catch(IOException e){
            System.out.println("Fehler: Datei existiert nicht");
        }
    }

    private static void printAllLines(String filename) {
        try{
            List<String> lines = Files.readAllLines(Paths.get(filename));
            for(int i = 0; i < lines.size(); i++){
                System.out.println((i + 1) + ". Zeile: " + lines.toArray()[i]);
            }
        }
        catch(IOException e){
            System.out.println("Datei existiert nicht!");
        }
    }

    private static void deleteFile(String filename) {
        try{
            Files.delete(Paths.get(filename));
            System.out.println("Datei gelöscht!");
        }
        catch(IOException e){
            System.out.println("Datei existiert nicht!");
        }
    }

    private static void createDirectory(String path){
        try{
            Files.createDirectory(Paths.get(path));
        } catch (IOException e) {
            System.out.println("Cannot create directory!");
        }
    }

}
