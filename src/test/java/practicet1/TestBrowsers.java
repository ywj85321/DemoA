package practicet1;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBrowsers {
	public WebDriver driver;
	
	@BeforeClass
	public void Initialization(){
		Browsers browsers = new Browsers(BrowsersType.firefox);
		driver = browsers.driver;
	}
	
	
	@Test
	public void start(){
		driver.manage().window().maximize(); 
		driver.navigate().to("https://www.baidu.com/");
		/*
		WebElement link = driver.findElement(By.xpath("//a[text()='糯米']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('target','_self');", link);
		link.click();*/
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void close(){
		driver.quit();
	}
}
