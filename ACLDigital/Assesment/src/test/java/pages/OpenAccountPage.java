package pages;

import org.openqa.selenium.By;

import config.BasePage;

public class OpenAccountPage extends BasePage {
	
	public OpenAccountPage() {
		super();
	}
	
	By OpenAccBtn    = By.xpath("//button[@ng-click='openAccount()']");
	By custSelect    = By.xpath("//select[@name='userSelect']");
	By curSelect     = By.xpath("//select[@name='currency']");
	By process       = By.xpath("//button[text()='Process']");
	By Customers     = By.xpath("//button[@ng-click='showCust()']");
	public By getcust(String name) {
        return By.xpath("//td[@class='ng-binding' and contains(text(),'"+name+"')]");
    }
	public void clickOpenAccBtn() throws InterruptedException {
		Thread.sleep(4000);
		click(OpenAccBtn);
		System.out.println("Open Account button is clicked");
	}
	
	public void fillAccDetails(String name, String cur) throws InterruptedException {
		Thread.sleep(2000);
		selectDropDownByText(custSelect, name);
		selectDropDownByText(curSelect, cur);
		acceptAlert();
		System.out.println("Open Account completed");
	}
	
	public void clickCust() throws InterruptedException {
		Thread.sleep(2000);
		click(Customers);
		System.out.println("Customer Details button is clicked");
	}
	
	public void custVisible(String name) throws InterruptedException {
		Thread.sleep(2000);
		isElementVisible(getcust(name));
		System.out.println("Account is created");
	}

}
