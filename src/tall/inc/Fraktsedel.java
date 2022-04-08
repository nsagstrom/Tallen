/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package tall.inc;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JOptionPane;




/**
 *
 * @author timme
 */
public class Fraktsedel {
    OutputStream outPut;
    Document document;
    PdfWriter writer;
    
    private int orderNummer;
    private String forNamn;
    private String efterNamn;
    private String kundAdress;
    private String telefonNummer;
    private int artikelNummer;
            
    
    private String file = "Fraktsedel.pdf";
   
    
    public Fraktsedel(){
       skapaFraktsedel();
    }
    
    public void skapaFraktsedel(){
        try{
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            Paragraph foretagsNamn = new Paragraph("Hattmakaren");
            foretagsNamn.add(new Paragraph());
            document.add(foretagsNamn);
            
            Paragraph foretagsAdress = new Paragraph("Åstadalsvägen 1E");
            foretagsAdress.add(new Paragraph());
            document.add(foretagsAdress);
            
            Paragraph foretagsOrt = new Paragraph("SE - 702 81 Örebro");
            addEmptyLine(foretagsOrt, 1);
            foretagsOrt.add(new Paragraph());
            document.add(foretagsOrt);
            
            Paragraph orgNummer = new Paragraph("Org Nr: 111003332821");
            orgNummer.setAlignment(Element.ALIGN_RIGHT);
            orgNummer.add(new Paragraph());
            document.add(orgNummer);
            
            Paragraph kontakt = new Paragraph("Kontakt: Otto & Judith");
            kontakt.setAlignment(Element.ALIGN_RIGHT);
            kontakt.add(new Paragraph());
            document.add(kontakt);
            
            Paragraph foretagsTelNr = new Paragraph("Tel: +46 76 058 9805");
            addEmptyLine(foretagsTelNr, 1);
            foretagsTelNr.add(new Paragraph());
            document.add(foretagsTelNr);
            
            Paragraph tillKund = new Paragraph("Till: \n");
            tillKund.add(new Paragraph());
            document.add(tillKund);
            
            Paragraph portKod = new Paragraph("Portkod:");
            portKod.setAlignment(Element.ALIGN_RIGHT);
            portKod.add(new Paragraph());
            document.add(portKod);
            
            Paragraph kundKontakt = new Paragraph("Kontakt:");
            kundKontakt.setAlignment(Element.ALIGN_RIGHT);
            kundKontakt.add(new Paragraph());
            document.add(kundKontakt);
            
            Paragraph inneHall = new Paragraph("Innehåll:");
            inneHall.setAlignment(Element.ALIGN_RIGHT);
            inneHall.add(new Paragraph());
            document.add(inneHall);
            
            Paragraph kundTelNr = new Paragraph("Tel:");
            kundTelNr.setAlignment(Element.ALIGN_RIGHT);
            kundTelNr.add(new Paragraph());
            document.add(kundTelNr);
            
            Paragraph posten = new Paragraph("Posten");
            addEmptyLine(posten, 1);
            posten.add(new Paragraph());
            document.add(posten);
            
            Paragraph vikt = new Paragraph("Vikt:");
            vikt.add(new Paragraph());
            document.add(vikt);
            
            Paragraph varuKod = new Paragraph("Varukod:");
            varuKod.add(new Paragraph());
            document.add(varuKod);
            
            Paragraph moms = new Paragraph("Moms:");
            moms.add(new Paragraph());
            document.add(moms);
            
            
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
    
    public void nyFraktsedel(int orderNummer,String forNamn, String efterNamn, String kundAdress, String telefonNummer, int artikelNummer){
        this.orderNummer = orderNummer;
        this.forNamn = forNamn;
        this.efterNamn = efterNamn;
        this.kundAdress = kundAdress;
        this.telefonNummer = telefonNummer;
        this.artikelNummer = artikelNummer;
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
    
    private void test(){
        nyFraktsedel(12345678, "Förnamn", "Efternamn", "Gatan 7", "073-123456", 11111111);
    }
    
}
