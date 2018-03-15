package com.cloudsrcsoft.view;

import java.util.List;
import java.util.Map;
import java.awt.Color;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.cloudsrcsoft.beans.*;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfET extends AbstractPdfView{
	public static final String DEST = "Proyectos/pdf/Proyecto.pdf";
	protected void buildPdfDocument(Map model, Document document, PdfWriter writer, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		new HeaderFooterPageEvent().createPdf(writer);
		PdfET proy= new PdfET();
        proy.infoProyecto(model, document);
        
        PdfET emp= new PdfET();
        emp.infoEmpresa(model, document);
        
        PdfET us= new PdfET();
        us.infoUser(model, document);
        
        PdfET diseno= new PdfET();
        diseno.infDiseno(model, document);        
	}

	public void infoProyecto(Map model, Document document) throws DocumentException {
		Proyectos proyectos = (Proyectos) model.get("proyectos");
		PdfPTable table = new PdfPTable(2);

		Paragraph proy = new Paragraph(new Chunk("Proyecto: "+proyectos.getNombre(),FontFactory.getFont(FontFactory.HELVETICA, 20)));
		document.add(proy);
        table.setSpacingBefore(20);
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        document.add(table);
	}
	
	public void infoUser(Map model, Document document) throws DocumentException {
		User user = (User) model.get("userDes");
		PdfPTable table = new PdfPTable(2);
		table.completeRow();
        table.setWidths(new int [] {70, 190});
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        
        PdfPCell cell=new PdfPCell(new Phrase("Desarrollador", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
        cell.setBorderWidthLeft(Rectangle.NO_BORDER);
        cell.setBackgroundColor(Color.GREEN);
        table.addCell(cell);
        cell=new PdfPCell(new Phrase(user.getFirstname()+" "+user.getLastname()));
        cell.setFixedHeight(25);
        cell.setBorderWidthRight(Rectangle.NO_BORDER);
        table.addCell(cell);
        document.add(table);
	}
	
	public void infoEmpresa(Map model, Document document) throws DocumentException {
		Empresa empresa = (Empresa) model.get("empresa");
		PdfPTable table = new PdfPTable(2);
		table.completeRow();
        table.setSpacingBefore(20);
        table.setWidths(new int [] {70, 190});
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        
        PdfPCell cell = new PdfPCell(new Phrase("Empresa", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
        cell.setBorderWidthLeft(Rectangle.NO_BORDER);
        cell.setBackgroundColor(Color.GREEN);
        cell.setFixedHeight(25);
        table.addCell(cell);
        cell=new PdfPCell(new Phrase(empresa.getNombre()));
        cell.setBorderWidthRight(Rectangle.NO_BORDER);
        table.addCell(cell);       
        document.add(table);
	}
	
	public void infDiseno(Map model, Document document) throws DocumentException {
		@SuppressWarnings("unchecked")
		List<Diseno> listDiseno =(List<Diseno>) model.get("listDiseno");
		PdfPTable table3 = new PdfPTable(2);
        table3.setSpacingBefore(20);
        table3.setWidths(new int [] {70, 190});
        table3.setHorizontalAlignment(Element.ALIGN_LEFT);
        table3.setWidthPercentage(100);
        
        Paragraph diseno = new Paragraph(new Chunk("Diseno",FontFactory.getFont(FontFactory.HELVETICA, 15)));
        diseno.setSpacingBefore(20);
        document.add(diseno);
        
        PdfPCell cell = new PdfPCell();
        for (Diseno a : listDiseno) {
        	cell=new PdfPCell(new Phrase("Actividad", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase(a.getActividad()));
        	table3.addCell(cell);
            cell=new PdfPCell(new Phrase("Descripcion", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase(a.getDescripcion()));
        	table3.addCell(cell);
        	cell=new PdfPCell(new Phrase("Comentarios", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase(a.getComentarios()));
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase("Fecha de entrega", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            table3.addCell(cell);
        	cell=new PdfPCell(new Phrase(a.getEntrega()));
        	table3.addCell(cell);
        	cell=new PdfPCell(new Phrase("Estatus", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            table3.addCell(cell);
        	cell=new PdfPCell(new Phrase(a.getEstatus()));
        	table3.addCell(cell);
        	
        	cell=new PdfPCell(new Phrase("Argumentos", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            table3.addCell(cell);
        	cell=new PdfPCell(new Phrase(a.getArgumentos()));
        	table3.addCell(cell);
        	cell=new PdfPCell(new Phrase("Salida", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            table3.addCell(cell);
        	cell=new PdfPCell(new Phrase(a.getSalida()));
        	table3.addCell(cell);
        	cell=new PdfPCell(new Phrase("Codigo", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            table3.addCell(cell);
        	cell=new PdfPCell(new Phrase(a.getCodigo()));
        	table3.addCell(cell);
        	
        	cell=new PdfPCell();
        	cell.setColspan(2);
        	cell.setBorder(Rectangle.NO_BORDER);
        	cell.setFixedHeight(35);
        	table3.addCell(cell);
        }        
        document.add(table3);
	}
	
	
}