/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tall.inc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author isakw
 */
public class BestallStatistik extends javax.swing.JFrame {

    int momspforsalj;
    int export;
    int utgaendeMoms;
    int attbetala;
    int inMoms;
    String perioden;

    String totForsalj;
    String momsforsaljforsalj;
    String exportexport;
    String ututgaende;
    String attattbetala;

    int inhemskPagande;
    int exportPagaende;
    int totPagande;

    String stardate = "";
    String slutdate = "";

    /**
     * Creates new form BestallStatistik
     */
    public BestallStatistik() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTillbaka = new javax.swing.JButton();
        dateStart = new com.toedter.calendar.JDateChooser();
        dateEnd = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtStat = new javax.swing.JTextArea();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        txtStat.setColumns(20);
        txtStat.setRows(5);
        jScrollPane1.setViewportView(txtStat);

        btnOk.setText("Test");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(btnOk)
                .addGap(83, 83, 83))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnTillbaka)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTillbaka)
                        .addGap(59, 59, 59)
                        .addComponent(dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnOk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        new Startsida().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        datum();
        forsalj();
        pagandeForsalj();
        sattVarden();
    }//GEN-LAST:event_btnOkActionPerformed

    private void sattVarden() {
        txtStat.setText("F�rs�ljning"
                + "\t" + totForsalj + "\n"
                + "Varav export" + "\t" + exportexport + "\n"
                + "P�g�ende" + "\t" + totPagande+"\n"
                + "Inhemsk" + "\t" + inhemskPagande +"\n"
                + "Export" + "\t"+ exportPagaende);
    }

    private void datum() {
        stardate = "";
        slutdate = "";

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start = dateStart.getDate();

        Date slut = dateEnd.getDate();

        stardate = dateFormat.format(start);
        slutdate = dateFormat.format(slut);
    }

    private void pagandeForsalj() {

        String fraga = "SELECT Pris FROM (\n"
                + "    SELECT * FROM (\n"
                + "        SELECT * FROM (\n"
                + "            SELECT FLOOR(SUM(pris)*1.2) AS Pris , LevDatum, TullID, Prio, BestDatum, Status\n"
                + "            FROM bestallning\n"
                + "            JOIN orderrad o on bestallning.BestID = o.BestID\n"
                + "            JOIN hatt h on o.HattID = h.HattID\n"
                + "            WHERE LevDatum IS NULL AND Status = 'P�g�ende' OR Status = '�ppen') t2\n"
                + "        WHERE BestDatum BETWEEN '" + stardate + "' AND '" + slutdate + "') t3\n"
                + "    WHERE TullID = 'Saknas' OR TullID = '') t4\n"
                + "WHERE Prio = 1;";

        String fragaPagandePrio = SqlFragor.getEttVarde(fraga);

        fraga = "SELECT SUM(Pris) FROM (\n"
                + "    SELECT * FROM (\n"
                + "        SELECT * FROM (\n"
                + "            SELECT Pris , LevDatum, TullID, Prio, BestDatum, Status\n"
                + "            FROM bestallning\n"
                + "            JOIN orderrad o on bestallning.BestID = o.BestID\n"
                + "            JOIN hatt h on o.HattID = h.HattID\n"
                + "            WHERE LevDatum IS NULL AND Status = 'P�g�ende' OR Status = '�ppen') t2\n"
                + "        WHERE BestDatum BETWEEN '" + stardate + "' AND '" + slutdate + "') t3\n"
                + "    WHERE TullID = 'Saknas' OR TullID = '') t4\n"
                + "WHERE Prio = 0;";

        String fragaPagande = SqlFragor.getEttVarde(fraga);

        fraga = "SELECT SUM(Pris) FROM (\n"
                + "    SELECT * FROM (\n"
                + "        SELECT * FROM (\n"
                + "            SELECT Pris , LevDatum, TullID, Prio, BestDatum, Status\n"
                + "            FROM bestallning\n"
                + "            JOIN orderrad o on bestallning.BestID = o.BestID\n"
                + "            JOIN hatt h on o.HattID = h.HattID\n"
                + "            WHERE LevDatum IS NULL AND Status = 'P�g�ende' OR Status = '�ppen') t2\n"
                + "        WHERE BestDatum BETWEEN '" + stardate + "' AND '" + slutdate + "') t3\n"
                + "    WHERE TullID != 'Saknas' AND TullID != '') t4\n"
                + "WHERE Prio = 0;";

        String fragaInt = SqlFragor.getEttVarde(fraga);

        fraga = "SELECT FLOOR(SUM(Pris)*1.2) FROM (\n"
                + "    SELECT * FROM (\n"
                + "        SELECT * FROM (\n"
                + "            SELECT Pris , LevDatum, TullID, Prio, BestDatum, Status\n"
                + "            FROM bestallning\n"
                + "            JOIN orderrad o on bestallning.BestID = o.BestID\n"
                + "            JOIN hatt h on o.HattID = h.HattID\n"
                + "            WHERE LevDatum IS NULL AND Status = 'P�g�ende' OR Status = '�ppen') t2\n"
                + "        WHERE BestDatum BETWEEN '" + stardate + "' AND '" + slutdate + "') t3\n"
                + "    WHERE TullID != 'Saknas' AND TullID != '') t4\n"
                + "WHERE Prio = 1;";

        String fragaIntPrio = SqlFragor.getEttVarde(fraga);

        int forsalj = 0;
        int forsaljPrio = 0;
        int export = 0;
        int exportPrio = 0;

        if (fragaPagande != null) {
            forsalj = Integer.parseInt(fragaPagande);
        }

        if (fragaPagandePrio != null) {
            forsaljPrio = Integer.parseInt(fragaPagandePrio);
        }

        if (fragaInt != null) {
            export = Integer.parseInt(fragaInt);

        }
        if (fragaIntPrio != null) {
            exportPrio = Integer.parseInt(fragaIntPrio);
        }

        inhemskPagande = forsalj + forsaljPrio;
        exportPagaende = export + exportPrio;
        totPagande = 0;
        totPagande = inhemskPagande + exportPagaende;

    }

    private void forsalj() {

        // momspliktig f�rs�ljning 
        String fragaForsaljMoms = """
                                  SELECT SUM(pris) FROM (
                                  SELECT pris , LevDatum
                                  FROM bestallning
                                  JOIN kund k on k.KundID = bestallning.KundID
                                  JOIN orderrad o on bestallning.BestID = o.BestID
                                  JOIN hatt h on o.HattID = h.HattID
                                  JOIN anvandare a on a.AnvandarID = bestallning.AnvandareID
                                  WHERE Status = 'St\u00e4ngd' AND Prio = 0 AND TullID= 'Saknas') t2
                                  WHERE LevDatum BETWEEN '""" + stardate + "' AND '" + slutdate + "';";

        String forsaljMoms = SqlFragor.getEttVarde(fragaForsaljMoms);

        // Momspliktig s�rs�ljning med ett 20% + F�r prio
        String fragaForsaljMomsPrio = """
                                      SELECT FLOOR(SUM(pris*1.2)) FROM (
                                      SELECT pris , LevDatum, TullID
                                      FROM bestallning
                                      JOIN kund k on k.KundID = bestallning.KundID
                                      JOIN orderrad o on bestallning.BestID = o.BestID
                                      JOIN hatt h on o.HattID = h.HattID
                                      JOIN anvandare a on a.AnvandarID = bestallning.AnvandareID
                                      WHERE Status = 'St\u00e4ngd' AND Prio = 1 AND TullID= 'Saknas') t2
                                      WHERE LevDatum BETWEEN '""" + stardate + "' AND '" + slutdate + "';";

        String forsaljMomsPrio = SqlFragor.getEttVarde(fragaForsaljMomsPrio);

        // f�rs�ljning p� export 
        String fragaForsaljExport = """
                                    SELECT SUM(pris) FROM (
                                    SELECT pris , LevDatum, TullID
                                    FROM bestallning
                                    JOIN kund k on k.KundID = bestallning.KundID
                                    JOIN orderrad o on bestallning.BestID = o.BestID
                                    JOIN hatt h on o.HattID = h.HattID
                                    JOIN anvandare a on a.AnvandarID = bestallning.AnvandareID
                                    WHERE Status = 'St\u00e4ngd' AND Prio = 0 AND TullID != 'Saknas') t2
                                    WHERE LevDatum BETWEEN '""" + stardate + "' AND '" + slutdate + "';";

        String forsaljMomsExport = SqlFragor.getEttVarde(fragaForsaljExport);

        // fors�ljning export prio
        String fragaForsaljExportPrio = """
                                        SELECT FLOOR(SUM(pris*1.2)) FROM (
                                        SELECT pris , LevDatum, TullID
                                        FROM bestallning
                                        JOIN kund k on k.KundID = bestallning.KundID
                                        JOIN orderrad o on bestallning.BestID = o.BestID
                                        JOIN hatt h on o.HattID = h.HattID
                                        JOIN anvandare a on a.AnvandarID = bestallning.AnvandareID
                                        WHERE Status = 'St\u00e4ngd' AND Prio = 1 AND TullID != 'Saknas') t2
                                        WHERE LevDatum BETWEEN '""" + stardate + "' AND '" + slutdate + "';";

        String forsaljExportPrio = SqlFragor.getEttVarde(fragaForsaljExportPrio);

        int momsForsalj = 0;
        int prioMomsForsalj = 0;
        int exportMomsForsalj = 0;
        int prioExportForsalj = 0;

        if (forsaljMoms != null) {
            momsForsalj = Integer.parseInt(forsaljMoms);
        }

        if (forsaljMomsPrio != null) {
            prioMomsForsalj = Integer.parseInt(forsaljMomsPrio);
        }

        if (forsaljMomsExport != null) {
            exportMomsForsalj = Integer.parseInt(forsaljMomsExport);

        }
        if (forsaljExportPrio != null) {
            prioExportForsalj = Integer.parseInt(forsaljExportPrio);
        }

//        inMoms = Integer.parseInt(txtInMoms.getText());
        momspforsalj = momsForsalj + prioMomsForsalj;
        export = exportMomsForsalj + prioExportForsalj;

        momsforsaljforsalj = String.valueOf(momspforsalj);
        exportexport = String.valueOf(export);
        ututgaende = String.valueOf(utgaendeMoms);
        attattbetala = String.valueOf(attbetala);

        int saljTot = momspforsalj + export;
        totForsalj = String.valueOf(saljTot);

    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnTillbaka;
    private com.toedter.calendar.JDateChooser dateEnd;
    private com.toedter.calendar.JDateChooser dateStart;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtStat;
    // End of variables declaration//GEN-END:variables
}
