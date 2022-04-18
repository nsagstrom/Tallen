/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tall.inc;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.YearMonth;
import java.util.Date;
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

    int momspforsalj;
    int export;
    int utgaendeMoms;
    int attbetala;
    int inMoms;
    String perioden;

    /**
     * Creates new form MomsRapport
     */
    public MomsRapport() {
        initComponents();
        lblSkapad.setVisible(false);
    }

    private void attBetala() {

        if (ValideringsKlass.taltest(txtInMoms)) {
            inMoms = Integer.parseInt(txtInMoms.getText());

            attbetala = utgaendeMoms - inMoms;

            txtBetala.setText(String.valueOf(attbetala));

        }
    }

    private void varden() {
        String stardate = "";
        String slutdate = "";
         
        int valdManad = txtmonth.getMonth() + 1;
        YearMonth yearMonth = YearMonth.of(txtyear.getValue(), Month.of(valdManad));

        String manadSlut = yearMonth.toString()+"-"+yearMonth.lengthOfMonth();
        String formatManad = String.format("%02d", valdManad);
        
        perioden = txtyear.getValue()+formatManad;
        
        String manadStart  = String.valueOf(yearMonth);
        
        stardate = manadStart+"-01";
        slutdate = manadSlut;
        

//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date start = dateStart.getDate();
//
//        Date slut = dateEnd.getDate();

//        stardate = dateFormat.format(start);
//        slutdate = dateFormat.format(slut);
        
        
        // momspliktig försäljning 
        String fragaForsaljMoms = """
                                  SELECT pris FROM (
                                  SELECT SUM(pris) AS pris , LevDatum
                                  FROM bestallning
                                  JOIN kund k on k.KundID = bestallning.KundID
                                  JOIN orderrad o on bestallning.BestID = o.BestID
                                  JOIN hatt h on o.HattID = h.HattID
                                  JOIN anvandare a on a.AnvandarID = bestallning.AnvandareID
                                  WHERE Status = 'St\u00e4ngd' AND Prio = 0 AND TullID= 'Saknas') t2
                                  WHERE LevDatum BETWEEN '""" + stardate + "' AND '" + slutdate + "';";

        String forsaljMoms = SqlFragor.getEttVarde(fragaForsaljMoms);

        // Momspliktig sörsäljning med ett 20% + För prio
        String fragaForsaljMomsPrio = """
                                      SELECT pris FROM (
                                      SELECT  FLOOR(SUM(pris)*1.2) AS pris , LevDatum, TullID
                                      FROM bestallning
                                      JOIN kund k on k.KundID = bestallning.KundID
                                      JOIN orderrad o on bestallning.BestID = o.BestID
                                      JOIN hatt h on o.HattID = h.HattID
                                      JOIN anvandare a on a.AnvandarID = bestallning.AnvandareID
                                      WHERE Status = 'St\u00e4ngd' AND Prio = 1 AND TullID= 'Saknas') t2
                                      WHERE LevDatum BETWEEN '""" + stardate + "' AND '" + slutdate + "';";

        String forsaljMomsPrio = SqlFragor.getEttVarde(fragaForsaljMomsPrio);

        // försäljning på export 
        String fragaForsaljExport = """
                                    SELECT pris FROM (
                                    SELECT  SUM(pris) AS pris , LevDatum, TullID
                                    FROM bestallning
                                    JOIN kund k on k.KundID = bestallning.KundID
                                    JOIN orderrad o on bestallning.BestID = o.BestID
                                    JOIN hatt h on o.HattID = h.HattID
                                    JOIN anvandare a on a.AnvandarID = bestallning.AnvandareID
                                    WHERE Status = 'St\u00e4ngd' AND Prio = 0 AND TullID != 'Saknas') t2
                                    WHERE LevDatum BETWEEN '""" + stardate + "' AND '" + slutdate + "';";

        String forsaljMomsExport = SqlFragor.getEttVarde(fragaForsaljExport);

        // forsäljning export prio
        String fragaForsaljExportPrio = """
                                        SELECT pris FROM (
                                        SELECT  FLOOR(SUM(pris)*1.2) AS pris , LevDatum, TullID
                                        FROM bestallning
                                        JOIN kund k on k.KundID = bestallning.KundID
                                        JOIN orderrad o on bestallning.BestID = o.BestID
                                        JOIN hatt h on o.HattID = h.HattID
                                        JOIN anvandare a on a.AnvandarID = bestallning.AnvandareID
                                        WHERE Status = 'St\u00e4ngd' AND Prio = 1 AND TullID != 'Saknas') t2
                                        WHERE LevDatum BETWEEN '""" + stardate + "' AND '" + slutdate + "';";

        String forsaljExportPrio = SqlFragor.getEttVarde(fragaForsaljExportPrio);

        int momsForsalj = 0;
        int prioMomsForsalj = 0;
        int exportMomsForsalj = 0;
        int prioExportForsalj = 0;

        if (forsaljMoms != null) {
            momsForsalj = Integer.parseInt(forsaljMoms);
        }

        if (forsaljMomsPrio != null) {
            prioMomsForsalj = Integer.parseInt(forsaljMomsPrio);
        }

        if (forsaljMomsExport != null) {
            exportMomsForsalj = Integer.parseInt(forsaljMomsExport);

        }
        if (forsaljExportPrio != null) {
            prioExportForsalj = Integer.parseInt(forsaljExportPrio);

        }

//        inMoms = Integer.parseInt(txtInMoms.getText());
        momspforsalj = momsForsalj + prioMomsForsalj;
        export = exportMomsForsalj + prioExportForsalj;
        utgaendeMoms = (int) (momspforsalj * 0.25);
        attbetala = utgaendeMoms - inMoms;

        String momsforsaljforsalj = String.valueOf(momspforsalj);
        String exportexport = String.valueOf(export);
        String ututgaende = String.valueOf(utgaendeMoms);
        String attattbetala = String.valueOf(attbetala);

        txtForsalj.setText(momsforsaljforsalj);
        txtForsaljEU.setText(exportexport);
        txtUtMoms.setText(ututgaende);
        txtBetala.setText(attattbetala);
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
        period.appendChild(doc.createTextNode(perioden));
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
        textupplysningmoms.appendChild(doc.createTextNode(txtOvrigUpplys.getText()));
        moms.appendChild(textupplysningmoms);

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, doctype.getPublicId());
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());

        DOMSource domSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(new File("momsDeklaration"+perioden+".xml"));
        transformer.transform(domSource, streamResult);

        System.out.println("Done creating XML File");

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        txtUtMoms = new javax.swing.JTextField();
        txtForsaljEU = new javax.swing.JTextField();
        txtForsalj = new javax.swing.JTextField();
        txtInMoms = new javax.swing.JTextField();
        txtBetala = new javax.swing.JTextField();
        btnSkapaRapport = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dateStart = new com.toedter.calendar.JDateChooser();
        dateEnd = new com.toedter.calendar.JDateChooser();
        btnSok = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOvrigUpplys = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        lblSkapad = new javax.swing.JLabel();
        btnTillbaka = new javax.swing.JButton();
        txtmonth = new com.toedter.calendar.JMonthChooser();
        txtyear = new com.toedter.calendar.JYearChooser();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtUtMoms.setEditable(false);

        txtForsaljEU.setEditable(false);

        txtForsalj.setEditable(false);

        txtInMoms.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtInMomsCaretUpdate(evt);
            }
        });
        txtInMoms.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtInMomsFocusLost(evt);
            }
        });

        txtBetala.setEditable(false);

        btnSkapaRapport.setText("Skapa deklaration");
        btnSkapaRapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaRapportActionPerformed(evt);
            }
        });

        jLabel1.setText("Momspliktig försäljning");

        jLabel2.setText("Utgående moms på försäljning");

        jLabel3.setText("Försäljning utanför EU");

        jLabel4.setText("Ingående moms");

        jLabel5.setText("Moms att betala eller få tillbaka");

        dateStart.setDateFormatString("yyyy-MM-dd");
        dateStart.setOpaque(false);

        dateEnd.setDateFormatString("yyyy-MM-dd");

        btnSok.setText("Sök");
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });

        txtOvrigUpplys.setColumns(20);
        txtOvrigUpplys.setRows(5);
        jScrollPane1.setViewportView(txtOvrigUpplys);

        jLabel6.setText("Överig upplysning till Skatteverket ");

        lblSkapad.setText("Deklaration skapad");

        btnTillbaka.setText("Tillbaka ");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        txtmonth.setAutoscrolls(true);
        txtmonth.setMonth(1);
        txtmonth.setYearChooser(txtyear);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtForsalj, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtForsaljEU, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(txtyear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29)
                        .addComponent(txtmonth, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(txtUtMoms, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtInMoms, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBetala, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSkapad)
                            .addComponent(btnSkapaRapport)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnTillbaka, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addComponent(btnSok, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel5))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnTillbaka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtyear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmonth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSok)
                            .addComponent(dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtForsalj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtForsaljEU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtUtMoms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtInMoms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBetala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(btnSkapaRapport)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSkapad)))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSkapaRapportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaRapportActionPerformed
        try {
            momsRapport();
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(MomsRapport.class.getName()).log(Level.SEVERE, null, ex);
        }

        lblSkapad.setVisible(true);
    }//GEN-LAST:event_btnSkapaRapportActionPerformed

    private void txtInMomsCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtInMomsCaretUpdate
        attBetala();
    }//GEN-LAST:event_txtInMomsCaretUpdate

    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
        varden();
    }//GEN-LAST:event_btnSokActionPerformed

    private void txtInMomsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtInMomsFocusLost
        attBetala();
    }//GEN-LAST:event_txtInMomsFocusLost

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        new Startsida().setVisible(true);
    }//GEN-LAST:event_btnTillbakaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSkapaRapport;
    private javax.swing.JButton btnSok;
    private javax.swing.JButton btnTillbaka;
    private com.toedter.calendar.JDateChooser dateEnd;
    private com.toedter.calendar.JDateChooser dateStart;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSkapad;
    private javax.swing.JTextField txtBetala;
    private javax.swing.JTextField txtForsalj;
    private javax.swing.JTextField txtForsaljEU;
    private javax.swing.JTextField txtInMoms;
    private javax.swing.JTextArea txtOvrigUpplys;
    private javax.swing.JTextField txtUtMoms;
    private com.toedter.calendar.JMonthChooser txtmonth;
    private com.toedter.calendar.JYearChooser txtyear;
    // End of variables declaration//GEN-END:variables
}
