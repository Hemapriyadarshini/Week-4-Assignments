package week4day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLeads {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		WebElement Username = driver.findElementById("username");
		Username.sendKeys("Demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByXPath("//a[text()='Contacts']").click();
		driver.findElementByXPath("//a[text()='Merge Contacts']").click();
		driver.findElementByXPath("//img[@alt='Lookup']").click();
		Set<String> allHandles = driver.getWindowHandles();
		List<String> winHandle = new ArrayList<String>(allHandles);
		System.out.println(allHandles.size());
		driver.switchTo().window(winHandle.get(1));		
		driver.findElementByXPath("//a[text()='DemoCustomer']").click();
		driver.switchTo().window(winHandle.get(0));
		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
		Set<String> allHandles1 = driver.getWindowHandles();
		List<String> winHandle1 = new ArrayList<String>(allHandles1);
		driver.switchTo().window(winHandle1.get(1));
		driver.findElementByXPath("//a[text()='dontship2me']").click();
		driver.switchTo().window(winHandle.get(0));
		driver.findElementByXPath("//a[text()='Merge']").click();
		Alert alert= driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();		
		System.out.println(title);
		
	}

}
