package pdf;

import java.awt.event.*;

// класс реализующий слушатель (ожидания нажатия кнопки)
public class ListenerButton implements ActionListener {

	@Override // ключевое слово, которое позволяет в дочернем классе заново создать реализацию метода родительского класса
	public void actionPerformed(ActionEvent arg0) {		
		System.exit(1);
	}
}

