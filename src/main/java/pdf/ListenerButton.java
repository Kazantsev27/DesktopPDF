package pdf;

import java.awt.event.*;

import javax.swing.JOptionPane;

// ����� ����������� ��������� (�������� ������� ������)
public class ListenerButton implements ActionListener {

	@Override // �������� �����, ������� ��������� � �������� ������ ������ ������� ���������� ������ ������������� ������
	public void actionPerformed(ActionEvent arg0) {	
		
		int exit = JOptionPane.showConfirmDialog(null,
                "�� ������� ��� ������ �����??",
                 "���������� ������ ����������",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
		
		if (JOptionPane.YES_OPTION==exit) {
			System.exit(1);
		}
		
	}
}

