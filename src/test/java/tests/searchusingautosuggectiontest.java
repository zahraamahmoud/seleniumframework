package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.productpagedetails;
import pages.searchpage;

public class searchusingautosuggectiontest extends testbase{

    String productname="Mac";
    searchpage searchobject;
    productpagedetails detailsobject;
    @Test
    public void usercansearchwithautosuggest( ){
        searchobject=new searchpage(driver );
        detailsobject=new productpagedetails(driver);
        searchobject.productsearchusingautosuggest(productname);
        Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().contains(productname));


    }
}
