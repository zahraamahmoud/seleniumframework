package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Homepage extends pagebase{

    public Homepage(WebDriver driver) {

        super(driver);
        jse=(JavascriptExecutor)driver;
        action=new Actions(driver) ;
        }

    public Select select;

    @FindBy(css="a.ico-register")
    public  WebElement registerlink;
    @FindBy(css= "a.ico-login")
    WebElement loginlink;
    @FindBy(linkText ="My account")
    public WebElement myaccountlink;

    @FindBy(linkText = "Contact us")
    WebElement cotactuslink;
    @FindBy(id="customerCurrency")
    WebElement currencylist;
    @FindBy(css="div.prices")
    public WebElement price;

    @FindBy(linkText = "Computers")
    WebElement computersmenue;
    @FindBy(linkText = "Notebooks")
    WebElement notebookssection;
    @FindBy(className = "page-title")
     public WebElement categorytitle;
    public void openRegisterationpage()
    {

        clickbutton(registerlink);
    }
    public void openloginnpage()
    {
        clickbutton(loginlink);

    }
    public void openmyaccountpage()
    {
        clickbutton(myaccountlink);

    }
    public void opencontactuspage(){
        scrolltobottom();
        clickbutton(cotactuslink);
    }


    public void changecurrency(String currency){
        select=new Select(currencylist);
        select.selectByVisibleText(currency);
        scrolltoproductpart();

    }
    public void selectnotebookssection(){
        //

        action.moveToElement(computersmenue).build().perform();
        action.moveToElement(notebookssection).click().build().perform();
    }
}
