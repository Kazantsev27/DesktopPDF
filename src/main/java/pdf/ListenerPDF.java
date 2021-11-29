package pdf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.Document;

import create.CreatePDF;

public class ListenerPDF implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[][] NameCell = new String[2][4];
		NameCell[0][0]=Create_pdf_with_gui.TextNumber.getText();
		NameCell[0][1]=Create_pdf_with_gui.TextGroup.getText();
		NameCell[0][2]=Create_pdf_with_gui.TextFIO.getText();
		NameCell[0][3]=Create_pdf_with_gui.TextPoints.getText();
		NameCell[1][0]="Данные1";
		NameCell[1][1]="Данные2";
		NameCell[1][2]="Данные3";
		NameCell[1][3]="Данные3";
		
		String[] Hat = new String[4];
		Hat[0]="Номер";
		Hat[1]="Группа";
		Hat[2]="Фамилия И.О.";
		Hat[3]="Оценка";

		String Texthat = "                                    Создание PDF файла.";
		String Textgeneral = "Здесь будет текст который необходимо выводить. Можно добавить достаточного большое "
				+ "количество текста. Можно продолжать писать и писать, но нужно когда-то остановиться "
				+ "и закончить. В таблице 1 приведены данные, которые можно вывести из TextField "
				+ "и данные которые просто присваиваются переменным.";
		String TextTable = "                 Таблица 1. Основные данные для вывода";
		String TextNext = "Текст после таблицы тоже без проблем можно добавлять! На рисунке 1 изображение логотипа.";
		URL Imagelink=getClass().getResource("/picture/ugatu.png");
		String Namefile = "Document.pdf";
		BaseFont times = null;
		try {
			times = BaseFont.createFont("/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);
		} catch (DocumentException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		CreatePDF pdf = new CreatePDF(Namefile,times);
		Document document = pdf.getDocument();
		pdf.addText(document, Texthat, 20,true);
		pdf.addText(document, Textgeneral, 14,true);
		pdf.addText(document, TextTable, 14, true);
		pdf.InitTableAndAddHat(document,Hat);
		pdf.addRowsInTable(pdf.getTable(), NameCell);
		pdf.addTable(document,pdf.getTable());
		pdf.addText(document, TextNext, 14,true);
		pdf.addPicture(Imagelink, document, 90, 400);
		pdf.addText(document, " ", 14, true);
		pdf.addText(document, " ", 14, true);
		pdf.addText(document, "               Рис. 1 Главный логотип для размешения на официальных документах", 14, true);
		pdf.getClose();
		
		//вывод окна с сообщением о создании файла
		JOptionPane.showMessageDialog(null, "Файл " + Namefile + " создан","Create PDF", JOptionPane.PLAIN_MESSAGE);
	}
}
