package tests;

import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.productpagedetails;
import pages.*;

public class addtocarttest extends testbase{
  /*1-user can search for product
     2-user add item to cart
   */
  String productname="Apple MacBook Pro 13-inch";
  String qty="6";
    searchpage searchobject;
    productpagedetails detailsobject;
    shoppingcartpage shoppingcartobject;

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
    @Test (priority = 2)
    public void usercnchangequantity(){
        shoppingcartobject=new shoppingcartpage(driver);
        shoppingcartobject.changeitemquantity(qty);
        Assert.assertEquals(qty,shoppingcartobject.quantitytxt.getAttribute("value"));

    }
    @Test(priority = 3)
    public void removeitemsfromcart(){
        shoppingcartobject=new shoppingcartpage(driver);
        shoppingcartobject.removeitems();
        Assert.assertTrue(shoppingcartobject.noitemsmessage.getText().contains("empty"));

    }



}
