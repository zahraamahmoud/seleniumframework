package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class shoppingcartpage extends pagebase{
    public shoppingcartpage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="a.product-name")
    public WebElement productnameincart;
    @FindBy(css="button.remove-btn")
    WebElement removebtn;
    @FindBy(css="input.qty-input")
    public WebElement quantitytxt;
    @FindBy(css = "span.product-subtotal")
    WebElement subtotal;
    @FindBy(id="updatecart")
    WebElement updatecart;
    @FindBy(id="termsofservice")
    WebElement termofsevicecheckbox;
    @FindBy(id="checkout")
    WebElement checkoutbtn;
    @FindBy(css="div.no-data")
    public WebElement  noitemsmessage;
    public void removeitems(){
        clickbutton(removebtn);
    }
    public void changeitemquantity(String x){
        cleartxt(quantitytxt);
        settext(quantitytxt,x);
        clickbutton(updatecart);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    }
    public void opencheckoutpage(){
       if(!termofsevicecheckbox.isSelected()){
           clickbutton(termofsevicecheckbox);
       }
       clickbutton(checkoutbtn);

    }

}
