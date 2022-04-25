/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tall.inc;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.JOptionPane;
import javax.swing.text.StyleConstants.FontConstants;

/**
 *
 * @author timme
 */
public class Fraktsedel2 {

    OutputStream outPut;
    Document document;
    PdfWriter writer;

    private String orderNummer;
    private String forNamn;
    private String efterNamn;
    private String kundAdress;
    private String telefonNummer;
    private String hattVikt;
    private double momsNr;
    private String tullID;

    private String file = "Fraktsedel.pdf";

    String frann = "Från";

    
    
    
    String spraket;
    String kont ="Kontakt";
    String tel = "Telefon";
    String till ="Till";

    public Fraktsedel2() {

    }

    private static String translate(String langFrom, String langTo, String text) throws IOException {
        // INSERT YOU URL HERE
        String urlStr = "https://script.google.com/macros/s/AKfycbzTZIvZiwWUApoqSu2NYmctZrdnKUXWnLdAYyZHtq90b72J2dw/exec"
                + "?q=" + URLEncoder.encode(text,"UTF-8")
                + "&target=" + langTo
                + "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    private void getSprak(){
        spraket = FardigStallBeställning.getSprak();
    }
    
    public void oversatt() throws IOException{
//        String text = "Från";
        //Translated text: Hallo Welt!
        
        getSprak();
//        System.out.println("Translated text: " + translate("sv", spraket, frann));
        
        
        frann = translate("sv", spraket, frann);
        kont = translate("sv", spraket, kont);
        tel = translate("sv", spraket, tel);
        till = translate("sv", spraket, till);
    }
    
    public void skapaFraktsedel() {
        try {
            
            if(!FardigStallBeställning.getSprak().equals("sv")){
                oversatt();
            }
            
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            // TullID tullid = new TullID();
            //if(tullid.equals(Saknad)){
            //
            //} else{
            // getTullID();
            //}
            Paragraph fran = new Paragraph(frann, litenFont);
            fran.add(new Paragraph());
            document.add(fran);

            Paragraph foretagsNamn = new Paragraph("Hattmakaren", titleFont);
            foretagsNamn.add(new Paragraph());
            document.add(foretagsNamn);

            Paragraph foretagsAdress = new Paragraph("Åstadalsvägen 1E", titleFont);
            foretagsAdress.add(new Paragraph());
            document.add(foretagsAdress);

            Paragraph foretagsOrt = new Paragraph("SE - 702 81 Örebro", titleFont);
            addEmptyLine(foretagsOrt, 1);
            foretagsOrt.add(new Paragraph());
            document.add(foretagsOrt);

            Paragraph testLinje = new Paragraph("__________________________________________________________", storFont);
            testLinje.add(new Paragraph());
            document.add(testLinje);

            Paragraph orgNummer = new Paragraph("Org Nr: 111003332821", litenFont);
            orgNummer.setAlignment(Element.ALIGN_RIGHT);
            orgNummer.add(new Paragraph());
            document.add(orgNummer);

            Paragraph kontakt = new Paragraph(kont + " : Otto&Judith@gmail.com", litenFont);
            kontakt.setAlignment(Element.ALIGN_RIGHT);
            kontakt.add(new Paragraph());
            document.add(kontakt);

            Paragraph foretagsTelNr = new Paragraph( tel+" : +46 76 058 9805", litenFont);
            addEmptyLine(foretagsTelNr, 1);
            foretagsTelNr.add(new Paragraph());
            document.add(foretagsTelNr);

            Paragraph tillKund = new Paragraph(till + ":\n" + forNamn + "\n" + efterNamn + "\n" + kundAdress + "\n", litenFont);
            tillKund.add(new Paragraph());
            document.add(tillKund);

            Paragraph portKod = new Paragraph("Portkod:                    ", litenFont);
            portKod.setAlignment(Element.ALIGN_RIGHT);
            portKod.add(new Paragraph());
            document.add(portKod);

            Paragraph kundKontakt = new Paragraph("Kontakt:                    ", litenFont);
            kundKontakt.setAlignment(Element.ALIGN_RIGHT);
            kundKontakt.add(new Paragraph());
            document.add(kundKontakt);

            Paragraph inneHall = new Paragraph("Innehåll:                    ", litenFont);
            inneHall.setAlignment(Element.ALIGN_RIGHT);
            inneHall.add(new Paragraph());
            document.add(inneHall);

            Paragraph testLinje2 = new Paragraph("__________________________________________________________", storFont);
            testLinje2.add(new Paragraph());
            document.add(testLinje2);

            Paragraph posten = new Paragraph("PostNord", postFont);
            addEmptyLine(posten, 1);
            posten.add(new Paragraph());
            document.add(posten);

            Paragraph varuKod = new Paragraph("Varukod: ", litenFont);
            varuKod.add(new Paragraph());
            document.add(varuKod);

            //Paragraph moms = new Paragraph("Moms: " + momsNr , litenFont);
            //moms.add(new Paragraph());
            //document.add(moms);
            Paragraph attaSiffrig = new Paragraph("Varudeklaration: " + tullID, litenFont);
            addEmptyLine(attaSiffrig, 1);
            attaSiffrig.add(new Paragraph());
            document.add(attaSiffrig);

            Paragraph vikt = new Paragraph("Vikt:" + hattVikt, litenFont);
            vikt.add(new Paragraph());
            document.add(vikt);

            Paragraph testLinje3 = new Paragraph("__________________________________________________________", storFont);
            testLinje3.add(new Paragraph());
            document.add(testLinje3);

            document.close();
            // JOptionPane.showMessageDialog(null, "Fraktsedel skapad");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        visaFraktsedel();
    }

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    public void nyFraktsedel(String orderNummer, String forNamn, String efterNamn, String kundAdress, String hattVikt, double momsNr, String tullID) {
        this.orderNummer = orderNummer;
        this.forNamn = forNamn;
        this.efterNamn = efterNamn;
        this.kundAdress = kundAdress;
        this.hattVikt = hattVikt;
        this.momsNr = momsNr;
        this.tullID = tullID;
        skapaFraktsedel();
    }

    public void visaFraktsedel() {
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("Fraktsedel.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }
    }

    private static Font storFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);

    private static Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL);

    private static Font litenFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);

    private static Font postFont = new Font(Font.FontFamily.COURIER, 18, Font.BOLD, BaseColor.BLUE);

}
