package tall.inc;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author noahjarvback
 */
public class LaggTillHatt extends javax.swing.JFrame {

    private Color farg;
    /**
     * Creates new form LaggTillHatt
     */
    public LaggTillHatt()   {
        initComponents();

        fillGenreCmb();
        fillTygCmb();
        fillDekList1();
        //fillFargCmb();

        visaFarg(Color.WHITE);
        
    }


   /* public void fillFargCmb() {
        fargCmb.addItem("");
        fargCmb.addItem("Skapa ny färg");
        String query = "SELECT Farg FROM farg";
        ArrayList<String> fargLista = SqlFragor.getEnKolumn(query);
        for (String farg : fargLista) {
            fargCmb.addItem(farg);
        }
    }*/
    
        //Färgmetoder---------------------------------------------------------
    private void valjFarg() {
        farg = JColorChooser.showDialog(this, "Välj färg", Color.BLACK);
        if (farg == null) {
            farg = Color.WHITE;
        }
        visaFarg(farg);
    }

    private void visaFarg(Color farg) {
        pnlColorSample.setBackground(farg);
        lblFarg.setText(colorToHex(farg));
    }

    private String colorToHex(Color farg) {
        String hex;
        hex = Integer.toHexString(farg.getRGB()).substring(2);
        return hex;
    }
    //Slut på färgmetoder-----------------------------------------------------
    
    public void fillGenreCmb() {
        genreCmb.removeAllItems();
        genreCmb.addItem("");
        genreCmb.addItem("Skapa ny");
        String query = "SELECT Genre FROM genre";
        ArrayList<String> genreLista = SqlFragor.getEnKolumn(query);
        for (String genre : genreLista) {
            genreCmb.addItem(genre);

        }
    }

    public void fillTygCmb() {
        tygCmb.removeAllItems();
        tygCmb.addItem("");
        tygCmb.addItem("Skapa nytt");
        String query = "SELECT tyg FROM tyg";
        ArrayList<String> tygLista = SqlFragor.getEnKolumn(query);
        for (String tyg : tygLista) {
            tygCmb.addItem(tyg);
        }
    }

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
        String query = "SELECT Dekoration FROM dekorationer";
        ArrayList<String> dekLista = SqlFragor.getEnKolumn(query);
        DefaultListModel model = new DefaultListModel();
        for (String dek : dekLista) {
            model.addElement(dek);
  

            dekList.setModel(model);
        }

    }

    private void skapaHattBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skapaHattBtnActionPerformed
        // TODO add your handling code here:
        String anvandarID = Inloggningssida.getAnvandarID();


        String hattID = SqlFragor.nyID("hatt", "HattID");
        
        String namn = namnTextField.getText();

        String tyg = tygCmb.getSelectedItem().toString();
        String tygQuery = "Select tygID From tyg where tyg = '" + tyg + "'";
        String tygID = SqlFragor.getEttVarde(tygQuery);

        String genre = genreCmb.getSelectedItem().toString();
        String genreQuery = "Select genreID From genre where genre = '" + genre + "'";
        String genreID = SqlFragor.getEttVarde(genreQuery);

        String pris = prisTextField.getText();
        String storlek = storlekTxt.getText();

        //String farg = fargCmb.getSelectedItem().toString();
        String fargQuery = "Select fargID From farg where farg = '" + farg + "'";
        
        String fargID = SqlFragor.getEttVarde(fargQuery);        
        String query = "INSERT INTO hatt (hattID, beskrivning, FargID,Pris, GenreID, TygID, AnvandarID, Storlek) VALUES ('" + hattID + "','"+namn+"', '" + fargID + "', '" + pris + "', '" + genreID + "', '" + tygID + "','"+anvandarID+"', '" + storlek + "')";
        SqlFragor.addToDatabasen(query);
        
        String hattQuery = "INSERT INTO standardhatt (HattID) VALUES ('"+hattID+"')";
        SqlFragor.addToDatabasen(hattQuery);
        
        List<String> dek = dekList.getSelectedValuesList();
        for (String dekoration : dek) {
            String dekQuery = "SELECT dekorationID FROM dekorationer WHERE dekoration = '" + dekoration + "'";
            String dekID = SqlFragor.getEttVarde(dekQuery);


            String insertQuery = "INSERT INTO dekorationerstandardhatt (hattID,dekorationID) VALUES ('" + hattID + "','" + dekID + "')";

            SqlFragor.addToDatabasen(insertQuery);
            
        }
        JOptionPane.showMessageDialog(null, "Hatten tillagd!");
        dispose();


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
        tillbakaButton = new javax.swing.JButton();
        storlekTxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblFarg = new javax.swing.JLabel();
        pnlColorSample = new javax.swing.JPanel();
        btnValjFarg = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel7.setText("Skapa hatt");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel8.setText("Namn:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel5.setText("Tyg:");

        tygCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tygCmbActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel6.setText("Storlek/cm:");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel3.setText("Genre:");

        genreCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genreCmbActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setText("Pris:");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel1.setText("Färg:");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel4.setText("Dekorationer:");

        dekList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(dekList);

        skapaHattBtn.setBackground(new java.awt.Color(255, 255, 255));
        skapaHattBtn.setText("Skapa hatt");
        skapaHattBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skapaHattBtnActionPerformed(evt);
            }
        });

        tillbakaButton.setBackground(new java.awt.Color(255, 255, 255));
        tillbakaButton.setText("Tillbaka");
        tillbakaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tillbakaButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Ny dekoration");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblFarg.setText("jLabel6");

        javax.swing.GroupLayout pnlColorSampleLayout = new javax.swing.GroupLayout(pnlColorSample);
        pnlColorSample.setLayout(pnlColorSampleLayout);
        pnlColorSampleLayout.setHorizontalGroup(
            pnlColorSampleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        pnlColorSampleLayout.setVerticalGroup(
            pnlColorSampleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        btnValjFarg.setText("Välj färg");
        btnValjFarg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValjFargActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addContainerGap(110, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tygCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(storlekTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(genreCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pnlColorSample, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblFarg)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(skapaHattBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tillbakaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnValjFarg)
                                .addComponent(prisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(namnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tygCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(storlekTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(genreCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnValjFarg)
                                .addComponent(lblFarg)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(prisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pnlColorSample, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(skapaHattBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tillbakaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tillbakaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tillbakaButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_tillbakaButtonActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        
    }//GEN-LAST:event_formFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        skapaDekoration();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tygCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tygCmbActionPerformed
        if (tygCmb.getSelectedIndex() == 1){
            skapaTyg();
        }
       
    }//GEN-LAST:event_tygCmbActionPerformed

    private void genreCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genreCmbActionPerformed

        if (genreCmb.getSelectedIndex() == 1){
            skapaGenre();
        }
    }//GEN-LAST:event_genreCmbActionPerformed

    private void btnValjFargActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValjFargActionPerformed

        valjFarg();
    }//GEN-LAST:event_btnValjFargActionPerformed

    private void skapaDekoration(){
        String nyDekoration = JOptionPane.showInputDialog(null);
        String nyid = SqlFragor.nyID("dekorationer", "DekorationID");
        SqlFragor.addToDatabasen("INSERT INTO dekorationer (DekorationID, Dekoration) VALUES ('" + nyid + "','" + nyDekoration + "')");
        fillDekList1();
    }
    
    private void skapaTyg() {
        String nyTyg = JOptionPane.showInputDialog(null);
        String nyid = SqlFragor.nyID("tyg", "TygID");
        SqlFragor.addToDatabasen("INSERT INTO tyg (TygID, Tyg) VALUES ('" + nyid + "','" + nyTyg + "')");
        fillTygCmb();
    }
    
    private void skapaGenre() {
        String nyGenre = JOptionPane.showInputDialog(null);
        String nyid = SqlFragor.nyID("genre", "GenreID");
        SqlFragor.addToDatabasen("INSERT INTO genre (GenreID, Genre) VALUES ('" + nyid + "','" + nyGenre + "')");
        fillGenreCmb();
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnValjFarg;
    private javax.swing.JList<String> dekList;
    private javax.swing.JComboBox<String> genreCmb;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFarg;
    private javax.swing.JTextField namnTextField;
    private javax.swing.JPanel pnlColorSample;
    private javax.swing.JTextField prisTextField;
    private javax.swing.JButton skapaHattBtn;
    private javax.swing.JTextField storlekTxt;
    private javax.swing.JButton tillbakaButton;
    private javax.swing.JComboBox<String> tygCmb;
    // End of variables declaration//GEN-END:variables
}
