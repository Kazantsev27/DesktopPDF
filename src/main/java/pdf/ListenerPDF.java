package pdf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;

import create.CreatePDF;

public class ListenerPDF implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String TextNumber=Create_pdf_with_gui.TextNumber.getText();
		String TextGroup=Create_pdf_with_gui.TextGroup.getText();
		String TextFIO=Create_pdf_with_gui.TextFIO.getText();
		String TextPoints=Create_pdf_with_gui.TextPoints.getText();
		String[] Hat = new String[4];
		//����� ��� ������ � �� �������
		Hat[0]="�����";
		Hat[1]="������";
		Hat[2]="������� �.�.";
		Hat[3]="������";
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
		
		new CreatePDF(TextNumber,TextGroup,TextFIO,TextPoints,Hat,Texthat,Textgeneral,Imagelink,Namefile,times);
		
		//����� ���� � ���������� � �������� �����
		JOptionPane.showMessageDialog(null, "����" + Namefile + "������","Create PDF", JOptionPane.PLAIN_MESSAGE);
	}
}
