package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class wishlistpage extends pagebase{
    public wishlistpage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="a.product-name")
    public WebElement product;
    @FindBy(css="button.remove-btn")
    WebElement removebtn;
    @FindBy(css="div.no-data")
    WebElement emptycart;

    public void removeproductfromwishlist(){
        clickbutton(removebtn);
        Assert.assertTrue(emptycart.getText().contains("empty"));
    }



}
