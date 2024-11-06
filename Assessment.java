package Asessment;

import java.time.Duration;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Asessment_01 {
		public static void main(String[] args) throws InterruptedException {
			ChromeDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			//Step 1: User go to "https://pos.com.my/send/ratecalculator"
			driver.get("https://pos.com.my/send/ratecalculator");
			//Step 2: User enter “Malaysia” as “From” country, and enter “35600” as the post-code
			driver.findElement(By.cssSelector("[formcontrolname=\"postcodeFrom\"]")).sendKeys("35600");
			//Step 3: User enter “India” as “To” country, and leave the post-code empty
			WebElement to_country = driver.findElement(By.cssSelector("[aria-label=\"country\"]"));
			to_country.clear();
			to_country.sendKeys("India");
			driver.findElement(By.cssSelector("[title='India - IN']")).click();
			//Step 4: User enter 1 as the “Weight”, and user press Calculate
			driver.findElement(By.cssSelector("[formcontrolname=\"itemWeight\"]")).sendKeys("1");
			driver.findElement(By.partialLinkText("Calculate")).click();
			//step:5:To Verify user can see multiple quotes and shipments options
			int total_count_quotes = driver.findElements(By.xpath("//div[contains(@class,\"border-b border\")]")).size();
			System.out.print(total_count_quotes);
			if(total_count_quotes>1) {
			System.out.println("user can see multiple quotes and shipments options");
			}
			else {
			System.out.println("user cant see multiple quotes and shipments options");
			}
			driver.close();
		}
	}
	


