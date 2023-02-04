package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class writereviewtest extends testbase{

    /*1-user should register
    2-user should login
    3-user should search for a product
    4-user can add review
     */
    Homepage homepageobject;
    Userregisterationpage registerationpageobject;
    loginpage loginobject;
    String productname="Apple MacBook Pro 13-inch";
    searchpage searchobject;
    productpagedetails detailsobject;
    productreviewpage productreviewobject;


    String email="nevo12@gmail.com";
    String pass="zozo1234";
    @Test(priority = 1)
    public void usercanregistersuccessfully()
    {
        homepageobject=new Homepage(driver);
        homepageobject.openRegisterationpage();
        registerationpageobject=new Userregisterationpage(driver);
        registerationpageobject.userregisteration("amir","mahmoud",email,pass);
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
    @Test(dependsOnMethods = "usersearchforproduct")
    public void usercanaddreviwforaproduct(){

        detailsobject=new productpagedetails(driver);
        productreviewobject=new productreviewpage(driver);
        detailsobject.openproductreviewpage();
        productreviewobject.addreview("test review","the screen is small");
        Assert.assertTrue(productreviewobject.successmessage.getText().contains("successfully"));

    }
    @Test(priority = 4)
    public void registeredusercanlogout()
    {
        registerationpageobject.userlogout();
    }


}
