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
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnLoggaUt))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSeOrderStatus)
                                .addGap(100, 100, 100)
                                .addComponent(btnSokArtikel)
                                .addGap(0, 67, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSkapaNyOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSkapaNyArtikel)
                        .addGap(51, 51, 51))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAndraPris)
                        .addGap(89, 220, Short.MAX_VALUE))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(btnLoggaUt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSeOrderStatus)
                            .addComponent(btnSokArtikel))
                        .addGap(29, 29, 29)
                        .addComponent(btnAndraPris)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoggaUtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaUtActionPerformed
        // TODO add your handling code here:
        new Inloggningssida().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLoggaUtActionPerformed

    private void btnSkapaNyArtikelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaNyArtikelActionPerformed
        try {
            // TODO add your handling code here:
            new LaggTillHatt().setVisible(true);
        } catch (InfException ex) {
            Logger.getLogger(Startsida.class.getName()).log(Level.SEVERE, null, ex);
        }
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


    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAndraPris;
    private javax.swing.JButton btnLoggaUt;
    private javax.swing.JButton btnSeOrderStatus;
    private javax.swing.JButton btnSkapaNyArtikel;
    private javax.swing.JButton btnSkapaNyOrder;
    private javax.swing.JButton btnSokArtikel;
    private javax.swing.JLabel lblValkommen;
    // End of variables declaration//GEN-END:variables
}
