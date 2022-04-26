/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tall.inc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import static tall.inc.FardigStallBeställning.map;

/**
 *
 * @author arvid
 */
public class FardigstallBestallning extends javax.swing.JFrame {

    /**
     * Creates new form FardigstallBestallning
     */
    String fNamn = "";
    String eNamn = "";
    String adress = "";
    double moms;
    String tull = "";
    String vikt = "";
    String antalHattar = "";
    String pris = "";
    String bestID = "";

    private static String sp = "sv";

    static Map<String, String> map = new LinkedHashMap<String, String>();

    public FardigstallBestallning() {
        initComponents();

        fillOrderCmb();
        fyllCB();
        AutoCompleteDecorator.decorate(cbAlla);
    }

    public void fillOrderCmb() {
        String orderIdQuery = "SELECT DISTINCT bestID FROM orderrad";
        ArrayList<String> bestIDLista = SqlFragor.getEnKolumn(orderIdQuery);
        for (String bestID : bestIDLista) {
            String besKlarQuery = "SELECT hattID FROM orderrad where BestID = '" + bestID + "' AND Hattstatus IS NULL";
            ArrayList<String> listaMedOklaraHattar = SqlFragor.getEnKolumn(besKlarQuery);
            if (listaMedOklaraHattar.isEmpty()) {
                String besStangdQuery = "SELECT DISTINCT Bestallning.BestID FROM bestallning bestallning inner join orderrad o on Bestallning.BestID = o.BestID where Status != 'Stängd' AND o.Hattstatus = 'Klar'";
                ArrayList<String> besStangdLista = SqlFragor.getEnKolumn(besStangdQuery);
                for (String oppenBestID : besStangdLista) {
                    bestCmb.addItem(oppenBestID);

                }

            }
            break;
        }
    }

    private void fyllCB() {
        map.put("Svenska", "sv");
        map.put("Engelska", "en");
        map.put("Estniska", "et");
        map.put("Spanska", "es");
        map.put("Tyska", "de");
        map.put("Franska", "fr");

        for (Map.Entry entry : map.entrySet()) {
            Object Items = entry.getKey();
            cbAlla.addItem((String) Items);

        }
    }

    private void fillBesTable() {
        String bestId = String.valueOf(bestCmb.getSelectedItem());

        String klaraHattarQuery = "SELECT hattID FROM orderrad where BestID = '" + bestId + "' AND Hattstatus = 'Klar'";
        ArrayList<String> listaMedKlaraHattar = SqlFragor.getEnKolumn(klaraHattarQuery);
        int antalHattar = listaMedKlaraHattar.size();

        String prisQuery = "SELECT Pris FROM hatt inner join orderrad o on Hatt.HattID = o.HattID where BestID = '" + bestId + "'";
        ArrayList<String> prisLista = SqlFragor.getEnKolumn(prisQuery);
        int totalaPriset = 0;
        for (String pris : prisLista) {
            int intPris = Integer.parseInt(pris);
            totalaPriset = totalaPriset + intPris;

        }

        String kundInfoQuery = "SELECT Fornamn,  Efternamn, adress FROM kund\n"
                + "    Inner join bestallning b on Kund.KundID = b.KundID\n"
                + "WHERE BestID = '" + bestId + "'";

        HashMap<String, String> kundInfo = SqlFragor.getEnRad(kundInfoQuery);
        System.out.println(kundInfo);
        int i = 0;
        for (String f : kundInfo.values()) {
            besTable.setValueAt(f, NORMAL, i);

            i++;

        }
        besTable.setValueAt(antalHattar, NORMAL, i);
        i++;

        besTable.setValueAt(totalaPriset, NORMAL, i);
        String tullIDQuery = "SELECT TullID FROM Bestallning WHERE BestID = '"+bestId+"'";
        tull = SqlFragor.getEttVarde(tullIDQuery);
        

    }

    private void angeVikt() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        besTable = new javax.swing.JTable();
        bestCmb = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        fardigstallBtn = new javax.swing.JButton();
        cbAlla = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        besTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Efternamn", "Förnamn", "Adress", "Antal Hattar", "Pris", "Vikt"
            }
        ));
        besTable.setRowHeight(40);
        besTable.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(besTable);

        bestCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj Ordernummer" }));
        bestCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bestCmbActionPerformed(evt);
            }
        });

        jLabel1.setText("Ange Vikt:");

        fardigstallBtn.setText("Färdigställ");
        fardigstallBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fardigstallBtnActionPerformed(evt);
            }
        });

        cbAlla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAllaActionPerformed(evt);
            }
        });

        jButton2.setText("Tillbaka");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Välj språk");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(bestCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbAlla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fardigstallBtn)))
                        .addGap(48, 48, 48))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(154, 154, 154))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bestCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAlla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fardigstallBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bestCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bestCmbActionPerformed
        // TODO add your handling code here:
        fillBesTable();
    }//GEN-LAST:event_bestCmbActionPerformed

    private void uppdateraBes() {

        String anvID = Inloggningssida.getAnvandarID();

        bestID = String.valueOf(bestCmb.getSelectedItem());

        HashMap<Integer, String> valueLista = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            Object obj = besTable.getValueAt(NORMAL, i);
            String value = String.valueOf(obj);
            valueLista.put(i, value);

        }
        int index = 0;
        for (String value : valueLista.values()) {

            switch (index) {
                case 0:
                    eNamn = value;
                case 1:
                    fNamn = value;
                case 2:
                    adress = value;
                case 3:
                    antalHattar = value;
                case 4:
                    pris = value;
                case 5:
                    vikt = value;
                    break;

            }
            index++;
        }
        String updateQuery = "UPDATE bestallning SET Status = 'Stängd', vikt = '" + vikt + "', AnvandareID = '" + anvID + "' WHERE bestID = '" + bestID + "'";

        SqlFragor.uppdatera(updateQuery);
    }

    public static String getSprak() {
        return sp;
    }

    private void fardigstallBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fardigstallBtnActionPerformed
        // TODO add your handling code here:
        uppdateraBes();
        Fraktsedel2 fraktsedel = new Fraktsedel2();
        fraktsedel.nyFraktsedel(bestID, fNamn, eNamn, adress, vikt, moms, tull);
        fraktsedel.visaFraktsedel();


    }//GEN-LAST:event_fardigstallBtnActionPerformed

    private void cbAllaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAllaActionPerformed
        // TODO add your handling code here:
        String ItemName = (String) cbAlla.getSelectedItem();

        sp = (String.valueOf(map.get(ItemName)));
    }//GEN-LAST:event_cbAllaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Startsida().setVisible(true);
        dispose();    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable besTable;
    private javax.swing.JComboBox<String> bestCmb;
    private javax.swing.JComboBox<String> cbAlla;
    private javax.swing.JButton fardigstallBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
