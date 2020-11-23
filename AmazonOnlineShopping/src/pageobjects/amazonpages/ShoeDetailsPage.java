package pageobjects.amazonpages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.amazon.AmazonTestPage;



public class ShoeDetailsPage extends AmazonTestPage {
	
WebDriver driver;
	
	@FindBy(how=How.ID, id="native_dropdown_selected_size_name")
	WebElement sizeDropdown;
	
	@FindBy(how=How.ID, id="quantity")
	WebElement shoeQuantity;
	
	@FindBy(how=How.ID, id="add-to-cart-button")
	WebElement addToCartButton;
	
	@FindBy(how=How.ID, id="hlb-view-cart-announce")
	WebElement cartButton;
	
	@FindBy(how=How.CSS, css="span[class='a-size-medium sc-product-title a-text-bold']")
	WebElement shoeNameTextAndSize;
	
	
	
	

	public ShoeDetailsPage(WebDriver driver) throws Exception {
		try
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		catch(Exception e) {
			Log.error("Error occured in Shoe details page Constructor : " +e.getMessage());
		}
	}
	
	
//Methods of Shoe details page
	
	//Method to select a size from the show size dropdown
	public void selectSize() throws Exception {
		 Select se=new Select(sizeDropdown);
		 se.selectByVisibleText("8 UK");
		 System.out.println("Shoes size is selected");
	}

	//Method to specify the quantity to buy
	public void selectQuantity() throws Exception {
		Select se=new Select(shoeQuantity);
		se.selectByVisibleText("2");
		System.out.println("Shoe quantity is selected");
	
	}
	
	//Method Waiting for Add to Cart button to be displayed and then clicking on it
	public boolean addToCart() throws Exception {
		  if(addToCartButton.isDisplayed())
		    {
			  addToCartButton.click();
			  System.out.println("Add to Cart Button is clicked");
		    	return true;
		    }
		  System.out.println("Add to Cart Button is not clicked");
		return false;

		}
		
	
	

//Method to click on Cart button to go to Shopping cart page 
	public void cartButtonClick() throws Exception {
		cartButton.click();
		System.out.println("Cart button is clicked");
		
	}
	
	//Verifying by Page Title that Shopping Cart Page appears
		public boolean verifyShoppingCartPageByPageTitle() throws Exception {
			
			String actualTitle = driver.getTitle();
		    String expectedTitle = "Amazon.in Shopping Cart";
		    if(actualTitle.equalsIgnoreCase(expectedTitle))
		    {
		    	System.out.println("We are on Shopping Cart Page");
		    	return true;
		    }
		    System.out.println("We are not on Shopping Cart Page");
		return false;

		}
		
		
		
		//Verifying the Shoes name and size that was selected on the previous page is same or not.
		
		public boolean verifyShoeNameAndSize() throws Exception {
				
			String text=shoeNameTextAndSize.getText();
			String shoeTitle="Bourge Men's Vega-3 R.Blue Running Shoes-8 UK/India (42 EU) (Vega-3-R.Blue-08)";
			if(text.contains(shoeTitle))			
			  {
				System.out.println("Shoe name and Size is same as selected on previous page");
		    	return true;
		    }
			System.out.println("Shoe name and size is not same as was selected on previous page");
		    return false;

		}
		
		
}

