package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage extends pagebase
{
    public loginpage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="Email")
    WebElement emailtxt;
    @FindBy(id="Password")
    WebElement passtxt;
    @FindBy(css="button.button-1.login-button")
    WebElement loinbtn;
    public void userlogin(String mail,String pass)
    {
      settext(emailtxt,mail);
      settext(passtxt,pass);
      clickbutton(loinbtn);

    }
}
