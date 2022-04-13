/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tall.inc;

import java.util.logging.Level;
import java.util.logging.Logger;
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
    }
    
    public static String getAnvandare()
    {
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(lblValkommen)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLoggaUt))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSeOrderStatus)
                                    .addComponent(btnAndraPris))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnKundUppgift)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSokArtikel)
                                        .addGap(0, 70, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSkapaNyOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSkapaNyArtikel)
                        .addGap(51, 51, 51))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblValkommen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSkapaNyOrder)
                    .addComponent(btnSkapaNyArtikel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(btnLoggaUt)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSeOrderStatus)
                            .addComponent(btnSokArtikel))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAndraPris)
                            .addComponent(btnKundUppgift))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(15, 15, 15))))
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
    private javax.swing.JLabel lblValkommen;
    // End of variables declaration//GEN-END:variables
}
