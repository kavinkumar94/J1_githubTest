package task_Anand;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class datatables {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://datatables.net/");
		List<WebElement> head=wd.findElements(By.xpath("(.//th[@tabindex='0'])"));
		for(int i=0;i<head.size();i++){
			System.out.print(head.get(i).getText()+" ");
		}
		wd.findElement(By.xpath("(.//input[@type='search'])")).sendKeys("London");
	WebElement path= wd.findElement(By.xpath("(.//tr[@class='even'][5])"));
	String data=((WebElement) path).getText();
	System.out.println();
//	for(int i=0;i<path.size();i++){  
	//	System.out.print(path.get(i).getText()+" ");
	//}
	System.out.print(data+"");
	}

}
