/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tall.inc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author nikla
 */
public class AndraUppgifterKund extends javax.swing.JFrame {

    private Object model;

    /**
     * Creates new form AndraUppgifterKund
     */
    public AndraUppgifterKund() {
        initComponents();
        fillNamn();
        DefaultTableModel model = (DefaultTableModel) kundTbl.getModel();
        for (int i = kundTbl.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    public void fillNamn() {
        String query = "SELECT distinct fornamn FROM kund";
        ArrayList<String> namn = SqlFragor.getEnKolumn(query);
        for (String namnen : namn) {
            namnCmb.addItem(namnen);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jButton2 = new javax.swing.JButton();
        namnCmb = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        kundTbl = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        TxtForNamn = new javax.swing.JTextField();
        TxtEfterNamn = new javax.swing.JTextField();
        TxtAdress = new javax.swing.JTextField();
        TxtTele = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnNamn = new javax.swing.JButton();

        jButton2.setText("Bekr�fta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        namnCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namnCmbActionPerformed(evt);
            }
        });

        jLabel1.setText("V�lj namn");

        kundTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "F�rnamn", "Efternamn", "Adress", "Tele"
            }
        ));
        jScrollPane2.setViewportView(kundTbl);

        jButton1.setText("�ndra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("F�rnamn");

        jLabel3.setText("Efternamn");

        jLabel4.setText("Adress");

        jLabel5.setText("Tel");

        btnNamn.setText("Ok");
        btnNamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNamnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(135, 135, 135))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(namnCmb, 0, 99, Short.MAX_VALUE))
                        .addGap(142, 142, 142)
                        .addComponent(btnNamn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtForNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtEfterNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtTele, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namnCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNamn))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtForNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtEfterNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtTele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jButton1)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        andraKund();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    private void andraKund() {
        int talet = kundTbl.getSelectedRow();

        TableModel model = kundTbl.getModel();
        String fornamn = (model.getValueAt(talet, 0).toString());
        String efternamn = (model.getValueAt(talet, 1).toString());
        String adress = (model.getValueAt(talet, 2).toString());
        String tel = (model.getValueAt(talet, 3).toString());

        String queryID = "select kundID from kund where fornamn = '" + fornamn + "' and efternamn = '" + efternamn + "' and adress = '" + adress + "' and tel ='" + tel + "'";
        String ID = SqlFragor.getEttVarde(queryID);

        System.out.println(ID);

        String valtNamn = TxtForNamn.getText();
        String valtEfterNamn = TxtEfterNamn.getText();
        String valdAdress = TxtAdress.getText();
        String valtTele = TxtTele.getText().toString();

        if (TxtForNamn.getText().isEmpty()==false) {
            String queryFornamn = "update kund set fornamn = '" + valtNamn + "' where kundId = '" + ID + "'";
            SqlFragor.uppdatera(queryFornamn);}
            
        if (TxtEfterNamn.getText().isEmpty()==false) {
            String queryEfternamn = "update kund set efternamn = '" + valtEfterNamn + "' where kundId = '" + ID + "'";
            SqlFragor.uppdatera(queryEfternamn);}
            
            if (TxtAdress.getText().isEmpty()==false) {
               
            String queryAdress = "update kund set adress = '" + valdAdress + "' where kundId = '" + ID + "'";
            SqlFragor.uppdatera(queryAdress);}
            
            if (TxtTele.getText().isEmpty()==false) {
            String queryTele = "update kund set tel = '" + valtTele + "' where kundId = '" + ID + "'";
            SqlFragor.uppdatera(queryTele);
        
            }
    }
    private void btnNamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNamnActionPerformed
        visaKunder();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnNamnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void namnCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namnCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namnCmbActionPerformed
    private void visaKunder() {
        String namnet = namnCmb.getSelectedItem().toString();

        String testLista = "select kundid from kund where fornamn = '" + namnet + "'";
        ArrayList<String> lista = SqlFragor.getEnKolumn(testLista);
        System.out.println(lista);
        for (String listan : lista) {
            String queryForNamn = "select fornamn from kund where kundid = '" + listan + "'";
            String forNamn = SqlFragor.getEttVarde(queryForNamn);

            String queryEfterNamn = "select efternamn from kund where kundid = '" + listan + "'";
            String efterNamn = SqlFragor.getEttVarde(queryEfterNamn);

            String queryAdress = "select adress from kund where kundid = '" + listan + "'";
            String adress = SqlFragor.getEttVarde(queryAdress);

            String queryTele = "select tel from kund where kundid = '" + listan + "'";
            String tele = SqlFragor.getEttVarde(queryTele);

            String data[] = {forNamn, efterNamn, adress, tele};
            DefaultTableModel tblModel = (DefaultTableModel) kundTbl.getModel();
            tblModel.addRow(data);
        }

    }

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
            java.util.logging.Logger.getLogger(AndraUppgifterKund.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AndraUppgifterKund.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AndraUppgifterKund.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AndraUppgifterKund.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AndraUppgifterKund().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtAdress;
    private javax.swing.JTextField TxtEfterNamn;
    private javax.swing.JTextField TxtForNamn;
    private javax.swing.JTextField TxtTele;
    private javax.swing.JButton btnNamn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable kundTbl;
    private javax.swing.JComboBox<String> namnCmb;
    // End of variables declaration//GEN-END:variables
}
