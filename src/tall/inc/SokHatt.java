/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tall.inc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;

/**
 *
 * @author arvid
 */
public class SokHatt extends javax.swing.JFrame {

    /**
     * Creates new form SokHatt
     */
    public SokHatt() {
        initComponents();
        //fillFargCmb();
        fillHattList();
        fillGenreCmb();
        fillGenreHatt();
        fillTygCmb();
        fillDekList();
        hattIDTextfield.setVisible(false);
        
    }

    public void fillHattList() {
        String query = "SELECT Beskrivning FROM hatt";
        ArrayList<String> hattar = SqlFragor.getEnKolumn(query);
        DefaultListModel model = new DefaultListModel();
        for (String hatt : hattar) {
            model.addElement(hatt);
            hattList.setModel(model);
        }
    }

    public void fillGenreCmb() {
        String query = "SELECT genre FROM genre";
        ArrayList<String> genreLista = SqlFragor.getEnKolumn(query);
        for (String genre : genreLista) {
            genreCmb.addItem(genre);
        }
    }

    /*public void fillFargCmb() {
        String query = "SELECT farg FROM farg";
        ArrayList<String> fargLista = SqlFragor.getEnKolumn(query);
        for (String farg : fargLista) {
            fargCmb.addItem(farg);
        }
    }*/

    public void fillTygCmb() {
        String query = "SELECT tyg FROM tyg";
        ArrayList<String> tygLista = SqlFragor.getEnKolumn(query);
        for (String tyg : tygLista) {
            tygCmb.addItem(tyg);
        }
    }

    public void fillDekList() {

        dekList.setSelectionModel(new DefaultListSelectionModel() {
            public void setSelectionInterval(int index0, int index1) {
                if (isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);
                } else {
                    super.addSelectionInterval(index0, index1);
                }
            }
        });
        String query = "SELECT Dekoration FROM dekorationer";
        ArrayList<String> dekLista = SqlFragor.getEnKolumn(query);
        DefaultListModel model = new DefaultListModel();
        for (String dek : dekLista) {
            model.addElement(dek);

            dekList.setModel(model);
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
        hattList = new javax.swing.JList<>();
        valjButton = new javax.swing.JButton();
        namnTextfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        prisTextfield = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        uppdateraButton = new javax.swing.JButton();
        genreCmb = new javax.swing.JComboBox<>();
        tygCmb = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dekList = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        hattIDTextfield = new javax.swing.JTextField();
        BtnTillbaka = new javax.swing.JButton();
        storlekTxt = new javax.swing.JTextField();
        fargTextfield = new javax.swing.JTextField();
        cmbGenreHatt = new javax.swing.JComboBox<>();
        lblKat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(hattList);

        valjButton.setText("Välj Hatt");
        valjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valjButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Namn:");

        jLabel2.setText("Färg:");

        jLabel3.setText("Storlek/cm:");

        jLabel5.setText("Genre:");

        jLabel6.setText("Pris:");

        uppdateraButton.setText("Uppdatera");
        uppdateraButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uppdateraButtonActionPerformed(evt);
            }
        });

        genreCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj Genre" }));

        tygCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj Tyg" }));

        jLabel7.setText("Tyg:");

        dekList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(dekList);

        jLabel8.setText("Dekorationer:");

        BtnTillbaka.setText("Tillbaka");
        BtnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTillbakaActionPerformed(evt);
            }
        });

        cmbGenreHatt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj Genre" }));
        cmbGenreHatt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGenreHattActionPerformed(evt);
            }
        });

        lblKat.setText("Sök efter kategori");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbGenreHatt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblKat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(35, 35, 35))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel6))
                                    .addGap(19, 19, 19)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(33, 33, 33)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(genreCmb, 0, 100, Short.MAX_VALUE)
                            .addComponent(tygCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(prisTextfield)
                            .addComponent(namnTextfield)
                            .addComponent(storlekTxt)
                            .addComponent(fargTextfield)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(valjButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(uppdateraButton)
                        .addGap(18, 18, 18)
                        .addComponent(BtnTillbaka)))
                .addGap(30, 30, 30)
                .addComponent(hattIDTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(namnTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(hattIDTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblKat, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fargTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGenreHatt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(storlekTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(genreCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tygCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prisTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel8)))
                        .addGap(41, 41, 41))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valjButton)
                    .addComponent(BtnTillbaka)
                    .addComponent(uppdateraButton))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void valjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valjButtonActionPerformed
        // TODO add your handling code here:
        String valdHatt = hattList.getSelectedValue();
        String hattQuery = "SELECT hattID FROM hatt where beskrivning = '" + valdHatt + "'";
        String hattID = SqlFragor.getEttVarde(hattQuery);
        hattIDTextfield.setText(hattID);

        String query = "SELECT beskrivning, Pris, storlek, Farg, Genre, Tyg FROM hatt inner join Genre on hatt.GenreID = Genre.GenreID inner join Tyg on hatt.TygID = Tyg.TygID WHERE hatt.HattID = '" + hattID + "'";
        String dekorationQuery = "SELECT d.Dekoration FROM dekorationerstandardhatt inner join dekorationer d on dekorationerstandardhatt.dekorationID = d.DekorationID where dekorationerstandardhatt.HattID = '" + hattID + "';";
        HashMap<String, String> hattMap = SqlFragor.getEnRad(query);
        ArrayList<String> dekorationList = SqlFragor.getEnKolumn(dekorationQuery);
        //cleara listan innan den fylls igen
        dekList.clearSelection();
        for (String dek : dekorationList) {
            Object dekObject = dek;
            dekList.setSelectedValue(dekObject, rootPaneCheckingEnabled);
        }
        storlekTxt.setText(hattMap.get("storlek"));
        fargTextfield.setText(hattMap.get("Farg"));
        genreCmb.setSelectedItem(hattMap.get("Genre"));
        tygCmb.setSelectedItem(hattMap.get("Tyg"));
        prisTextfield.setText(hattMap.get("Pris"));
        namnTextfield.setText(hattMap.get("beskrivning"));
    }//GEN-LAST:event_valjButtonActionPerformed

    private void uppdateraButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uppdateraButtonActionPerformed
        // TODO add your handling code here:
        String hattID = hattIDTextfield.getText();

        String namn = namnTextfield.getText();
        String pris = prisTextfield.getText();
        boolean namnStringTest = ValideringsKlass.stringHarVarde(namn);
        boolean prisStringTest = ValideringsKlass.stringHarVarde(pris);
        boolean prisIntTest = ValideringsKlass.taltest(prisTextfield);

        if (namnStringTest == true && prisStringTest == true) {
            String updateNamnQuery = "update Hatt set beskrivning = '" + namn + "' where HattID = '" + hattID + "'";
            SqlFragor.uppdatera(updateNamnQuery);
            String updatePrisQuery = "update Hatt set Pris = '" + pris + "' where HattID = '" + hattID + "'";
            SqlFragor.uppdatera(updatePrisQuery);

            //
            //
            String farg = fargTextfield.getText();
            //String fargQuery = "SELECT farg FROM hatt where farg = '" + farg + "'";
            //String fargID = SqlFragor.getEttVarde(fargQuery);
            String updateFargQuery = "update Hatt set Farg = '" + farg + "' where HattID = '" + hattID + "'";
            SqlFragor.uppdatera(updateFargQuery);
            //
            String genre = genreCmb.getSelectedItem().toString();
            String genreQuery = "SELECT genreID FROM genre where genre = '" + genre + "'";
            String genreID = SqlFragor.getEttVarde(genreQuery);
            String updateGenreQuery = "update Hatt set GenreID = '" + genreID + "' where HattID = '" + hattID + "'";
            SqlFragor.uppdatera(updateGenreQuery);
            //
            String tyg = tygCmb.getSelectedItem().toString();
            String tygQuery = "SELECT tygID FROM tyg where tyg = '" + tyg + "'";
            String tygID = SqlFragor.getEttVarde(tygQuery);
            String updateTygQuery = "update hatt set TygID = '" + tygID + "' where HattID = '" + hattID + "'";
            SqlFragor.uppdatera(updateTygQuery);
            //
            String storlek = storlekTxt.getText();
            String updateStorlekQuery = "update hatt set storlek = '" + storlek + "' where HattID = '" + hattID + "'";
            SqlFragor.uppdatera(updateStorlekQuery);
            //
            String deleteDekQuery = "DELETE FROM dekorationerstandardhatt WHERE hattID = '" + hattID + "'";
            SqlFragor.deleteFranDatabasen(deleteDekQuery);
            //
            List<String> dek = dekList.getSelectedValuesList();
            for (String dekoration : dek) {
                String dekQuery = "SELECT dekorationID FROM dekorationer WHERE dekoration = '" + dekoration + "'";
                String dekID = SqlFragor.getEttVarde(dekQuery);
                String updateDekQuery = "INSERT INTO dekorationerstandardhatt (HattID,DekorationID) VALUES ('" + hattID + "', '" + dekID + "')";
                SqlFragor.addToDatabasen(updateDekQuery);

            }
            JOptionPane.showMessageDialog(null, "Hatten uppdaterad!");
            dispose();
            
        } else if (prisIntTest == false) {
            JOptionPane.showMessageDialog(null, "Priset kan endast bestå av siffror!");

        } else {
            JOptionPane.showMessageDialog(null, "Du måste fylla i alla fält!");

        }


    }//GEN-LAST:event_uppdateraButtonActionPerformed

    private void BtnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTillbakaActionPerformed
        // TODO add your handling code here:
        new Startsida().setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnTillbakaActionPerformed

    private void fillGenreHatt(){
        String query = "SELECT genre FROM genre";
        ArrayList<String> genreLista = SqlFragor.getEnKolumn(query);
        for (String genre : genreLista) {
            cmbGenreHatt.addItem(genre);
    }
    }
    private void cmbGenreHattActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGenreHattActionPerformed
       String valdGenre = cmbGenreHatt.getSelectedItem().toString();
       String genreQuery =  "Select Beskrivning from Hatt\n" +
                            "join mibdb.Genre G on Hatt.GenreID = G.GenreID\n" +
                            "where Genre = '" + valdGenre + "'";
       ArrayList<HashMap<String, String>> genreFilter = SqlFragor.getFleraRader(genreQuery);
       DefaultListModel model = new DefaultListModel();
       for(HashMap<String, String>genre : genreFilter){
            String hattNamn = genre.get("Beskrivning"); 
            model.addElement(hattNamn);
            hattList.setModel(model);
       }
       if(cmbGenreHatt.getSelectedIndex() == 0){
           fillHattList();
       }
        
    }//GEN-LAST:event_cmbGenreHattActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnTillbaka;
    private javax.swing.JComboBox<String> cmbGenreHatt;
    private javax.swing.JList<String> dekList;
    private javax.swing.JTextField fargTextfield;
    private javax.swing.JComboBox<String> genreCmb;
    private javax.swing.JTextField hattIDTextfield;
    private javax.swing.JList<String> hattList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblKat;
    private javax.swing.JTextField namnTextfield;
    private javax.swing.JTextField prisTextfield;
    private javax.swing.JTextField storlekTxt;
    private javax.swing.JComboBox<String> tygCmb;
    private javax.swing.JButton uppdateraButton;
    private javax.swing.JButton valjButton;
    // End of variables declaration//GEN-END:variables
}
