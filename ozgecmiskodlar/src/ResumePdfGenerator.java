import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class ResumePdfGenerator {
    private PersonalInfo personalInfo;

    public ResumePdfGenerator(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public void generatePdf(String outputPath) {
        Document document = new Document(PageSize.A4, 36, 36, 36, 36);

        try {
            PdfWriter.getInstance(document, new FileOutputStream(outputPath));
            document.open();

            // Türkçe Karakter Desteği Sağlayan Font Tanımlaması
            BaseFont helveticaTr = BaseFont.createFont(BaseFont.HELVETICA, "Cp1254", BaseFont.EMBEDDED);
            Font titleFont = new Font(helveticaTr, 18, Font.BOLD, BaseColor.BLACK);
            Font subTitleFont = new Font(helveticaTr, 11, Font.NORMAL, BaseColor.DARK_GRAY);
            Font sectionFont = new Font(helveticaTr, 14, Font.BOLD, BaseColor.BLUE);
            Font expTitleFont = new Font(helveticaTr, 11, Font.BOLD, BaseColor.BLACK);
            Font expBodyFont = new Font(helveticaTr, 10, Font.NORMAL, BaseColor.BLACK);

            // Üst Bilgi Tablosu (Fotoğraf + Kişisel Bilgiler)
            PdfPTable headerTable = new PdfPTable(2);
            headerTable.setWidthPercentage(100);
            headerTable.setWidths(new float[]{1, 3});

            try {
                Image img = Image.getInstance(personalInfo.getPhotoPath());
                img.scaleToFit(100, 100);
                PdfPCell imgCell = new PdfPCell(img);
                imgCell.setBorder(Rectangle.NO_BORDER);
                headerTable.addCell(imgCell);
            } catch (Exception e) {
                PdfPCell emptyCell = new PdfPCell(new Phrase("Fotoğraf Bulunamadı", subTitleFont));
                emptyCell.setBorder(Rectangle.NO_BORDER);
                headerTable.addCell(emptyCell);
            }

            Phrase infoPhrase = new Phrase();
            infoPhrase.add(new Chunk(personalInfo.getFullName() + "\n", titleFont));
            infoPhrase.add(new Chunk(personalInfo.getTitle() + "\n\n", subTitleFont));
            infoPhrase.add(new Chunk("E-posta: " + personalInfo.getEmail() + "\n", subTitleFont));
            infoPhrase.add(new Chunk("Telefon: " + personalInfo.getPhone() + "\n", subTitleFont));

            PdfPCell infoCell = new PdfPCell(infoPhrase);
            infoCell.setBorder(Rectangle.NO_BORDER);
            headerTable.addCell(infoCell);

            document.add(headerTable);
            document.add(new Paragraph("\n"));

            // İş Deneyimleri Başlığı
            document.add(new Paragraph("İŞ DENEYİMLERİ", sectionFont));
            document.add(new Paragraph("---------------------------------------------------------------------------------------------------"));

            // İş Deneyimleri Listesi
            for (Experience exp : personalInfo.getExperiences()) {
                Paragraph expPara = new Paragraph();
                expPara.add(new Chunk(exp.getPosition() + " - " + exp.getCompanyName() + " (" + exp.getDuration() + ")\n", expTitleFont));
                expPara.add(new Chunk(exp.getDescription() + "\n\n", expBodyFont));
                document.add(expPara);
            }

            document.close();
            System.out.println("PDF başarıyla güncellendi: " + outputPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}