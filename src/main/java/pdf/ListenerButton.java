package pdf;

import java.awt.event.*;

// ����� ����������� ��������� (�������� ������� ������)
public class ListenerButton implements ActionListener {

	@Override // �������� �����, ������� ��������� � �������� ������ ������ ������� ���������� ������ ������������� ������
	public void actionPerformed(ActionEvent arg0) {		
		System.exit(1);
	}
}

