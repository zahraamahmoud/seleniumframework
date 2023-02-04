package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Userregisterationpage extends pagebase {

    public Userregisterationpage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(id="gender-male")
    WebElement genderradiobtn;

    @FindBy(id="FirstName")
    WebElement firstnametxt;
    @FindBy(id="LastName")
    WebElement lastnametxt;
    @FindBy(id="Email")
    WebElement emailtxt;
    @FindBy(id="Password")
    WebElement passwordtxt;
    @FindBy(id="ConfirmPassword")
    WebElement confirmpasswordtxt;
    @FindBy(id="register-button")
    WebElement registerationbtn;
    @FindBy(css = "div.result")
    public WebElement successmessage;
    @FindBy(css="a.ico-logout")
     public  WebElement logoutlink;

    public void userregisteration(String fname,String lname,String email,String pass)
    {
    clickbutton(genderradiobtn);
    settext(firstnametxt,fname);
    settext(lastnametxt,lname);
    settext(emailtxt,email);
    settext(passwordtxt,pass);
    settext(confirmpasswordtxt,pass);
    clickbutton(registerationbtn);
    }
    public void userlogout()
    {
        clickbutton(logoutlink);

    }







}
