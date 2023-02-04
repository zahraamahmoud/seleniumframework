package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.productpagedetails;
import pages.*;

public class addproducttowishlisttest extends testbase{
    /*
      1-user should search for a product
      2-user can add product to wishlist
     */
    String productname="Apple MacBook Pro 13-inch";
    searchpage searchobject;
    productpagedetails detailsobject;
    wishlistpage wishlistobject;

    @Test(priority = 1)
    public void usersearchforproduct()
    {
        searchobject=new searchpage(driver);
        detailsobject=new productpagedetails(driver);
        searchobject.productsearch(productname);
        searchobject.openproductdetailspage();
        Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productname));

    }
    @Test(priority = 2)
    public void usercanadditemtowishlist(){
        detailsobject=new productpagedetails(driver);
        wishlistobject=new wishlistpage(driver);
        detailsobject.addtowishlist();
        detailsobject.openwishlistpage();
        Assert.assertEquals( wishlistobject.product.getText(),productname);

    }
    @Test(dependsOnMethods ="usercanadditemtowishlist")
    public void usercandeleteitemfromwishlist()
    {
      wishlistobject=new wishlistpage(driver);
      wishlistobject.removeproductfromwishlist();
    }



}
