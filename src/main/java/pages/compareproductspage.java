package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class compareproductspage extends pagebase{
    public compareproductspage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="div.page-title")
    WebElement pagetitle;
    @FindBy(css = "a.clear-list")
    WebElement clearlistbtn;
    @FindBy(css="tr.product-name")
    public WebElement productsnameincomparelist;

    @FindBy(css="div.no-data")
    public WebElement noitemsmessage;


    public void clearlist()
    {
        clickbutton(clearlistbtn);
    }

}
