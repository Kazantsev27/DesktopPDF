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
		Hat[0]="Номер";
		Hat[1]="Группа";
		Hat[2]="Фамилия И.О.";
		Hat[3]="Оценка";
		new CreatePDF(f1,f2,f3,f4,Hat);
		
		//вывод окна с сообщением о создании файла
		JOptionPane.showMessageDialog(null, "Файл check.pdf создан","Create PDF", JOptionPane.PLAIN_MESSAGE);
		
	}

	
}
