package task_Anand;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task3 {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://en.wikipedia.org/wiki/Chennai");
		WebElement para=wd.findElement(By.xpath("/html/body/div[3]/div[3]/div[5]/div[1]/p[5]"));
		String data=para.getText();
		System.out.println(data);
		String city="Chennai";
		String words[]=data.split(" ");
		int a=0;
		if(data.contains(city)){
		for (int i = 0; i < words.length; i++) {
			if(words[i].equals(city)){
				a=a+1;
			}
		}
		}else{
			System.out.println("no Chennai in the paragraph");
		}
		
		
		System.out.println(a);
		String newData=data.replace("Chennai", "Madras");
		System.out.println(newData);
		
		File f=new File("G:/Batch251/Task_1Project/file/wiki.txt");
		f.createNewFile();
		FileWriter fw=new FileWriter(f);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(newData);
		bw.close();
		}
	}
