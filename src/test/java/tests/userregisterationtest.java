package tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.Userregisterationpage;
import pages.loginpage;

import java.util.concurrent.TimeUnit;

public class userregisterationtest extends testbase{

    Homepage homepageobject;
    Userregisterationpage registerationpageobject;
    loginpage loginobject;
    @DataProvider(name="testdata")
    public static Object[][] userdata(){

        return new Object[][]{{"zahraa","mahmoud","zaa@yahoo.com","1234567"},{"soso","amin","soso@gmail.com","123498"} };

    }
    @Test(priority = 1,alwaysRun = true,dataProvider = "testdata")
    public void usercanregistersuccessfully(String fname,String lname,String email,String pass)
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
