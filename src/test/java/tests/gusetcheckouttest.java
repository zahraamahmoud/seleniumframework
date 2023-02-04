package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class gusetcheckouttest extends addtocarttest{

    /*1-user can search for a product
    2- user can add the product to cart
    3-user can check out as guest
     */

    String productname="Apple MacBook Pro 13-inch";
    String firstname="soso";
    String lastname="ahmed";
    String email="soso@gmail.com";
    String country="United States";
    String state="Alaska";
    String city="asaka";
    String postalcode="12345";
    String phone="01053268769";
    String address="23-abad_st";
    searchpage searchobject;
    productpagedetails detailsobject;
    shoppingcartpage shoppingcartobject;
    checkoutpage checkoutobject;
    orderdetailspage orderdetailsobject;
    @Test(priority = 1)
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
    @Test(dependsOnMethods = "usercanaddproducttocart")
    public void usercancheckoutasguest(){
        shoppingcartobject=new shoppingcartpage(driver);
        checkoutobject=new checkoutpage(driver);
        orderdetailsobject=new orderdetailspage(driver);
        shoppingcartobject.opencheckoutpage();
        checkoutobject.checkoutasguest();
        checkoutobject.guestdetails(firstname,lastname,email);
        checkoutobject.shippingaddress(country,state,city,address,postalcode,phone);
        checkoutobject.shippingmethod();
        checkoutobject.paymentmethod();
        Assert.assertEquals(productname,checkoutobject.productname.getText());
        checkoutobject.confirmorder();
        Assert.assertTrue(checkoutobject.successmessage.getText().contains("successfully"));
        checkoutobject.openorderdetailspage();
        orderdetailsobject.downloadpdf();
        orderdetailsobject.printorderdetails();


    }



}
