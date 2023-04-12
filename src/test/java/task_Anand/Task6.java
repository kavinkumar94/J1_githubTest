package task_Anand;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task6 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wd.get("https://www.makemytrip.com/");
		Thread.sleep(1000);
		wd.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/ul/li[4]")).click();
		
		
		wd.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/ul/li[2]")).click();
		 WebElement from=wd.findElement(By.id("fromCity"));
		 from.sendKeys("chennai");
		 Thread.sleep(2000);
		 wd.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div/div/ul/li[1]/div/div[1]/p[1]")).click();
		//wd.findElement(By.id("fromCity")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
	
		
		wd.findElement(By.id("toCity")).sendKeys("new delhi");
		Thread.sleep(1000);
		wd.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/div/div/ul/li[1]/div/div[1]/p[1]")).click();
		Thread.sleep(1000);
		wd.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[3]/div[6]/div/p")).click();
		Thread.sleep(1000);
		wd.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[4]/div[5]/div/p")).click();
		
		wd.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div[5]/label/span")).click();
		Thread.sleep(1000);
		wd.findElement(By.xpath(".//li[text()='Business']")).click();
		wd.findElement(By.xpath(".//button[text()='APPLY']")).click();
		
		wd.findElement(By.xpath(".//a[text()='Search']")).click();
		Thread.sleep(5000);
		wd.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/span")).click();
		List<WebElement> xpath=wd.findElements(By.xpath(".//p[@class='blackText fontSize16 blackFont']"));
		
		ArrayList price=new ArrayList();
		for (int i = 0; i < xpath.size(); i++) {
			price.add(xpath+xpath.get(i).getText());
			//System.out.println(xpath.size());
		}
		
		Collections.sort(price);
		for (int i = 0; i < price.size(); i++) {
			//System.out.println(price.get(i));
		}
		String highestPrice=(String) price.get(price.size()-1);
		
		String highestpriceXpath=highestPrice.substring(81, 126);
		//System.out.println(highestPrice);
		String newXpath=highestpriceXpath+"/following::span[@class='customRadioBtn']["+price.size()+"]";
		//System.out.println(newXpath);
		WebElement element=wd.findElement(By.xpath(newXpath));
		JavascriptExecutor js=(JavascriptExecutor)wd;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		wd.findElement(By.xpath(".//button[text()='Book Now']")).click();
		wd.findElement(By.xpath(".//button[text()='Continue']")).click();
		
		
		
		//Collections.sort(pricelist);
		
		//wd.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div[3]/label/span")).click();
		//wd.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[2]/div[5]")).click();
		//wd.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/p")).click();
		//wd.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/p")).click();
		//wd.navigate().refresh();
		//wd.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/p/a")).click();
		//Thread.sleep(5000);
		//wd.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/span")).click();
		
		
		//Thread.sleep(3000);
		//wd.quit();
		
		
	}
}	
