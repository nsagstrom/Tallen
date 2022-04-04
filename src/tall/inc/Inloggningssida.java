package tall.inc;


import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author noahjarvback
 */
public class Inloggningssida extends javax.swing.JFrame {

    private static InfDB idb;
    
    /**
     * Creates new form Inloggningssida
     */
    public Inloggningssida(InfDB idb) {
        initComponents();
        this.idb = idb;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblRubrik = new javax.swing.JLabel();
        txtInloggAnvandare = new javax.swing.JTextField();
        pswInloggLosen = new javax.swing.JPasswordField();
        btnLoggaIn = new javax.swing.JButton();
        lblAnvandarnamn = new javax.swing.JLabel();
        lblLosenord = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(33, 31, 31));

        lblRubrik.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 24)); // NOI18N
        lblRubrik.setForeground(new java.awt.Color(255, 255, 255));
        lblRubrik.setText("Logga in");

        txtInloggAnvandare.setBackground(new java.awt.Color(255, 255, 255));
        txtInloggAnvandare.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        txtInloggAnvandare.setForeground(new java.awt.Color(0, 0, 0));
        txtInloggAnvandare.setToolTipText("");
        txtInloggAnvandare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInloggAnvandareActionPerformed(evt);
            }
        });

        pswInloggLosen.setBackground(new java.awt.Color(255, 255, 255));
        pswInloggLosen.setForeground(new java.awt.Color(0, 0, 0));
        pswInloggLosen.setToolTipText("");
        pswInloggLosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pswInloggLosenActionPerformed(evt);
            }
        });
        pswInloggLosen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pswInloggLosenKeyPressed(evt);
            }
        });

        btnLoggaIn.setBackground(new java.awt.Color(255, 255, 255));
        btnLoggaIn.setForeground(new java.awt.Color(0, 0, 0));
        btnLoggaIn.setText("Logga In");
        btnLoggaIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggaInActionPerformed(evt);
            }
        });

        lblAnvandarnamn.setBackground(new java.awt.Color(153, 153, 153));
        lblAnvandarnamn.setForeground(new java.awt.Color(153, 153, 153));
        lblAnvandarnamn.setText("Anv�ndarnamn:");

        lblLosenord.setBackground(new java.awt.Color(153, 153, 153));
        lblLosenord.setForeground(new java.awt.Color(153, 153, 153));
        lblLosenord.setText("L�senord:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLosenord)
                    .addComponent(lblAnvandarnamn)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnLoggaIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addComponent(pswInloggLosen)
                        .addComponent(txtInloggAnvandare, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(lblRubrik)
                .addContainerGap(163, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lblRubrik)
                .addGap(80, 80, 80)
                .addComponent(lblAnvandarnamn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInloggAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLosenord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pswInloggLosen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLoggaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoggaInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaInActionPerformed
        
    }//GEN-LAST:event_btnLoggaInActionPerformed

    private void pswInloggLosenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswInloggLosenKeyPressed
       //Gör att man kan klicka på enter för att logga in när man är i lösenordsfältet
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            btnLoggaIn.doClick();
        }
       
    }//GEN-LAST:event_pswInloggLosenKeyPressed

    private void txtInloggAnvandareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInloggAnvandareActionPerformed
        // Textruta för användare
    }//GEN-LAST:event_txtInloggAnvandareActionPerformed

    private void pswInloggLosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pswInloggLosenActionPerformed
        // Textruta för lösenord
    }//GEN-LAST:event_pswInloggLosenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inloggningssida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inloggningssida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inloggningssida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inloggningssida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inloggningssida(idb).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoggaIn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAnvandarnamn;
    private javax.swing.JLabel lblLosenord;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JPasswordField pswInloggLosen;
    private javax.swing.JTextField txtInloggAnvandare;
    // End of variables declaration//GEN-END:variables
}
