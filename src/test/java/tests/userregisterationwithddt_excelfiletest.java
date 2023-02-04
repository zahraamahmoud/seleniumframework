package tests;


import data.excelreader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.Userregisterationpage;
import pages.loginpage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class userregisterationwithddt_excelfiletest extends testbase{

    Homepage homepageobject;
    Userregisterationpage registerationpageobject;
    loginpage loginobject;

    @DataProvider(name="exceldata")
    public static Object[][] userdata() throws IOException {

   excelreader er=new excelreader();
   return  er.getexceldata();
    }


    @Test(priority = 1,alwaysRun = true,dataProvider = "exceldata")
    public void usercanregistersuccessfully( String fname, String lname,String email, String pass)
    {
     homepageobject=new Homepage(driver);
     homepageobject.openRegisterationpage();
     registerationpageobject=new Userregisterationpage(driver);
     registerationpageobject.userregisteration(fname,lname,email,pass);
     driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
     Assert.assertTrue(registerationpageobject.successmessage.getText().equals("Your registration completed"));

    }


}
