package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myaccountpage extends pagebase{
    public myaccountpage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Change password")
    WebElement changepasslink;
    @FindBy(id="OldPassword")
    WebElement oldpass;
    @FindBy(id="NewPassword")
    WebElement newpass;
    @FindBy(id="ConfirmNewPassword")
    WebElement confirmpnewpass;
    @FindBy(css= "button.button-1.change-password-button")
    WebElement changepassbtn;
    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p")
    public WebElement resultmessage;
    public void openchangepasspage()
    {

        clickbutton(changepasslink);
    }
    public void changepassword(String oldpassword,String newpassword)
    {
        settext(oldpass,oldpassword);
        settext(newpass,newpassword);
        settext(confirmpnewpass,newpassword);
        clickbutton(changepassbtn );

    }

}
