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
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author noahjarvback
 */
public class PDFUtskrift {

    OutputStream outPut;
    Document document;
    PdfWriter writer;

    private String file = "Material.pdf";

    public PDFUtskrift() {

    }

    public void skapaPDF() {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            Paragraph materialbestallning = new Paragraph("Materialbeställning", titleFont);
            materialbestallning.add(new Paragraph());
            document.add(materialbestallning);

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

            String query = "Select BestID from Bestallning\n"
                    + "where Status = 'Öppen' or Status = 'Pågående'";
            ArrayList<String> bestIDLista = SqlFragor.getEnKolumn(query);
        

            for (String bestID : bestIDLista) {
                String query2 = "select Beskrivning, Tyg, Farg from Hatt\n"
                        + "join Tyg on Tyg.TygID = Hatt.TygID\n"
                        + "join Orderrad on Orderrad.HattID = Hatt.HattID\n"
                        + "where BestID = '" + bestID + "'";
                Paragraph orderNummer = new Paragraph("Ordernummer " + bestID, storFont);
                orderNummer.add(new Paragraph());
                document.add(orderNummer);

                PdfPTable beskrivning = new PdfPTable(3);
                beskrivning.setWidthPercentage(100);
                beskrivning.addCell(getCell("Namn", PdfPCell.ALIGN_LEFT));
                beskrivning.addCell(getCell("Tyg", PdfPCell.ALIGN_CENTER));
                beskrivning.addCell(getCell("Färgkod", PdfPCell.ALIGN_RIGHT));
                document.add(beskrivning);

                ArrayList<HashMap<String, String>> hattLista = SqlFragor.getFleraRader(query2);
                
                for (HashMap<String, String> hattar : hattLista) {
                    String hattNamn = hattar.get("Beskrivning");
                    String tygNamn = hattar.get("Tyg");
                    String fargNamn = hattar.get("Farg");

                    PdfPTable hattarna = new PdfPTable(3);
                    hattarna.setWidthPercentage(100);
                    hattarna.addCell(getCell(hattNamn, PdfPCell.ALIGN_LEFT));
                    hattarna.addCell(getCell(tygNamn, PdfPCell.ALIGN_CENTER));
                    hattarna.addCell(getCell(fargNamn, PdfPCell.ALIGN_RIGHT));
                    document.add(hattarna);

//                    Paragraph hattarna = new Paragraph(hattNamn + tygNamn + fargNamn, titleFont);
//                    hattarna.setSpacingAfter(5);
//                    hattarna.add(new Paragraph());
//                    document.add(hattarna);
//                    Paragraph tyger = new Paragraph(tygNamn, titleFont);
//                    tyger.add(new Paragraph());
//                    document.add(tyger);
//                    
//                    Paragraph farger = new Paragraph(fargNamn, titleFont );
//                    farger.add(new Paragraph());
//                    document.add(farger); 
                }

            }

            //Paragraph moms = new Paragraph("Moms: " + momsNr , litenFont);
            //moms.add(new Paragraph());
            //document.add(moms);
            document.close();
            // JOptionPane.showMessageDialog(null, "Fraktsedel skapad");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        visaPDF();
    }

    public PdfPCell getCell(String text, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(text));
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));

        }
    }

    public void nyPDF() {
        skapaPDF();
    }

    public void visaPDF() {
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("Material.pdf");
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

    private static Font FetFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

}
