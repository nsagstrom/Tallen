/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tall.inc;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

/**
 *
 * @author nsags
 */
public class MomsRapport extends javax.swing.JFrame {

    public static final String xmlFilePath = "momsDeklaration.xml";
    
    

    /**
     * Creates new form MomsRapport
     */
    public MomsRapport() {
        initComponents();
    }

    
    private void berakningUt(){
        
        int forsalj = Integer.parseInt(txtForsalj.getText());
        int utMoms = Integer.parseInt(txtUtMoms.getText());
        int inMoms = Integer.parseInt(txtInMoms.getText());
        int betala;
        
       int ututmoms = (int) (forsalj*0.25);
        
        betala = utMoms - inMoms;
        
        txtUtMoms.setText(String.valueOf(ututmoms));
    }
    
    private void betala(){
                int forsalj = Integer.parseInt(txtForsalj.getText());
        int utMoms = Integer.parseInt(txtUtMoms.getText());
        int inMoms = Integer.parseInt(txtInMoms.getText());
        int betala;
        
        utMoms = (int) (forsalj*0.25);
        
        betala = utMoms - inMoms;
        
        txtBetala.setText(String.valueOf(betala));
    }
    
    

    private void momsRapport() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        factory.setValidating(true);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

        Document doc = builder.newDocument();
        //Create doc type
        DOMImplementation domImpl = doc.getImplementation();
        DocumentType doctype = domImpl.createDocumentType("eSKDUpload",
                "-//Skatteverket, Sweden//DTD Skatteverket eSKDUpload-DTD Version 6.0//SV",
                "https://www1.skatteverket.se/demoeskd/eSKDUpload_6p0.dtd");

//        doc.appendChild(doctype);
        // Add root element
        Element rootElement = doc.createElement("eSKDUpload");
        doc.appendChild(rootElement);

        Attr attr = doc.createAttribute("Version");
        attr.setValue("6.0");
        rootElement.setAttributeNode(attr);

        Element orgnummer = doc.createElement("OrgNr");
        orgnummer.appendChild(doc.createTextNode("599900-0465"));
        rootElement.appendChild(orgnummer);

        Element moms = doc.createElement("Moms");
        rootElement.appendChild(moms);

        Element period = doc.createElement("Period");
        period.appendChild(doc.createTextNode("202202"));
        moms.appendChild(period);

        Element forsmomsejannan = doc.createElement("ForsMomsEjAnnan");
        forsmomsejannan.appendChild(doc.createTextNode(txtForsalj.getText()));
        moms.appendChild(forsmomsejannan);

//        Element uttagmoms = doc.createElement("UttagMoms");
//        uttagmoms.appendChild(doc.createTextNode("0"));
//        moms.appendChild(uttagmoms);
//
//        Element ulagmargbesk = doc.createElement("UlagMargbesk");
//        ulagmargbesk.appendChild(doc.createTextNode("0"));
//        moms.appendChild(ulagmargbesk);
//
//        Element hyrinkomstfriv = doc.createElement("HyrinkomstFriv");
//        hyrinkomstfriv.appendChild(doc.createTextNode("0"));
//        moms.appendChild(hyrinkomstfriv);
//
//        Element inkopvaruannateg = doc.createElement("InkopVaruAnnatEg");
//        inkopvaruannateg.appendChild(doc.createTextNode("0"));
//        moms.appendChild(inkopvaruannateg);
//
//        Element inkoptjanstannateg = doc.createElement("InkopTjanstAnnatEg");
//        inkoptjanstannateg.appendChild(doc.createTextNode("0"));
//        moms.appendChild(inkoptjanstannateg);
//
//        Element inkoptjanstutomeg = doc.createElement("InkopTjanstUtomEg");
//        inkoptjanstutomeg.appendChild(doc.createTextNode("0"));
//        moms.appendChild(inkoptjanstutomeg);
//
//        Element inkopvarusverige = doc.createElement("InkopVaruSverige");
//        inkopvarusverige.appendChild(doc.createTextNode("0"));
//        moms.appendChild(inkopvarusverige);
//
//        Element inkoptjanstsverige = doc.createElement("InkopTjanstSverige");
//        inkoptjanstsverige.appendChild(doc.createTextNode("0"));
//        moms.appendChild(inkoptjanstsverige);
//
//        Element momsulagimport = doc.createElement("MomsUlagImport");
//        momsulagimport.appendChild(doc.createTextNode("0"));
//        moms.appendChild(momsulagimport);
//
//        Element forsvaruannateg = doc.createElement("ForsVaruAnnatEg");
//        forsvaruannateg.appendChild(doc.createTextNode("0"));
//        moms.appendChild(forsvaruannateg);

        Element forsvaruutomeg = doc.createElement("ForsVaruUtomEg");
        forsvaruutomeg.appendChild(doc.createTextNode(txtForsaljEU.getText()));
        moms.appendChild(forsvaruutomeg);
//
//        Element inkopvarumellan3p = doc.createElement("InkopVaruMellan3p");
//        inkopvarumellan3p.appendChild(doc.createTextNode("0"));
//        moms.appendChild(inkopvarumellan3p);
//
//        Element forsvarumellan3p = doc.createElement("ForsVaruMellan3p");
//        forsvarumellan3p.appendChild(doc.createTextNode("0"));
//        moms.appendChild(forsvarumellan3p);
//
//        Element forstjskskannateg = doc.createElement("ForsTjSkskAnnatEg");
//        forstjskskannateg.appendChild(doc.createTextNode("0"));
//        moms.appendChild(forstjskskannateg);
//
//        Element forstjovrutomeg = doc.createElement("ForsTjOvrUtomEg");
//        forstjovrutomeg.appendChild(doc.createTextNode("0"));
//        moms.appendChild(forstjovrutomeg);
//
//        Element forskoparesksksverige = doc.createElement("ForsKopareSkskSverige");
//        forskoparesksksverige.appendChild(doc.createTextNode("0"));
//        moms.appendChild(forskoparesksksverige);
//
//        Element forsovrigt = doc.createElement("ForsOvrigt");
//        forsovrigt.appendChild(doc.createTextNode("0"));
//        moms.appendChild(forsovrigt);
//
        Element momsutghog = doc.createElement("MomsUtgHog");
        momsutghog.appendChild(doc.createTextNode(txtUtMoms.getText()));
        moms.appendChild(momsutghog);
//
//        Element momsutgmedel = doc.createElement("MomsUtgMedel");
//        momsutgmedel.appendChild(doc.createTextNode("0"));
//        moms.appendChild(momsutgmedel);
//
//        Element momsutglag = doc.createElement("MomsUtgLag");
//        momsutglag.appendChild(doc.createTextNode("0"));
//        moms.appendChild(momsutglag);
//
//        Element momsinkoputghog = doc.createElement("MomsInkopUtgHog");
//        momsinkoputghog.appendChild(doc.createTextNode("0"));
//        moms.appendChild(momsinkoputghog);
//
//        Element momsinkoputgmedel = doc.createElement("MomsInkopUtgMedel");
//        momsinkoputgmedel.appendChild(doc.createTextNode("0"));
//        moms.appendChild(momsinkoputgmedel);
//
//        Element momsinkoputglag = doc.createElement("MomsInkopUtgLag");
//        momsinkoputglag.appendChild(doc.createTextNode("0"));
//        moms.appendChild(momsinkoputglag);
//
//        Element momsimportutghog = doc.createElement("MomsImportUtgHog");
//        momsimportutghog.appendChild(doc.createTextNode("0"));
//        moms.appendChild(momsimportutghog);
//
//        Element momsimportutgmedel = doc.createElement("MomsImportUtgMedel");
//        momsimportutgmedel.appendChild(doc.createTextNode("0"));
//        moms.appendChild(momsimportutgmedel);
//
//        Element momsimportutglag = doc.createElement("MomsImportUtgLag");
//        momsimportutglag.appendChild(doc.createTextNode("0"));
//        moms.appendChild(momsimportutglag);

        Element momsingavdr = doc.createElement("MomsIngAvdr");
        momsingavdr.appendChild(doc.createTextNode(txtInMoms.getText()));
        moms.appendChild(momsingavdr);

        Element momsbetala = doc.createElement("MomsBetala");
        momsbetala.appendChild(doc.createTextNode(txtBetala.getText()));
        moms.appendChild(momsbetala);

        Element textupplysningmoms = doc.createElement("TextUpplysningMoms");
        textupplysningmoms.appendChild(doc.createTextNode("Bla bla bla bla"));
        moms.appendChild(textupplysningmoms);

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, doctype.getPublicId());
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());

        DOMSource domSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(new File(xmlFilePath));
        transformer.transform(domSource, streamResult);

        System.out.println("Done creating XML File");

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUtMoms = new javax.swing.JTextField();
        txtForsaljEU = new javax.swing.JTextField();
        txtForsalj = new javax.swing.JTextField();
        txtInMoms = new javax.swing.JTextField();
        txtBetala = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtForsalj.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtForsaljCaretUpdate(evt);
            }
        });

        txtInMoms.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtInMomsCaretUpdate(evt);
            }
        });

        txtBetala.setEditable(false);

        jButton1.setText("Skapa deklaration");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Momspliktig försäljning");

        jLabel2.setText("Utgående moms på försäljning");

        jLabel3.setText("Försäljning utanför EU");

        jLabel4.setText("Ingående moms");

        jLabel5.setText("Moms att betala eller få tillbaka");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtForsalj, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtForsaljEU, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtUtMoms, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInMoms, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBetala, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtForsalj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtUtMoms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtForsaljEU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtInMoms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBetala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            momsRapport();
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(MomsRapport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtForsaljCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtForsaljCaretUpdate
        berakningUt();
    }//GEN-LAST:event_txtForsaljCaretUpdate

    private void txtInMomsCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtInMomsCaretUpdate
        betala();
    }//GEN-LAST:event_txtInMomsCaretUpdate

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
            java.util.logging.Logger.getLogger(MomsRapport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MomsRapport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MomsRapport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MomsRapport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MomsRapport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtBetala;
    private javax.swing.JTextField txtForsalj;
    private javax.swing.JTextField txtForsaljEU;
    private javax.swing.JTextField txtInMoms;
    private javax.swing.JTextField txtUtMoms;
    // End of variables declaration//GEN-END:variables
}
