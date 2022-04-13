/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tall.inc;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.table.DefaultTableModel;
import oru.inf.InfException;

/**
 *
 * @author gewe_
 */
public class Startsida extends javax.swing.JFrame {

    private static String anvandarnamn;
    private static String losenord;

    String anvandarID;

    public Startsida() {
        initComponents();
        this.anvandarnamn = anvandarnamn;
        this.losenord = losenord;
        anvandarID = Inloggningssida.getAnvandarID();
        fillOppenHattTbl();
        fillEgnaHattarList();
    }

    public void fillEgnaHattarList() {
        String query = "SELECT Beskrivning FROM Hatt WHERE anvandarID = '"+anvandarID+"'";
        ArrayList<String> hattLista = SqlFragor.getEnKolumn(query);
        DefaultListModel model = new DefaultListModel();
        for (String hatt : hattLista) {
            model.addElement(hatt);

            listValdaHattar.setModel(model);
        }

    }

    public void fillOppenHattTbl() {
        listAllaHattar.setSelectionModel(new DefaultListSelectionModel() {
            public void setSelectionInterval(int index0, int index1) {
                if (isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);
                } else {
                    super.addSelectionInterval(index0, index1);
                }
            }
        });
        String query = "SELECT Beskrivning FROM Hatt WHERE anvandarID != '"+anvandarID+"'";
        ArrayList<String> hattLista = SqlFragor.getEnKolumn(query);
        DefaultListModel model = new DefaultListModel();
        for (String hatt : hattLista) {
            model.addElement(hatt);

            listAllaHattar.setModel(model);
        }

    }

    public static String getAnvandare() {
        String anvandare = anvandarnamn;
        return anvandare;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblValkommen = new javax.swing.JLabel();
        btnSkapaNyOrder = new javax.swing.JButton();
        btnLoggaUt = new javax.swing.JButton();
        btnSeOrderStatus = new javax.swing.JButton();
        btnSokArtikel = new javax.swing.JButton();
        btnSkapaNyArtikel = new javax.swing.JButton();
        btnAndraPris = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnKundUppgift = new javax.swing.JButton();
        startHattBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listAllaHattar = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listValdaHattar = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblValkommen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblValkommen.setText("V�lkommen!");

        btnSkapaNyOrder.setText("Skapa ny order");
        btnSkapaNyOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaNyOrderActionPerformed(evt);
            }
        });

        btnLoggaUt.setText("Logga ut");
        btnLoggaUt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggaUtActionPerformed(evt);
            }
        });

        btnSeOrderStatus.setText("Se orderstatus");
        btnSeOrderStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeOrderStatusActionPerformed(evt);
            }
        });

        btnSokArtikel.setText("S�k artikel");
        btnSokArtikel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokArtikelActionPerformed(evt);
            }
        });

        btnSkapaNyArtikel.setText("Skapa ny artikel");
        btnSkapaNyArtikel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaNyArtikelActionPerformed(evt);
            }
        });

        btnAndraPris.setText("�ndra Pris Specialhatt");
        btnAndraPris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraPrisActionPerformed(evt);
            }
        });

        jButton1.setText("F�rdigst�ll order");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnKundUppgift.setText("�ndra kunduppgifter");
        btnKundUppgift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKundUppgiftActionPerformed(evt);
            }
        });

        startHattBtn.setText("P�b�rja hatt tillverkning");
        startHattBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startHattBtnActionPerformed(evt);
            }
        });

        listAllaHattar.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listAllaHattar);

        listValdaHattar.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listValdaHattar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAndraPris)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSeOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSkapaNyOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(4, 4, 4)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(btnSkapaNyArtikel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btnKundUppgift, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(btnSokArtikel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(42, 42, 42)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblValkommen)
                        .addGap(176, 176, 176)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLoggaUt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startHattBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblValkommen)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnSkapaNyArtikel)
                                .addGap(18, 18, 18)
                                .addComponent(btnKundUppgift)
                                .addGap(18, 18, 18)
                                .addComponent(btnSokArtikel)
                                .addGap(18, 18, 18)
                                .addComponent(btnSkapaNyOrder)
                                .addGap(18, 18, 18)
                                .addComponent(btnSeOrderStatus)
                                .addGap(18, 18, 18)
                                .addComponent(btnAndraPris))
                            .addComponent(startHattBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(btnLoggaUt)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(15, 15, 15))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 74, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoggaUtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaUtActionPerformed
        // TODO add your handling code here:
        new Inloggningssida().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLoggaUtActionPerformed

    private void btnSkapaNyArtikelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaNyArtikelActionPerformed
        new LaggTillHatt().setVisible(true);
    }//GEN-LAST:event_btnSkapaNyArtikelActionPerformed


    private void btnSkapaNyOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaNyOrderActionPerformed
        // TODO add your handling code here:
        new SkapaNyOrder().setVisible(true);
    }//GEN-LAST:event_btnSkapaNyOrderActionPerformed

    private void btnAndraPrisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraPrisActionPerformed
        new SattPrisSpecial().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAndraPrisActionPerformed

    private void btnSeOrderStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeOrderStatusActionPerformed
        new SeOrderStatus().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSeOrderStatusActionPerformed

    private void btnSokArtikelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokArtikelActionPerformed
        // TODO add your handling code here:
        new SokHatt().setVisible(true);
    }//GEN-LAST:event_btnSokArtikelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new FardigStallBest�llning().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnKundUppgiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKundUppgiftActionPerformed
        new AndraUppgifterKund().setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKundUppgiftActionPerformed

    private void startHattBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startHattBtnActionPerformed
        // TODO add your handling code here:
        
        List<String> hattar = listAllaHattar.getSelectedValuesList();
        for(String hatt: hattar)        {
            String hattIdQuery = "SELECT hattID FROM hatt WHERE beskrivning = '"+hatt+"'";
            String hattID = SqlFragor.getEttVarde(hattIdQuery);
            String updateQuery = "UPDATE hatt SET anvandarID = '"+anvandarID+"' where hattID = '"+hattID+"'";
            SqlFragor.uppdatera(updateQuery);
            fillOppenHattTbl();
        }
        fillEgnaHattarList();
        
        


    }//GEN-LAST:event_startHattBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAndraPris;
    private javax.swing.JButton btnKundUppgift;
    private javax.swing.JButton btnLoggaUt;
    private javax.swing.JButton btnSeOrderStatus;
    private javax.swing.JButton btnSkapaNyArtikel;
    private javax.swing.JButton btnSkapaNyOrder;
    private javax.swing.JButton btnSokArtikel;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblValkommen;
    private javax.swing.JList<String> listAllaHattar;
    private javax.swing.JList<String> listValdaHattar;
    private javax.swing.JButton startHattBtn;
    // End of variables declaration//GEN-END:variables
}
