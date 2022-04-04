package tall.inc;


import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Den här klassen innehåller metoder för olika SQL-frågor.
 * Alla metoder är klassmetoder vilket anges med nyckelordet static.
 * Detta innebeär att vi kommer åt metoderna från alla andra klasser i projektet utan att instansiera ett objekt av den här klassen.
 * @author Markus
 */
public class SqlFragor {
    
    private static InfDB idb;

    //Metod för att ge klassvariabeln idb rätt referensvärde utan att behöva instansiera ett objekt av klassen
    public static void setDatabas(InfDB idb) {
        SqlFragor.idb = idb;
    }

    /**
     * Ställer en SQL-fråga och returnerar ett värde i form av en String
     *
     * @param fraga En SQL-fråga
     * @return Svaret på SQL-frågan. Om frågan inte resulterar i ett svar
     * returneras en sträng med värdet null.
     */
    public static String getEttVarde(String fraga) {
        String returString = null;

        try {
            returString = idb.fetchSingle(fraga);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Databasfel");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }
        return returString;
    }

    /**
     * Ställer en SQL-fråga och returnerar en rad i form av en Hashmap
     *
     * @param fraga En SQL-fråga
     * @return Svaret på SQL-frågan. Om frågan inte resulterar i ett svar
     * returneras en tom HashMap.
     */
    public static HashMap getEnRad(String fraga) {
        HashMap<String, String> returMap;

        try {
            returMap = idb.fetchRow(fraga);
        } catch (InfException e) {
            returMap = new HashMap<>();
            JOptionPane.showMessageDialog(null, "Databasfel");
        } catch (Exception e) {
            returMap = new HashMap<>();
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }

        return returMap;
    }

    /**
     * Ställer en SQL-fråga och returnerar flera rad i form av en ArrayList of
     * HashMap
     *
     * @param fraga En SQL-fråga
     * @return Svaret på SQL-frågan. Om frågan inte resulterar i ett svar
     * returneras en tom ArrayList of HashMap.
     */
    public static ArrayList<HashMap<String, String>> getFleraRader(String fraga) {
        ArrayList<HashMap<String, String>> returArrayList = new ArrayList<>();

        try {
            returArrayList = idb.fetchRows(fraga);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Databasfel");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }

        return returArrayList;
    }

    /**
     * Ställer en SQL-fråga och returnerar en kolumn i form av en ArrayList
     *
     * @param fraga En SQL-fråga
     * @return Svaret på SQL-frågan. Om frågan inte resulterar i ett svar
     * returneras en tom ArrayList.
     */
    public static ArrayList<String> getEnKolumn(String fraga) {
        ArrayList<String> returArrayList = new ArrayList<>();

        try {
            returArrayList = idb.fetchColumn(fraga);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Databasfel");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }

        return returArrayList;
    }

    /**
     * Uppdaterar värden i databasen. Kanske finns ett bättre namn på metoden?
     * Dålig fantasi här :)
     *
     * @param fraga En SQL-fråga
     * @return True om frågan fungerade
     */
    public static boolean uppdatering(String fraga) {
        boolean lyckades = false;

        try {
            idb.update(fraga);
            lyckades = true;
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Databasfel");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }
        return lyckades;
    }

    /**
     * En metod för att ta bort en rad ur databasen.
     *
     * @param fraga SQL-frågan man vill använda.
     */
    public static void deleteFranDatabasen(String fraga) {
        try {
            idb.delete(fraga);
            //JOptionPane.showMessageDialog(null, "Objektet har tagits bort ur databasen.");
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel");
            System.out.println(ex.getMessage());
        }
    }

    /**
     * En metod för att läga till något i databasen.
     *
     * @param fraga En SQL-fråga.
     */
    public static boolean addToDatabasen(String fraga) {
        boolean lyckades = true;
        try {
            idb.insert(fraga);
            //JOptionPane.showMessageDialog(null, "Objektet har lagts till i databasen.");
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel");
            System.out.println(ex.getMessage());
            lyckades = false;
        }
        return lyckades;
    }
    /**
     * H�mtar n�sta tillg�ngliga ID
     * @param tabell
     * @param kolumn
     * @return 
     */
    public static String nyID(String tabell, String kolumn) {

        String svar = "";
        try {
            svar = idb.getAutoIncrement(tabell, kolumn);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "J�VLA PAPPSKALLE8");
        }
        return svar;
    }
    
}
