/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tall.inc;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author nsags
 */
public class SattPrisSpecial extends javax.swing.JFrame {

    public SattPrisSpecial() {
        initComponents();
        fyllHattLista();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPris = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtHattLista = new javax.swing.JTextArea();
        btnTillbaka = new javax.swing.JButton();
        btnAndra = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("�ndra Pris ");

        txtPris.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrisKeyPressed(evt);
            }
        });

        txtHattLista.setEditable(false);
        txtHattLista.setColumns(20);
        txtHattLista.setRows(5);
        jScrollPane1.setViewportView(txtHattLista);

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        btnAndra.setText("�ndra");
        btnAndra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraActionPerformed(evt);
            }
        });

        jLabel2.setText("Pris");

        jLabel3.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTillbaka, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(118, 118, 118)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPris, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAndra, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTillbaka))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAndra)
                    .addComponent(txtPris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAndraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraActionPerformed
        AndraPris();
    }//GEN-LAST:event_btnAndraActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        new Startsida().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void txtPrisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrisKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAndra.doClick();
        }
    }//GEN-LAST:event_txtPrisKeyPressed

    private void fyllHattLista() {

        ArrayList<HashMap<String, String>> allInfo;
        String fraga = "SELECT HattID, f.Namn, t.Namn, Status, pris, KundID,AnvandarID FROM specialhatt\n"
                + "JOIN farg f on specialhatt.FargID = f.FargID\n"
                + "JOIN tyg t on t.TygID = specialhatt.TygID\n"
                + "WHERE Status = '�ppen' OR Status = 'P�g�ende';";
        allInfo = SqlFragor.getFleraRader(fraga);

        String rubrik = " Hatt ID:"
                + "\t" + "F�rg:"
                + "\t" + "Tyg:"
                + "\t" + "Status:"
                + "\t" + "Pris:"
                + "\t" + "Kund ID:"
                + "\t" + "Anv�ndare:" + "\n";

        txtHattLista.append(rubrik);

        for (HashMap<String, String> info : allInfo) {
            txtHattLista.append(info.get("HattID")
                    + "\t" + info.get("Namn")
                    + "\t" + info.get("Namn")
                    + "\t" + info.get("Status")
                    + "\t" + info.get("pris")
                    + "\t" + info.get("KundID")
                    + "\t" + info.get("AnvandarID") + "\n");
        }
    }

    public void AndraPris() {
        if (okUppgifter()) {
            SqlFragor.uppdatera("UPDATE specialhatt\n"
                    + "SET pris = " + txtPris.getText() + "\n"
                    + "WHERE HattID = " + txtID.getText() + " ;");

            txtHattLista.setText("");
            fyllHattLista();
        }
    }

    public boolean okUppgifter() {
        boolean ok = true;

        ArrayList<String> aktuellaID = SqlFragor.getEnKolumn("SELECT HattID FROM specialhatt\n"
                + "JOIN farg f on specialhatt.FargID = f.FargID\n"
                + "JOIN tyg t on t.TygID = specialhatt.TygID\n"
                + "WHERE Status = '�ppen' OR Status = 'P�g�ende';");

        boolean finnsID = aktuellaID.contains(txtID.getText());

        if (!ValideringsKlass.taltest(txtID)) {
            ok = false;
            JOptionPane.showMessageDialog(null, "Ange ID");
            txtID.requestFocus();
        } else if (!ValideringsKlass.taltest(txtPris)) {
            ok = false;
            JOptionPane.showMessageDialog(null, "Ange Pris");
            txtPris.requestFocus();
        } else if (!finnsID) {
            ok = false;
            JOptionPane.showMessageDialog(null, "ID existerar inte");
            txtID.requestFocus();
        }
        return ok;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAndra;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtHattLista;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPris;
    // End of variables declaration//GEN-END:variables
}
