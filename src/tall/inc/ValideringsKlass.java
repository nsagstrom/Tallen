/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tall.inc;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author isakw
 */
public class ValideringsKlass {
//Validera s� att textruta inneh�ller v�rde
    public static boolean txtFaltHarVarde(JTextField ruta) {
        boolean rutaHarVarde = true;
        if (ruta.getText().isEmpty()) {
            rutaHarVarde = false;
            ruta.requestFocus();
        }
        return rutaHarVarde;
    }
//Validera s� att string input inneh�ller v�rde
    public static boolean stringHarVarde(String instring) {
        boolean stringFinns = true;
        if (instring.isEmpty()) {
            stringFinns = false;
        }
        return stringFinns;
    }
//Validera s� att textruta inneh�ller tal
    public static boolean taltest(JTextField taltest) {
        boolean arTal = true;
        String idid = taltest.getText();

        if (!idid.matches("\\d+")) {
            arTal = false;

        }
//        else {
//            taltest.requestFocus();
//        }
        return arTal;
    }
//Validera s� att combobox har korrekt position, inte index position noll
    public static boolean testaIndexPos(JComboBox position) {
        boolean indexOk = true;

        if (position.getSelectedIndex() == 0) {
            indexOk = false;
        }

        return indexOk;
    }
//Testa s� att textruta telefonnummer inneh�ller korrekta tecken
    public static boolean testaTeleNmr(JTextField teleNmr) {
        boolean nmrOk = true;
        String nmr = teleNmr.getText();

        if (!nmr.matches("[0-9-+]+")) {
            nmrOk = false;
        }

        return nmrOk;
    }
//Testa s� att string inneh�ller korrekta tecken i telefonnumret
    public static boolean testaTeleNmrString(String teleNmr) {
        boolean nmrOk = true;

        if (!teleNmr.matches("[0-9-+]+")) {
            nmrOk = false;
        }

        return nmrOk;
    }
//Testa s� att datum �r angett i korrekt format
    public static boolean kollaDatumCheck(String datum) {
        boolean resultat = false;

        if (datum.matches("\\d{4}-\\d{2}-\\d{2}")) {
            resultat = true;
        } else {
            JOptionPane.showMessageDialog(null, "Fel datumformat, prova igen enligt 'YYYY-MM-DD'");
        }

        return resultat;
    }

    static void taltest(String namn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
