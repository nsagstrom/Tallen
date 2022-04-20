/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tall.inc;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.table.DefaultTableModel;
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
        fillOppenHattTbl();
        fillEgnaHattarList();
    }

    public void fillEgnaHattarList() {
        String query = "Select Beskrivning from Hatt\n"
                + "join Orderrad O on Hatt.HattID = O.HattID\n"
                + "join mibdb.Bestallning B on O.BestID = B.BestID\n"
                + "where O.AnvandarID = '" + anvandarID + "'";
        ArrayList<String> hattLista = SqlFragor.getEnKolumn(query);
        DefaultListModel model = new DefaultListModel();
        for (String hatt : hattLista) {
            model.addElement(hatt);

            listValdaHattar.setModel(model);
        }

    }

    public void fillOppenHattTbl() {
        listAllaHattar.setSelectionModel(new DefaultListSelectionModel() {
            public void setSelectionInterval(int index0, int index1) {
                if (isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);
                } else {
                    super.addSelectionInterval(index0, index1);
                }
            }
        });
        String query = "Select Beskrivning from Hatt\n"
                + "join Orderrad O on Hatt.HattID = O.HattID\n"
                + "join mibdb.Bestallning B on O.BestID = B.BestID\n"
                + "where O.AnvandarID is null";
        System.out.println(query);
        ArrayList<String> hattLista = SqlFragor.getEnKolumn(query);
        DefaultListModel model = new DefaultListModel();
        for (String hatt : hattLista) {
            model.addElement(hatt);

            listAllaHattar.setModel(model);
        }

    }

    public static String getAnvandare() {
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
        jButton1 = new javax.swing.JButton();
        btnKundUppgift = new javax.swing.JButton();
        startHattBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listAllaHattar = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listValdaHattar = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        btnPrisHatt = new javax.swing.JButton();
        btnMoms = new javax.swing.JButton();
        klarHattBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        antalBesLabel = new javax.swing.JLabel();
        btnSeListaMaterial = new javax.swing.JButton();
        hanteraBestallningBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

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
        btnSokArtikel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokArtikelActionPerformed(evt);
            }
        });

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

        jButton1.setText("F�rdigst�ll order");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnKundUppgift.setText("�ndra kunduppgifter");
        btnKundUppgift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKundUppgiftActionPerformed(evt);
            }
        });

        startHattBtn.setText("P�b�rja hatt tillverkning");
        startHattBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startHattBtnActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listAllaHattar);

        jScrollPane3.setViewportView(listValdaHattar);

        jButton2.setText("F�rg palette");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnPrisHatt.setText("�ndra pris standardhatt");
        btnPrisHatt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrisHattActionPerformed(evt);
            }
        });

        btnMoms.setText("Momsrapport");
        btnMoms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMomsActionPerformed(evt);
            }
        });

        klarHattBtn.setText("Tillverkning klar");
        klarHattBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klarHattBtnActionPerformed(evt);
            }
        });

        jButton3.setText("Klara f�r f�rdigst�llning");

        antalBesLabel.setText("0");

        btnSeListaMaterial.setText("Se lista material");
        btnSeListaMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeListaMaterialActionPerformed(evt);
            }
        });

        hanteraBestallningBtn.setText("Hantera best�llning");
        hanteraBestallningBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hanteraBestallningBtnActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("�ndra");

        jMenuItem2.setText("Kunduppgifter");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Pris specialhatt");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Pris standardhatt");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Rapporter");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItem1.setText("Momsrapport");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem5.setText("Statistik");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAndraPris))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMoms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSeListaMaterial)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnKundUppgift, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSokArtikel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSkapaNyArtikel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(hanteraBestallningBtn)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPrisHatt, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(klarHattBtn)
                .addGap(148, 148, 148)
                .addComponent(startHattBtn)
                .addGap(36, 36, 36)
                .addComponent(btnLoggaUt)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblValkommen)
                .addGap(406, 406, 406))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(btnSeOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(btnSkapaNyOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(348, 348, 348))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(antalBesLabel)
                        .addGap(38, 38, 38)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValkommen)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnLoggaUt)
                                    .addComponent(startHattBtn)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(klarHattBtn))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(hanteraBestallningBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeListaMaterial)
                        .addGap(18, 18, 18)
                        .addComponent(btnSkapaNyArtikel)
                        .addGap(18, 18, 18)
                        .addComponent(btnKundUppgift)
                        .addGap(18, 18, 18)
                        .addComponent(btnSokArtikel)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(antalBesLabel))
                        .addGap(1, 1, 1)
                        .addComponent(btnSkapaNyOrder)
                        .addGap(18, 18, 18)
                        .addComponent(btnSeOrderStatus)
                        .addGap(18, 18, 18)
                        .addComponent(btnAndraPris)
                        .addGap(29, 29, 29)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrisHatt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMoms)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoggaUtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaUtActionPerformed
        // TODO add your handling code here:
        new Inloggningssida().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLoggaUtActionPerformed

    private void btnSkapaNyArtikelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaNyArtikelActionPerformed
        new LaggTillHatt().setVisible(true);
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

    private void btnSokArtikelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokArtikelActionPerformed
        // TODO add your handling code here:
        new SokHatt().setVisible(true);
    }//GEN-LAST:event_btnSokArtikelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new FardigStallBest�llning().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnKundUppgiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKundUppgiftActionPerformed
        new AndraUppgifterKund().setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKundUppgiftActionPerformed

    private void startHattBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startHattBtnActionPerformed
        // TODO add your handling code here:

        List<String> hattar = listAllaHattar.getSelectedValuesList();
        for (String hatt : hattar) {
            String hattIdQuery = "SELECT hattID FROM Hatt WHERE beskrivning = '" + hatt + "'";
            String hattID = SqlFragor.getEttVarde(hattIdQuery);
            String updateQuery = "UPDATE Orderrad SET anvandarID = '" + anvandarID + "' where hattID = '" + hattID + "'";
            SqlFragor.uppdatera(updateQuery);
            fillOppenHattTbl();
        }
        fillEgnaHattarList();


    }//GEN-LAST:event_startHattBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new FargPalette().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnPrisHattActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrisHattActionPerformed

        // TODO add your handling code here:
        new AndraPrisStandardHatt().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnPrisHattActionPerformed

    private void btnMomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMomsActionPerformed
        new MomsRapport().setVisible(true);
        dispose();

    }//GEN-LAST:event_btnMomsActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new MomsRapport().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new AndraPrisStandardHatt().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new SattPrisSpecial().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new AndraUppgifterKund().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new BestallStatistik().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void klarHattBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_klarHattBtnActionPerformed
        // TODO add your handling code here:
        String valdHatt = listValdaHattar.getSelectedValue();
        String hattIdQuery = "SELECT hattID FROM hatt WHERE beskrivning = '" + valdHatt + "'";
        String hattID = SqlFragor.getEttVarde(hattIdQuery);
        String insertStatusQuery = "INSERT INTO orderrad (Hattstatus) VALUES ('Klar') WHERE HattID = '" + hattID + "'";
        SqlFragor.addToDatabasen(insertStatusQuery);
        ///
        String hattStatusQuery = "SELECT Hattstatus FROM orderrad WHERE hattID = '" + hattID + "'";
        ArrayList<String> hattStatusLista = SqlFragor.getEnKolumn(hattStatusQuery);
        int i = 0;
        int antalKlara = 0;
        for (String status : hattStatusLista) {
            if (status.equals("Klar")) {
                i++;
            }

        }
        if (i == hattStatusLista.size()) {

            antalKlara++;
            antalBesLabel.setText(String.valueOf(antalKlara));

        }


    }//GEN-LAST:event_klarHattBtnActionPerformed

    private void btnSeListaMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeListaMaterialActionPerformed
        // TODO add your handling code here:
        new SeListaMaterial().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSeListaMaterialActionPerformed

    private void hanteraBestallningBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hanteraBestallningBtnActionPerformed
        // TODO add your handling code here:
        new HanteraBestallning().setVisible(true);
        dispose();
    }//GEN-LAST:event_hanteraBestallningBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel antalBesLabel;
    private javax.swing.JButton btnAndraPris;
    private javax.swing.JButton btnKundUppgift;
    private javax.swing.JButton btnLoggaUt;
    private javax.swing.JButton btnMoms;
    private javax.swing.JButton btnPrisHatt;
    private javax.swing.JButton btnSeListaMaterial;
    private javax.swing.JButton btnSeOrderStatus;
    private javax.swing.JButton btnSkapaNyArtikel;
    private javax.swing.JButton btnSkapaNyOrder;
    private javax.swing.JButton btnSokArtikel;
    private javax.swing.JButton hanteraBestallningBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton klarHattBtn;
    private javax.swing.JLabel lblValkommen;
    private javax.swing.JList<String> listAllaHattar;
    private javax.swing.JList<String> listValdaHattar;
    private javax.swing.JButton startHattBtn;
    // End of variables declaration//GEN-END:variables
}
