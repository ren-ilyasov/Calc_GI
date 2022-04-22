import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * <b> Êëàññ ðåàëèçóþùèé ñîçäàíèå è çàïîëíåíèå òèïîâîãî PDF ôàéëà.</b>
 * @author Kazantsev AV
 * @version 2.0
 * Â êëàññå îäèí êîíñòðóêòîð c 2 ïàðàìåòðàìè.
 * Êëàññ îñíîâàí íà áèáëèîòåêè itextpdf.
 *
 * Äëÿ ñîçäàíèÿ PDF ôàéëà íåîáõîäèìî ñîçäàòü ýêçåìïëÿð îáúåêòà CreatePDF è äàëåå äîáàâëÿòü íåîáõîäèìûå âñòàâêè (òåêñò, ðèñóíêè è òàáëèöû). Ïîñëå îêîí÷àíèÿ äîáàâëåíèÿ íåîáõîäèìî âûïîëíèòü ìåòîä getClose, êîòîðûé çàêðîåò è ñîõðàíèòü PDF äîêóìåíò.
 *
 */
public class CreatePDF {

    /** Ïîëå áàçîâîãî èñïîëüçóåìîãî øðèôòà */
    private BaseFont times = null;
    /** Ïîëå ñ èìåíåì ñîçäàâàåìîãî PDF ôàéëà */
    private String Namefile;
    /** Ïîëå ñ ññëûêîé íà ñîçäàâàåìûé äîêóìåíò */
    private Document document;
    /**Ïîëå ñ ññûëêîé íà ñîçäàâàåìóþ òàáëèöó */
    private PdfPTable table;

    /**
     * Êîíñòðóêòîð - ñîçäàíèå îáúåêòà ñ ãåíåðàöèåé PDF
     * @param Namefile - èìÿ âûâîäèìîãî ôàéëà
     * @param BaseFontPDF - øðèôò äëÿ âûâîäà
     */
    public CreatePDF(String Namefile, BaseFont BaseFontPDF) {
        this.Namefile=Namefile;
        this.times=BaseFontPDF;

        this.document = new Document(); //ñîçäàíèå îáúåêòà Document
        try {
            PdfWriter.getInstance(document, new FileOutputStream(this.Namefile)); //âûõîäíîé ïîòîê äëÿ ñîçäàíèÿ PDF, à âíóòðè ñîçäàåòñÿ ïîòîê çàïèñè ñ êîíêðåòíûì èìåíåì
        } catch (FileNotFoundException | DocumentException e) { //Èñêëþ÷åíèå êîãäà ôàéë íå íàéäåí
            e.printStackTrace();
        }
        document.open(); //îòêðûòèå äëÿ âîçìîæíîñòè çàïèñè
    }

    /**
     * Ìåòîä äîáàâëåíèÿ ñòðîê â òàáëèöó
     * @param table - òàáëèöà äëÿ çàïîëíåíèÿ
     * @param arrayCell - äâóìåðíûé ìàññèâ ñî çíà÷åíèÿ ÿ÷ååê
     */
    private void addRows(PdfPTable table, String[][] arrayCell) {
        //óñòàíîâêà çíà÷åíèÿ è øðèôòà äëÿ âûâîäèìîãî òåêñòà â ÿ÷åéêè
        int SizeTwo = arrayCell.length; //êîëè÷åñòâî ñòðîê
        int SizeOne = arrayCell[0].length; //ïîäðàçóìåâàåì êîëè÷åñòâî ñòîëáöîâ

        for (int j=0; j<SizeTwo; j++) {
            for (int i=0; i<SizeOne; i++) {
                table.addCell(new Phrase(arrayCell[j][i], new Font(times,14)));
            }}
    }

    /**
     * Ìåòîä çàïîëíåíèÿ øàïêè òàáëèöû
     * @param table - òàáëèöà äëÿ çàïîëíåíèÿ
     */
    private void setHeader(PdfPTable table, String[] NameCellHat) {
        for (int i=0; i<NameCellHat.length; i++) {
            PdfPCell header = new PdfPCell(); //ðåàëèçàöèÿ ÿ÷åéêè â òàáëèöå
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(NameCellHat[i],new Font(times,14)));
            table.addCell(header);
        }
    }

    /**
     * Ìåòîä äëÿ ïîëó÷åíèÿ ññûëêà íà ñîçäàâàåìûé äîêóìåíò
     * @return âîçâàðàùåò ññûëêó íà ñîçäàâàåìûé äîêóìåíò
     */
    public Document getDocument() {
        return this.document;
    }

    /**
     * Ìåòîä äëÿ çàêðûòèÿ è ñîõðàíåíèÿ PDF ôàéëà
     */
    public void getClose() {
        this.document.close();
    }

    /**
     * Ìåòîä äîáàâëåíèÿ êàðòèíêè â PDF ôàéë
     * @param url - ññûëêà íà èçîáðàæåíèå
     * @param document - ññûëêà íà ñîçäàâàåìûé äîêóìåíò
     * @param position1 - àáñîëþòíàÿ ïîçèöèÿ ïî îñè X
     * @param position2 - àáñîëþòíàÿ ïîçèöèÿ ïî îñè Y
     */
    public void addPicture(URL url, Document document, int position1, int position2) {
        Image img = null;
        try {
            img = Image.getInstance(url.toString());
        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        img.setAbsolutePosition(position1, position2); //ïîçèöèîíèðîâàíèå èçîáðàæåíèÿ â PDF

        try {
            document.add(img);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ìåòîä äîáàâëåíèÿ òåêñòà â PDF äîêóìåíò. Äîáàâëåíèå ïðîèñõîäèò ñ íà÷àëà äîêóìåíòà.
     * @param document - ññûëêà íà ñîçäàâàåìûé äîêóìåíò
     * @param Text - çàäàâàåìûé òåêñò
     * @param SizeFont - ðàçìåð øðèôòà
     * @param Space - óêàçàíèå òðåáóåòñÿ ëè ïåðåéòè íà íîâóþ ñòðîêó
     */
    public void addText(Document document, String Text, int SizeFont, boolean Space ) {
        Paragraph paragraph = new Paragraph(); //ñîçäàíèå îáúåêòà "ïàðàãðàô" äëÿ âîçìîæíîñòè çàïèñè äàííûõ â ôàéë
        Paragraph paragraphadd = new Paragraph(Text, new Font(times,SizeFont));
        paragraphadd.setAlignment(com.itextpdf.text.Element.ALIGN_JUSTIFIED);
        paragraph.add(paragraphadd);

        try {
            document.add(paragraph);
        } catch (DocumentException e1) {
            e1.printStackTrace();
        }
        paragraph.clear();

        if (Space) {

            String string_pdf3 = " ";
            paragraph.add(new Paragraph(string_pdf3, new Font(times,14)));

            try {
                document.add(paragraph);
            } catch (DocumentException e1) {
                e1.printStackTrace();
            }
        }
        paragraph=null;
    }

    /**
     * Ìåòîä èíèöèàëèçàöèè òàáëèöû è äîáàâëåíèÿ øàïêè â òàáëèöå.
     * @param document - ññûëêà íà ñîçäàâàåìûé äîêóìåíò
     * @param NameCellHat - äàííûå äëÿ øàïêè òàáëèöû
     */
    public void InitTableAndAddHat (Document document, String[] NameCellHat) {

        table = new PdfPTable(NameCellHat.length);
        setHeader(table,NameCellHat);
    }

    /**
     * Ìåòîä ïîëó÷åíèÿ ññûëêè íà ñîçäàâàåìóþ òàáëèöó, êîòîðóþ íóæíî íàïîëíèòü (ãåòòåð).
     * @return âîçâðàùàåò ññûëêó íà ñîçäàííóþ òàáëèöó
     */
    public PdfPTable getTable () {
        return table;
    }

    /**
     * Ìåòîä èíèöèàëèçàöèè òàáëèöû è äîáàâëåíèÿ øàïêè â òàáëèöå.
     * @param Table - ññûëêà íà ñîçäàâàåìóþ òàáëèöó, êîòîðàÿ ïîëó÷åíà ìåòîäîì {@link InitTableAndAddHat}
     * @param arrayCell - äàííûå äëÿ ñòðîê â òàáëèöå (ïðåäñòàâëÿåòñÿ â âèäå äâóìåðíîãî ìàññèâà)
     */
    public void addRowsInTable(PdfPTable Table, String[][] arrayCell) {
        addRows(Table, arrayCell);

    }

    /**
     * Ìåòîä äîáàâëåíèÿ òàáëèöû â PDF äîêóìåíò.
     * @param document - ññûëêà íà ñîçäàâàåìûé äîêóìåíò
     * @param Table - ññûëêà íà ñîçäàâàåìóþ òàáëèöó, êîòîðàÿ ïîëó÷åíà ìåòîäîì {@link InitTableAndAddHat}
     */
    public void addTable(Document document, PdfPTable Table) {
        try {
            document.add(Table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }}