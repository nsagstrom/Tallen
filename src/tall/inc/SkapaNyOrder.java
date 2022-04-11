/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tall.inc;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gewe_
 */
public class SkapaNyOrder extends javax.swing.JFrame {

    /**
     * Creates new form SkapaNyOrder
     */
    public SkapaNyOrder() {
        initComponents();
        skapaOrderNummer();
        fillFargCmb();
        fillTygCmb();
        fillStandardHattCmb();
        fillDekList();
        fillGenreCmb();
        DefaultTableModel model = (DefaultTableModel) hattTbl.getModel();
        for (int i = hattTbl.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNyOrder = new javax.swing.JLabel();
        lblAntal = new javax.swing.JLabel();
        lblArtikelnummer = new javax.swing.JLabel();
        lblEfternamn = new javax.swing.JLabel();
        lblKundinfo = new javax.swing.JLabel();
        lblFornamn = new javax.swing.JLabel();
        lblAdress = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        txtangivetFornamn = new javax.swing.JTextField();
        txtangivetEfternamn = new javax.swing.JTextField();
        txtangivetAdress = new javax.swing.JTextField();
        txtangivetTelefonnummer = new javax.swing.JTextField();
        lblOrdernummer = new javax.swing.JLabel();
        lblVarOrderNummer = new javax.swing.JLabel();
        lblLagerartikel = new javax.swing.JLabel();
        lblSpecialartikel = new javax.swing.JLabel();
        standardHattCmb = new javax.swing.JComboBox<>();
        lblSpecialartikelFarg = new javax.swing.JLabel();
        lblSpecialartikelTyg = new javax.swing.JLabel();
        txtSpecialBenamning = new javax.swing.JTextField();
        btnLaggTillHatt = new javax.swing.JButton();
        btnLaggTillSpHatt = new javax.swing.JButton();
        btnLaggTillKund = new javax.swing.JButton();
        btnTillbaka = new javax.swing.JButton();
        CBoxSpecialartikelFarg = new javax.swing.JComboBox<>();
        genreCmb = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tygCmb = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        dekList = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        storlekCmb = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        hattTbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNyOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNyOrder.setText("Ny order");

        lblAntal.setText("Antal");

        lblArtikelnummer.setText("Artikelnummer");

        lblEfternamn.setText("Efternamn");

        lblKundinfo.setText("Ny kund");

        lblFornamn.setText("F�rnamn");

        lblAdress.setText("Adress");

        lblTelefon.setText("Telefonnummer");

        lblOrdernummer.setText("Ordernummer");

        lblVarOrderNummer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblVarOrderNummer.setText("\"ordernr\"");

        lblLagerartikel.setText("Lagerartikel");

        lblSpecialartikel.setText("Specialartikel");

        lblSpecialartikelFarg.setText("F�rg");

        lblSpecialartikelTyg.setText("Tyg");

        btnLaggTillHatt.setText("L�gg till");
        btnLaggTillHatt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillHattActionPerformed(evt);
            }
        });

        btnLaggTillSpHatt.setText("L�gg till");
        btnLaggTillSpHatt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillSpHattActionPerformed(evt);
            }
        });

        btnLaggTillKund.setText("L�gg till");
        btnLaggTillKund.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillKundActionPerformed(evt);
            }
        });

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        jLabel1.setText("Ben�mning:");

        jLabel2.setText("Genre:");

        tygCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dekList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(dekList);

        jLabel3.setText("Dekorationer:");

        storlekCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L", "XL" }));

        jLabel4.setText("Storlek:");

        hattTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        hattTbl.setDropMode(javax.swing.DropMode.INSERT);
        jScrollPane2.setViewportView(hattTbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKundinfo)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(lblNyOrder)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOrdernummer)
                            .addComponent(lblVarOrderNummer))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLagerartikel)
                            .addComponent(lblSpecialartikel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSpecialartikelFarg, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(116, 116, 116)
                                .addComponent(lblSpecialartikelTyg, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtangivetFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFornamn))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtangivetEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEfternamn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtangivetAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAdress))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtangivetTelefonnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblArtikelnummer)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(CBoxSpecialartikelFarg, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32)
                                                .addComponent(txtSpecialBenamning, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(standardHattCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblAntal)
                                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(genreCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(tygCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(storlekCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(btnLaggTillKund))
                            .addComponent(btnLaggTillHatt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLaggTillSpHatt)
                                    .addComponent(btnTillbaka, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNyOrder)
                    .addComponent(lblOrdernummer))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKundinfo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblVarOrderNummer))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFornamn)
                    .addComponent(lblAdress)
                    .addComponent(lblEfternamn)
                    .addComponent(lblTelefon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtangivetFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtangivetEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtangivetAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtangivetTelefonnummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLaggTillKund))
                .addGap(80, 80, 80)
                .addComponent(lblLagerartikel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAntal)
                    .addComponent(lblArtikelnummer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(standardHattCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLaggTillHatt))
                .addGap(27, 27, 27)
                .addComponent(lblSpecialartikel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSpecialartikelTyg, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSpecialartikelFarg)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CBoxSpecialartikelFarg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSpecialBenamning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(genreCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tygCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(storlekCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnLaggTillSpHatt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTillbaka, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(226, 226, 226))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLaggTillKundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillKundActionPerformed
        if (valideringMetod() == false) {
            laggTillNyKund();
        }
    }//GEN-LAST:event_btnLaggTillKundActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void btnLaggTillSpHattActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillSpHattActionPerformed
        laggTillSpecial();

    }//GEN-LAST:event_btnLaggTillSpHattActionPerformed

    private void btnLaggTillHattActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillHattActionPerformed
        Object hatt = standardHattCmb.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) hattTbl.getModel();
        model.addRow(new Object[]{hatt});
    }//GEN-LAST:event_btnLaggTillHattActionPerformed

    private void laggTillNyKund() {
        String fornamn = txtangivetFornamn.getText();
        String efternamn = txtangivetEfternamn.getText();
        String adress = txtangivetAdress.getText();
        String telefonnummer = txtangivetTelefonnummer.getText();
        int kNr = skapaKundnummer();

        String fraga = "INSERT INTO kund (KundID, Fornamn, Efternamn, Adress, Tel) VALUES ('" + kNr + "', '" + fornamn + "', '" + efternamn + "', '" + adress + "', '" + telefonnummer + "');";
        SqlFragor.addToDatabasen(fraga);

        JOptionPane.showMessageDialog(null, "Ny kund tillagd!");
    }

    private void laggTillSpecial() {
        String hattID = SqlFragor.nyID("hatt", "HattID");
        String benamning = txtSpecialBenamning.getText();
        String farg = CBoxSpecialartikelFarg.getSelectedItem().toString();
        String fargQuery = "Select fargID From farg where farg = '" + farg + "'";

        String fargID = SqlFragor.getEttVarde(fargQuery);
        //
        String genre = genreCmb.getSelectedItem().toString();
        String genreQuery = "Select genreID From genre where genre = '" + genre + "'";
        String genreID = SqlFragor.getEttVarde(genreQuery);
        //
        String tyg = tygCmb.getSelectedItem().toString();
        String tygQuery = "Select tygID From tyg where tyg = '" + tyg + "'";
        String tygID = SqlFragor.getEttVarde(tygQuery);
        //
        String storlek = storlekCmb.getSelectedItem().toString();
        String anvandare = Inloggningssida.getAnvandarID();

        String fragaSpecial = "INSERT INTO SpecialHatt(HattID) VALUES (" + hattID + ");";
        SqlFragor.addToDatabasen(fragaSpecial);

        String fraga = "INSERT INTO hatt (HattID, Beskrivning, FargID,pris, storlek, GenreID, TygID, AnvandarID) VALUES (" + hattID + ",'" + benamning + "'," + fargID + ",0,'" + storlek + "'," + genreID + "," + tygID + "," + anvandare + ")";
        SqlFragor.addToDatabasen(fraga);

        List<String> dek = dekList.getSelectedValuesList();
        for (String dekoration : dek) {
            String dekQuery = "SELECT dekorationID FROM dekorationer WHERE dekoration = '" + dekoration + "'";
            String dekID = SqlFragor.getEttVarde(dekQuery);
            String insertQuery = "INSERT INTO dekorationerstandardhatt (hattID,dekorationID) VALUES ('" + hattID + "','" + dekID + "')";

            SqlFragor.addToDatabasen(insertQuery);

        }

        String addToTableQuery = "SELECT Beskrivning FROM hatt where hattID = '" + hattID + "'";
        Object hattIDTbl = SqlFragor.getEttVarde(addToTableQuery);
        DefaultTableModel model = (DefaultTableModel) hattTbl.getModel();
        model.addRow(new Object[]{hattIDTbl});
        /*String query = "SELECT HattID FROM specialhatt";
        ArrayList<String> hattIdLista = SqlFragor.getEnKolumn(query);
        for (String hatt : hattIdLista) {
            String beskrivningQuery = "SELECT beskrivning from Hatt inner join StandardHatt SH on Hatt.HattID = SH.HattID where SH.HattID = '" + hatt + "'";
            String hattBes = SqlFragor.getEttVarde(beskrivningQuery);
            standardHattCmb.addItem(hattBes);
        }
         */
        JOptionPane.showMessageDialog(null, "Ny specialhatt!");

    }

    private boolean valideringMetod() {
        boolean ok = false;
        if (ValideringsKlass.stringHarVarde(txtangivetFornamn.getText()) == false) {
            ok = true;
            JOptionPane.showMessageDialog(null, "V�nligen ange f�rnamn i rutan");
        }

        if (ValideringsKlass.stringHarVarde(txtangivetEfternamn.getText()) == false) {
            ok = true;
            JOptionPane.showMessageDialog(null, "V�nligen ange efternamn i rutan");
        }
        if (ValideringsKlass.stringHarVarde(txtangivetAdress.getText()) == false) {
            ok = true;
            JOptionPane.showMessageDialog(null, "V�nligen ange adress i rutan");
        }
        if (ValideringsKlass.stringHarVarde(txtangivetTelefonnummer.getText()) == false) {
            ok = true;
            JOptionPane.showMessageDialog(null, "V�nligen ange telefonnummer i rutan");
        }
        if (ValideringsKlass.testaTeleNmrString(txtangivetTelefonnummer.getText()) == false) {
            ok = true;
            JOptionPane.showMessageDialog(null, "Telefonnummer kan inte inneh�lla bokst�ver");
        }

        return ok;
    }

    public String getNuvarandeOrderNummer() {
        String nuvarandeOrderNummer = lblVarOrderNummer.getText();

        return nuvarandeOrderNummer;
    }

    public void fillFargCmb() {
        String query = "SELECT farg FROM farg";
        ArrayList<String> fargLista = SqlFragor.getEnKolumn(query);
        for (String farg : fargLista) {
            CBoxSpecialartikelFarg.addItem(farg);
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

    public void fillStandardHattCmb() {

        String query = "SELECT HattID FROM standardhatt";
        ArrayList<String> hattIdLista = SqlFragor.getEnKolumn(query);
        for (String hatt : hattIdLista) {
            String beskrivningQuery = "SELECT beskrivning from Hatt inner join StandardHatt SH on Hatt.HattID = SH.HattID where SH.HattID = '" + hatt + "'";
            String hattBes = SqlFragor.getEttVarde(beskrivningQuery);
            standardHattCmb.addItem(hattBes);
        }
    }

    public void fillGenreCmb() {
        String query = "SELECT Genre FROM genre";
        ArrayList<String> genreLista = SqlFragor.getEnKolumn(query);
        for (String genre : genreLista) {
            genreCmb.addItem(genre);

        }
    }

    public void fillTygCmb() {
        String query = "SELECT tyg FROM tyg";
        ArrayList<String> tygLista = SqlFragor.getEnKolumn(query);
        for (String tyg : tygLista) {
            tygCmb.addItem(tyg);
        }
    }

    //Skapar "n�sta" ordernummer (BestID) baserat p� det h�gsta ID:t som finns i databasen.
    private void skapaOrderNummer() {
        int ordernummer = taFramMaxBestId() + 1;
        String order = Integer.toString(ordernummer);
        lblVarOrderNummer.setText(order);
    }

    //Skapar "n�sta" KundID baserat p� det h�gsta ID:t som finns i databasen.
    private int skapaKundnummer() {
        int kundNummer = taFramMaxKundId() + 1;
        String kundNr = Integer.toString(kundNummer);

        return kundNummer;
    }

    //Skapar "n�sta" HattID baserat p� det h�gsta v�rdet som finns i databasen.
    private int skapaHattId() {
        int hattId = taFramMaxHattId() + 1;
        String kundNr = Integer.toString(hattId);

        return hattId;
    }
    // H�mtar det h�gsta HattID:t som finns i databasen

    public int taFramMaxHattId() {
        int maxId = Integer.parseInt(SqlFragor.getEttVarde("SELECT MAX(HattID) FROM hatt"));
        return maxId;
    }

    //H�mtar och returnerar h�gsta BestID som finns i databasen
    public int taFramMaxBestId() {
        int maxId = Integer.parseInt(SqlFragor.getEttVarde("SELECT MAX(BestID) FROM Bestallning"));
        return maxId;
    }

    //H�mtar och returnerar h�gsta KundID som finns i databasen
    public int taFramMaxKundId() {
        int maxId = Integer.parseInt(SqlFragor.getEttVarde("SELECT MAX(KundID) FROM Kund"));
        return maxId;
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBoxSpecialartikelFarg;
    private javax.swing.JButton btnLaggTillHatt;
    private javax.swing.JButton btnLaggTillKund;
    private javax.swing.JButton btnLaggTillSpHatt;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JList<String> dekList;
    private javax.swing.JComboBox<String> genreCmb;
    private javax.swing.JTable hattTbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblAntal;
    private javax.swing.JLabel lblArtikelnummer;
    private javax.swing.JLabel lblEfternamn;
    private javax.swing.JLabel lblFornamn;
    private javax.swing.JLabel lblKundinfo;
    private javax.swing.JLabel lblLagerartikel;
    private javax.swing.JLabel lblNyOrder;
    private javax.swing.JLabel lblOrdernummer;
    private javax.swing.JLabel lblSpecialartikel;
    private javax.swing.JLabel lblSpecialartikelFarg;
    private javax.swing.JLabel lblSpecialartikelTyg;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JLabel lblVarOrderNummer;
    private javax.swing.JComboBox<String> standardHattCmb;
    private javax.swing.JComboBox<String> storlekCmb;
    private javax.swing.JTextField txtSpecialBenamning;
    private javax.swing.JTextField txtangivetAdress;
    private javax.swing.JTextField txtangivetEfternamn;
    private javax.swing.JTextField txtangivetFornamn;
    private javax.swing.JTextField txtangivetTelefonnummer;
    private javax.swing.JComboBox<String> tygCmb;
    // End of variables declaration//GEN-END:variables
}
