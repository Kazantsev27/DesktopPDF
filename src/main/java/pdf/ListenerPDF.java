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
		// TODO Auto-generated method stub
		String f1=Create_pdf_with_gui.TextNumber.getText();
		String f2=Create_pdf_with_gui.TextGroup.getText();
		String f3=Create_pdf_with_gui.TextFIO.getText();
		String f4=Create_pdf_with_gui.TextPoints.getText();
		String[] Hat = new String[4];
		Hat[0]="�����";
		Hat[1]="������";
		Hat[2]="������� �.�.";
		Hat[3]="������";
		String Texthat = "�������� PDF �����.";
		String Textgeneral = "����� ����� ����� ������� ���������� ��������. ����� �������� ������������ ������� ���������� ������";
		URL Imagelink=getClass().getResource("/picture/ugatu.png");
		String Namefile = "TestPDF.pdf";
		BaseFont times = null;
		try {
			times = BaseFont.createFont("/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);
		} catch (DocumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		new CreatePDF(f1,f2,f3,f4,Hat,Texthat,Textgeneral,Imagelink,Namefile,times);
		
		//����� ���� � ���������� � �������� �����
		JOptionPane.showMessageDialog(null, "����" + Namefile + "������","Create PDF", JOptionPane.PLAIN_MESSAGE);
	}

	
}
