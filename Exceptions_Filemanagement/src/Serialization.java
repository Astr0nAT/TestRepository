import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import models.*;

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
        Person p = new Person(1, "Daniel", 2810.90);
        p.setAddress(new Address(100, "Anichstraße"));
        List<Person> people = new ArrayList<Person>();
        people.add(new Person(1, "Philipp", 2810.90));
        people.add(new Person(2, "Sebastian", 3110.90));
        people.get(0).setAddress(new Address(100, "Museumstraße"));

        String filePerson = "person.bin";
        String filePeople = "people.bin";

        Person personFromFile;
        List<Person> peopleFromFile;

        do{
            choice = Menu();
            switch(choice){
                case 's':
                    createFile(filePerson);
                    serializePerson(filePerson, p);
                    break;
                case 'a':
                    personFromFile = deserializePerson(filePerson);
                    System.out.println(personFromFile);
                    System.out.println(personFromFile.getAddress());
                    break;
                case 'm':
                    createFile(filePeople);
                    serializePeople(filePeople, people);
                    break;
                case 'n':
                    peopleFromFile = deserializePeople(filePeople);
                    for(Person pe : peopleFromFile){
                        System.out.println(pe);
                        System.out.println(pe.getAddress());
                    }
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

    public static void serializePerson(String filename, Person person){
        // erweiterte Version von try - mit ()-Klammern
        // innerhalb der Klammern werden Instanzen für Ressourcen angegeben, diese müssen unbedingt möglichst rasch
        // wieder freigegeben werden
        try(FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(person);
        }
        // hier werden die obigen Ressourcen wieder freigegeben
        // es wird automatisch der finally-Block eingefügt
        catch(IOException e){
            System.out.println("Serialisierung hat nicht funktioniert.");
        }
    }
    private static Person deserializePerson(String filename) {
        try(FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis))
        {
            // Rückgabetyp von readObject ist immer die Basisklasse Object
            // diese muss noch in den gewünschen Typ (hier Person) konvertiert werden
            return (Person)ois.readObject();
        }
        catch(IOException e){
            System.out.println("Deserialisierung hat nicht funktioniert.");
        }
        catch(ClassNotFoundException e){
            System.out.println("Klasse Person oder Address existiert nicht.");
        }
        return null;
    }

    private static void serializePeople(String filename, List<Person> people){
        try(FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            for(Person p : people){
                oos.writeObject(p);
            }
        }
        catch(IOException e){
            System.out.println("Serialisierung hat nicht funktioniert.");
        }
    }
    private static List<Person> deserializePeople(String filename){
        List<Person> people = new ArrayList<Person>();
        try(FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis))
        {
            return (List<Person>)ois.readObject();
        }
        catch(IOException e){
            System.out.println("Deserialisierung hat nicht funktioniert.");
        }
        catch(ClassNotFoundException e){
            System.out.println("Klasse Person oder Address existiert nicht.");
        }
        return null;
    }

    private static void createFile(String filename){
        try {
            Files.createFile(Paths.get(filename));
        }
        catch(FileAlreadyExistsException e){
            System.out.println("Fehler: Datei exisitiert bereits!");
        }
        catch(IOException e){

            System.out.println("Fehler: IO-Fehler");

        }
    }

}