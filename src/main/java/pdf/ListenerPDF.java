package pdf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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
		new CreatePDF(f1,f2,f3,f4,Hat);
		
		//����� ���� � ���������� � �������� �����
		JOptionPane.showMessageDialog(null, "���� check.pdf ������","Create PDF", JOptionPane.PLAIN_MESSAGE);
		
	}

	
}
