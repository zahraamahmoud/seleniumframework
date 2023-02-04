package tests;


import com.github.javafaker.Faker;
import data.jsondatareader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.Userregisterationpage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class userregisterationwithddt_javafakertest extends testbase{

    Homepage homepageobject;
    Userregisterationpage registerationpageobject;
    Faker fakedata=new Faker();
    String fname=fakedata.name().firstName();
    String lname= fakedata.name().lastName();
    String email=fakedata.internet().emailAddress();
    String pass=fakedata.number().digits(8).toString();

    @Test(priority = 1,alwaysRun = true)
    public void usercanregistersuccessfully( ) {
         homepageobject=new Homepage(driver);
         homepageobject.openRegisterationpage();
         registerationpageobject=new Userregisterationpage(driver);
         registerationpageobject.userregisteration(fname,lname,email,pass);
         driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
         System.out.println(fname+lname+email+pass);
         Assert.assertTrue(registerationpageobject.successmessage.getText().equals("Your registration completed"));

        }


    }



