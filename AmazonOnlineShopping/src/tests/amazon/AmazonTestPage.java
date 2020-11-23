package tests.amazon;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageobjects.amazonpages.ShoeDetailsPage;
import pageobjects.amazonpages.ShoeListPage;

public class AmazonTestPage{

	public WebDriver driver;
	public String URL="https://www.amazon.in/";

	@BeforeTest
	public void launchWebsite() {
		
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(URL);
	        driver.manage().window().maximize();
	        
	}


@Test
public void shoeSelection() throws Exception
{
	 
	ShoeListPage obj1=new ShoeListPage(driver);
	obj1.isSearchTextBoxDisplayed();
	obj1.enterTextInSearchBox();
	obj1.clickSearch();
	obj1.verifyShoeSearchResultsByPageTitle();
	obj1.verifyShoeSearchResults();
	obj1.clickFirstFilter();
	obj1.clickSecondFilter();
	obj1.verifyFilterResults();
	obj1.clickonShoe();
	obj1.switchTab();

ShoeDetailsPage obj2=new ShoeDetailsPage(driver);
obj2.selectSize();
obj2.selectQuantity();
obj2.addToCart();
obj2.cartButtonClick();
obj2.verifyShoppingCartPageByPageTitle();
obj2.verifyShoeNameAndSize();


}
@AfterTest
public void closeBrowser() {
	//To close the newly opened tab
    driver.close();
    //To close the main tab
    driver.quit();
    System.out.println("The process is completed");

}
}

