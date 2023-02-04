package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class emailfriendtest extends testbase{
    /*
    1-user should register
    2-user should login
    3-user can search for product
    4-user can email a friend
    5-user should logout
    */
    Homepage homepageobject;
    loginpage loginobject;

    Userregisterationpage registerationpageobject;
    String productname="Apple MacBook Pro 13-inch";
    searchpage searchobject;
    productpagedetails detailsobject;
    emailafriendpage emailafriendobject;
    String email="renam34@gmail.com";
    String pass="zozo1234";
    String friendmail="zozo@hotmail.com";
    @Test(priority = 1)
    public void usercanregistersuccessfully()
    {
        homepageobject=new Homepage(driver);
        homepageobject.openRegisterationpage();
        registerationpageobject=new Userregisterationpage(driver);
        registerationpageobject.userregisteration("mohamed","mahmoud",email,pass);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertTrue(registerationpageobject.successmessage.getText().equals("Your registration completed"));

    }
    @Test(dependsOnMethods ="usercanregistersuccessfully")
    public void registeredusercanlogin(){
        homepageobject.openloginnpage();
        loginobject=new loginpage(driver);
        loginobject.userlogin(email,pass);
      //  Assert.assertEquals(registerationpageobject.logoutlink.getText(),"log out");

    }
    @Test(priority = 2)
    public void usersearchforproduct()
    {
        searchobject=new searchpage(driver);
        detailsobject=new productpagedetails(driver);
        searchobject.productsearch(productname);
        searchobject.openproductdetailspage();
        Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productname));

    }
    @Test(dependsOnMethods ={ "registeredusercanlogin","usersearchforproduct"})
    public void usercanemailafriend(){

        detailsobject=new productpagedetails(driver);
        emailafriendobject=new emailafriendpage(driver);
        detailsobject.openemailfriendpage();
        emailafriendobject.emailfriend(friendmail);
        Assert.assertTrue(emailafriendobject.resultmessage.getText().contains("sent"));

    }
    @Test(priority = 3)
    public void registeredusercanlogout()
    {
        registerationpageobject.userlogout();
    }



}
