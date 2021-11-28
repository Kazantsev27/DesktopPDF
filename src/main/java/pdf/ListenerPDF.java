package pdf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.Document;

import create.CreatePDF;

public class ListenerPDF implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] NameCell = new String[5];
		NameCell[0]=Create_pdf_with_gui.TextNumber.getText();
		NameCell[1]=Create_pdf_with_gui.TextGroup.getText();
		NameCell[2]=Create_pdf_with_gui.TextFIO.getText();
		NameCell[3]=Create_pdf_with_gui.TextPoints.getText();
		NameCell[4]="��������";
		
		String[] Hat = new String[5];
		//����� ��� ������ � �� �������
		Hat[0]="�����";
		Hat[1]="������";
		Hat[2]="������� �.�.";
		Hat[3]="������";
		Hat[4]="��������";
		String Texthat = "�������� PDF �����.";
		String Textgeneral = "����� ����� ����� ������� ���������� ��������. ����� �������� ������������ ������� ���������� ������";
		URL Imagelink=getClass().getResource("/picture/ugatu.png");
		String Namefile = "Document.pdf";
		BaseFont times = null;
		try {
			times = BaseFont.createFont("/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);
		} catch (DocumentException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		CreatePDF pdf = new CreatePDF(Hat,NameCell,Namefile,times);
		Document document = pdf.getDocument();
		pdf.addText(document, Texthat, 20,true);
		pdf.addText(document, Textgeneral, 14,true);
		pdf.addTable(document);
		pdf.addPicture(Imagelink, document, 90, 300);
		pdf.getClose();
		
		//����� ���� � ���������� � �������� �����
		JOptionPane.showMessageDialog(null, "���� " + Namefile + " ������","Create PDF", JOptionPane.PLAIN_MESSAGE);
	}
}
