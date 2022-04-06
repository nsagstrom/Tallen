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
            Paragraph foretagsNamn = new Paragraph();
            foretagsNamn.add(new Paragraph("Hattmakaren"));
            document.add(foretagsNamn);
            Paragraph foretagsAdress = new Paragraph();
            foretagsAdress.add(new Paragraph("Åstadalsvägen 1E"));
            document.add(foretagsAdress);
            Paragraph preface = new Paragraph("heheh");
            
            //preface.add(new Paragraph("hej!"));
            preface.setAlignment(Element.ALIGN_RIGHT);
            addEmptyLine(preface, 1);
            preface.add(new Paragraph("Ordernummer"));
            document.add(preface);
            document.addTitle("pffff");
            
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
       
    }
    
    public void visaFraktsedel(){
        if (Desktop.isDesktopSupported()) {
    try {
        File myFile = new File("Fraktsedel.pdf");
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
    }
}
    }
    
    
    
}
