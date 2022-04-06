/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package tall.inc;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
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
    
    private String file = "Fraktsedel.pdf";
   
    
    public Fraktsedel(){
       skapaFraktsedel();
    }
    
    public void skapaFraktsedel(){
        try{
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            Paragraph preface = new Paragraph();
            preface.add(new Paragraph("hej"));
            document.add(preface);
            document.addTitle("pffff");
            
            document.close();
           // JOptionPane.showMessageDialog(null, "Fraktsedel skapad");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    
}
