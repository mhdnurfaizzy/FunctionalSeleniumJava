package functionalTest;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new EdgeDriver();
		
		int j=0;
		String[] itemsNedeed= {"Brocolli", "Cucumber", "Beetroot", "Carrot"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		List <WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<products.size();i++) 
		{
			String[] name=products.get(i).getText().split("-");
			String formatedName=name[0].trim();
			
			
			List itemsNeededList = Arrays.asList(itemsNedeed);
			
			
			if(itemsNeededList.contains(formatedName))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsNedeed.length)
				{
					break;
				}
			}
		}
		
	}

}
