package Basics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class BasicTitleFetch {
	
	public static void main(String...args) {
		
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.marketo.com/");
		String appTitle = driver.getTitle();
		System.out.println("Application title is :: "+appTitle);

		driver.findElement(By.xpath(".//*[@id='products']/a")).click();
		driver.findElement(By.xpath(".//*[@id='solutions']/a")).click();
		driver.findElement(By.xpath(".//*[@id='why-marketo']/a")).click();
		driver.findElement(By.xpath(".//*[@id='resources']/a")).click();
		
		driver.quit();
	}

}