package pages;

import org.openqa.selenium.By;

import config.BasePage;

public class AddCustomerPage extends BasePage {
	
	public AddCustomerPage() {
		super();
	}
		
	By BMloginBtn = By.xpath("//button[@ng-click='manager()']");
	By AddCust    = By.xpath("//button[@ng-click='addCust()']");
	By FName      = By.xpath("//input[@placeholder='First Name']");
	By LName      = By.xpath("//input[@placeholder='Last Name']");
	By PostCode   = By.xpath("//input[@placeholder='Post Code']");
	By AddCustBtn    = By.xpath("//button[@class='btn btn-default']");
	
	public void clickBMlogin() throws InterruptedException {
		Thread.sleep(2000);
		click(BMloginBtn);
		System.out.println("Bank Manager login button is clicked");
	}

	
	public void clickAddCust() throws InterruptedException {
		Thread.sleep(2000);
		click(AddCust);
		System.out.println("Bank Manager login button is clicked");
	}
	
	public void fillCustForm(String fname, String lname,String postcode) throws InterruptedException {
		Thread.sleep(2000);
		type(FName,fname);
		type(LName,lname);
		type(PostCode,postcode);
		click(AddCustBtn);
		acceptAlert();
		System.out.println("Form is filled and Add customer button is clicked");
	}
	
}
