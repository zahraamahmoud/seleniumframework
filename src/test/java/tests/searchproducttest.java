package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.searchpage;
import pages.productpagedetails;

public class searchproducttest extends testbase{
    String productname="Apple MacBook Pro 13-inch";
    searchpage searchobject;
    productpagedetails detailsobject;
    @Test
    public void usersearchforproduct()
    {
        searchobject=new searchpage(driver);
        detailsobject=new productpagedetails(driver);
        searchobject.productsearch(productname);
        searchobject.openproductdetailspage();
        Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productname));

    }
}
