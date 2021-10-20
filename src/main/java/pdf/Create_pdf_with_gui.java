/** Класс реализующий графический интерфейс.
 * @author Kazantsev
 * @version 1.5
 * 
 * Класс имеет один конструктор по умолчанию.
 * Класс имеет один метод без параметров.
 */

package pdf;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Create_pdf_with_gui{

	public static JTextField TextNumber;
	public static JTextField TextGroup;
	public static JTextField TextFIO;
	public static JTextField TextPoints;
	
	public Create_pdf_with_gui() {
	JFrame main_GUI = new JFrame("PDF");	// создание графического окна
	main_GUI.setTitle ("Создание типового PDF-файла");
	main_GUI.setBounds(500,400,400,300);
	main_GUI.setResizable(false); // фиксированный размер окна
	
	JPanel main_panel = new JPanel(); // Панель - используется для организации компонентов в окне
	main_panel.setLayout(null);
	main_GUI.add(main_panel);
		
	JLabel laba_info = new JLabel("Создания PDF файла для десктоп приложения"); //создание объект "Метка" с заданным значением
	laba_info.setBounds(60,0,300,30);
	main_panel.add(laba_info);
	
	//создание надписей около текстовых полей
	JLabel labelNumber = new JLabel("Номер");
	JLabel labelGroup = new JLabel("Группа");
	JLabel labelFIO = new JLabel("ФИО");
	JLabel labelPoints = new JLabel("Оценка");
	
	//добавление label на панель
	main_panel.add(labelNumber);
	main_panel.add(labelGroup);
	main_panel.add(labelFIO);
	main_panel.add(labelPoints);
	
	//форматирование label - установка атрибутов положения и размера
	labelNumber.setBounds(30,30,150,30);
	labelGroup.setBounds(30,70,150,30);
	labelFIO.setBounds(30,110,150,30);
	labelPoints.setBounds(30,150,150,30);
	
	//создание текстовых полей с размерностью поля 15 символов
	TextNumber = new JTextField(15);
	TextGroup = new JTextField(15);
	TextFIO = new JTextField(15);
	TextPoints = new JTextField(15);
	
	//форматирование текстовых полей - установка атрибутов положения и размера
	TextNumber.setBounds(130,30,150,30);
	TextGroup.setBounds(130,70,150,30);
	TextFIO.setBounds(130,110,150,30);
	TextPoints.setBounds(130,150,150,30);
	
	//добавление текстовых полей на панель
	main_panel.add(TextNumber);
	main_panel.add(TextGroup);
	main_panel.add(TextFIO);
	main_panel.add(TextPoints);
	
	JButton button_exit = new JButton("Выход"); // добавляем кнопку
	button_exit.setBounds(270,200,100,40);
	ActionListener actionListener = new ListenerButton(); //создаем слушатель
	button_exit.addActionListener(actionListener); // добавляем слушатель к кнопке
	main_panel.add(button_exit);
	
	JButton button_create = new JButton("Создать PDF"); // добавляем кнопку
	button_create.setBounds(20,200,150,40);
	ActionListener actionCreate = new ListenerPDF(); //создаем слушатель для кнопки PDF
	button_create.addActionListener(actionCreate); // добавляем слушатель к кнопке
	main_panel.add(button_create);
	
	main_GUI.setVisible(true);
	main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие окна JFrame и процесса Java
		
	}

}
