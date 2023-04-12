package task_Anand;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task2 {
	public static void main(String[] args) throws IOException {
		File f=new File("G:/Batch251/Task_1Project/file/task1.xlsx");
		FileInputStream fis=new FileInputStream(f);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Home");
		XSSFSheet sheet2=workbook.createSheet("Title");
		
		int row=sheet.getLastRowNum()+1;
		int col=sheet.getRow(0).getLastCellNum();
		WebDriverManager.chromedriver().setup();
		WebDriver wd=new ChromeDriver();
		wd.manage().window().maximize();
		
		for(int rownum=0;rownum<row;rownum++){
			for(int colnum=0;colnum<col;colnum++){
				String data=sheet.getRow(rownum).getCell(colnum).getStringCellValue();
				
				wd.get("https://www.google.co.in/");
				WebElement element=wd.findElement(By.name("q"));
				element.sendKeys(data);
				element.submit();
				String title=wd.getTitle();	
				XSSFRow row1=sheet2.createRow(rownum);
				XSSFCell cell=row1.createCell(colnum);
				cell.setCellValue(title);
				}
			}

		FileOutputStream fos=new FileOutputStream(f);
		workbook.write(fos);
		fos.close();
	}	
}
