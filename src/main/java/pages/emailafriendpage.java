package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class emailafriendpage extends pagebase{
    public emailafriendpage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="FriendEmail")
    WebElement friendmail;
  //  @FindBy(id="YourEmailAddress")
    //WebElement youremail;
    @FindBy(name="send-email")
    WebElement sendbtn;
    @FindBy(css="div.result")
    public WebElement resultmessage;
    public void emailfriend(String fmail){
        settext(friendmail,fmail);
       // settext(youremail,yourmail);
        clickbutton(sendbtn);
    }
}
