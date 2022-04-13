package testcase;

import org.testng.annotations.Test;

import pages.AddCustomerPage;
import pages.OpenAccountPage;

public class Test1 {
	
	@Test
	public void test() throws InterruptedException {
	AddCustomerPage acp = new AddCustomerPage();
	OpenAccountPage oap = new OpenAccountPage();
	String url = "https://www.way2automation.com/angularjs-protractor/banking/#/login";
	acp.launchURL(url);
	acp.clickBMlogin();
	acp.clickAddCust();
	acp.fillCustForm("sravan", "neela", "E725JB");
	oap.clickOpenAccBtn();
	oap.fillAccDetails("Sravan Neela", "Rupee");
	oap.clickCust();
	oap.custVisible("Sravan");
	}
	

}
