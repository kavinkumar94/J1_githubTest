package task_Anand;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AamzonTask {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wd.get("https://www.amazon.in/gp/bestsellers/books/ref=zg_bs_nav_0");
	/**	List<WebElement> Company =wd.findElements(By.xpath("(.//span[text()='Paperback']//ancestor::div[5])"));
		for (int i = 0; i <Company.size(); i++) {
	WebElement	element	=Company.get(i).findElement(By.xpath("(.//div[@class='a-row a-size-small'])[1]"));
		String text	=element.getText();
		System.out.println(text);
		}*/
		List<WebElement> Company =wd.findElements(By.xpath("(.//span[text()='Paperback']//ancestor::div[5]//div[@class='a-row a-size-small'][1])"));
		for (int i = 0; i <Company.size(); i++) {
			String text	=Company.get(i).getText();

		System.out.println(text);
		}
		//String title ="Paperback";
		//String fullXpath="(.//span[text()='"+title+"']//ancestor::div[5]//div[@class='a-row a-size-small'][1])";
		
		
	}

}
