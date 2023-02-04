package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class registereduseercheckouttest extends testbase{

    /*1-registertion
      2-login
      3-search for item
      4-add item to cart
      5-check-out
     */
    Homepage homepageobject;
    Userregisterationpage registerationpageobject;
    loginpage loginobject;
    searchpage searchobject;
    productpagedetails detailsobject;
    shoppingcartpage shoppingcartobject;
    checkoutpage checkoutobject;
    orderdetailspage orderdetailsobject;
    String productname="Apple MacBook Pro 13-inch";

    String email="sosamahm1995@gmail.com";
    String pass="zozo1234";
    String country="United States";
    String state="Alaska";
    String city="asaka";
    String postalcode="12345";
    String phone="01098268350";
    String address="23-abad_st";
    @Test(priority = 1)
    public void usercanregistersuccessfully()
    {
        homepageobject=new Homepage(driver);
        homepageobject.openRegisterationpage();
        registerationpageobject=new Userregisterationpage(driver);
        registerationpageobject.userregisteration("zahraa","mahmoud",email,pass);
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
    public void usercanaddproducttocart (){
        detailsobject=new productpagedetails(driver);
        shoppingcartobject=new shoppingcartpage(driver);
        detailsobject.addtocart();
        detailsobject.opencartpage();
        Assert.assertEquals(productname,shoppingcartobject.productnameincart.getText());
    }
    @Test(dependsOnMethods ="usercanaddproducttocart" )
    public void registeredusercancheckout(){
        shoppingcartobject=new shoppingcartpage(driver);
        checkoutobject=new checkoutpage(driver);
        shoppingcartobject.opencheckoutpage();
        orderdetailsobject=new orderdetailspage(driver);
        checkoutobject.shippingaddress(country,state,city,address,postalcode,phone);
        checkoutobject.shippingmethod();
        checkoutobject.paymentmethod();
        Assert.assertEquals(productname,checkoutobject.productname.getText());
        checkoutobject.confirmorder();
        //System.out.println(checkoutobject.successmessage.getText());
         Assert.assertTrue(checkoutobject.successmessage.getText().contains("successfully"));
        checkoutobject.openorderdetailspage();
        orderdetailsobject.downloadpdf();
        orderdetailsobject.printorderdetails();
    }





    @Test(priority = 4)
    public void registeredusercanlogout()
    {
        registerationpageobject.userlogout();
    }

}
