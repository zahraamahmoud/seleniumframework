package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;

public class changecurrencytest extends testbase{
    String eurosign="€";
    String dollarsign="$";
    String euro="Euro";
    String dolar="US Dollar";
    Homepage home;
    @Test
    public void usercanchangecurrency()
    {
        home=new Homepage(driver);
        home.changecurrency(dolar);
        Assert.assertTrue(home.price.getText().contains(dollarsign));
    }
}
