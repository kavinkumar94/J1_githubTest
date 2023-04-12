package task_Anand;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task4 {
	public static void main(String[] args) throws IOException, InterruptedException {
		File f=new File("C:\\Batch251\\C2_WebdriverTest\\file\\login.properties");
		File f1=new File("C:\\Batch251\\C2_WebdriverTest\\file\\SimpleForm.xlsx");
		FileInputStream fis=new FileInputStream(f);
		FileInputStream fis1=new FileInputStream(f1);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis1);
		XSSFSheet sheet=workbook.getSheet("form");
		
		Properties prop=new Properties();
		prop.load(fis);
		
		WebDriverManager.chromedriver().setup();
		WebDriver wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.get((String) prop.get("login"));
		
		WebElement username=wd.findElement(By.name("username"));
		username.sendKeys((String) prop.get("username"));
		WebElement password=wd.findElement(By.name("password"));
		password.sendKeys((String) prop.get("password"));
		password.submit();
		wd.get((String) prop.get("form"));
		
		for (int i = 0; i < 6; i++) {
			wd.findElement(By.id("id"+i)).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());	
		}
		
		//wd.findElement(By.id("id0")).sendKeys(sheet.getRow(0).getCell(0).getStringCellValue());
		//wd.findElement(By.id("id1")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		//wd.findElement(By.id("id2")).sendKeys(sheet.getRow(2).getCell(0).getStringCellValue());
		//wd.findElement(By.id("id3")).sendKeys(sheet.getRow(3).getCell(0).getStringCellValue());
		//wd.findElement(By.id("id4")).sendKeys(sheet.getRow(4).getCell(0).getStringCellValue());
		//wd.findElement(By.id("id5")).sendKeys(sheet.getRow(5).getCell(0).getStringCellValue());
		wd.findElement(By.id("idyes")).click();
		wd.findElement(By.id("cod")).click();
		Thread.sleep(3000);
		wd.findElement(By.id("order")).click();
		}
	}
