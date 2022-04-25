/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tall.inc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 *
 * @author nsags
 */
public class FardigStallBeställning extends javax.swing.JFrame {

    private static String bestNummer;
    String fNamn;
    String eNamn;
    String adress;
    double moms;
    String tull;
    String vikt;
    
       private static String sp = "sv";
   
   static Map<String, String> map = new HashMap<String, String>();
    
    /**
     * Creates new form FardigStallBeställning
     */
    public FardigStallBeställning() {
        initComponents();
        fyllBestallning();
    }

    private void fyllBestallning() {

        ArrayList<HashMap<String, String>> allInfo;
        String fraga = "SELECT o.BestID , k.KundID, k.ForNamn, Efternamn, Adress,  vikt, sum(Pris)*1.2 AS pris, Prio\n"
                + "FROM bestallning\n"
                + "JOIN orderrad o on bestallning.BestID = o.BestID\n"
                + "JOIN hatt h on o.HattID = h.HattID\n"
                + "JOIN anvandare a on a.AnvandarID = bestallning.AnvandareID\n"
                + "JOIN kund k on k.KundID = bestallning.KundID\n"
                + "WHERE Status = '?ppen' OR Status = 'P?g?ende' AND prio = 1\n"
                + "GROUP BY o.BestID\n"
                + "UNION\n"
                + "SELECT  o.BestID , k.KundID, k.ForNamn, Efternamn, Adress,  vikt, sum(Pris) AS pris, Prio\n"
                + "FROM bestallning\n"
                + "JOIN orderrad o on bestallning.BestID = o.BestID\n"
                + "JOIN hatt h on o.HattID = h.HattID\n"
                + "JOIN anvandare a on a.AnvandarID = bestallning.AnvandareID\n"
                + "JOIN kund k on k.KundID = bestallning.KundID\n"
                + "JOIN (\n"
                + "    SELECT o.BestID FROM bestallning\n"
                + "    JOIN orderrad o on bestallning.BestID = o.BestID\n"
                + "    WHERE Status = '?ppen' OR Status = 'P?g?ende' AND prio = 1\n"
                + "    GROUP BY o.BestID) t2\n"
                + "    on o.BestID != t2.BestID\n"
                + "WHERE Status = '?ppen' OR Status = 'P?g?ende' AND prio = 0\n"
                + "GROUP BY o.BestID;";

        allInfo = SqlFragor.getFleraRader(fraga);

        String rubrik = "Order ID:"
                + "\t" + "Kund ID:"
                + "\t" + "F?rnamn:"
                + "\t" + "Efternamn:"
                + "\t" + "Adress:"
                + "\t" + "Vikt:"
                + "\t" + "Pris:"
                + "\t" + "Express:" + "\n";

        txtBestLista.append(rubrik);

        for (HashMap<String, String> info : allInfo) {
            txtBestLista.append(info.get("BestID")
                    + "\t" + info.get("KundID")
                    + "\t" + info.get("ForNamn")
                    + "\t" + info.get("Efternamn")
                    + "\t" + info.get("Adress")
                    + "\t" + info.get("vikt")
                    + "\t" + info.get("pris")
                    + "\t" + info.get("Prio") + "\n");
        }
    }

    private void infoBest() {
        bestNummer = txtBestNummer.getText();

        String fraga2 = "SELECT * FROM (\n"
                + "    SELECT o.BestID , k.KundID, k.ForNamn, Efternamn, Adress,  vikt, sum(Pris)*1.2 AS pris, Prio,TullID\n"
                + "    FROM bestallning\n"
                + "    JOIN orderrad o on bestallning.BestID = o.BestID\n"
                + "    JOIN hatt h on o.HattID = h.HattID\n"
                + "    JOIN anvandare a on a.AnvandarID = bestallning.AnvandareID\n"
                + "    JOIN kund k on k.KundID = bestallning.KundID\n"
                + "    WHERE Status = '?ppen' OR Status = 'P?g?ende' AND prio = 1\n"
                + "    GROUP BY o.BestID\n"
                + "    UNION\n"
                + "    SELECT  o.BestID , k.KundID, k.ForNamn, Efternamn, Adress,  vikt, sum(Pris) AS pris, Prio, TullID\n"
                + "    FROM bestallning\n"
                + "    JOIN orderrad o on bestallning.BestID = o.BestID\n"
                + "    JOIN hatt h on o.HattID = h.HattID\n"
                + "    JOIN anvandare a on a.AnvandarID = bestallning.AnvandareID\n"
                + "    JOIN kund k on k.KundID = bestallning.KundID\n"
                + "    JOIN (\n"
                + "        SELECT o.BestID FROM bestallning\n"
                + "        JOIN orderrad o on bestallning.BestID = o.BestID\n"
                + "        WHERE Status = '?ppen' OR Status = 'P?g?ende' AND prio = 1\n"
                + "        GROUP BY o.BestID) t2\n"
                + "        on o.BestID != t2.BestID\n"
                + "    WHERE Status = '?ppen' OR Status = 'P?g?ende' AND prio = 0\n"
                + "    GROUP BY o.BestID) t3\n"
                + "WHERE BestID =" +  bestNummer +  ";";

        System.out.println(fraga2);

        HashMap<String, String> allInfoEnBest;
        allInfoEnBest = SqlFragor.getEnRad(fraga2);

        fNamn = allInfoEnBest.get("ForNamn");
        eNamn = allInfoEnBest.get("Efternamn");
        adress = allInfoEnBest.get("Adress");
        vikt = allInfoEnBest.get("vikt");
        tull = allInfoEnBest.get("TullID");
        
        String moms1 = allInfoEnBest.get("pris");
        
        double pris = Double.parseDouble(moms1);
        double moms2 = (pris*0.25);
        double moms3 = Math.floor(moms2);
        
        moms = moms3; 
    }
    
    public static String getBestID(){
        return bestNummer;
    }
    
        
    private void sprak(){
        switch (cbSprak.getSelectedIndex()) {
            case 0 -> sp = "sv";
            case 1 -> sp = "en";
            case 2 -> sp = "et";
            default -> {
            }
        }
        
        
    }
    
        public static void ddd() {

        String[] languages = Locale.getISOLanguages();

        for (int i = 0; i < languages.length; i++) {

            Locale loc = new Locale(languages[i]);

            map.put(loc.getLanguage().toUpperCase(), loc.getDisplayLanguage());

        }

        System.out.println("print language codes and names:");

        System.out.println();
        


        
        
//
//        System.out.println("print only language codes:");
//
//        map.keySet().forEach(langCode -> {
//
//            System.out.println(langCode);
//           
//
//        });

    }
    
    
    public static String getSprak(){
        return sp;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBestLista = new javax.swing.JTextArea();
        btnTillbaka = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBestNummer = new javax.swing.JTextField();
        txtVikt = new javax.swing.JTextField();
        btnValjBest = new javax.swing.JButton();
        btnAndraVikt = new javax.swing.JButton();
        btnKlar = new javax.swing.JButton();
        cbSprak = new javax.swing.JComboBox<>();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtBestLista.setColumns(20);
        txtBestLista.setRows(5);
        jScrollPane1.setViewportView(txtBestLista);

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        jLabel1.setText("Färdigställ order");

        txtVikt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtViktActionPerformed(evt);
            }
        });

        btnValjBest.setText("Väl order");
        btnValjBest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValjBestActionPerformed(evt);
            }
        });

        btnAndraVikt.setText("Lägg till Vikt ");
        btnAndraVikt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraViktActionPerformed(evt);
            }
        });

        btnKlar.setText("Klar");
        btnKlar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKlarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBestNummer, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtVikt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAndraVikt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnValjBest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKlar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTillbaka, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(31, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbSprak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnTillbaka))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBestNummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnValjBest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(cbSprak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVikt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAndraVikt)
                    .addComponent(btnKlar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnValjBestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValjBestActionPerformed
       infoBest();
    }//GEN-LAST:event_btnValjBestActionPerformed

    private void btnAndraViktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraViktActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAndraViktActionPerformed

    private void btnKlarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKlarActionPerformed
        // TODO add your handling code here:
        
        Fraktsedel fraktsedel = new Fraktsedel();
        fraktsedel.nyFraktsedel(bestNummer, fNamn, eNamn, adress, vikt, moms, tull);
        fraktsedel.visaFraktsedel();
    }//GEN-LAST:event_btnKlarActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        new Startsida().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void txtViktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtViktActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtViktActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAndraVikt;
    private javax.swing.JButton btnKlar;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JButton btnValjBest;
    private javax.swing.JComboBox<String> cbSprak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea txtBestLista;
    private javax.swing.JTextField txtBestNummer;
    private javax.swing.JTextField txtVikt;
    // End of variables declaration//GEN-END:variables
}
