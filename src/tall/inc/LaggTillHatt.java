package tall.inc;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
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
public class LaggTillHatt extends javax.swing.JFrame {

    /**
     * Creates new form LaggTillHatt
     */
    public LaggTillHatt() throws InfException {
        initComponents();

        fillGenreCmb();
        fillTygCmb();
        fillDekList1();
        fillFargCmb();

    }

    public void fillGenreCmb() {
        String query = "SELECT namn FROM genre";
        ArrayList<String> genreLista = SqlFragor.getEnKolumn(query);
        for (String genre : genreLista) {
            genreCmb.addItem(genre);
        }
    }

    public void fillFargCmb() {
        String query = "SELECT namn FROM farg";
        ArrayList<String> fargLista = SqlFragor.getEnKolumn(query);
        for (String farg : fargLista) {
            fargCmb.addItem(farg);
        }
    }

    public void fillTygCmb() {
        String query = "SELECT namn FROM tyg";
        ArrayList<String> tygLista = SqlFragor.getEnKolumn(query);
        for (String tyg : tygLista) {
            tygCmb.addItem(tyg);
        }
    }

    /*public void fillDekList() {
        String query = "SELECT namn FROM dekoration";
        ArrayList<String> dekLista = SqlFragor.getEnKolumn(query);
        DefaultListModel m = new DefaultListModel();
        dekList.setModel(m);
        for (String dek : dekLista) {
            m.addElement(dek);

        }

    }*/
    public void fillDekList1() {

        dekList.setSelectionModel(new DefaultListSelectionModel() {
            public void setSelectionInterval(int index0, int index1) {
                if (isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);
                } else {
                    super.addSelectionInterval(index0, index1);
                }
            }
        });
        String query = "SELECT namn FROM dekorationer";
        ArrayList<String> dekLista = SqlFragor.getEnKolumn(query);
        DefaultListModel model = new DefaultListModel();
        for (String dek : dekLista) {
            model.addElement(dek);
  

            dekList.setModel(model);
        }

    }

    private void skapaHattBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skapaHattBtnActionPerformed
        // TODO add your handling code here:


        String hattID = SqlFragor.nyID("hatt", "HattID");
        System.out.println(hattID);
        String anvandarID = Startsida.getAnvandare();
        
        String namn = namnTextField.getText();

        String tyg = tygCmb.getSelectedItem().toString();
        String tygQuery = "Select tygID From tyg where namn = '" + tyg + "'";
        String tygID = SqlFragor.getEttVarde(tygQuery);

        String genre = genreCmb.getSelectedItem().toString();
        String genreQuery = "Select genreID From genre where namn = '" + genre + "'";
        String genreID = SqlFragor.getEttVarde(genreQuery);

        String pris = prisTextField.getText();
        String storlek = storlekCmb.getSelectedItem().toString();

        String farg = fargCmb.getSelectedItem().toString();
        String fargQuery = "Select fargID From farg where namn = '" + farg + "'";
        
        String fargID = SqlFragor.getEttVarde(fargQuery);        
        String query = "INSERT INTO standardhatt (hattID, Namn, FargID,Pris, GenreID, TygID, AnvandarID, Storlek) VALUES ('" + hattID + "','"+namn+"', '" + fargID + "', '" + pris + "', '" + genreID + "', '" + tygID + "','1', '" + storlek + "')";
        SqlFragor.addToDatabasen(query);
        
        String hattQuery = "INSERT INTO hatt (HattID) VALUES ('"+hattID+"')";
        SqlFragor.addToDatabasen(hattQuery);
        
        List<String> dek = dekList.getSelectedValuesList();
        for (String dekoration : dek) {
            String dekQuery = "SELECT dekorationID FROM dekorationer WHERE namn = '" + dekoration + "'";
            String dekID = SqlFragor.getEttVarde(dekQuery);
                    System.out.println(dekID);
                            System.out.println(dekQuery);


            String insertQuery = "INSERT INTO dekorationerstandardhatt (hattID,dekorationID) VALUES ('" + hattID + "','" + dekID + "')";
                                        System.out.println(insertQuery);

            SqlFragor.addToDatabasen(insertQuery);
        }


    }//GEN-LAST:event_skapaHattBtnActionPerformed

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        namnTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tygCmb = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        storlekCmb = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        genreCmb = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        prisTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dekList = new javax.swing.JList<>();
        dekList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        skapaHattBtn = new javax.swing.JButton();
        avbrytBtn = new javax.swing.JButton();
        fargCmb = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Skapa hatt");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Namn:");

        namnTextField.setBackground(new java.awt.Color(255, 255, 255));
        namnTextField.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tyg:");

        tygCmb.setBackground(new java.awt.Color(255, 255, 255));
        tygCmb.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Storlek:");

        storlekCmb.setBackground(new java.awt.Color(255, 255, 255));
        storlekCmb.setForeground(new java.awt.Color(0, 0, 0));
        storlekCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "V�lj storlek:", "S", "M", "L", "XL" }));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Genre:");

        genreCmb.setBackground(new java.awt.Color(255, 255, 255));
        genreCmb.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Pris:");

        prisTextField.setBackground(new java.awt.Color(255, 255, 255));
        prisTextField.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("F�rg:");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Dekorationer:");

        dekList.setBackground(new java.awt.Color(255, 255, 255));
        dekList.setForeground(new java.awt.Color(0, 0, 0));
        dekList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(dekList);

        skapaHattBtn.setBackground(new java.awt.Color(255, 255, 255));
        skapaHattBtn.setForeground(new java.awt.Color(0, 0, 0));
        skapaHattBtn.setText("Skapa hatt");
        skapaHattBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skapaHattBtnActionPerformed(evt);
            }
        });

        avbrytBtn.setBackground(new java.awt.Color(255, 255, 255));
        avbrytBtn.setForeground(new java.awt.Color(0, 0, 0));
        avbrytBtn.setText("Avbryt");
        avbrytBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avbrytBtnActionPerformed(evt);
            }
        });

        fargCmb.setBackground(new java.awt.Color(255, 255, 255));
        fargCmb.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(genreCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(storlekCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tygCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(skapaHattBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(avbrytBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fargCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(66, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tygCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(storlekCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genreCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fargCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(prisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(skapaHattBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avbrytBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void avbrytBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avbrytBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_avbrytBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton avbrytBtn;
    private javax.swing.JList<String> dekList;
    private javax.swing.JComboBox<String> fargCmb;
    private javax.swing.JComboBox<String> genreCmb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namnTextField;
    private javax.swing.JTextField prisTextField;
    private javax.swing.JButton skapaHattBtn;
    private javax.swing.JComboBox<String> storlekCmb;
    private javax.swing.JComboBox<String> tygCmb;
    // End of variables declaration//GEN-END:variables
}
