package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.productpagedetails;
import pages.*;

import java.util.ArrayList;
import java.util.List;

public class addtocomparelisttest extends testbase{

    /*1-user can search for a product
      2-user can add the product to compare list
     */
    String [] productnamelist={"macbook","asus"};
    String[]fullname=new String[2];
    int i=0;
    searchpage searchobject;
    productpagedetails detailsobject;
    compareproductspage compareproductobject;

    @Test(priority = 1)
    public void usercanadditemstocomparelist()
    {
        searchobject=new searchpage(driver);
        detailsobject=new productpagedetails(driver);
        compareproductobject=new compareproductspage(driver);
        for(String productname:productnamelist){
        searchobject.productsearch(productname);
        searchobject.openproductdetailspage();
        fullname[i]= detailsobject.getproductname();
        detailsobject.addtocomparelist();
            i++;
        }
        for(String name:fullname){
        detailsobject.opencomparelistpage();
        System.out.println(name);
        Assert.assertTrue(  compareproductobject.productsnameincomparelist.getText().contains(name));
        }

    }
    @Test(dependsOnMethods = "usercanadditemstocomparelist")
    public void clearcomparelist(){
        compareproductobject=new compareproductspage(driver);
        compareproductobject.clearlist();
        Assert.assertTrue(compareproductobject.noitemsmessage.getText().contains("no items"));

    }




   }


