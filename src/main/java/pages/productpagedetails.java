package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productpagedetails extends pagebase{
    public productpagedetails(WebDriver driver)
    {
        super(driver);
        jse=(JavascriptExecutor)driver;
    }
    @FindBy(css="strong.current-item")
    public WebElement productnamebreadcrumb;
    @FindBy(css="div.product-name")
    WebElement productname;
    @FindBy(css="button.button-2.email-a-friend-button")
    WebElement emailfriendbtn;
    @FindBy(linkText = "Add your review")
    WebElement addreviewlink;
    @FindBy(id="add-to-wishlist-button-4")
    WebElement addtowishlistbtn;
    @FindBy(css = "a.ico-wishlist")
    WebElement wishlistlink;
   @FindBy(css="button.button-2.add-to-compare-list-button")
   WebElement addtocomparelistbtn;
   @FindBy(linkText = "Compare products list")
   WebElement comparelistlink;
   @FindBy(id="add-to-cart-button-4")
   WebElement addtocartbtn;
   @FindBy(css="a.ico-cart")
   WebElement shoppingcartlink;
   public String getproductname()
   {

       return (productname.getText());
   }
    public void openemailfriendpage()
    {

        clickbutton(emailfriendbtn);
    }
    public void openproductreviewpage()
    {
        clickbutton(addreviewlink);
    }
  public void addtowishlist()
  {
        clickbutton(addtowishlistbtn);
  }
  public void openwishlistpage()
  {
        clickbutton(wishlistlink);
  }
  public void addtocart(){

       clickbutton(addtocartbtn);
  }
  public void  opencartpage(){
       clickbutton(shoppingcartlink);
  }
    public void addtocomparelist()
    {
        clickbutton(addtocomparelistbtn);
    }
    public void opencomparelistpage()
    {
        scrolltobottom();
        clickbutton(comparelistlink);

    }

}
