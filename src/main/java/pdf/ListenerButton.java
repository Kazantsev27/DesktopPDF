package pdf;

import java.awt.event.*;

import javax.swing.JOptionPane;

// класс реализующий слушатель (ожидания нажатия кнопки)
public class ListenerButton implements ActionListener {

	@Override // ключевое слово, которое позволяет в дочернем классе заново создать реализацию метода родительского класса
	public void actionPerformed(ActionEvent arg0) {	
	
		String f2="Вы уверены что хотите выйтиgfgfgffgh??";
		new exit(f2);
		
	}
}

