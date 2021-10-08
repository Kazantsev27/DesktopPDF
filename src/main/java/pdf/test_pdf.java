package pdf;

import java.awt.event.ActionListener; //���������� ��� ������� ���������
import javax.swing.*; // ���������� ��� GUI (��������� �� ������ awt)
import pdf.ListenerButton;

//��� ������ ������� � ������������� ���������� Maven - "package shade:shade"

public class test_pdf {

	public static JTextField TextNumber;
	public static JTextField TextGroup;
	public static JTextField TextFIO;
	public static JTextField TextPoints;
	protected static  test_pdf kurs_pi;
	
	//�������� ���������� ����� �����!!! � ������� ����� ������������ ��� ���������. � ������ �� ��� ����� ����������.
	public test_pdf() {
	JFrame main_GUI = new JFrame("PDF");	// �������� ������������ ����
	main_GUI.setTitle ("PDF create and edit");
	main_GUI.setBounds(500,400,400,300);
	main_GUI.setResizable(false); // ������������� ������ ����
	
	JPanel main_panel = new JPanel(); // ������ - ������������ ��� ����������� ����������� � ����
	main_panel.setLayout(null);
	main_GUI.add(main_panel);
		
	JLabel laba_info = new JLabel("Test create PDF-file"); // ����������� ������ ��� �����������
	laba_info.setBounds(120,0,150,30);
	main_panel.add(laba_info);
	
	//�������� �������� ����� ��������� �����
	JLabel labelNumber = new JLabel("Number");
	JLabel labelGroup = new JLabel("Group");
	JLabel labelFIO = new JLabel("FIO");
	JLabel labelPoints = new JLabel("Points");
	
	//���������� label �� ������
	main_panel.add(labelNumber);
	main_panel.add(labelGroup);
	main_panel.add(labelFIO);
	main_panel.add(labelPoints);
	
	//�������������� label - ��������� ��������� ��������� � �������
	labelNumber.setBounds(30,30,150,30);
	labelGroup.setBounds(30,70,150,30);
	labelFIO.setBounds(30,110,150,30);
	labelPoints.setBounds(30,150,150,30);
	
	//�������� ��������� ����� � ������������ ���� 15 ��������
	TextNumber = new JTextField(15);
	TextGroup = new JTextField(15);
	TextFIO = new JTextField(15);
	TextPoints = new JTextField(15);
	
	//�������������� ��������� ����� - ��������� ��������� ��������� � �������
	TextNumber.setBounds(130,30,150,30);
	TextGroup.setBounds(130,70,150,30);
	TextFIO.setBounds(130,110,150,30);
	TextPoints.setBounds(130,150,150,30);
	
	//���������� ��������� ����� �� ������
	main_panel.add(TextNumber);
	main_panel.add(TextGroup);
	main_panel.add(TextFIO);
	main_panel.add(TextPoints);
		
	
	JButton button_exit = new JButton("Exit"); // ��������� ������
	button_exit.setBounds(270,200,100,40);
	ActionListener actionListener = new ListenerButton(); //������� ���������
	button_exit.addActionListener(actionListener); // ��������� ��������� � ������
	main_panel.add(button_exit);
	
	JButton button_create = new JButton("Create PDF"); // ��������� ������
	button_create.setBounds(20,200,100,40);
	ActionListener actionCreate = new ListenerCreate(); //������� ��������� ��� ������ PDF
	button_create.addActionListener(actionCreate); // ��������� ��������� � ������
	main_panel.add(button_create);
	
	main_GUI.setVisible(true);
	main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���� JFrame � �������� Java
		
	
	}
	
	public static void main(String[] args) { 
		kurs_pi= new test_pdf();
		
	}
	
}
