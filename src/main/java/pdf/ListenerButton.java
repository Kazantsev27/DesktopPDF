package pdf;

import java.awt.event.*;

import javax.swing.JOptionPane;

// ����� ����������� ��������� (�������� ������� ������)
public class ListenerButton implements ActionListener {

	@Override // �������� �����, ������� ��������� � �������� ������ ������ ������� ���������� ������ ������������� ������
	public void actionPerformed(ActionEvent arg0) {	
	
		String exitHat="�� ������� ��� ������ �����??";
		String exitLow="���������� ������ ����������";
		new exit(exitHat, exitLow);
		
	}
}

