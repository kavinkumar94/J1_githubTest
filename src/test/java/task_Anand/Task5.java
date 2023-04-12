package task_Anand;

import java.time.Duration;
import java.util.Set;

import org.bouncycastle.util.Arrays.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task5 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd=new ChromeDriver();
		
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wd.get("https://www.flipkart.com/");
		//Thread.sleep(3000);
		wd.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		wd.findElement(By.className("_3704LK")).sendKeys("iphone 12");
		wd.findElement(By.className("_3704LK")).submit();
		wd.findElement(By.partialLinkText("APPLE iPhone 12 (White, 128 GB)")).click();
		Set<String> sessions= wd.getWindowHandles();
		Iterator<String> it=(Iterator<String>) sessions.iterator();
		
		String parentIt=it.next();
		String childIt=it.next();
		wd.switchTo().window(childIt);
		WebElement productLink=wd.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/h1/span"));
		String productName=productLink.getText();
		WebElement priceLink=wd.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div/div[4]/div[1]/div/div[1]"));
		String price=priceLink.getText();
		String productTitle="APPLE iPhone 12 (White, 128 GB)";
		//String priceTile="57,999";
		if( productName.equals(productTitle)){
			WebElement product=wd.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button"));
			product.click();
			//wd.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div/div[3]/div/div[2]/div[2]/div[3]/button/span")).click();
			System.out.println(productName);
			
			//WebDriverWait wait=new WebDriverWait(wd, Duration.ofSeconds(20));
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@id='container']/descendant::div[54]")));
			WebElement confirmProduct=wd.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div/div[3]/div/div[1]/div[1]/div[1]/a"));
			confirmProduct.sendKeys(Keys.ARROW_DOWN);
			confirmProduct.sendKeys(Keys.ARROW_DOWN);
			confirmProduct.sendKeys(Keys.ARROW_DOWN);
			confirmProduct.sendKeys(Keys.ARROW_DOWN);
			confirmProduct.sendKeys(Keys.ARROW_DOWN);
			confirmProduct.sendKeys(Keys.ARROW_DOWN);
			confirmProduct.sendKeys(Keys.ARROW_DOWN);
			confirmProduct.sendKeys(Keys.ARROW_DOWN);
			System.out.println(confirmProduct.getText());
			WebElement remove=wd.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div/div[3]/div/div[3]/div[2]/div[2]"));
			remove.click();
			wd.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div[2]")).click();
			wd.close();
			wd.switchTo().window(parentIt);
			wd.findElement(By.className("_3704LK")).clear();
			Thread.sleep(3000);
			wd.quit();
			System.err.println(productName);
			
		}else{
			System.out.println("Add to cart failed");
		}	
		
	}

}
