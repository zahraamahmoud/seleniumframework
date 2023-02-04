package tests;


import data.loadproperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.Userregisterationpage;
import pages.loginpage;

import java.util.concurrent.TimeUnit;

public class userregisterationwithddt_propertyfiletest extends testbase{

    Homepage homepageobject;
    Userregisterationpage registerationpageobject;
    loginpage loginobject;
    String fname= loadproperties.userdata.getProperty("firstname");
    String lname=loadproperties.userdata.getProperty("lastname");
    String email=loadproperties.userdata.getProperty("mail");
    String pass=loadproperties.userdata.getProperty("password");
    @Test(priority = 1,alwaysRun = true)
    public void usercanregistersuccessfully()
    {
     homepageobject=new Homepage(driver);
     homepageobject.openRegisterationpage();
     registerationpageobject=new Userregisterationpage(driver);
     registerationpageobject.userregisteration(fname,lname,email,pass);
     driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
     Assert.assertTrue(registerationpageobject.successmessage.getText().equals("Your registration completed"));

    }

  /*   @Test(dependsOnMethods ="usercanregistersuccessfully")
    public void registeredusercanlogin(){
        homepageobject.openloginnpage();
        loginobject=new loginpage(driver);
        loginobject.userlogin("roem223@gmail.com","zaza12345");
         Assert.assertEquals(registerationpageobject.logoutlink.getText(),"Log out");

     }
    @Test(dependsOnMethods = "registeredusercanlogin")
    public void registeredusercanlogout()
    {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertEquals(registerationpageobject.logoutlink.getText(),"Log out");
        registerationpageobject.userlogout();
    }*/

}
