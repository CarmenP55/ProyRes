package com.cloudsrcsoft.view;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;

public class HeaderFooterPageEvent {
 
    class MyFooter extends PdfPageEventHelper { 
        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte cb = writer.getDirectContent();
            Image img;
			try {
				img = Image.getInstance("lanconta.jpg");
				//img.scaleAbsolute(120, 120);
				img.setAbsolutePosition(20, 800);
				img.scaleToFit(150, 350);
				writer.getDirectContent().addImage(img);
			} catch (BadElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Calendar hoy = Calendar.getInstance();
			int dia=hoy.get(Calendar.DATE);
			int mes=hoy.get(Calendar.MONTH);
			int anio=hoy.get(Calendar.YEAR);

			Phrase footer = new Phrase("Desarrollos Lanconta S de RL de CV");
			Phrase header = new Phrase("Generado:  "+dia+"-"+(mes+1)+"-"+anio);
            //Phrase footer = new Phrase("Desarrollos Lanconta S de RL de CV"+"Pág. "+writer.getPageNumber());
			ColumnText.showTextAligned(cb, Element.ALIGN_RIGHT, header, (document.right() - document.left()) + document.rightMargin(), document.top() + 10, 0);            
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, footer, (document.right() - document.left()) / 2 + document.leftMargin(), document.bottom() - 10, 0);						
        }
    }

/*
    public void createPdf(String filename) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        MyFooter event = new MyFooter();
        writer.setPageEvent(event);
        document.open();
        for (int i = 0; i < 3; ) {
            i++;
            document.add(new Paragraph("Test " + i));
            document.newPage();
        }
        document.close();
    }
    */
    
    public void createPdf(PdfWriter writer) throws IOException, DocumentException {
        MyFooter event = new MyFooter();        
        writer.setPageEvent(event);
    }
    
    
}