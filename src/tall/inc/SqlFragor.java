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
 * Den hÃ¤r klassen innehÃ¥ller metoder fÃ¶r olika SQL-frÃ¥gor. Alla metoder Ã¤r klassmetoder vilket anges med nyckelordet static. Detta innebeÃ¤r att vi kommer Ã¥t metoderna frÃ¥n alla andra klasser i projektet utan att instansiera ett objekt av den hÃ¤r klassen.
 *
 * @author Markus
 */
public class SqlFragor {

    private static InfDB idb;

    //Metod fÃ¶r att ge klassvariabeln idb rÃ¤tt referensvÃ¤rde utan att behÃ¶va instansiera ett objekt av klassen
    public static void setDatabas(InfDB idb) {
        SqlFragor.idb = idb;
    }

    /**
     * StÃ¤ller en SQL-fråga och returnerar ett vÃ¤rde i form av en String
     *
     * @param fraga En SQL-fråga
     * @return Svaret på SQL-frÃ¥gan. Om frÃ¥gan inte resulterar i ett svar returneras en strÃ¤ng med vÃ¤rdet null.
     */
    public static String getEttVarde(String fraga) {
        String returString = null;

        try {
            returString = idb.fetchSingle(fraga);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Databasfel");
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }
        return returString;

    }

    /**
     * StÃ¤ller en SQL-frÃ¥ga och returnerar en rad i form av en Hashmap
     *
     * @param fraga En SQL-frÃ¥ga
     * @return Svaret pÃ¥ SQL-frÃ¥gan. Om frÃ¥gan inte resulterar i ett svar returneras en tom HashMap.
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
     * StÃ¤ller en SQL-frÃ¥ga och returnerar flera rad i form av en ArrayList of HashMap
     *
     * @param fraga En SQL-frÃ¥ga
     * @return Svaret pÃ¥ SQL-frÃ¥gan. Om frÃ¥gan inte resulterar i ett svar returneras en tom ArrayList of HashMap.
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
     * StÃ¤ller en SQL-frÃ¥ga och returnerar en kolumn i form av en ArrayList
     *
     * @param fraga En SQL-frÃ¥ga
     * @return Svaret pÃ¥ SQL-frÃ¥gan. Om frÃ¥gan inte resulterar i ett svar returneras en tom ArrayList.
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
     * Uppdaterar vÃ¤rden i databasen. Kanske finns ett bÃ¤ttre namn pÃ¥ metoden? DÃ¥lig fantasi hÃ¤r :)
     *
     * @param fraga En SQL-frÃ¥ga
     * @return True om frÃ¥gan fungerade
     */
    public static void uppdatera(String fraga) {
        try {
            idb.update(fraga);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "JÄVLA PAPPSKALLE6");
        }
    }

    /**
     * En metod fÃ¶r att ta bort en rad ur databasen.
     *
     * @param fraga SQL-frÃ¥gan man vill anvÃ¤nda.
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
     * En metod fÃ¶r att lÃ¤ga till nÃ¥got i databasen.
     *
     * @param fraga En SQL-frÃ¥ga.
     */
    public static boolean addToDatabasen(String fraga) {
        boolean lyckades = true;
        try {
            idb.insert(fraga);
            //JOptionPane.showMessageDialog(null, "Objektet har lagts till i databasen.");
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel");
            System.out.println(ex.getMessage());
            System.out.println("addToDatabas");

            lyckades = false;
        }
        return lyckades;
    }

    /**
     
     *
     * @param tabell
     * @param kolumn
     * @return
     */
    public static String nyID(String tabell, String kolumn) {

        String svar = "";
        try {
            svar = idb.getAutoIncrement(tabell, kolumn);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "JÄVLA PAPPSKALLE8");
        }
        return svar;
    }

}
