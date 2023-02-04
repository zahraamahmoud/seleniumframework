package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class checkoutpage extends pagebase{
    public checkoutpage(WebDriver driver) {
        super(driver);
    }
   public  Select select;


    @FindBy(css= "button.button-1.checkout-as-guest-button")
    WebElement checkoutasguestbtn;
    @FindBy(id="BillingNewAddress_FirstName")
    WebElement guestfirstname;
    @FindBy(id="BillingNewAddress_LastName")
    WebElement guestlastname;
    @FindBy(id="BillingNewAddress_Email")
    WebElement guestemail;
    @FindBy(id="BillingNewAddress_CountryId")
    WebElement countrylist;
    @FindBy(id="BillingNewAddress_StateProvinceId")
    WebElement statelist;
    @FindBy(id="BillingNewAddress_City")
    WebElement city;
    @FindBy(id="BillingNewAddress_Address1")
    WebElement address;
    @FindBy(id="BillingNewAddress_ZipPostalCode")
    WebElement postalcode;
    @FindBy(id="BillingNewAddress_PhoneNumber")
    WebElement phonenumber;
    @FindBy(name="save")
            //shipping method
    WebElement savebtn;
    @FindBy(id="shippingoption_1")
    WebElement nextdayairradiobtn;
    @FindBy(css="button.button-1.shipping-method-next-step-button")
    WebElement continuebtn;
    @FindBy(id="paymentmethod_0")
    WebElement paybycheck;
    @FindBy(css="button.button-1.payment-method-next-step-button")
    WebElement savepaymentmethod;
    @FindBy(css="button.button-1.payment-info-next-step-button")
    WebElement savepaymentinfo;
    @FindBy(css="td.product")
    public WebElement productname;
    @FindBy(css="button.button-1.confirm-order-next-step-button")
    WebElement confirmbtn;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong")
    public WebElement successmessage;
    @FindBy(linkText = "Click here for order details.")
    WebElement orderdetailslink;
    public void checkoutasguest(){
          clickbutton(checkoutasguestbtn);
     }
     public void guestdetails(String fname,String lname,String mail){
        settext(guestfirstname,fname);
        settext(guestlastname,lname);
        settext(guestemail,mail);

     }
    public void shippingaddress(String country,String state,String cityname,String addre,String pstcode,String phone){
        clickbutton(countrylist);
        select=new Select(countrylist);
        select.selectByVisibleText(country);
        clickbutton(statelist);
        select=new Select(statelist);
        select.selectByVisibleText(state);
        settext(city,cityname);
        settext(address,addre);
        settext(postalcode,pstcode);
        settext(phonenumber,phone);
        clickbutton(savebtn);

    }
    public void shippingmethod(){
        clickbutton(nextdayairradiobtn);
        clickbutton(continuebtn);

    }
    public void paymentmethod(){
        clickbutton(paybycheck);
        clickbutton(savepaymentmethod);
        clickbutton(savepaymentinfo);

    }
    public void confirmorder(){
        clickbutton(confirmbtn);
       // Assert.assertTrue(successmessage.getText().contains("successfully"));

    }
    public void openorderdetailspage(){
        clickbutton(orderdetailslink);
    }


}
