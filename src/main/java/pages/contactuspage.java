package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class contactuspage extends pagebase{
    public contactuspage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="FullName")
     WebElement fullname;
    @FindBy(id="Email")
    WebElement email;
    @FindBy(id="Enquiry")
    WebElement enquiry;
    @FindBy(name = "send-email")
    WebElement submitbtn;
    @FindBy(css="div.result")
    public WebElement successmessage;

    public void writeenquiry(String name,String mail,String enq){
        settext(fullname,name);
        settext(email,mail);
        settext(enquiry,enq);
        clickbutton(submitbtn);
    }


}
