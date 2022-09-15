package com.sample.test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TEtx {
	
	@Test
	public void m() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MATEEQ\\Downloads\\New folder (3)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.get("https://demoqa.com/browser-windows");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("windowButton"))));
		
        // Open new child window within the main window
        driver.findElement(By.id("windowButton")).click();
        

       String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
           
            }
        }
        String y  = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(y);
        
		Thread.sleep(5000);
		driver.quit();
	}

}
