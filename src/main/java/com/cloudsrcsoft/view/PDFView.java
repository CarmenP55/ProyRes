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


public class PDFView extends AbstractPdfView{
	public static final String DEST = "Proyectos/pdf/Proyecto.pdf";
	protected void buildPdfDocument(Map model, Document document, PdfWriter writer, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		new HeaderFooterPageEvent().createPdf(writer);
		
		PDFView proy= new PDFView();
        proy.infoProyecto(model, document);
        
		PDFView reque= new PDFView();
        reque.infReq(model, document);
        
        PDFView pruebas= new PDFView();
        pruebas.infPruebas(model, document);
        
        PDFView riesgos= new PDFView();
        riesgos.infRiesgos(model, document);
        
        PDFView diseno= new PDFView();
        diseno.infDiseno(model, document);
	}
	
	public void infoUserRes(Map model, Document document) throws DocumentException {
		User user = (User) model.get("userRes");
		PdfPTable table = new PdfPTable(2);
		table.completeRow();
        table.setWidths(new int [] {70, 190});
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        
        PdfPCell cell=new PdfPCell(new Phrase("Responsable", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
        cell.setBorderWidthLeft(Rectangle.NO_BORDER);
        cell.setBackgroundColor(Color.GREEN);
        table.addCell(cell);
        cell=new PdfPCell(new Phrase(user.getFirstname()+" "+user.getLastname()));
        cell.setFixedHeight(25);
        cell.setBorderWidthRight(Rectangle.NO_BORDER);
        table.addCell(cell);
        document.add(table);
	}

	
	public void infoProyecto(Map model, Document document) throws DocumentException {
		Proyectos proyectos = (Proyectos) model.get("command");
		Paragraph proy = new Paragraph(new Chunk(proyectos.getNombre(),FontFactory.getFont(FontFactory.HELVETICA, 20)));
		document.add(proy);
		PdfPTable table = new PdfPTable(2);        
		table.setWidths(new int [] {70, 190});
        PdfET emp= new PdfET();
        emp.infoEmpresa(model, document);
        PDFView usRes= new PDFView();
        usRes.infoUserRes(model, document);
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        PdfPCell cell=new PdfPCell(new Phrase("Tipo de Proyecto", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
        cell.setBorderWidthLeft(Rectangle.NO_BORDER);
        table.addCell(cell);
        cell=new PdfPCell(new Phrase(proyectos.getTipo()));
        cell.setFixedHeight(25);
        cell.setBorderWidthRight(Rectangle.NO_BORDER);
        table.addCell(cell);
        PdfET us= new PdfET();
        us.infoUser(model, document);
        cell=new PdfPCell(new Phrase("Lenguaje", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
        cell.setBorderWidthLeft(Rectangle.NO_BORDER);
        cell.setFixedHeight(25);
        table.addCell(cell);
        cell=new PdfPCell(new Phrase(proyectos.getTecnologia()));
        cell.setBorderWidthRight(Rectangle.NO_BORDER);
        table.addCell(cell);
        cell=new PdfPCell(new Phrase("Repositorio", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
        cell.setBorderWidthLeft(Rectangle.NO_BORDER);
        cell.setFixedHeight(25);
        table.addCell(cell);
        cell=new PdfPCell(new Phrase(proyectos.getRepositorio()));
        cell.setBorderWidthRight(Rectangle.NO_BORDER);
        table.addCell(cell);
        cell=new PdfPCell(new Phrase("Acceso a repositorio", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
        cell.setBorderWidthLeft(Rectangle.NO_BORDER);
        cell.setFixedHeight(25);
        table.addCell(cell);
        cell=new PdfPCell(new Phrase(proyectos.getDetalle()));
        cell.setBorderWidthRight(Rectangle.NO_BORDER);
        table.addCell(cell);
        cell=new PdfPCell(new Phrase("Fecha de solicitud", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
        cell.setBorderWidthLeft(Rectangle.NO_BORDER);
        cell.setFixedHeight(25);
        table.addCell(cell);
        cell=new PdfPCell(new Phrase(proyectos.getSolicitud()));
        cell.setFixedHeight(25);
        cell.setBorderWidthRight(Rectangle.NO_BORDER);
        table.addCell(cell);
        cell=new PdfPCell(new Phrase("Fecha de entrega", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));        
        cell.setBorderWidthLeft(Rectangle.NO_BORDER);
        table.addCell(cell);
        cell=new PdfPCell(new Phrase(proyectos.getEntrega()));        
        cell.setFixedHeight(25);
        cell.setBorderWidthRight(Rectangle.NO_BORDER);
        table.addCell(cell);
        cell=new PdfPCell(new Phrase("Estatus", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
        cell.setFixedHeight(25);
        cell.setBorderWidthLeft(Rectangle.NO_BORDER);
        table.addCell(cell);
        cell=new PdfPCell(new Phrase(proyectos.getEstatus()));
        cell.setBorderWidthRight(Rectangle.NO_BORDER);
        table.addCell(cell);
        cell=new PdfPCell(new Phrase("Descripción", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
        cell.setBorderWidthLeft(Rectangle.NO_BORDER);
        table.addCell(cell);
        cell=new PdfPCell(new Phrase(proyectos.getDescripcion()));
        cell.setBorderWidthRight(Rectangle.NO_BORDER);
        table.addCell(cell);
        document.add(table);
	}
	
	public void infPruebas(Map model, Document document) throws DocumentException {
		List<Pruebas> listPruebas =(List<Pruebas>) model.get("listPruebas");
		PdfPTable table3 = new PdfPTable(6);
        table3.setWidthPercentage(100);
        table3.setSpacingBefore(20);
        
        if (listPruebas.size()>0) {
        Paragraph pruebas = new Paragraph(new Chunk("Pruebas",FontFactory.getFont(FontFactory.HELVETICA, 15)));
        pruebas.setSpacingBefore(20);
        document.add(pruebas);
        }
        
        PdfPCell cell = new PdfPCell();
        for (Pruebas a : listPruebas) {
        	cell=new PdfPCell(new Phrase("Entrada", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase("Proceso", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase("Salida", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table3.addCell(cell);
            
            cell=new PdfPCell(new Phrase(a.getEntrada()));
            cell.setFixedHeight(40);
            cell.setColspan(2);
        	table3.addCell(cell);
        	cell=new PdfPCell(new Phrase(a.getProceso()));
        	cell.setColspan(2);
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase(a.getSalida()));
            cell.setColspan(2);
            table3.addCell(cell);
            
            cell=new PdfPCell();
        	cell.setColspan(6);
        	cell.setBorder(Rectangle.NO_BORDER);
        	cell.setFixedHeight(5);
        	table3.addCell(cell);
            
        	cell=new PdfPCell(new Phrase("Observaciones", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
        	cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase("Responsable", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase("Version", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase("Estatus", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            table3.addCell(cell); 
            
            cell=new PdfPCell(new Phrase(a.getObservaciones()));
            cell.setColspan(2);
            cell.setFixedHeight(40);
        	table3.addCell(cell);
        	cell=new PdfPCell(new Phrase(a.getResponsable()));
        	cell.setColspan(2);
        	table3.addCell(cell);
        	cell=new PdfPCell(new Phrase(Integer.toString(a.getVersion())));
        	table3.addCell(cell);
        	cell=new PdfPCell(new Phrase(a.getEstatus()));
        	table3.addCell(cell);
        	
        	cell=new PdfPCell();
        	cell.setColspan(6);
        	cell.setBorder(Rectangle.NO_BORDER);
        	cell.setFixedHeight(35);
        	table3.addCell(cell);
        }
        
        document.add(table3);
	}
	
	public void infRiesgos(Map model, Document document) throws DocumentException {
		@SuppressWarnings("unchecked")
		List<Riesgos> listRiesgos =(List<Riesgos>) model.get("listRiesgos");
		PdfPTable table3 = new PdfPTable(7);
        table3.setWidthPercentage(100);
        table3.setSpacingBefore(20);
        
        if (listRiesgos.size()>0) {
        Paragraph riesgos = new Paragraph(new Chunk("Riesgos",FontFactory.getFont(FontFactory.HELVETICA, 15)));
        riesgos.setSpacingBefore(10);
        document.add(riesgos);
        }
        
        PdfPCell cell = new PdfPCell();
        for (Riesgos a : listRiesgos) {
        	cell=new PdfPCell(new Phrase("Riesgos", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
        	cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase("Descripcion", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase("Clasificacion", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase("Probabilidad de ocurrencia", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            table3.addCell(cell);
            
            cell=new PdfPCell(new Phrase(a.getRiesgo()));
            cell.setColspan(2);
            cell.setFixedHeight(40);
        	table3.addCell(cell);
            cell=new PdfPCell(new Phrase(a.getDescripcion()));
            cell.setColspan(2);
        	table3.addCell(cell);
        	cell=new PdfPCell(new Phrase(a.getClasificacion()));
        	cell.setColspan(2);
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase(a.getOcurrencia()+"%"));
            table3.addCell(cell);
            
            cell=new PdfPCell();
        	cell.setColspan(7);
        	cell.setBorder(Rectangle.NO_BORDER);
        	cell.setFixedHeight(5);
        	table3.addCell(cell);
            
        	cell=new PdfPCell(new Phrase("Efectos", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
        	cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase("Plan de Accion", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase("Plan de contingencia", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase("Version", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            table3.addCell(cell); 
            
            
            cell=new PdfPCell(new Phrase(a.getEfectos()));
            cell.setColspan(2);
            cell.setFixedHeight(40);
            table3.addCell(cell);
        	cell=new PdfPCell(new Phrase(a.getAccion()));
        	cell.setColspan(2);
        	table3.addCell(cell);
        	cell=new PdfPCell(new Phrase(a.getContingencia()));
        	cell.setColspan(2);
        	table3.addCell(cell);
        	cell=new PdfPCell(new Phrase(Integer.toString(a.getVersion())));
        	table3.addCell(cell);
        	
        	cell=new PdfPCell();
        	cell.setColspan(7);
        	cell.setBorder(Rectangle.NO_BORDER);
        	cell.setFixedHeight(35);
        	table3.addCell(cell);
        }
        
        document.add(table3);
	}
	
	public void infDiseno(Map model, Document document) throws DocumentException {
		@SuppressWarnings("unchecked")
		List<Diseno> listDiseno =(List<Diseno>) model.get("listDiseno");
		PdfPTable table3 = new PdfPTable(6);
        table3.setWidthPercentage(100);
        table3.setSpacingBefore(20);
        
        if (listDiseno.size()>0) {
        Paragraph diseno = new Paragraph(new Chunk("Diseno",FontFactory.getFont(FontFactory.HELVETICA, 15)));
        diseno.setSpacingBefore(10);
        document.add(diseno);
        }
        
        PdfPCell cell = new PdfPCell();
        for (Diseno a : listDiseno) {
        	cell=new PdfPCell(new Phrase("Actividad", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
        	cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase("Descripcion", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase("Fecha de entrega", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table3.addCell(cell);
           
            cell=new PdfPCell(new Phrase(a.getActividad()));
            cell.setFixedHeight(40);
            cell.setColspan(2);
        	table3.addCell(cell);
            cell=new PdfPCell(new Phrase(a.getDescripcion()));
            cell.setColspan(2);
        	table3.addCell(cell);
        	cell=new PdfPCell(new Phrase(a.getEntrega()));
        	cell.setColspan(2);
        	table3.addCell(cell);
        	
        	cell=new PdfPCell();
        	cell.setColspan(6);
        	cell.setBorder(Rectangle.NO_BORDER);
        	cell.setFixedHeight(5);
        	table3.addCell(cell);
            
            cell=new PdfPCell(new Phrase("Comentarios", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase("Version", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table3.addCell(cell); 
            cell=new PdfPCell(new Phrase("Estatus", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table3.addCell(cell);
            
            cell=new PdfPCell(new Phrase(a.getComentarios()));
            cell.setColspan(2);
            cell.setFixedHeight(40);
            table3.addCell(cell);
            cell=new PdfPCell(new Phrase(Integer.toString(a.getVersion())));
            cell.setColspan(2);
            table3.addCell(cell);
        	cell=new PdfPCell(new Phrase(a.getEstatus()));
        	cell.setColspan(2);
        	table3.addCell(cell);
        	
        	cell=new PdfPCell();
        	cell.setColspan(6);
        	cell.setBorder(Rectangle.NO_BORDER);
        	cell.setFixedHeight(35);
        	table3.addCell(cell);
        }
        
        document.add(table3);
	}
	
	@SuppressWarnings("unchecked")
	public void infReq(Map model, Document document) throws Exception {
		List<Requerimientos> listRequerimientos =(List<Requerimientos>) model.get("listRequerimientos");
		PdfPTable table2 = new PdfPTable(6);
        table2.setWidthPercentage(100);
        table2.setSpacingBefore(20);
        PdfPCell cell = new PdfPCell();
        
        if (listRequerimientos.size()>0) {
        Paragraph req1 = new Paragraph(new Chunk("Requerimientos",FontFactory.getFont(FontFactory.HELVETICA, 15)));
        req1.setSpacingBefore(40);
        document.add(req1);
        }
        for (Requerimientos a : listRequerimientos) {
        	cell=new PdfPCell(new Phrase("Actividad", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
        	cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(3);
            table2.addCell(cell);
            cell=new PdfPCell(new Phrase("Descripcion", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table2.addCell(cell);
            cell=new PdfPCell(new Phrase("Fecha de Entrega", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            table2.addCell(cell);
            
            cell=new PdfPCell(new Phrase(a.getActividad()));
            cell.setColspan(3);
            cell.setFixedHeight(40);
        	table2.addCell(cell);
        	cell=new PdfPCell(new Phrase(a.getDescripcion()));
        	cell.setColspan(2);
            table2.addCell(cell);
            cell=new PdfPCell(new Phrase(a.getEntrega()));
        	table2.addCell(cell);
            
        	cell=new PdfPCell();
        	cell.setColspan(6);
        	cell.setBorder(Rectangle.NO_BORDER);
        	cell.setFixedHeight(5);
        	table2.addCell(cell);
        	
            cell=new PdfPCell(new Phrase("Plan de Accion", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(3);
            table2.addCell(cell);
            cell=new PdfPCell(new Phrase("Comentarios", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(2);
            table2.addCell(cell);
            cell=new PdfPCell(new Phrase("Estatus", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            table2.addCell(cell); 
            
            cell=new PdfPCell(new Phrase(a.getAccion()));
            cell.setColspan(3);
            cell.setFixedHeight(40);
        	table2.addCell(cell);
        	cell=new PdfPCell(new Phrase(a.getComentarios()));
            cell.setColspan(2);
        	table2.addCell(cell);
        	cell=new PdfPCell(new Phrase(a.getEstatus()));
        	table2.addCell(cell);
        	
        	cell=new PdfPCell();
        	cell.setColspan(6);
        	cell.setBorder(Rectangle.NO_BORDER);
        	cell.setFixedHeight(35);
        	table2.addCell(cell);
        }
        document.add(table2);
	}
	
	
	
}