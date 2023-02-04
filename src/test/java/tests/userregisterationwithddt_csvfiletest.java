package tests;



import com.opencsv.CSVReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.Userregisterationpage;
import pages.loginpage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class userregisterationwithddt_csvfiletest extends testbase{

    Homepage homepageobject;
    Userregisterationpage registerationpageobject;
    loginpage loginobject;
    CSVReader reader;


    @Test(priority = 1,alwaysRun = true)
    public void usercanregistersuccessfully( ) throws IOException {
        //get the path of the file
     String csv_file=System.getProperty("user.dir")+"/src/test/java/data/userdatacsv.csv";
     reader=new CSVReader(new FileReader(csv_file));
     String[]csvcell;
     while ((csvcell=reader.readNext())!=null){
         String fname=csvcell[0];
         String lname=csvcell[1];
         String email=csvcell[2];
         String pass=csvcell[3];
         homepageobject=new Homepage(driver);
         homepageobject.openRegisterationpage();
         registerationpageobject=new Userregisterationpage(driver);
         registerationpageobject.userregisteration(fname,lname,email,pass);
         driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
         Assert.assertTrue(registerationpageobject.successmessage.getText().equals("Your registration completed"));

        }


    }


}
