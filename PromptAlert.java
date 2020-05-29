package week4day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class PromptAlert {
	
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
	driver.manage().window().maximize();
	driver.switchTo().frame("iframeResult");
	driver.findElementByXPath("//button[text()='Try it']").click();
	Alert alert= driver.switchTo().alert();
	alert.sendKeys("Hema");
	Thread.sleep(1000);
	alert.accept();
		String Name = driver.findElementById("demo").getText();
		System.out.println(Name);
		Thread.sleep(1000);

	if(Name.contains("Hema"))
	{
		System.out.println("Name Matched");
	}
	else
	{
		System.out.println("Name not Matched");
	}
	

}
}