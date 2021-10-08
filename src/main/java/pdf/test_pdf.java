package pdf;

import java.awt.event.ActionListener; //библиотека для события слушателя
import javax.swing.*; // Библиотека для GUI (построена на основе awt)
import pdf.ListenerButton;

//для сборки проекта с зависимостями используем Maven - "package shade:shade"

public class test_pdf {

	public static JTextField TextNumber;
	public static JTextField TextGroup;
	public static JTextField TextFIO;
	public static JTextField TextPoints;
	protected static  test_pdf kurs_pi;
	
	//замените магические числа везде!!! В примере числа используются для упрощения. В работе от них нужно избавиться.
	public test_pdf() {
	JFrame main_GUI = new JFrame("PDF");	// создание графического окна
	main_GUI.setTitle ("PDF create and edit");
	main_GUI.setBounds(500,400,400,300);
	main_GUI.setResizable(false); // фиксированный размер окна
	
	JPanel main_panel = new JPanel(); // Панель - используется для организации компонентов в окне
	main_panel.setLayout(null);
	main_GUI.add(main_panel);
		
	JLabel laba_info = new JLabel("Test create PDF-file"); // Отображение текста или изображения
	laba_info.setBounds(120,0,150,30);
	main_panel.add(laba_info);
	
	//создание надписей около текстовых полей
	JLabel labelNumber = new JLabel("Number");
	JLabel labelGroup = new JLabel("Group");
	JLabel labelFIO = new JLabel("FIO");
	JLabel labelPoints = new JLabel("Points");
	
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
	
	//форматирование текстовых волей - установка атрибутов положения и размера
	TextNumber.setBounds(130,30,150,30);
	TextGroup.setBounds(130,70,150,30);
	TextFIO.setBounds(130,110,150,30);
	TextPoints.setBounds(130,150,150,30);
	
	//добавление текстовых полей на панель
	main_panel.add(TextNumber);
	main_panel.add(TextGroup);
	main_panel.add(TextFIO);
	main_panel.add(TextPoints);
		
	
	JButton button_exit = new JButton("Exit"); // добавляем кнопку
	button_exit.setBounds(270,200,100,40);
	ActionListener actionListener = new ListenerButton(); //создаем слушатель
	button_exit.addActionListener(actionListener); // добавляем слушатель к кнопке
	main_panel.add(button_exit);
	
	JButton button_create = new JButton("Create PDF"); // добавляем кнопку
	button_create.setBounds(20,200,100,40);
	ActionListener actionCreate = new ListenerCreate(); //создаем слушатель для кнопки PDF
	button_create.addActionListener(actionCreate); // добавляем слушатель к кнопке
	main_panel.add(button_create);
	
	main_GUI.setVisible(true);
	main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие окна JFrame и процесса Java
		
	
	}
	
	public static void main(String[] args) { 
		kurs_pi= new test_pdf();
		
	}
	
}
