package functionalTest;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class fluentWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.xpath("//button[normalize-space()='Start']")).click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			
		     public WebElement apply(WebDriver driver) {
		    	 
		       if (driver.findElement(By.xpath("//h4[normalize-space()='Hello World!']")).isDisplayed())
		       {
		    	   return driver.findElement(By.xpath("//h4[normalize-space()='Hello World!']"));
		       }
		       else return null;
		       
		     }
		     
		   });

		System.out.println(driver.findElement(By.xpath("//h4[normalize-space()='Hello World!']")).getText());
		

	}

}
