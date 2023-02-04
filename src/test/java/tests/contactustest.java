package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.contactuspage;

public class contactustest extends testbase{
    contactuspage contactusobject;
    Homepage homepageobject;
    String name="zahraa";
    String mail="zaz@gmail.com";
    String enquiry="my order is late";

    @Test
    public void usercancontactus(){

        contactusobject=new contactuspage(driver);
        homepageobject=new Homepage(driver);
        homepageobject.opencontactuspage();
        contactusobject.writeenquiry(name,mail,enquiry);
        Assert.assertTrue(contactusobject.successmessage.getText().contains("successfully sent "));
    }


}
