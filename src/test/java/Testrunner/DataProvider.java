package Testrunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Base.BaseClass;

public class DataProvider extends BaseClass {
	@Test(priority = 0)
	public void searchHotel() {
		WebElement location=driver.findElement(By.id("location"));
		Select a=new Select(location);
		a.selectByValue("London");
		WebElement hotel=driver.findElement(By.id("hotels"));
		Select b=new Select(hotel);
		b.selectByValue("Hotel Sunshine");
		WebElement room=driver.findElement(By.xpath("//*[@id=\"room_type\"]"));
		Select c=new Select(room);
		c.selectByIndex(1);
		
		
		driver.findElement(By.id("Submit")).click();
	}
	@Test(priority = 1)
	private void selectHotel() {
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.xpath(".//input[@id='continue']")).click();
	}
	
	@Test(priority = 2)
	private void bookAHotel() {
		driver.findElement(By.id("first_name")).sendKeys("kavya");
		driver.findElement(By.name("last_name")).sendKeys("G");
		driver.findElement(By.xpath(".//textarea[@rows='4']")).sendKeys("hyd");
		driver.findElement(By.xpath(".//input[@id='cc_num']")).sendKeys("9999999999999999");
		Select s3=new Select(driver.findElement(By.id("cc_type")));
		s3.selectByIndex(4);
		Select s4=new Select(driver.findElement(By.xpath(".//select[@id='cc_exp_month']")));
		s4.selectByVisibleText("December");
		Select s5=new Select(driver.findElement(By.xpath(".//select[@id='cc_exp_year']")));
		s5.selectByVisibleText("2022");
		driver.findElement(By.id("cc_cvv")).sendKeys("432");
		driver.findElement(By.id("book_now")).click();
	}
	@Test(priority = 3)
	private void printOrderNo() throws InterruptedException {
		Thread.sleep(7000);
		String orderNo=driver.findElement(By.id("order_no")).getAttribute("value");
		System.out.println("Order Number is : "+orderNo);
	}

}

