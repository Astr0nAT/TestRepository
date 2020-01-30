public class MyMath {
    
    // Test Conflict
    
    // WICHTIG
    /*
    statische Members (Felder und Methoden) können im Hauptprogramm oder in anderen Klassen ohne erzeugung einer Instanz
    verwendet werden, es muss nur der Klassenname und durch Punkt getrennt der Membername angegeben werden.

    statische Members werden nur ein einziges Mal erzeugt
    werden im Hauptprogramm z.B. 10 Instanzen einer Klasse mit statischen Feldern erzeugt, existiert dieses Feld nur ein
    einziges Mal für alle Instanzen
    normale Members (Felder) werden pro Instanz erzeugt; bei 10 Instanzen existiert dieses Feld (z.B. Firstname) 10 mal
    im Speicher

    in einer statischen Methode darf man nur auf statische Members (Felder, Methoden) zugreifen

     */

    // statische Members (Methoden, Felder)
    public static final double MyPI = 3.1415;

    // würde man so nicht machen
    public final double MyPI_ns = 3.1415;

    public double wert = 10;

    // statische Methoden
    public static double DegreeToRadiant(double degree){
        return degree * 2 * Math.PI / 360;
    }
    public static double RadiantToDegree(double rad){
        return rad * (100 / Math.PI);
    }

    public double nonStatic(){
        // WICHTIG: in einer nichtstatischen Methode dürfen normale und statische Members verwendet werden
        return wert * MyPI * RadiantToDegree(wert);
    }

}
