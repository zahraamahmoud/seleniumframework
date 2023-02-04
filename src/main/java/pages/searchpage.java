package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class searchpage extends pagebase{
    public searchpage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="small-searchterms")
    WebElement searchtxt;
    // list of suggestion;
    @FindBy(css="a.ui-menu-item-wrapper")
    List<WebElement> productlist;
    @FindBy(css = "button.button-1.search-box-button")
    WebElement searchbtn;
    @FindBy(css="h2.product-title>a")
    WebElement producttitle;
    public void productsearch(String productname)
    {
        settext(searchtxt,productname);
        clickbutton(searchbtn);
    }
    public void openproductdetailspage()
    {

        clickbutton(producttitle);
    }
    public void productsearchusingautosuggest(String txt){
        settext(searchtxt,txt);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        productlist.get(0).click();
    }

}
