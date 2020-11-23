package pageobjects.amazonpages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import tests.amazon.AmazonTestPage;


public class ShoeListPage extends AmazonTestPage {
WebDriver driver;
	
	@FindBy(how=How.ID, id="twotabsearchtextbox")
	WebElement searchTextBox;
	
	@FindBy(how=How.ID, id="nav-search-submit-text")
	WebElement searchButton;
	
	@FindBy(how=How.CSS, css="div[class='a-section a-spacing-small a-spacing-top-small']")
	WebElement shoeText;
	
	@FindBy(how=How.XPATH, xpath="//*[@id='p_89/Bourge']/span/a/div/label/i")
	WebElement bourgeFilterCheckbox;
	
	@FindBy(how=How.XPATH, xpath="//*[@id='p_89/Puma']/span/a/div/label/i")
	WebElement pumaFilterCheckbox;
	
	@FindBy(how=How.CSS, css="span[class='a-size-base-plus a-color-base']")
	List<WebElement> filterResultsCheck;
	
	@FindBy(how=How.XPATH, xpath="//span[contains(text(),'Vega-3')]")
	WebElement specificShoe;
	
	
	public ShoeListPage(WebDriver driver) throws Exception {
		try
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		catch(Exception e) {
			Log.error("Error occured in Shoe list landing page Constructor : " +e.getMessage());
		}
	}
	
	
//Methods of Shoe list page
	
	//Method to check that Search textbox is present on page
	public boolean isSearchTextBoxDisplayed() throws Exception {
		return searchTextBox.isDisplayed();
	}
	
	//Method to enter "Shoes" in the Search Text Box
	public void enterTextInSearchBox() throws Exception {
		String text="Shoes";
		searchTextBox.sendKeys(text);
		System.out.println("Shoes is entered for search in the text box");
	
	}
	
	//Method to click on Search icon to get the results after entering Shoes in text box
	public void clickSearch() throws Exception {
		searchButton.click();
		System.out.println("Search button is clicked");
		
	}
	
	//Verifying that Page appears only for the Shoes searched from Page Title
	public boolean verifyShoeSearchResultsByPageTitle() throws Exception {
		
		String actualTitle = driver.getTitle();
	    String expectedTitle = "Amazon.in : Shoes";
	    if(actualTitle.equalsIgnoreCase(expectedTitle))
	    {
	    	System.out.println("Page has results of Shoes as per Page title");
	    	return true;
	    }
	    System.out.println("Page does not have results of Shoes as per Page title");
	return false;

	}
	
	
	//Verifying the Page results by the text "Showing results for 'Shoes'" at the top
	
public boolean verifyShoeSearchResults() throws Exception {
		
	String text=shoeText.getText();
	String Item="Shoes";
	if(text.contains(Item))			
	  {
		System.out.println("Page has results of Shoes showing in the top");
    	return true;
    }
	System.out.println("Page does not have results of Shoes showing at the top of the page");
    return false;

}



//Method to click on Bourge Brand checkbox under Filter
	public void clickFirstFilter() throws Exception {
		bourgeFilterCheckbox.click();
		System.out.println("Bourge filter is selected");
		
	}
//Method to click on Puma Brand checkbox under Filter
	public void clickSecondFilter() throws Exception {
	pumaFilterCheckbox.click();
	System.out.println("Puma filter is selected");
			
		}
	
	
//Method to verify the results appear according to selected brand filters	
public boolean verifyFilterResults() {
		for(WebElement element : filterResultsCheck)	{
			String filterName= element.getText();
			if(filterName.contains("Bourge") || filterName.contains("Puma"))
		
		  {
			System.out.println("Page has results of Shoes according to applied filter brands-Puma and Bourge");
	    	return true;
	    }
	}
		System.out.println("Page does not have results of Shoes according to the applied filters");
	    return false;

	}
		

	//Method to click on the Shoe of our choice
		public void clickonShoe() throws Exception {
			specificShoe.click();
			System.out.println("Men's Vega-3 Shoe is selected to be bought");
				
			

	}
		
//Method to switch to a new tab after selecting the Shoe
		public void switchTab() throws Exception {
		//Get the list of window handles
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		//Switching to the newly opened tab
		driver.switchTo().window(tabs.get(1));
		}
		

}
