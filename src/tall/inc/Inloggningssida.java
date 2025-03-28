package tall.inc;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author patrickkreek
 */
public class Inloggningssida extends javax.swing.JFrame {

private static String hamtaUser;

    /**
     * Creates new form Inloggningssida
     */
    public Inloggningssida() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
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
        lblFel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

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
        lblAnvandarnamn.setText("Användarnamn:");

        lblLosenord.setBackground(new java.awt.Color(153, 153, 153));
        lblLosenord.setForeground(new java.awt.Color(153, 153, 153));
        lblLosenord.setText("Lösenord:");

        lblFel.setForeground(new java.awt.Color(204, 204, 204));
        lblFel.setToolTipText("");
        lblFel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblRubrik)
                    .addComponent(lblLosenord)
                    .addComponent(lblAnvandarnamn)
                    .addComponent(txtInloggAnvandare)
                    .addComponent(pswInloggLosen)
                    .addComponent(lblFel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLoggaIn, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblRubrik)
                .addGap(52, 52, 52)
                .addComponent(lblAnvandarnamn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInloggAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLosenord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pswInloggLosen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblFel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnLoggaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void loggaIn() {
        if(okUppgifter() == true){
            
        String anvandarNamn = txtInloggAnvandare.getText();
        String losenordet = new String(pswInloggLosen.getPassword());
        String query = "SELECT AnvandarID FROM anvandare where Losenord = '" + losenordet + "'" + " and ForNamn = '" + anvandarNamn + "'";
        hamtaUser = SqlFragor.getEttVarde(query);
        if (hamtaUser != null) {
            new Startsida().setVisible(true);
            dispose();
        } else {
            lblFel.setText("Fel användarnamn eller lösenord");
        }
        }
    }
    
        public static String getAnvandarID() {
        return hamtaUser;
    }
    
    private void btnLoggaInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaInActionPerformed
        loggaIn();
    }//GEN-LAST:event_btnLoggaInActionPerformed

    private void pswInloggLosenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswInloggLosenKeyPressed
        //Gör att man kan klicka på enter för att logga in
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

    private boolean okUppgifter() {
        boolean ok = true;
        if (!ValideringsKlass.txtFaltHarVarde(txtInloggAnvandare)) {
            ok = false;
            lblFel.setText("Ange användarnamn");
            txtInloggAnvandare.requestFocus();
        } else if (!ValideringsKlass.txtFaltHarVarde(pswInloggLosen)) {
            ok = false;
            lblFel.setText("Ange lösenord");
            pswInloggLosen.requestFocus();
        }

        return ok;
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoggaIn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAnvandarnamn;
    private javax.swing.JLabel lblFel;
    private javax.swing.JLabel lblLosenord;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JPasswordField pswInloggLosen;
    private javax.swing.JTextField txtInloggAnvandare;
    // End of variables declaration//GEN-END:variables
}
