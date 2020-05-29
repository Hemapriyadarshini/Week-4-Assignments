package week4day2;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flight {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.findElementByXPath("//button[@class = 'btn btn-primary']").click();
		driver.findElementByXPath("//span[@class = 'allcircle circleone']").click();
		Set<String> allHandles = driver.getWindowHandles();
		List<String> winHandle = new ArrayList<String>(allHandles);
		System.out.println(allHandles.size());
		driver.switchTo().window(winHandle.get(1));		
		driver.findElementByXPath("(//label[@class = 'custom-control-label'])[2]").click();
		driver.findElementByXPath("//button[text() = 'Continue ']").click();
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/flight1.png");
		FileUtils.copyFile(src, dest);
		
		driver.switchTo().window(winHandle.get(0));	
		driver.close();
		
	}

}
