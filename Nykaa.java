package week4day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable notifications--");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.nykaa.com");
		driver.manage().window().maximize();
		WebElement brand = driver.findElementByXPath("//a[text()='brands']");
		Actions builder = new Actions(driver);
		builder.moveToElement(brand).perform();
		Thread.sleep(2000);
		WebElement popular = driver.findElementByXPath("//a[text()='Popular']");
	    Actions builder1 = new Actions(driver);
	    builder1.moveToElement(popular).perform();
	    driver.findElementByXPath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']").click();
	    Set<String> allHandles = driver.getWindowHandles();
		List<String> winHandle = new ArrayList<String>(allHandles);
		System.out.println(allHandles.size());
		driver.switchTo().window(winHandle.get(1));
		String title = driver.getTitle();		
		System.out.println(title);
		if(title.contains("L'Oreal Paris"))
		{
			System.out.println("Title contains L'Oreal Paris");
		}
		
		else {
			System.out.println("Title Does not contains L'Oreal Paris");
		}
		
		driver.switchTo().window(winHandle.get(0));
		
		driver.close();
		driver.switchTo().window(winHandle.get(1));		
		driver.findElementByXPath("//span[text()='Sort By : ']").click();
		driver.findElementByXPath("//span[text()='customer top rated']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[text()='Category']").click();
		driver.findElementByXPath("//span[text()='Shampoo (16)']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//img[@class='listing-img']").click();
		driver.switchTo().window(winHandle.get(1));
		Thread.sleep(2000);
		driver.findElementByXPath("//button[text()='ADD TO BAG']").click();
		driver.findElementByXPath("//div[@class='AddBagIcon']").click();
		driver.findElementByXPath("//span[text()='Proceed']").click();
		String Msg = driver.findElementByXPath("//div[@class='popup-error']").getText();
		System.out.println(Msg);
		driver.close();
	}

}
