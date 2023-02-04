package tests;



import com.opencsv.CSVReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.Userregisterationpage;
import pages.loginpage;
import data.jsondatareader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class userregisterationwithddt_jsonfiletest extends testbase{

    Homepage homepageobject;
    Userregisterationpage registerationpageobject;



    @Test(priority = 1,alwaysRun = true)
    public void usercanregistersuccessfully( ) throws IOException, ParseException {
        jsondatareader jsonreader=new jsondatareader();
        jsonreader.jsonReader();

        //get the path of the file

         homepageobject=new Homepage(driver);
         homepageobject.openRegisterationpage();
         registerationpageobject=new Userregisterationpage(driver);
         registerationpageobject.userregisteration(jsonreader.fname,jsonreader.lname,jsonreader.email,jsonreader.password);
         driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
         Assert.assertTrue(registerationpageobject.successmessage.getText().equals("Your registration completed"));

        }


    }



