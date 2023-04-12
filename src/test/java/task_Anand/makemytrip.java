package task_Anand;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makemytrip {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://www.makemytrip.com/");
		List<WebElement>data=wd.findElements(By.xpath(".//span[@class='chNavText darkGreyText']"));
	for(int i=0;i<data.size();i++){
		System.out.println(data.get(i).getText());
	}
	}
	

}
