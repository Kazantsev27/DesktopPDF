/**
 * ���������� ����� ��� �������� PDF ��������� � ������ ������ ���������.
 * @author Kazantsev
 * @version 1.2
 * @return void
 * 
 * ����� � ������ ������ ������������ ������������ �����������, ������� �� ����� �����������.
 */

package pdf;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;

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

//����� ����������� ��������� (�������� ������� ������)
//����� �������, �� ��� ����� ������������ (� ��������� �� �� ������������)
public class ListenerCreate implements ActionListener {
	
	BaseFont times = null; //������ ������
	
	@Override // �������� �����, ������� ��������� � �������� ������ ������ ������� ���������� ������ ������������� ������
	public void actionPerformed(ActionEvent arg0) { //���������� ������ ��� ��������, ���������� � ���������� PDF �����
		Document document = new Document(); //�������� ������� Document
		try {
			PdfWriter.getInstance(document, new FileOutputStream("Check.pdf")); //�������� ����� ��� �������� PDF, � ������ ��������� ����� ������ � ���������� ������
		} catch (FileNotFoundException | DocumentException e) { //���������� ����� ���� �� ������
			e.printStackTrace();
		}
			
		document.open(); //�������� ��� ����������� ������
				
		try {
			times = BaseFont.createFont("/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
		String string_pdf = "������ ����!";
		Paragraph paragraph = new Paragraph(); //�������� ������� "��������" ��� ����������� ������ ������ � ����
	    paragraph.add(new Paragraph(string_pdf, new Font(times,14)));
	    
	    String string_pdf2 = "�������������� �����, ������� ��������� � PDF. ��� ���� ����� ��������, ��� ����� ��������� ��������, ������� ����� ��������� � ���� PDF.";
	    paragraph.add(new Paragraph(string_pdf2, new Font(times,14)));
	
	    try {
			document.add(paragraph);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
	    	    
	    //���������� ����������� � pdf
	    URL url = getClass().getResource("/picture/ugatu.png");
	    Image img = null;
		try {
			img = Image.getInstance(url.toString());
			
			
		} catch (BadElementException e2) {
			
			e2.printStackTrace();
		} catch (MalformedURLException e2) {
			
			e2.printStackTrace();
		} catch (IOException e2) {
			
			e2.printStackTrace();
		}
		
		img.setAbsolutePosition(90, 500); //���������������� ����������� � PDF
		
		try {
				document.add(img);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
	    	    
		 //����������� �������� �� ��������� ������
		 paragraph.clear();
		 String string_pdf3 = " ";
		 paragraph.add(new Paragraph(string_pdf3, new Font(times,14)));
		 
		 try {
				document.add(paragraph);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}
		 		 
	    //���������� �������
		 PdfPTable table = new PdfPTable(4); //�������� ������� � 4 ���������
		 addHeader(table); //���������� ��������� (����� �������)
		 addRows(table); // ���������� �����
		 
		 try {
			document.add(table);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		document.close(); //�������� � ���������� ���������
		
	}

	private void addRows(PdfPTable table) {
		
		//���������� ������� ��������� ���������� � ��������� ���� �� ������� �����
		String cell1 = "null";
		String cell2 = "null";
		String cell3 = "null";
		String cell4 = "null";
		
		cell1 = Create_pdf_with_gui.TextNumber.getText();
		cell2 = Create_pdf_with_gui.TextGroup.getText();
		cell3 = Create_pdf_with_gui.TextFIO.getText();
		cell4 = Create_pdf_with_gui.TextPoints.getText();
		
		table.addCell(cell1);
	    table.addCell(cell2);
	    table.addCell(cell3);
	    table.addCell(cell4);
		
	    //���� ������ ���� ����� �� ������� �����, ��� ��� ������� ����� ���������� � �������.
	}

	private void addHeader(PdfPTable table) { //����� ��� ������ � ������ �������
		Stream.of("�����", "������", "���", "������") //����� � ���������� ��� �����
	      .forEach(columnTitle -> { //� ����� ��� ���� ������ � ������ ���� ������� ������, ������� �������� � ������������� �������� ������ 
	        PdfPCell header = new PdfPCell(); //���������� ������ � �������
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(2);
	        //���� ������������ ���� (��� ����� ���������)
	        try {
				times = BaseFont.createFont("/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);
			} catch (DocumentException | IOException e) {
				e.printStackTrace();
			}
			//��������� �������� � ������ ��� ���������� ������ � ������	        
	        header.setPhrase(new Phrase(columnTitle,new Font(times,14)));
	        table.addCell(header); 
	    });
		
	}

	
}
