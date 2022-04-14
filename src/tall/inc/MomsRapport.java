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

    public static final String xmlFilePath = "C:\\Users\\nsags\\OneDrive\\Skrivbord\\New folder\\momsDeklaration.xml";

    /**
     * Creates new form MomsRapport
     */
    public MomsRapport() {
        initComponents();
    }

    public static void rapport() {

        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            DOMImplementation domImpl = document.getImplementation();
            DocumentType doctype = domImpl.createDocumentType("eSKDUpload", "-//Skatteverket, Sweden//DTD Skatteverket eSKDUpload-DTD Version 6.0//SV", "https://www1.skatteverket.se/demoeskd/eSKDUpload_6p0.dtd");

            document.appendChild(doctype);

            // root element
            Element root = document.createElement("company");
            document.appendChild(root);

            // employee element
            Element employee = document.createElement("employee");

            root.appendChild(employee);

            // set an attribute to staff element
            Attr attr = document.createAttribute("id");
            attr.setValue("10");
            employee.setAttributeNode(attr);

            //you can also use staff.setAttribute("id", "1") for this
            // firstname element
            Element firstName = document.createElement("firstname");
            firstName.appendChild(document.createTextNode("James"));
            employee.appendChild(firstName);

            // lastname element
            Element lastname = document.createElement("lastname");
            lastname.appendChild(document.createTextNode("Harley"));
            employee.appendChild(lastname);

            // email element
            Element email = document.createElement("email");
            email.appendChild(document.createTextNode("james@example.org"));
            employee.appendChild(email);

            // department elements
            Element department = document.createElement("department");
            department.appendChild(document.createTextNode("Human Resources"));
            employee.appendChild(department);

            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging 
            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");

        } catch (ParserConfigurationException | TransformerException pce) {
        }
    }

    private void rapport2() throws ParserConfigurationException, TransformerException {
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
        forsmomsejannan.appendChild(doc.createTextNode("40000"));
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
        forsvaruutomeg.appendChild(doc.createTextNode("0"));
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
//        Element momsutghog = doc.createElement("MomsUtgHog");
//        momsutghog.appendChild(doc.createTextNode("10000"));
//        moms.appendChild(momsutghog);
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
        momsingavdr.appendChild(doc.createTextNode("5000"));
        moms.appendChild(momsingavdr);

        Element momsbetala = doc.createElement("MomsBetala");
        momsbetala.appendChild(doc.createTextNode("5000"));
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

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField1");

        jTextField3.setText("jTextField1");

        jTextField4.setText("jTextField1");

        jTextField5.setText("jTextField1");

        jButton1.setText("Skapa deklaration");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(344, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jButton1)
                .addGap(66, 66, 66)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            rapport2();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MomsRapport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(MomsRapport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
