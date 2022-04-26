/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tall.inc;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
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
        seKlaraOrdrar();
    }

    public void fillEgnaHattarList() {

        String bestIdQuery = "SELECT DISTINCT BestID FROM orderrad where Orderrad.AnvandarID = " + anvandarID + " AND Orderrad.Hattstatus IS NULL";
        ArrayList<String> bestIDLista = SqlFragor.getEnKolumn(bestIdQuery);
        DefaultListModel model = new DefaultListModel();

        for (String bestID : bestIDLista) {
            model.addElement("<html><b><u>Order " + bestID + "<u><b><html>");

            listValdaHattar.setModel(model);
            String query = "SELECT Beskrivning FROM hatt inner join orderrad o on Hatt.HattID = o.HattID WHERE Hattstatus IS NULL AND o.Hattstatus IS NULL AND o.AnvandarID = " + anvandarID + " AND o.BestID = " + bestID + "";
            ArrayList<String> hattLista = SqlFragor.getEnKolumn(query);
            for (String hatt : hattLista) {
                model.addElement(hatt);
                listValdaHattar.setFont(listValdaHattar.getFont().deriveFont(Font.PLAIN));

                listValdaHattar.setModel(model);
            }
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

        String bestIdQuery = "SELECT DISTINCT bestID from orderrad where Orderrad.Hattstatus IS NULL AND Orderrad.AnvandarID IS NULL";
        ArrayList<String> bestIDLista = SqlFragor.getEnKolumn(bestIdQuery);
        DefaultListModel model = new DefaultListModel();
        for (String bestID : bestIDLista) {
            model.addElement("<html><b><u>Order " + bestID + "<u><b><html>");

            listAllaHattar.setModel(model);
            String query = "SELECT Beskrivning FROM Hatt inner join orderrad o on Hatt.HattID = o.HattID where BestID = " + bestID + " AND o.Hattstatus IS NULL AND o.AnvandarID IS NULL";
            ArrayList<String> hattLista = SqlFragor.getEnKolumn(query);
            for (String hatt : hattLista) {
                model.addElement(hatt);
                listAllaHattar.setFont(listAllaHattar.getFont().deriveFont(Font.PLAIN));
                listAllaHattar.setModel(model);
            }

        }

    }

    public static String getAnvandare() {
        String anvandare = anvandarnamn;
        return anvandare;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        lblValkommen = new javax.swing.JLabel();
        btnSkapaNyOrder = new javax.swing.JButton();
        btnLoggaUt = new javax.swing.JButton();
        btnSeOrderStatus = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        startHattBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listAllaHattar = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listValdaHattar = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        klarHattBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        antalBesLabel = new javax.swing.JLabel();
        btnSeListaMaterial = new javax.swing.JButton();
        hanteraBestallningBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnTEST = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menKundfrekvens = new javax.swing.JMenuItem();
        menMateriallista = new javax.swing.JMenuItem();
        menSkapaNyArtikel = new javax.swing.JMenu();
        menSokArtikel = new javax.swing.JMenu();

        jMenuItem6.setText("jMenuItem6");

        jMenuItem7.setText("jMenuItem7");

        jMenuItem8.setText("jMenuItem8");

        jMenuItem9.setText("jMenuItem9");

        jMenuItem10.setText("jMenuItem10");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem11.setText("jMenuItem11");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblValkommen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblValkommen.setText("Välkommen!");

        btnSkapaNyOrder.setText("Skapa ny beställning");
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

        btnSeOrderStatus.setText("Se beställningsstatus");
        btnSeOrderStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeOrderStatusActionPerformed(evt);
            }
        });

        jButton1.setText("Färdigställ beställning");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        startHattBtn.setText("Påbörja hatt tillverkning");
        startHattBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startHattBtnActionPerformed(evt);
            }
        });

        listAllaHattar.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Det finns inga hattar att tillverka" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listAllaHattar);

        listValdaHattar.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Du har inte valt någon hatt" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listValdaHattar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(listValdaHattar);

        jButton2.setText("Färg palette");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        klarHattBtn.setText("Tillverkning klar");
        klarHattBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klarHattBtnActionPerformed(evt);
            }
        });

        jButton3.setText("Färdigställ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        antalBesLabel.setText("0");

        btnSeListaMaterial.setText("Se lista material");
        btnSeListaMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeListaMaterialActionPerformed(evt);
            }
        });

        hanteraBestallningBtn.setText("Hantera beställning");
        hanteraBestallningBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hanteraBestallningBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Du har ");

        jLabel2.setText("ordrar klara för färdigställning");

        btnTEST.setText("TEST");
        btnTEST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTESTActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ändra");

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

        menKundfrekvens.setText("Kundfrekvens");
        menKundfrekvens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menKundfrekvensActionPerformed(evt);
            }
        });
        jMenu3.add(menKundfrekvens);

        menMateriallista.setText("Materiallista");
        menMateriallista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menMateriallistaActionPerformed(evt);
            }
        });
        jMenu3.add(menMateriallista);

        jMenuBar1.add(jMenu3);

        menSkapaNyArtikel.setText("Skapa ny artikel");
        menSkapaNyArtikel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menSkapaNyArtikelMouseClicked(evt);
            }
        });
        jMenuBar1.add(menSkapaNyArtikel);

        menSokArtikel.setText("Sök artikel");
        menSokArtikel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menSokArtikelMouseClicked(evt);
            }
        });
        jMenuBar1.add(menSokArtikel);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblValkommen)
                .addGap(406, 406, 406))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSeListaMaterial)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSeOrderStatus)
                            .addComponent(btnSkapaNyOrder)
                            .addComponent(btnTEST))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(antalBesLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addComponent(jButton3))
                        .addGap(74, 74, 74))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hanteraBestallningBtn)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(316, 316, 316)
                                .addComponent(startHattBtn)
                                .addGap(168, 168, 168)
                                .addComponent(klarHattBtn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLoggaUt)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(lblValkommen)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(klarHattBtn)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(antalBesLabel)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(32, 32, 32)
                                .addComponent(jButton3)
                                .addGap(304, 304, 304)
                                .addComponent(btnLoggaUt))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(startHattBtn))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(hanteraBestallningBtn)
                .addGap(18, 18, 18)
                .addComponent(btnSeListaMaterial)
                .addGap(16, 16, 16)
                .addComponent(btnSkapaNyOrder)
                .addGap(18, 18, 18)
                .addComponent(btnSeOrderStatus)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(26, 26, 26)
                .addComponent(btnTEST)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoggaUtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaUtActionPerformed
        // TODO add your handling code here:
        new Inloggningssida().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLoggaUtActionPerformed


    private void btnSkapaNyOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaNyOrderActionPerformed
        // TODO add your handling code here:
        dispose();
        new SkapaNyOrder().setVisible(true);
    }//GEN-LAST:event_btnSkapaNyOrderActionPerformed

    private void btnSeOrderStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeOrderStatusActionPerformed
        new SeOrderStatus().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSeOrderStatusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new FardigStallBeställning().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void startHattBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startHattBtnActionPerformed
        // TODO add your handling code here:
        String bestIdQuery = "SELECT DISTINCT bestID from orderrad where Orderrad.Hattstatus IS NULL AND Orderrad.AnvandarID IS NULL";
        ArrayList<String> bestIDLista = SqlFragor.getEnKolumn(bestIdQuery);
        if (bestIDLista.isEmpty()) {
            dispose();
            new Startsida().setVisible(true);
        } else if (!bestIDLista.isEmpty()) {
            List<String> hattar = listAllaHattar.getSelectedValuesList();
            for (String hatt : hattar) {
                String hattIdQuery = "SELECT hattID FROM hatt where beskrivning = '" + hatt + "'";
                String hattID = SqlFragor.getEttVarde(hattIdQuery);

                String radIdQuery = "SELECT DISTINCT radID FROM orderrad inner join hatt h on Orderrad.HattID = h.HattID\n"
                        + "WHERE h.HattID = '" + hattID + "' AND orderrad.anvandarID IS NULL LIMIT 1";
                String radID = SqlFragor.getEttVarde(radIdQuery);
                String updateQuery = "UPDATE Orderrad SET anvandarID = '" + anvandarID + "' where hattID = '" + hattID + "' AND radID = '" + radID + "'";
                SqlFragor.uppdatera(updateQuery);
                fillOppenHattTbl();
            }
            fillEgnaHattarList();
        }


    }//GEN-LAST:event_startHattBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new FargPalette().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void seKlaraOrdrar() {

        String hattListaQuery = "SELECT DISTINCT bestID FROM orderrad;";
        ArrayList<String> hattLista = SqlFragor.getEnKolumn(hattListaQuery);
        int i = 0;
        for (String hatt : hattLista) {

            String inteKlaraQuery = "SELECT hattID FROM orderrad\n"
                    + "where BestID = '" + hatt + "' AND Hattstatus is null;";
            ArrayList<String> inteKlaraHattLista = SqlFragor.getEnKolumn(inteKlaraQuery);

            if (inteKlaraHattLista.isEmpty()) {
                i++;
                antalBesLabel.setText(String.valueOf(i));

            }
        }

    }

    private void klarHattBtn() {
        String valdHatt = listValdaHattar.getSelectedValue();
        String radIdQuery = "SELECT DISTINCT o.RadID from Hatt\n"
                + "                join orderrad o on Hatt.HattID = o.HattID\n"
                + "                where Beskrivning like '" + valdHatt + "' AND Hattstatus is null ORDER BY RadID LIMIT 1;";
        String radID = SqlFragor.getEttVarde(radIdQuery);
        if (radID == null) {
            dispose();
            new Startsida().setVisible(true);
        } else if (radID != null) {
            String updateStatusQuery = "update Orderrad\n"
                    + "set orderrad.Hattstatus = 'Klar' where RadID = '" + radID + "'";
            SqlFragor.uppdatera(updateStatusQuery);
            ///

            seKlaraOrdrar();
            fillEgnaHattarList();
        }
    }
    private void klarHattBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_klarHattBtnActionPerformed
        // TODO add your handling code here:
        klarHattBtn();
        fillOppenHattTbl();

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

    private void menSokArtikelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menSokArtikelMouseClicked
        new SokHatt().setVisible(true);
    }//GEN-LAST:event_menSokArtikelMouseClicked

    private void menSkapaNyArtikelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menSkapaNyArtikelMouseClicked
        new LaggTillHatt().setVisible(true);
    }//GEN-LAST:event_menSkapaNyArtikelMouseClicked

    private void menKundfrekvensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menKundfrekvensActionPerformed
        new Kundfrekvens().setVisible(true);
        dispose();
    }//GEN-LAST:event_menKundfrekvensActionPerformed

    private void menMateriallistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menMateriallistaActionPerformed
        PDFUtskrift pdf = new PDFUtskrift();
        pdf.nyPDF();
        pdf.visaPDF();
    }//GEN-LAST:event_menMateriallistaActionPerformed

    private void btnTESTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTESTActionPerformed
        new HamtaHattRitning().setVisible(true);
    }//GEN-LAST:event_btnTESTActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new FardigstallBestallning().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel antalBesLabel;
    private javax.swing.JButton btnLoggaUt;
    private javax.swing.JButton btnSeListaMaterial;
    private javax.swing.JButton btnSeOrderStatus;
    private javax.swing.JButton btnSkapaNyOrder;
    private javax.swing.JButton btnTEST;
    private javax.swing.JButton hanteraBestallningBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton klarHattBtn;
    private javax.swing.JLabel lblValkommen;
    private javax.swing.JList<String> listAllaHattar;
    private javax.swing.JList<String> listValdaHattar;
    private javax.swing.JMenuItem menKundfrekvens;
    private javax.swing.JMenuItem menMateriallista;
    private javax.swing.JMenu menSkapaNyArtikel;
    private javax.swing.JMenu menSokArtikel;
    private javax.swing.JButton startHattBtn;
    // End of variables declaration//GEN-END:variables
}
