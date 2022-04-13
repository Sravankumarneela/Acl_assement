package config;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	public BasePage() {
		
	}
	
	@BeforeTest
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	
	public void launchURL(String url) {
		driver.get(url);
		System.out.println(url+" is launched");
	}
	
	public void click(By locator) {
		//addExplicitWait(locator, "visibility", 10);
		try {
            driver.findElement(locator).click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("The element with"
                    + locator.toString().replace("By.", " ")
                    + " not found");
        }
	}
	
	public boolean isElementVisible(By locator) {
        addExplicitWait(locator, "visibility", 10);
        boolean bool = driver.findElement(locator).isDisplayed();
        return bool;
    }
	
	public void type(By locator, String value) {
		addExplicitWait(locator, "visibility", 10);
        try {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(value);
            
        } 
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("The element with"
                    + locator.toString().replace("By.", " ")
                    + " not found");
        }
    }
	public void selectDropDownByText(By locator, String name) {
		addExplicitWait(locator, "visibility", 10);
        try {
            Select dropDown = new Select(driver.findElement(locator));
            dropDown.selectByVisibleText(name);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("The element with"
                    + locator.toString().replace("By.", " ")
                    + " not found");
        }
    }
	public void acceptAlert() {
        try {
            Alert alertBox = driver.switchTo().alert();
            alertBox.accept();
           
        } catch (NoAlertPresentException e) {
          
            throw new NoAlertPresentException("Alert not present");
        }
    }
	
	public void addExplicitWait(By locator, String condition, int inttimeoutinseconds) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, inttimeoutinseconds, 250L);
        try {
            if (condition.equalsIgnoreCase("visibility")) {
                webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
            } else if (condition.equalsIgnoreCase("clickable")) {
                webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
                
            } else if (condition.equalsIgnoreCase("presence")) {
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
                
            } 
              
        } catch (NoSuchElementException e) {
            
            throw new NoSuchElementException("The element with"
                    + locator.toString().replace("By.", " ")
                    + " not found");
        } 
    }
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
