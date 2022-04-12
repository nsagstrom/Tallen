/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tall.inc;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author nsags
 */
public class SeOrderStatus extends javax.swing.JFrame {

    /**
     * Creates new form SeOrderStatus
     */
    public SeOrderStatus() {
        initComponents();
        fyllOrderLista();
        fyllCmbStatus();
        fyllCmbUser();
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
        txtOrderLista = new javax.swing.JTextArea();
        btnTillbaka = new javax.swing.JButton();
        cmbStatus = new javax.swing.JComboBox<>();
        lblStatus = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        cmbUser = new javax.swing.JComboBox<>();
        btnStatFilt = new javax.swing.JButton();
        btnUserFilt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtOrderLista.setColumns(20);
        txtOrderLista.setRows(5);
        jScrollPane1.setViewportView(txtOrderLista);

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alla" }));
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });

        lblStatus.setText("Status");

        lblUser.setText("Användare");

        cmbUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alla" }));
        cmbUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUserActionPerformed(evt);
            }
        });

        btnStatFilt.setText("Filtrera status");
        btnStatFilt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatFiltActionPerformed(evt);
            }
        });

        btnUserFilt.setText("Filtrera användare");
        btnUserFilt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserFiltActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblStatus))
                                .addGap(112, 112, 112))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnStatFilt)
                                .addGap(75, 75, 75)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUserFilt)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblUser)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cmbUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnTillbaka))))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(lblUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTillbaka)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStatFilt)
                    .addComponent(btnUserFilt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        new Startsida().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        
    }//GEN-LAST:event_cmbStatusActionPerformed

    private void cmbUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUserActionPerformed

    }//GEN-LAST:event_cmbUserActionPerformed

    private void btnUserFiltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserFiltActionPerformed
        knapp2();
    }//GEN-LAST:event_btnUserFiltActionPerformed

    private void btnStatFiltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatFiltActionPerformed
        knapp();
    }//GEN-LAST:event_btnStatFiltActionPerformed

    private void knapp() {
        switch (cmbStatus.getSelectedIndex()) {
            case 0:
                txtOrderLista.setText("");
                fyllOrderLista();
                break;
            case 1:
                fyllListaUrval();
                break;
            case 2:
                fyllListaUrval();
                break;
            case 3:
                fyllListaUrval();
                break;
            default:
                break;
        }
    }
    
    private void knapp2() {
        switch (cmbUser.getSelectedIndex()){
            case 0:
                txtOrderLista.setText("");
                fyllOrderLista();
                break;
            case 1:
                fyllAnvUrval();
                break;
            case 2:
                fyllAnvUrval();
                break;
            default:
                break;
        }
    }
    
    private void fyllAnvUrval() {
        ArrayList<HashMap<String, String>> filterAnv;
        String user = cmbUser.getSelectedItem().toString();
        String fraga5 = "Select BestID, Status, KundID, TullID, Prio FROM bestallning join Anvandare on Anvandare.AnvandarID like bestallning.AnvandareID where ForNamn = '" + user + "'";
        filterAnv = SqlFragor.getFleraRader(fraga5);
        
        txtOrderLista.setText("");
        
        String rubrik3 = " BeställningsID:"
                + "\t" + "Status:"
                + "\t" + "Kund ID"
                + "\t" + "TullID:"
                + "\t" + "Prio:" + "\n";
        txtOrderLista.append(rubrik3);

        for (HashMap<String, String> info : filterAnv) {
            txtOrderLista.append(info.get("BestID")
                    + "\t" + info.get("Status")
                    + "\t" + info.get("KundID")
                    + "\t" + info.get("TullID")
                    + "\t" + info.get("Prio") + "\n");
    }
    }

    private void fyllListaUrval() {
        ArrayList<HashMap<String, String>> filter;
        String status = cmbStatus.getSelectedItem().toString();
        String fraga3 = "Select BestID, Status, KundID, TullID, Prio FROM bestallning where Status like '" + status + "'";
        filter = SqlFragor.getFleraRader(fraga3);

        txtOrderLista.setText("");
        String rubrik2 = " BeställningsID:"
                + "\t" + "Status:"
                + "\t" + "Kund ID"
                + "\t" + "TullID:"
                + "\t" + "Prio:" + "\n";
        txtOrderLista.append(rubrik2);

        for (HashMap<String, String> info : filter) {
            txtOrderLista.append(info.get("BestID")
                    + "\t" + info.get("Status")
                    + "\t" + info.get("KundID")
                    + "\t" + info.get("TullID")
                    + "\t" + info.get("Prio") + "\n");

        }
    }

    private void fyllOrderLista() {

        ArrayList<HashMap<String, String>> allInfo;
        String fraga = "SELECT BestID, Status, KundID, TullID, Prio FROM bestallning";

        allInfo = SqlFragor.getFleraRader(fraga);

        String rubrik = " BeställningsID:"
                + "\t" + "Status:"
                + "\t" + "Kund ID"
                + "\t" + "TullID:"
                + "\t" + "Prio:" + "\n";

        txtOrderLista.append(rubrik);

        for (HashMap<String, String> info : allInfo) {
            txtOrderLista.append(info.get("BestID")
                    + "\t" + info.get("Status")
                    + "\t" + info.get("KundID")
                    + "\t" + info.get("TullID")
                    + "\t" + info.get("Prio") + "\n");
        }
    }

    private void fyllCmbStatus() {
        String fraga2 = "SELECT Status FROM bestallning";
        ArrayList<String> status;

        status = SqlFragor.getEnKolumn(fraga2);

        for (String info : status) {
            cmbStatus.addItem(info);
        }
    }
    
    private void fyllCmbUser(){
        String fraga4 = "SELECT ForNamn FROM anvandare";
        ArrayList<String> user;
        
        user = SqlFragor.getEnKolumn(fraga4);
        
        for (String info : user) {
            cmbUser.addItem(info);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStatFilt;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JButton btnUserFilt;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JComboBox<String> cmbUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextArea txtOrderLista;
    // End of variables declaration//GEN-END:variables
}
