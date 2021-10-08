package pdf;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



//класс реализующий слушатель (ожидания нажатия кнопки)
public class ListenerCreate implements ActionListener {
	
	BaseFont times = null;
	
	@Override // ключевое слово, которое позволяет в дочернем классе заново создать реализацию метода родительского класса
	public void actionPerformed(ActionEvent arg0) { //реализация метода для создания, наполнения и сохранения PDF файла
		Document document = new Document(); //создание объекта Document
		try {
			PdfWriter.getInstance(document, new FileOutputStream("Check.pdf")); //выходной поток для создания PDF, а внутри создается поток записи с конкретным именем
		} catch (FileNotFoundException | DocumentException e) { //Исключение когда файл не найден
			e.printStackTrace();
		}
			
		document.open(); //открытие для возможности записи
		
		
		try {
			times = BaseFont.createFont("/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
		String string_pdf = "Добрый день!";
		Paragraph paragraph = new Paragraph(); //создание объекта "параграф" для возможности записи данных в файл
	    paragraph.add(new Paragraph(string_pdf, new Font(times,14)));
	    
	    String string_pdf2 = "Дополнительный текст, который выводится в PDF. При этом нужно понимать, что можно указывать значения, которые будут выводится в файл PDF.";
	    paragraph.add(new Paragraph(string_pdf2, new Font(times,14)));
	
	    try {
			document.add(paragraph);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
	    	
	    
	    //добавление изображения в pdf
	    URL url = getClass().getResource("/picture/ugatu.png");
	    Image img = null;
		try {
			img = Image.getInstance(url.toString());
			
			
		} catch (BadElementException e2) {
			
			e2.printStackTrace();
		} catch (MalformedURLException e2) {
			
			e2.printStackTrace();
		} catch (IOException e2) {
			
			e2.printStackTrace();
		}
		
		img.setAbsolutePosition(90, 500); //позиционирование изображения в PDF
		
		try {
				document.add(img);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
	    
	    
		 //организация перехода на следующую строку
		 paragraph.clear();
		 String string_pdf3 = " ";
		 paragraph.add(new Paragraph(string_pdf3, new Font(times,14)));
		 
		 try {
				document.add(paragraph);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}
		 
		 
	    //добавление таблицы
		 PdfPTable table = new PdfPTable(4); //создание таблицы с 4 столбцами
		 addHeader(table); //добавление заголовка (шапки таблицы)
		 addRows(table); // добавление строк
		 
		 try {
			document.add(table);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		document.close(); //закрытие и сохранение документа
		
	}

	private void addRows(PdfPTable table) {
		
		//заполнение таблицы вводимыми значениями в текстовые поля на главной форме
		String cell1 = "null";
		String cell2 = "null";
		String cell3 = "null";
		String cell4 = "null";
		
		cell1 = Create_pdf_with_gui.TextNumber.getText();
		cell2 = Create_pdf_with_gui.TextGroup.getText();
		cell3 = Create_pdf_with_gui.TextFIO.getText();
		cell4 = Create_pdf_with_gui.TextPoints.getText();
		
		table.addCell(cell1);
	    table.addCell(cell2);
	    table.addCell(cell3);
	    table.addCell(cell4);
		
	    //выше должен быть текст на русском языке, как его вывести можно посмотреть в справке.
	}

	private void addHeader(PdfPTable table) { //метод для работы с шапкой таблицы
		Stream.of("Номер", "Группа", "ФИО", "Оценка") //поток с названиями для шапки
	      .forEach(columnTitle -> { //в цикле для всех данных в потоке выше создаем ячейки, заносим названия и устанавливаем свойства ячейки 
	        PdfPCell header = new PdfPCell(); //реализация ячейки в таблице
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(2);
	        //ниже дублирование кода (это можно устранить)
	        try {
				times = BaseFont.createFont("/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);
			} catch (DocumentException | IOException e) {
				e.printStackTrace();
			}
			//установка значения и шрифта для выводимого текста в ячейки	        
	        header.setPhrase(new Phrase(columnTitle,new Font(times,14)));
	        table.addCell(header); 
	    });
		
	}

	
}
