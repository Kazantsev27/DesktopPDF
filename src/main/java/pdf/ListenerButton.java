package pdf;

import java.awt.event.*;

import javax.swing.JOptionPane;

// класс реализующий слушатель (ожидания нажатия кнопки)
public class ListenerButton implements ActionListener {

	@Override // ключевое слово, которое позволяет в дочернем классе заново создать реализацию метода родительского класса
	public void actionPerformed(ActionEvent arg0) {	
		
		int exit = JOptionPane.showConfirmDialog(null,
                "Вы уверены что хотите выйти??",
                 "Завершение работы пррограммы",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
		
		if (JOptionPane.YES_OPTION==exit) {
			System.exit(1);
		}
		
	}
}

