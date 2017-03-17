package multiple_parallel_complex;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.apache.commons.io.FileUtils;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class ParallelComputerTest2 {

	@Test
	public void test() {
		Class[] cls = { ParallelTest1.class, ParallelTest2.class };

		/*
		 * //Parallel among classes
		 * JUnitCore.runClasses(ParallelComputer.classes(), cls);
		 * 
		 * //Parallel among methods in a class
		 * JUnitCore.runClasses(ParallelComputer.methods(), cls);
		 */
		// Parallel all methods in all classes
		JUnitCore.runClasses(new ParallelComputer(true, true), cls);
	}

	
	
	
	public static class ParallelTest1 {

		private ScreenRecorder screenRecorder;

		@Test
		public void a() throws IOException {
			processit(ParallelTitleFetch(1));

		}

		@Test
		public void b() throws Exception {

			ParallelTest1 videoReord = new ParallelTest1();
			videoReord.startRecording();

			processit2(ParallelTitleFetch(1));
			videoReord.stopRecording();

		}

		public static WebDriver ParallelTitleFetch(int num) {
			System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			return driver;

		}

		public void startRecording() throws Exception {

			File file = new File("C:\\Videos1");

			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int width = screenSize.width;
			int height = screenSize.height;

			Rectangle captureSize = new Rectangle(0, 0, width, height);

			GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
					.getDefaultConfiguration();

			this.screenRecorder = new SpecializedScreenRecorder(gc, captureSize,
					new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
					new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
							CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
							Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
					new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
					null, file, "MyVideo");
			this.screenRecorder.start();

		}

		public void stopRecording() throws Exception {
			this.screenRecorder.stop();
		}

		public static void processit(WebDriver driver) throws IOException {


			driver.navigate().to("http://www.datastax.com/");
			String appTitle = driver.getTitle();
			System.out.println("Application title is :: "+appTitle);
			
			
			
			
			
		
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			try {	
				driver.findElement(By.xpath(".//*[@id='menu-item-37117']/a")).click();
				driver.findElement(By.xpath(".//*[@id='menu-item-47644']/a")).click();
				
				
			}

			catch (Exception e) {

			}
		
			
			File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile1, new File("screenshot1.png"));

			
			driver.close();

		

		
			
		}

		public static void processit2(WebDriver driver) throws IOException {


			driver.navigate().to("http://www.datastax.com/");
			String appTitle = driver.getTitle();
			System.out.println("Application title is :: "+appTitle);
			
			
			
			
			
		
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			try {	
				driver.findElement(By.xpath(".//*[@id='menu-item-37117']/a")).click();
				driver.findElement(By.xpath(".//*[@id='menu-item-47644']/a")).click();
				
				
			}

			catch (Exception e) {

			}
		
			
			File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile1, new File("screenshot1.png"));

			
			driver.close();

		

		
			
		}

	}
	
	
	
	
	
	
	
	

	public static class ParallelTest2 {
		@Test
		public void a() throws IOException {
			processit(ParallelTitleFetch(1));

		}

		@Test
		public void b() throws Exception {

			processit2(ParallelTitleFetch(1));

		}

		public static WebDriver ParallelTitleFetch(int num) {
			System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			return driver;

		}

		public static void processit(WebDriver driver) throws IOException {


			driver.navigate().to("http://www.datastax.com/");
			String appTitle = driver.getTitle();
			System.out.println("Application title is :: "+appTitle);
			
			
			
			
			
		
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			try {	
				driver.findElement(By.xpath(".//*[@id='menu-item-37117']/a")).click();
				driver.findElement(By.xpath(".//*[@id='menu-item-47644']/a")).click();
				
				
			}

			catch (Exception e) {

			}
		
			
			File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile1, new File("screenshot1.png"));

			
			driver.close();

		

		
			
		}

		public static void processit2(WebDriver driver) throws IOException {


			driver.navigate().to("http://www.datastax.com/");
			String appTitle = driver.getTitle();
			System.out.println("Application title is :: "+appTitle);
			
			
			
			
			
		
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			try {	
				driver.findElement(By.xpath(".//*[@id='menu-item-37117']/a")).click();
				driver.findElement(By.xpath(".//*[@id='menu-item-47644']/a")).click();
				
				
			}

			catch (Exception e) {

			}
		
			
			File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile1, new File("screenshot1.png"));

			
			driver.close();

		

		
			
		}

	}

}
