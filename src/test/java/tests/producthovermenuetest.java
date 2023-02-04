package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;

public class producthovermenuetest extends testbase{

     Homepage homeobject;
     @Test
     public void usercanslectsubcategoryfrommainmenue()
     {
        homeobject=new Homepage(driver);
        homeobject.selectnotebookssection();
        Assert.assertTrue(homeobject.categorytitle.getText().equalsIgnoreCase("notebooks"));

     }


}
