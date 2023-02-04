package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.Userregisterationpage;
import pages.loginpage;
import pages.myaccountpage;


import java.util.concurrent.TimeUnit;

public class Myaccounttest extends testbase{

    Homepage homepageobject;
    Userregisterationpage registerationpageobject;
    loginpage loginobject;
    myaccountpage myaccountobject;
    String email="awad101@gmail.com";
    String oldpass="zaza1234";
    String newpass="1234567";
    @Test
    public void usercanregistersuccessfully()
    {
        homepageobject=new Homepage(driver);
        homepageobject.openRegisterationpage();
        registerationpageobject=new Userregisterationpage(driver);
        registerationpageobject.userregisteration("mona","mahmoud",email,oldpass);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertEquals(registerationpageobject.successmessage.getText(), "Your registration completed");

    }
    @Test(dependsOnMethods = "usercanregistersuccessfully")
    public void registeredusercanlogin(){
        homepageobject.openloginnpage();
        loginobject=new loginpage(driver);
        loginobject.userlogin(email,oldpass);
       // Assert.assertEquals(registerationpageobject.logoutlink.getText(),"log out");

    }
    @Test(dependsOnMethods ="registeredusercanlogin" )
    public void registeredusercanchangepassword()
    {
     homepageobject.openmyaccountpage();
     myaccountobject=new myaccountpage(driver);
     myaccountobject.openchangepasspage();
     myaccountobject.changepassword(oldpass,newpass);
     Assert.assertTrue(myaccountobject.resultmessage.getText().contains("Password was changed"));
    }
    @Test(priority = 4)
    public void registeredusercanlogout()
    {
        registerationpageobject.userlogout();
    }
}
